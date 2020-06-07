package interfata;

import servicii.Biblioteca;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener{
    private Biblioteca biblioteca;

    public MainFrame(Biblioteca biblioteca) throws HeadlessException {

        super("Library Management");

        this.biblioteca= biblioteca;

        int width = 470;
        int height = 180;
        setLayout(new BorderLayout());

        setSize(width, height);

        JPanel panel = new JPanel();

        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);


        panel.setLayout(boxlayout);

        panel.setBackground(Color.GRAY);
        panel.setBorder(new EmptyBorder(new Insets(height/5, width/2 , height/2, width/2)));

        JButton jb1 = new JButton("AddUser");
        JButton jb2 = new JButton("AddBook");
        JButton jb3 = new JButton("BorrowBook");
        JButton jb4 = new JButton("ReturnBook");
        JButton jb5 = new JButton("ExtendBook");
        JButton jb6 = new JButton("ShowUsers");
        JButton jb7 = new JButton("ShowBooks");


        Font newButtonFont=new Font("Verdana", Font.PLAIN, 15);

        jb1.setFont(newButtonFont);
        jb2.setFont(newButtonFont);
        jb3.setFont(newButtonFont);
        jb4.setFont(newButtonFont);
        jb5.setFont(newButtonFont);
        jb6.setFont(newButtonFont);
        jb7.setFont(newButtonFont);



        JLabel label= new JLabel("Welcome to our Library!");
        label.setFont(new Font("Verdana", Font.PLAIN, 35));

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 25)));
        JLabel label1 = new JLabel("Please select an option: ");
        label1.setFont(new Font("Verdana", Font.PLAIN, 25));
        panel.add(label1);


        panel.add(Box.createRigidArea(new Dimension(0, 60)));
        panel.add(jb1);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(jb2);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(jb3);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(jb4);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(jb5);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(jb6);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(jb7);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);



        add(panel);
        pack();
        setVisible(true);
        setResizable(false);



    }



    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "AddUser":
                AddUserFrame addUserFrame = new AddUserFrame(biblioteca);
                dispose();

                break;
            case "AddBook":
                AddBookFrame addBookFrame = new AddBookFrame(biblioteca);
                dispose();

                break;
            case "BorrowBook":
                BorrowBookFrame borrowBookFrame = new BorrowBookFrame(biblioteca);
                dispose();


                break;
            case "ExtendBook":
                ExtendBookFame extendBookFame = new ExtendBookFame(biblioteca);
                dispose();
                break;

            case "ReturnBook":
                ReturnBookFrame returnBookFrame = new ReturnBookFrame(biblioteca);
                dispose();
                break;
            case "ShowUsers":
                ShowUsersFrame showUsersFrame = new ShowUsersFrame(biblioteca);
                dispose();
                break;
            case "ShowBooks":
                ShowBooksFrame showBooksFrame = new ShowBooksFrame(biblioteca);
                dispose();
                break;
        }

    }
}

