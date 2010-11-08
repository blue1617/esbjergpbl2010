/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imdb;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.html.HTML;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

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
	            rankedGenres.add((String) nodes.item(i).getNodeValue());
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
			if(movie != null)
				movies.add(movie);

			i++;
			Thread.currentThread().sleep(1500);
                        if(i==36)break;
			
		}

		Iterator<MovieHTML> blabla = movies.iterator();
		while(blabla.hasNext()){
			System.out.println(blabla.next().toString());
		}

		return movies;

	}



	public static void main(String[] args) throws XPathExpressionException, IOException, InterruptedException{
		GenreClient gg = new GenreClient();
		gg.getMovieHtml();

	}

}

