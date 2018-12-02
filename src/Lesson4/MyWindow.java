package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private JButton jb;
    private JTextField jtf;
    private JTextArea jta;


    public MyWindow() {
        setTitle("Messenger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600, 200, 400, 500);
        setVisible(true);
        setLayout(new BorderLayout());
        jb = new JButton();
        jb.setBounds(10,10,30,20);
        jb.setText("Send");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });
        //add(jb);

        jtf = new JTextField();
        jtf.setColumns(20);
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        jta = new JTextArea(10,10);
        jta.setLineWrap(true);
        Font font = new Font("Arrial", Font.PLAIN, 24);
        jta.setFont(font);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp,BorderLayout.CENTER);

        JPanel myPanel = new JPanel(new BorderLayout());
        //myPanel.setBounds(100,100,40,40);
        myPanel.add(jtf, BorderLayout.WEST);
        myPanel.add(jb, BorderLayout.EAST);
        add(myPanel,BorderLayout.SOUTH);
    }

    public void sendMsg() {
        if (!jtf.getText().isEmpty()) {
            jta.append(jtf.getText() + "\n");
            jtf.setText("");
        }
        jtf.grabFocus();
    }

}
