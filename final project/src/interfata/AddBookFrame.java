package interfata;

import carte.Atlas;
import carte.Dictionar;
import carte.Manual;
import carte.Roman;
import servicii.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame frame;
    private JLabel title, author, publisher, subject, type, bookType;
    private JTextField titleTF, authorTF, publisherTF, subjectTF, typeTF, bookTypeTF;
    private JButton submit;
    private JRadioButton jrb1, jrb2, jrb3, jrb4;

    private boolean pressSubmit1;
    private String book;
    public AddBookFrame(Biblioteca biblioteca) throws HeadlessException {


        this.biblioteca = biblioteca;
        frame = new JFrame("Add Book");
        jrb1 = new JRadioButton();
        jrb1.setText("Atlas");

        pressSubmit1 = false;

        jrb1.setBounds(80, 90, 200, 30);

        Label l1 = new Label("Select the type of the book");
        l1.setBounds(80, 50,200,30);


        frame.add(l1);
        frame.add(jrb1);
        jrb2 = new JRadioButton();
        jrb2.setText("Roman");
        jrb2.setBounds(80, 120, 200, 30);
        frame.add(jrb2);


        jrb3 = new JRadioButton();
        jrb3.setText("Manual");
        jrb3.setBounds(80, 150, 200, 30);
        frame.add(jrb3);


        jrb4 = new JRadioButton();
        jrb4.setText("Dictionar");
        jrb4.setBounds(80, 180, 200, 30);
        frame.add(jrb4);


        title = new JLabel("Title");
        author = new JLabel("Author");
        subject = new JLabel("Subject");
        publisher = new JLabel("Publisher");
        type = new JLabel("Type");
        bookType = new JLabel("Type");


        titleTF = new JTextField();
        authorTF = new JTextField();
        publisherTF = new JTextField();
        subjectTF = new JTextField();
        typeTF = new JTextField();
        bookTypeTF = new JTextField();




        submit = new JButton("Add Book");
        JButton submit1 = new JButton("Select Type");
        JButton submit2 = new JButton("Back to menu");



        ButtonGroup G = new ButtonGroup();

        G.add(jrb1);
        G.add(jrb2);
        G.add(jrb3);
        G.add(jrb4);


        title.setBounds(500, 100, 200, 30);
        author.setBounds(500, 150, 200, 30);
        publisher.setBounds(500, 200, 200, 30);
        subject.setBounds(500,200, 200, 30 );


        titleTF.setBounds(600, 100, 200, 30);
        authorTF.setBounds(600, 150, 200, 30);
        publisherTF.setBounds(600, 200, 200, 30);
        subjectTF.setBounds(600,200, 200, 30 );

        type.setBounds(500, 250, 200, 30);
        bookType.setBounds(500, 200, 200, 30);

        typeTF.setBounds(600, 250, 200, 30);
        bookTypeTF.setBounds(600, 200, 200, 30);

        submit.setBounds(640, 300, 200, 30);
        submit1.setBounds(80, 220, 200, 30);
        submit2.setBounds(300,450, 200, 30);
        frame.add(submit1);
        frame.add(submit2);

        frame.add(title);
        frame.add(author);
        frame.add(titleTF);
        frame.add(authorTF);
//        this.add(publisher);
//        this.add(publisherTF);

        frame.add(submit);

        submit.addActionListener(this);
        submit1.addActionListener(this);
        submit2.addActionListener(this);

        frame.setSize(900, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
//        dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        switch (e.getActionCommand()){
            case "Select Type":

                if(jrb1.isSelected()){

                    frame.add(publisherTF);
                    frame.add(publisher);
                    frame.repaint();


                    pressSubmit1 = true;
                    book = "atlas";

                }
                else if(jrb2.isSelected()){
                    pressSubmit1 = true;
                    //roman
                    //

                    frame.add(bookType);
                    frame.add(bookTypeTF);
                    frame.repaint();
                    book = "roman";

                }
                else if(jrb3.isSelected()){
                    pressSubmit1 = true;
                    //manual
                    //subject

                    frame.add(subject);
                    frame.add(subjectTF);
                    frame.repaint();
                    book = "manual";

                }
                else if(jrb4.isSelected()){
                    pressSubmit1 = true;
                    //dictionar
                    //publisher, type

                    frame.add(publisherTF);
                    frame.add(publisher);

                    frame.add(type);
                    frame.add(typeTF);

                    frame.repaint();
                    book = "dictionar";

                }
                else{
                    JOptionPane.showMessageDialog(frame, "Please select an option", "Option error",  JOptionPane.INFORMATION_MESSAGE);

                }

                break;
            case "Add Book":

                String tile = titleTF.getText();
                String author = authorTF.getText();


                String publisher;
                String type;
                String subject;

                if(!pressSubmit1) {
                    JOptionPane.showMessageDialog(frame, "Please select an option", "Option error",  JOptionPane.INFORMATION_MESSAGE);

                }
                else{
                    switch (book){
                        case "atlas":
                            // editura

                            publisher = publisherTF.getText();

                            Atlas atlas = new Atlas(tile,author,publisher);

                            biblioteca.adaugaCarteinStoc(atlas);


                            break;
                        case "dictionar":
                            //tip editura
                            type = typeTF.getText();

                            publisher = publisherTF.getText();


                            biblioteca.adaugaCarteinStoc(new Dictionar(tile,author,type,publisher));

                            break;
                        case "roman":
                            //gen
                            type = bookTypeTF.getText();
                            biblioteca.adaugaCarteinStoc(new Roman(tile,author,type));

                            break;
                        case "manual":
                            //subiect
                            subject = subjectTF.getText();

                            biblioteca.adaugaCarteinStoc(new Manual(tile,author,subject));
                            break;
                    }

                    JOptionPane.showMessageDialog(frame, "Success", "Olee",  JOptionPane.INFORMATION_MESSAGE);


                }


                break;


            case "Back to menu":
                MainFrame mainFrame = new MainFrame(biblioteca);
                frame.dispose();
                break;
        }








    }
}
