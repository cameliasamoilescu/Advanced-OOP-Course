import interfata.MainFrame;
import servicii.Biblioteca;

import javax.swing.*;

public class AppGUI extends JFrame {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.start();
        MainFrame mainFrame = new MainFrame(biblioteca);
    }
}