package Controller;

import Model.Faculty;
import Model.FootbalTeam;
import Model.Student;
import View.*;

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
    FootbalTeam footbalTeam;
    Faculty faculty;


    public ControllerButton() {

        mainWindow = new MainWindow(this);
        tableModel = new View.TableModel();
        mainWindow.addTableModel(tableModel);


        mainWindow.setBool(true);
        dialogInput = new DialogInput(this);
        delete = new Delete(this);
        search = new Search(this);


    }

    public void addNewStudent() {
        student = new Student();
        footbalTeam = new FootbalTeam();
        faculty = new Faculty();
    }

    public void setName(JTextField textField) {
        student.setName(textField.getText());

    }
    public void setFaculty(JTextField textField) {
        faculty.setNameFaculty(textField.getText());

    }

    public void setSurname(JTextField textField) {
        student.setSurname(textField.getText());

    }

    public void setPatronomic(JTextField textField) {
        student.setPatronomic(textField.getText());


    }
    public void setNameFootballTeam(JTextField textField) {
        footbalTeam.setNameFootballTeam(textField.getText());


    }
    public void setPosition(JTextField textField) {
        student.setPosition(textField.getText());


    }
    public void setComposition(JTextField textField) {
        student.setComposition(textField.getText());


    }

    public void setDataTable() {
        tableModel.addData(student);
        tableModel.addData(footbalTeam);
        tableModel.addData(faculty);
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
