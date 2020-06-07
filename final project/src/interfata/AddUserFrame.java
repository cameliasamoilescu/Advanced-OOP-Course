package interfata;

import persoana.Adult;
import persoana.Copil;
import persoana.Student;
import servicii.Biblioteca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserFrame implements ActionListener {
    private Biblioteca biblioteca;
    private JFrame frame;
    private JLabel lastName, firstName, cnp, phoneNumber, discount, age;
    private JTextField lastNameTF, firstNameTF, cnpTF, phoneNumberTF, discountTF, ageTF;
    private JButton submit;
    private JRadioButton jrb1, jrb2, jrb3;

    private boolean pressSubmit1;
    private String user;

    public AddUserFrame(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        frame = new JFrame("Add User");
        jrb1 = new JRadioButton();
        jrb1.setText("Adult");

        pressSubmit1 = false;

        jrb1.setBounds(80, 90, 200, 30);

        Label l1 = new Label("The person is a ");
        l1.setBounds(80, 50, 200, 30);


        frame.add(l1);
        frame.add(jrb1);
        jrb2 = new JRadioButton();
        jrb2.setText("Student");
        jrb2.setBounds(80, 120, 200, 30);
        frame.add(jrb2);


        jrb3 = new JRadioButton();
        jrb3.setText("Child");
        jrb3.setBounds(80, 150, 200, 30);
        frame.add(jrb3);


        lastName = new JLabel("Last Name");
        firstName = new JLabel("First Name");
        phoneNumber = new JLabel("Phone Number");
        cnp = new JLabel("Cnp");
        discount = new JLabel("crt");
        age = new JLabel("Age");


        lastNameTF = new JTextField();
        firstNameTF = new JTextField();
        cnpTF = new JTextField();
        phoneNumberTF = new JTextField();
        discountTF = new JTextField("Type 'yes' if the person has discount");
        ageTF = new JTextField("Please enter a number");


        submit = new JButton("Add User");
        JButton submit1 = new JButton("Select");
        JButton submit2 = new JButton("Back to menu");


        ButtonGroup G = new ButtonGroup();

        G.add(jrb1);
        G.add(jrb2);
        G.add(jrb3);


        lastName.setBounds(500, 100, 200, 30);
        firstName.setBounds(500, 150, 200, 30);
        cnp.setBounds(500, 200, 200, 30);
        phoneNumber.setBounds(500, 250, 200, 30);


        lastNameTF.setBounds(600, 100, 200, 30);
        firstNameTF.setBounds(600, 150, 200, 30);
        cnpTF.setBounds(600, 200, 200, 30);
        phoneNumberTF.setBounds(600, 250, 200, 30);

        discount.setBounds(500, 300, 200, 30);
        age.setBounds(500, 300, 200, 30);

        discountTF.setBounds(600, 300, 300, 30);
        ageTF.setBounds(600, 300, 200, 30);

        submit.setBounds(640, 400, 200, 30);
        submit1.setBounds(80, 220, 200, 30);
        submit2.setBounds(300, 500, 200, 30);
        frame.add(submit1);
        frame.add(submit2);

        frame.add(lastName);
        frame.add(firstName);
        frame.add(lastNameTF);
        frame.add(firstNameTF);
        frame.add(cnp);
        frame.add(cnpTF);
        frame.add(phoneNumber);
        frame.add(phoneNumberTF);

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

        boolean check  = true;
            switch (e.getActionCommand()) {
                case "Select":

                    if (jrb1.isSelected()) {

                        frame.add(discount);
                        frame.add(discountTF);
                        frame.repaint();


                        pressSubmit1 = true;
                        user = "adult";

                    } else if (jrb3.isSelected()) {
                        pressSubmit1 = true;
                        //roman
                        //

                        frame.add(age);
                        frame.add(ageTF);
                        frame.repaint();
                        user = "copil";

                    } else if (jrb2.isSelected()) {
                        pressSubmit1 = true;
                        //manual
                        //subject

                        frame.add(discount);
                        frame.add(discountTF);
                        frame.repaint();
                        user = "student";

                    }
                    else
                    {
                        JOptionPane.showMessageDialog(frame, "Please select an option", "Option error",  JOptionPane.INFORMATION_MESSAGE);

                    }

                    break;

                case "Add User":


                    String lastName = lastNameTF.getText();
                    String firstName = firstNameTF.getText();
                    String cnp = cnpTF.getText();
                    String phoneNumber = phoneNumberTF.getText();


                    String crt;
                    int age;


                    if(!pressSubmit1) {
                        JOptionPane.showMessageDialog(frame, "Please select an option", "Option error",  JOptionPane.INFORMATION_MESSAGE);


                    }
                    else{
                        switch (user){
                            case "adult":
                                // editura

                                crt = discountTF.getText();



                                if (crt.equals("yes"))
                                    check = biblioteca.adaugaAbonat(new Adult(lastName, firstName, cnp, phoneNumber, true));
                                else
                                    check =  biblioteca.adaugaAbonat(new Adult(lastName, firstName, cnp, phoneNumber, false));


                                break;

                            case "copil":
                                //tip editura
                                age = Integer.parseInt(ageTF.getText());

                                check = biblioteca.adaugaAbonat(new Copil(lastName,firstName,cnp,phoneNumber,age));


                                break;
                            case "student":
                                crt = discountTF.getText();


                                if (crt.equals("yes"))
                                    check = biblioteca.adaugaAbonat(new Student(lastName, firstName, cnp, phoneNumber, true));
                                else
                                    check = biblioteca.adaugaAbonat(new Student(lastName, firstName, cnp, phoneNumber, false));


                        }

                    }
                    if(!check) {
                        JOptionPane.showMessageDialog(frame, "User already in our data base", "User error",  JOptionPane.INFORMATION_MESSAGE);

                    }
                    else {
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
