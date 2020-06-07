package interfata;

import servicii.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

public class ExtendBookFame implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame frame;

    private JLabel bookID, bookAuthor, userCnp;
    private JTextField bookIDTF, bookAuthorTF, userCnpTF;
    private JButton submit;

    Date date;

    public ExtendBookFame(Biblioteca biblioteca) {

        this.biblioteca = biblioteca;
        frame = new JFrame();
        frame.setTitle("Return Book");

        date = new Date();

        JButton submit = new JButton("Submit");
        JButton submit2 = new JButton("Back to menu");


        submit2.setBounds(300, 500, 200, 30);
        submit.setBounds(300,300,200,30);


        frame.add(submit2);
        frame.add(submit);

        submit.addActionListener(this);
        submit2.addActionListener(this);

        bookID = new JLabel("Book Id");
        userCnp = new JLabel("User Cnp");

        bookIDTF = new JTextField();
        userCnpTF = new JTextField();

        bookID.setBounds(250, 200, 200, 30);
        userCnp.setBounds(250, 250, 200, 30);


        bookIDTF.setBounds(350, 200, 200, 30);
        userCnpTF.setBounds(350, 250, 200, 30);


        frame.add(bookID);
        frame.add(bookIDTF);
        frame.add(userCnp);
        frame.add(userCnpTF);


        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Submit" :

                String userCnp = userCnpTF.getText();
                int idCarte = Integer.parseInt(bookIDTF.getText());

                try {
                    int c = this.biblioteca.prelungesteTermenImprumut(userCnp, idCarte, date);

                    if ( c == -1){
                        // nu exista abonat
                        JOptionPane.showMessageDialog(frame, "User not found!", "User error",  JOptionPane.INFORMATION_MESSAGE);

                    }
                    else if (c == -2){
                        //nu a imprumutat carte
                        JOptionPane.showMessageDialog(frame, "This user hasn't borrowed this book", "Book error",  JOptionPane.INFORMATION_MESSAGE);

                    }else if(c == -3){
                        //carti nerestituite la timp
                        JOptionPane.showMessageDialog(frame, "This user has borrowed books that should have been returned, and he can't extend the date of this borrowed book", "Error",  JOptionPane.INFORMATION_MESSAGE);

                    }else{
                        JOptionPane.showMessageDialog(frame, "Success", "Olee",  JOptionPane.INFORMATION_MESSAGE);

                    }

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;

            case "Back to menu":
                MainFrame mainFrame = new MainFrame(biblioteca);
                frame.dispose();
                break;
        }
    }
}
