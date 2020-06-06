package swing_example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {
    private JButton helloButton;
    private JButton goodByeButton;

    private TypingListener typingListener;

    public Toolbar(){
        helloButton = new JButton("hello");
        helloButton.addActionListener(this);

        goodByeButton = new JButton("bye");
        goodByeButton.addActionListener(this);

        setLayout(new FlowLayout((FlowLayout.LEFT)));
        add(helloButton);
        add(goodByeButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if(clicked == helloButton){
            if(typingListener != null){
                typingListener.textTyped("hello button clicked\n");

            }
        }
        else if(clicked == goodByeButton){
            if(typingListener != null)
            {typingListener.textTyped("goodbye button clicked\n");}
        }
    }

    public TypingListener getTypingListener() {
        return typingListener;
    }

    public void setTypingListener(TypingListener typingListener) {
        this.typingListener = typingListener;
    }
}
