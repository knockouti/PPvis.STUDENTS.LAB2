package Controller;

import Model.Faculty;
import Model.FootbalTeam;
import Model.Student;
import View.*;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;


/**
 * Created by Игорь on 19.04.2016.
 */
public class ControllerButton implements ControllerInterface {
    MainWindow mainWindow;
    TableModel tableModel;
    Student student;
    DialogInput dialogInput;
    Delete delete;
    Search search;

    public ControllerButton() {
        mainWindow = new MainWindow(this);
        tableModel = new View.TableModel();
        mainWindow.addTableModel(tableModel);
        mainWindow.setBool(true);
        dialogInput = new DialogInput(this);
        delete = new Delete(this);
        search = new Search(this);
        search.addTableModel(tableModel);
    }

    public void addNewStudent() {
        student = new Student();

    }

    public void setName(JTextField textField) {
        student.setName(textField.getText());
    }

    public void setSurname(JTextField textField) {
        student.setSurname(textField.getText());
    }

    public void setPatronomic(JTextField textField) {
        student.setPatronomic(textField.getText());
    }

    public void setPosition(JTextField textField) {
        student.setPosition(textField.getText());
    }

    public void setComposition(JTextField textField) {
        student.setComposition(textField.getText());
    }

    public void setFaculty(JTextField textField) {
        student.setFaculty(textField.getText());
    }

    public void setFootbalTeam(JTextField textField) {
        student.setFootbalTeam(textField.getText());
    }

    public void setDataTable() {
        tableModel.addData(student);

    }
    public void setData(JDateChooser dateChooser){
        student.setDateBirthday(dateChooser.getDate());
    }
    public void setNullDate(JDateChooser dateChooser){
        dateChooser.setToolTipText("");

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
