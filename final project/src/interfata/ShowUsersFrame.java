package interfata;

import persoana.Abonat;
import servicii.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShowUsersFrame implements ActionListener {
    private JFrame frame;

    Biblioteca biblioteca;

    public ShowUsersFrame(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
        frame = new JFrame();


        JButton submit2 = new JButton("Back to menu");
        submit2.setBounds(300, 500, 200, 30);
        frame.add(submit2);
        submit2.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 1, 0));
        frame.setTitle("Show Users");
        ArrayList<Abonat> abonati = biblioteca.getServiciiAbonati().getAbonati();


        Object[][] ob = this.getData(abonati);
        String[] columnNames = {"Id Abonat", "Nume", "Prenume", "Data inregistrare", "CNP", "Numar Telefon", "Abateri"};

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


    public Object[][] getData(ArrayList<Abonat> abonati){

        Object[][] ob = new Object[abonati.size()][7];

        int index = 0;
        for(Abonat abonat:abonati){
            ob[index][0] = abonat.getIdAbonat();
            ob[index][1] = abonat.getNume();
            ob[index][2] = abonat.getPrenume();
            ob[index][3] = abonat.afisareData();
            ob[index][4] = abonat.getCnp();
            ob[index][5] = abonat.getNumarTelefon();
            ob[index++][6] = abonat.getNrAbateri();

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
