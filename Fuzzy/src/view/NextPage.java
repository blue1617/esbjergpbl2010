package view;

import javax.swing.JFrame;


public class NextPage extends JFrame {

    public NextPage() {

        setSize(300, 200);
        setTitle("Simple");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

    public static void main(String[] args) {

        NextPage simple = new NextPage();
        simple.setVisible(true);

    }
}
