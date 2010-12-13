package view;

import control.DataMining;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends JFrame implements ActionListener
{
 JButton SUBMIT;
 JPanel panel;
 JLabel label1,label2;
 String value1;
 final JTextField  text1,text2;
  Login()
  {
    label1 = new JLabel();
    label1.setText("Username:");
    text1 = new JTextField(15);

    label2 = new JLabel();
    label2.setText("Password:");
      text2 = new JPasswordField(15);

    SUBMIT=new JButton("SUBMIT");

    panel=new JPanel(new GridLayout(3,1));
    panel.add(label1);
    panel.add(text1);
    panel.add(label2);
    panel.add(text2);
    panel.add(SUBMIT);
    add(panel,BorderLayout.CENTER);
    SUBMIT.addActionListener(this);
    setTitle("LOGIN FORM");
  }
   public void actionPerformed(ActionEvent ae)
  {
    DataMining data = new DataMining();
    value1=text1.getText();
    String value2=text2.getText();
        try {
            if (data.validate(value1, value2)) {
                NextPage page = new NextPage(value1);
                page.setVisible(true);
                //JLabel label = new JLabel("Welcome:" + value1);
               // page.getContentPane().add(label);
                this.setVisible(true);
            } else {
                System.out.println("enter the valid username and password");
                JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}
 class LoginDemo
{
  public static void main(String arg[])
  {
    try
    {
    Login frame=new Login();
    frame.setSize(500,200);
    frame.setVisible(true);
    }
  catch(Exception e)
    {JOptionPane.showMessageDialog(null, e.getMessage());}
  }
}