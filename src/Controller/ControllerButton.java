package Controller;

import Model.TableModel;
import View.Delete;
import View.DialogInput;
import View.MainWindow;
import View.Search;

import javax.sql.rowset.serial.SerialArray;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Игорь on 19.04.2016.
 */
public class ControllerButton implements ControllerInterface {
    MainWindow mainWindow;
    TableModel tableModel;
    DialogInput dialogInput;
    Delete delete;
    Search search;
    String[] addStr;


    public ControllerButton(TableModel tableModel) {
        this.tableModel = tableModel;
        mainWindow = new MainWindow(this, tableModel);
        mainWindow.setBool(true);
        dialogInput = new DialogInput(this);
        delete = new Delete(this);
        search = new Search(this);


    }

    public void setName(JTextField textField1, JTextField textField2, JTextField textField3, JTextField textField4, JTextField textField5, JTextField textField6) {
        addStr = new String[6];
        addStr[0] = textField1.getText();
        addStr[1] = textField2.getText();
        addStr[2] = textField3.getText();
        addStr[3] = textField4.getText();
        addStr[4] = textField5.getText();
        addStr[5] = textField6.getText();
        tableModel.addDataTable(addStr);
    }


    @Override
    public void add() {
        mainWindow.setBool(true);
        dialogInput.setBool(true);
    }

    @Override
    public void goMainFrame() {
        mainWindow.setBool(true);
        delete.setBool(false);
        search.setBool(false);
        dialogInput.setBool(false);
    }

    @Override
    public void goMainDelete() {
        delete.setBool(true);
        mainWindow.setBool(false);
    }

    @Override
    public void goMainSearch() {
        search.setBool(true);
        mainWindow.setBool(false);
    }

    @Override
    public void setTextFielNull(JTextField textField) {
        textField.setText("");
    }
}
