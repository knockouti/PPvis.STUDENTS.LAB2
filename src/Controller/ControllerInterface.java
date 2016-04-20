package Controller;

import javax.swing.*;

/**
 * Created by Игорь on 19.04.2016.
 */
public interface ControllerInterface {
    void add();

    void goMainFrame();

    void goMainDelete();

    void goMainSearch();

    void setTextFielNull(JTextField textField);

    void setName(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField textField5, JTextField textField6);
}
