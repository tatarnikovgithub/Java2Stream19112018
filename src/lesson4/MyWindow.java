package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyWindow extends JFrame {
    private JTextField jtf;
    private JTextArea jta;

    class MyHintTextField extends JTextField{
        String hint;

        public MyHintTextField(String hint) {
            this.hint = hint;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (getText().isEmpty()) g.drawString(hint, 4, 16);
        }
    }

    public MyWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("My Application");
        setBounds(1500, 500, 400, 400);
        JButton jb1 = new JButton("Button #1");
        JButton jb2 = new JButton("Button #2");
//        add(jb1);
//        add(jb2);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });

        jtf = new MyHintTextField("Введите слово");
        jta = new JTextArea(10,20);
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);
//        add(jtf);


        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyWindow.this.sendMsg();
            }
        });
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyWindow.this.sendMsg();
            }
        });
        JPanel upperPanel = new JPanel(new BorderLayout());
        upperPanel.add(jb1, BorderLayout.WEST);
        upperPanel.add(jb2, BorderLayout.EAST);
        upperPanel.add(jtf, BorderLayout.CENTER);
        add(upperPanel, BorderLayout.NORTH);
        JButton jbWarning = new JButton("Warning");
        jbWarning.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "WARNING!!!");
//                JOptionPane.showInputDialog(null, "Here is your value", "10");
                JOptionPane.showOptionDialog(null, "msg", "title",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"A", "B", "C", "D"}, "A");
            }
        });
        jbWarning.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                jbWarning.setBackground(new Color((int)((float)e.getX()/(float)jbWarning.getWidth() * 255f), 0,0));
            }
        });

        Font font = new Font("Arial", Font.PLAIN, 24);
        jta.setFont(font);
        add(jbWarning, BorderLayout.SOUTH);
        JList<String> jls = new JList<>(new DefaultListModel<>());
        add(jls, BorderLayout.EAST);
        jls.setPreferredSize(new Dimension(100,1));
        ((DefaultListModel<String>)jls.getModel()).addElement("A");
        ((DefaultListModel<String>)jls.getModel()).addElement("B");
        ((DefaultListModel<String>)jls.getModel()).addElement("C");
        JLabel jll = new JLabel("Hello Java");
        add(jll, BorderLayout.WEST);

        setVisible(true);
    }

    public void sendMsg(){
        jta.append(jtf.getText() + "\n");
        jtf.setText("");
        jtf.grabFocus();
    }
}
