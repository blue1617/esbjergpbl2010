package view;

import control.DataMining;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.dto.Film;
import model.dto.User;



public class NextPage extends JFrame implements ActionListener {
    JPanel panel, pan1, pan2, panelFilms, panel5;
    JButton boton;
    JCheckBox box1, box2, box3, box4;
    JLabel label;
    JList list;
    String[] films = new String[10];
    ArrayList<Film> rankFilms;
    String name;
    User idUser;
    DataMining data = new DataMining();
    public NextPage(String nam) throws SQLException {
        this.name = nam;
        
        this.idUser = data.getUser(nam);
        rankFilms = data.get10R1(this.idUser.idUser);
        for(int i=0;i<10; i++){
            System.out.println(rankFilms.get(i).getTitle());
            films[i] = rankFilms.get(i).getTitle();
        }

        label = new JLabel();
        panel = new JPanel(new GridLayout(2,1));
        pan2 = new JPanel();
        panelFilms = new JPanel();
        boton = new JButton("Recommendate");
        box1 = new JCheckBox("R1");
        box2 = new JCheckBox("R2");
        box3 = new JCheckBox("Reco3");
        box4 = new JCheckBox("Reco4");
        list = new JList(films);
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	panelFilms.add(new JScrollPane(list));
		




        pan1=new JPanel(new GridLayout(2,2));
        pan1.add(box1);
        pan1.add(box2);
        pan1.add(box3);
        pan1.add(box4);
        pan2.add(boton);
        panel.add(pan1);
        panel.add(pan2);
        boton.addActionListener(this);
        panelFilms.add(list);

       /* list.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {
                        System.out.println("dsfsghsdg");

			}
		});
        */

        setLayout(new BorderLayout());
        panel.setSize(300, 300);
        add(panelFilms, BorderLayout.WEST);
        add(panel, BorderLayout.EAST);
        label.setVisible(true);



       // setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   public void actionPerformed(ActionEvent e) {
        if(this.box1.isSelected()){
            try {
                rankFilms = data.get10R1(this.idUser.idUser);
            } catch (SQLException ex) {
                Logger.getLogger(NextPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        for(int i=0;i<10; i++){
            System.out.println(rankFilms.get(i).getTitle());
            films[i] = rankFilms.get(i).getTitle();
        }
                    this.list = new JList(films);
        this.panelFilms.updateUI();
                }else if(this.box2.isSelected()){
            try {
                rankFilms = data.get10R2(this.idUser.idUser);
            } catch (SQLException ex) {
                Logger.getLogger(NextPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        for(int i=0;i<10; i++){
            System.out.println(rankFilms.get(i).getTitle());
            films[i] = rankFilms.get(i).getTitle();
        }
                    this.list = new JList(films);
        this.panelFilms.updateUI();
                }
	}
    
}
