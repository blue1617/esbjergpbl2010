/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imdb;

import control.DataMining;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.text.html.HTML;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import model.DDBB.DAOFactory;
import model.DDBB.FilmDAO;
import model.DDBB.ItemDAO;
import model.DDBB.UserDAO;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.xalan.xsltc.compiler.sym;
import org.apache.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;
import org.xml.sax.InputSource;


public class GenreClient {

	private static DefaultHttpClient httpclient;

	private ArrayList<String[]> readFile(String filename) throws IOException{
		ArrayList<String[]> list = new ArrayList<String[]>();
		BufferedReader fh = new BufferedReader(new FileReader(filename));
		String s;
		while ((s=fh.readLine())!=null){
			String f[] = s.split("[|]");
			list.add(f);
		}
		return list;
	}

	private MovieHTML createMovie(String[] line) throws ClientProtocolException, IOException, XPathExpressionException {

		ArrayList<String> rankedGenres = getRankedGenres(line[4]);

		if(rankedGenres != null){
			MovieHTML movie = new MovieHTML(Integer.parseInt(line[0]), line[1], line[2]);
			movie.setRankedGenres(rankedGenres);
			return movie;
		}else{
			return null;
		}

	}

	private ArrayList<String> getRankedGenres(String url) throws ClientProtocolException, IOException, XPathExpressionException {
		ArrayList<String> rankedGenres = new ArrayList<String>();

		url= url.replaceAll("%20", "+");
		url= url.replaceAll("%28", "(");
		url= url.replaceAll("%29", ")");

                System.out.println("<----->");
                System.out.println(url);
                System.out.println("<----->");

		HttpGet httpget = new HttpGet(url);
    	httpget.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.9.2.3) Gecko/20100401 Firefox/3.6.3");
    	ResponseHandler<String> responseHandler = new BasicResponseHandler();

        String response = httpclient.execute(httpget,responseHandler);

        Reader reader = new StringReader(response);

        Tidy tidy = new Tidy();
    	tidy.setQuiet(true);
    	tidy.setShowWarnings(false);
    	Document doc = tidy.parseDOM(reader, null);

    	javax.xml.xpath.XPathFactory factory = javax.xml.xpath.XPathFactory.newInstance();

		javax.xml.xpath.XPath xpath = factory.newXPath();

    	String xpathExpression = "//div[@class='infobar']/a/text()";

    	NodeList nodes = (NodeList)xpath.evaluate(xpathExpression, doc, XPathConstants.NODESET);

    	if(nodes.getLength() != 0 ){

	    	for (int i = 0; i < nodes.getLength(); i++) {
	            rankedGenres.add((String) nodes.item(i).getNodeValue().toLowerCase());
	    	}
	    	return rankedGenres;

    	}else{
    		return null;
    	}

	}

	public ArrayList<MovieHTML> getMovieHtml() throws IOException, XPathExpressionException, InterruptedException{

		httpclient = new DefaultHttpClient();
		ArrayList<MovieHTML> movies = new ArrayList<MovieHTML>();
		String filename = "u.item";
		ArrayList<String[]> list = readFile(filename);
		Iterator<String[]> lineIterator = list.iterator();
		int i=0;
		while(lineIterator.hasNext()){
			MovieHTML movie = createMovie(lineIterator.next());
                        i++;
                        System.out.println("Ciclo "+i);
			if(movie != null){
                            
				movies.add(movie);
                                System.out.println("Pelicula: "+movie.getId()+movie.getTitle()+movie.releaseDate());
                                DAOFactory MySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MySQL);
                                FilmDAO DAO = MySQLFactory.getFilmDAO();
                                ItemDAO iDAO = MySQLFactory.getItemDAO();
                try {
                    DAO.insertFilm(movie);
                   
                } catch (SQLException ex) {
                    Logger.getLogger(GenreClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    iDAO.insertItem(movie);
                } catch (SQLException ex) {
                    Logger.getLogger(GenreClient.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("User in database:");
                        }
                        System.out.println("waiting "+i);
			
		}

		Iterator<MovieHTML> blabla = movies.iterator();
		while(blabla.hasNext()){
			System.out.println(blabla.next().toString());
		}

		return movies;

	}


        public void eraseRows(String filename) throws IOException, SQLException{
            DataMining data = new DataMining();
            String outputFile = "u.data.NEW";
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            BufferedReader fh = new BufferedReader(new FileReader(filename));
            String s;
            while ((s=fh.readLine())!=null){
                String f[] = s.split("\t");
                //if f[1] is not in our db
                if(data.exits(Integer.parseInt(f[1]))){
                    out.write(s+"\n");
                }
            }
            out.flush();
            out.close();
            fh.close();

        }

        public void writeSql(String filename) throws FileNotFoundException, IOException{
            String outputFile = "rate.sql";
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            out.write("INSERT INTO `rate` (`idFilm`, `idUser`, `rate`) VALUES\n");
            BufferedReader fh = new BufferedReader(new FileReader(filename));
            String s;
            while ((s=fh.readLine())!=null){
                String f[] = s.split("\t");
                out.write("("+f[0]+","+f[1]+","+f[2]+"),\n");

            }
            out.flush();
            out.close();
            fh.close();
        }

        public void writeUserSql(String filename) throws IOException{
            String outputFile = "user.sql";
            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
            out.write("INSERT INTO `user` (`idUser`, `idItem`, `sex`, `password`, `name`, `surname`, `age`, `occupation`) VALUES\n");
            BufferedReader fh = new BufferedReader(new FileReader(filename));
            String s;
            while ((s=fh.readLine())!=null){
                String f[] = s.split("[|]");
                //System.out.println(f[0]+" "+f[1]+" "+f[2]+" "+f[3]);
                out.write("("+f[0]+", '0','"+f[2]+"' , '', '', '', "+f[1]+", '"+f[3]+"'),\n");

            }
            out.flush();
            out.close();
            fh.close();
        }



	public static void main(String[] args) throws XPathExpressionException, IOException, InterruptedException, SQLException{
		GenreClient gg = new GenreClient();
		//gg.getMovieHtml();
                gg.writeUserSql("u.user");

	}

}

