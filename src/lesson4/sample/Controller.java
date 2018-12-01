package lesson4.sample;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    public TextField jtf;
    public TextArea jta;

    public void sendMsg(){
        jta.appendText(jtf.getText() + "\n");
        jtf.clear();
        jtf.requestFocus();
    }
}
