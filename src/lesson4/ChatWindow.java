package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ChatWindow extends JFrame {
    private JTextField jtfMessage;
    private JTextField jtfName;
    private JTextArea jtaTextArea;

    public ChatWindow() {
        // Set form elements settings
        setBounds(600, 300, 600, 500);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jtaTextArea = new JTextArea();
        jtaTextArea.setEditable(false);
        jtaTextArea.setLineWrap(true);

        JScrollPane jsp = new JScrollPane(jtaTextArea);
        add(jsp, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JButton jbSendMessage = new JButton("Send");
        bottomPanel.add(jbSendMessage, BorderLayout.EAST);

        jtfMessage = new JTextField("Enter your message: ");
        bottomPanel.add(jtfMessage, BorderLayout.CENTER);
        jtfName = new JTextField("Enter your name: ");
        bottomPanel.add(jtfName, BorderLayout.WEST);
        // Handle send message
        jbSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!jtfMessage.getText().trim().isEmpty() && !jtfName.getText().trim().isEmpty()) {
                    sendMsg();
                    jtfMessage.grabFocus();
                }
            }
        });
        // Clear message field
        jtfMessage.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMessage.setText("");
            }
        });
        // Clear name field
        jtfName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfName.setText("");
            }
        });
        setVisible(true);
    }

    void sendMsg() {
        String messageStr = jtfName.getText() + ": " + jtfMessage.getText();
        jtaTextArea.append(messageStr + "\n");
        jtfMessage.setText("");
    }
}