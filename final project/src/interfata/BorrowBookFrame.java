package interfata;

import servicii.Biblioteca;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

public class BorrowBookFrame implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame frame;

    private JLabel bookTitle, bookAuthor, userCnp;
    private JTextField bookTitleTF, bookAuthorTF, userCnpTF;
    private JButton submit;
    Date date;


    public BorrowBookFrame(Biblioteca biblioteca)  {

        this.biblioteca = biblioteca;
        frame = new JFrame();
        frame.setTitle("Borrow Book");


        date = new Date();
        JButton submit = new JButton("Submit");
        JButton submit2 = new JButton("Back to menu");
        submit2.setBounds(300, 500, 200, 30);
        submit.setBounds(300,350,200,30);
        frame.add(submit2);
        frame.add(submit);

        submit.addActionListener(this);
        submit2.addActionListener(this);

        bookTitle = new JLabel("Book Title");
        bookAuthor = new JLabel("Book Author");
        userCnp = new JLabel("User Cnp");

        bookTitleTF = new JTextField();
        bookAuthorTF = new JTextField();
        userCnpTF = new JTextField();

        bookTitle.setBounds(250, 200, 200, 30);
        bookAuthor.setBounds(250, 250, 200, 30);
        userCnp.setBounds(250, 300, 200, 30);


        bookTitleTF.setBounds(350, 200, 200, 30);
        bookAuthorTF.setBounds(350, 250, 200, 30);
        userCnpTF.setBounds(350, 300, 200, 30);


        frame.add(bookTitle);
        frame.add(bookTitleTF);
        frame.add(bookAuthor);
        frame.add(bookAuthorTF);
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

                String bookTitle = bookTitleTF.getText();
                String bookAuthor = bookAuthorTF.getText();
                String cnp = userCnpTF.getText();

                try {
                    int c =  biblioteca.imprumutaCarte(cnp, bookTitle, bookAuthor, date);
                    if ( c == 1){
                        //nu exista cartea
                        JOptionPane.showMessageDialog(frame, "The book you are looking for is not in our library. Sorry :)", "Book error",  JOptionPane.INFORMATION_MESSAGE);

                    }
                    else if(c == -1){
                        JOptionPane.showMessageDialog(frame, "User doesn't exist. Please add user first", "User error",  JOptionPane.INFORMATION_MESSAGE);

                    }
                    else{
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
