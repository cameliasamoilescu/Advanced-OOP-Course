package interfata;

import carte.Carte;

import servicii.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowBooksFrame implements ActionListener {
    private JFrame frame;

    Biblioteca biblioteca;


    public ShowBooksFrame(Biblioteca biblioteca) {


        this.biblioteca = biblioteca;
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 1, 0));
        frame = new JFrame();
        frame.setTitle("Show Users");
        ArrayList<Carte> carti = biblioteca.getServiciiCarti().getCarti();


        JButton submit2 = new JButton("Back to menu");
        submit2.setBounds(300, 500, 200, 30);
        frame.add(submit2);

        submit2.addActionListener(this);

        Object[][] ob = this.getData(carti);
        String[] columnNames = {"Book ID", "Title", "Author", "Borrowed"};

        JTable table = new JTable(ob, columnNames);

        panel.add(table);

        JPanel topPanel = (JPanel) frame.getContentPane();
        topPanel.setLayout(new FlowLayout());


        table.setPreferredScrollableViewportSize(new Dimension(800, 500));
        JScrollPane tablePanel = new JScrollPane(table);
        topPanel.add(tablePanel);
        frame.setSize(new Dimension(900, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    public Object[][] getData(ArrayList<Carte> carti){

        Object[][] ob = new Object[carti.size()][4];

        int index = 0;
        for(Carte carte:carti){
            ob[index][0] = carte.getIdCarte();
            ob[index][1] = carte.getTitlu();
            ob[index][2] = carte.getAutor();
            if(carte.isImprumutata())
                ob[index++][3] = "Yes";
            else
                ob[index++][3] ="No";
        }

        return ob;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Back to menu")){

            MainFrame mainFrame = new MainFrame(biblioteca);
            frame.dispose();

        }
    }
}
