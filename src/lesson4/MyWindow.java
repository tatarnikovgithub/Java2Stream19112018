package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyWindow extends JFrame {
    private JTextField jtfMsg;
    private JTextArea jtaChat;

    MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lesson-04");
        setBounds(300, 200, 400, 400);

        JButton jbSendMsg = new JButton("Отправить");
        jbSendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        jtaChat = new JTextArea(10,20);
        jtaChat.setLineWrap(true);
        Font font = new Font("Arial", Font.PLAIN, 24);
        jtaChat.setFont(font);
        JScrollPane jsp = new JScrollPane(jtaChat);
        jtaChat.setEditable(false);
        add(jsp);

        jtfMsg = new MyHintTextField("Введите сообщение");
        jtfMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyWindow.this.sendMsg();
            }
        });

        JPanel footerPanel = new JPanel(new BorderLayout());
        footerPanel.add(jbSendMsg, BorderLayout.EAST);
        footerPanel.add(jtfMsg, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
        jtfMsg.requestFocus();
    }

    private void sendMsg() {
//    if ( !jtfMsg.getText().trim().isBlank() ){
      if ( !jtfMsg.getText().trim().isEmpty() ){
        jtaChat.append(jtfMsg.getText() + "\n");
        jtfMsg.setText("");
      }
      jtfMsg.grabFocus();
    }

  class MyHintTextField extends JTextField{
    String hint;

    MyHintTextField(String hint) {
      this.hint = hint;
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (getText().isEmpty()) {
        g.drawString(hint, 4, 16);
      }
    }
  }
}
