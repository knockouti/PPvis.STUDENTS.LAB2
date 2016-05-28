package Controller;

import Model.Student;
import View.*;
import com.toedter.calendar.JDateChooser;
import javafx.scene.control.Tab;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Игорь on 19.04.2016.
 */
public class ControllerButton implements ControllerInterface {
    MainWindow mainWindow;
    TableModel tableModel;
    TableModel searchModel;
    Student student;
    DialogInput dialogInput;
    Delete delete;
    Search search;
    Date dateBirthday;
    int deleteStrudent;

    public ControllerButton() {
        mainWindow = new MainWindow(this);
        tableModel = new View.TableModel();
        searchModel = new TableModel();
        mainWindow.addTableModel(tableModel);
        mainWindow.setBool(true);
        dialogInput = new DialogInput(this);
        delete = new Delete(this);
        deleteStrudent = 0;
        search = new Search(this);

    }

    public void addNewStudent() {
        student = new Student();

    }

    public Student getStudent() {
        return student;
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

    public void setPosition(JComboBox jcomboBox) {
        student.setPosition(jcomboBox.getSelectedItem().toString());

    }

    public void setComposition(JComboBox jComboBox) {
        student.setComposition(jComboBox.getSelectedItem().toString());
    }

    public void setFaculty(JComboBox jcomboBox) {


        student.setFaculty(jcomboBox.getSelectedItem().toString());
    }

    public void setFootbalTeam(JTextField textField) {
        student.setFootbalTeam(textField.getText());
    }

    public void setDataTable() {
        tableModel.addData(student);

    }

    public void setData(JDateChooser dateChooser) {
        student.setDateBirthday(dateChooser.getDate());
    }

    public void setNullDate(JDateChooser dateChooser) {
        dateChooser.setToolTipText("");

    }

    @Override
    public void add() {
        mainWindow.setBool(true);
        dialogInput.setBool(true);
    }

    public TableModel searchNameDate(JTextField textFieldName, JTextField textFieldSurname, JTextField textFieldPatronomic, JDateChooser dateChooser) {
        searchModel = null;
        searchModel = new TableModel();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
        if (dateChooser == null) {
            dateChooser = new JDateChooser();
        }
        if (dateChooser.getDate() == null) {

            Date date = new Date();
            dateChooser.setDate(date);
        }
        try {
            dateBirthday = simpleDateFormat.parse(simpleDateFormat.format(dateChooser.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int count = 0; count < tableModel.getOneStudent().size(); count++) {
            if ((textFieldName.getText().equals(tableModel.getOneStudent().get(count).getName()) && textFieldSurname.getText().equals(tableModel.getOneStudent().get(count).getSurname()) && textFieldPatronomic.getText().equals(tableModel.getOneStudent().get(count).getPatronomic())) || dateBirthday.equals(tableModel.getOneStudent().get(count).getBirthdayDate())) {
                searchModel.addData(tableModel.getOneStudent().get(count));
                searchModel.fireTableDataChanged();


            }
        }

        dateChooser.setCalendar(null);
        textFieldName.setText("");
        textFieldSurname.setText("");
        textFieldPatronomic.setText("");
        return searchModel;
    }

    public TableModel searchPosComp(JComboBox comboboxPosition, JComboBox comboboxComposition) {
        searchModel = null;
        searchModel = new TableModel();
        if (comboboxComposition.getSelectedIndex() != -1 && comboboxPosition.getSelectedIndex() != -1) {
            for (int count = 0; count < tableModel.getOneStudent().size(); count++) {
                if (comboboxPosition.getSelectedItem().toString().equals(tableModel.
                        getOneStudent().get(count).getPosition())
                        || comboboxComposition.getSelectedItem().toString().
                        equals(tableModel.getOneStudent().get(count).getComposition())) {
                    searchModel.addData(tableModel.getOneStudent().get(count));
                    searchModel.fireTableDataChanged();

                }
            }
        }
        return searchModel;
    }

    public TableModel searchNameFaculty(JTextField textFieldName, JTextField textFieldSurname, JTextField textFieldPatronomic, JComboBox comboboxFaculty) {
        searchModel = null;
        searchModel = new TableModel();
        if (comboboxFaculty.getSelectedIndex() != -1)
            for (int count = 0; count < tableModel.getOneStudent().size(); count++) {
                if ((textFieldName.getText().equals(tableModel.getOneStudent().get(count).getName()) && textFieldSurname.getText().equals(tableModel.getOneStudent().get(count).getSurname()) && textFieldPatronomic.getText().equals(tableModel.getOneStudent().get(count).getPatronomic())) || comboboxFaculty.getSelectedItem().toString().equals(tableModel.
                        getOneStudent().get(count).getFaculty())) {
                    searchModel.addData(tableModel.getOneStudent().get(count));
                    searchModel.fireTableDataChanged();

                }
                textFieldName.setText("");
                textFieldSurname.setText("");
                textFieldPatronomic.setText("");
            }
        return searchModel;
    }

    public TableModel searchNameFootball(JTextField textFieldName, JTextField textFieldSurname, JTextField textFieldPatronomic, JTextField textFieldFootballTeam) {
        searchModel = null;
        searchModel = new TableModel();
        for (int count = 0; count < tableModel.getOneStudent().size(); count++)

            if ((textFieldName.getText().equals(tableModel.getOneStudent().get(count).getName()) && textFieldSurname.getText().equals(tableModel.getOneStudent().get(count).getSurname()) && textFieldPatronomic.getText().equals(tableModel.getOneStudent().get(count).getPatronomic())) || textFieldFootballTeam.getText().equals(tableModel.getOneStudent().get(count).getFootballTeam())) {
                searchModel.addData(tableModel.getOneStudent().get(count));
                searchModel.fireTableDataChanged();

            }
        textFieldName.setText("");
        textFieldSurname.setText("");
        textFieldPatronomic.setText("");
        textFieldFootballTeam.setText("");
        return searchModel;
    }

    public void deleteNameDate(JTextField textFieldName, JTextField textFieldSurname, JTextField textFieldPatronomic, JDateChooser dateChooser) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy");
        if (dateChooser == null) {
            dateChooser = new JDateChooser();
        }
        if (dateChooser.getDate() == null) {

            Date date = new Date();
            dateChooser.setDate(date);
        }
        try {
            dateBirthday = simpleDateFormat.parse(simpleDateFormat.format(dateChooser.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int count = 0; count < tableModel.getOneStudent().size(); count++) {
            if ((textFieldName.getText().equals(tableModel.getOneStudent().get(count).getName()) && textFieldSurname.getText().equals(tableModel.getOneStudent().get(count).getSurname()) && textFieldPatronomic.getText().equals(tableModel.getOneStudent().get(count).getPatronomic())) || dateBirthday.equals(tableModel.getOneStudent().get(count).getBirthdayDate())) {
                tableModel.getOneStudent().remove(count);

                tableModel.fireTableDataChanged();
                deleteStrudent++;
                count--;
            }
        }
        tableModel.changelist();
        dateChooser.setCalendar(null);
        textFieldName.setText("");
        textFieldSurname.setText("");
        textFieldPatronomic.setText("");
    }

    public void deletePosComp(JComboBox comboboxPosition, JComboBox comboboxComposition) {
        if (comboboxComposition.getSelectedIndex() != -1 && comboboxPosition.getSelectedIndex() != -1) {
            for (int count = 0; count < tableModel.getOneStudent().size(); count++) {
                if (comboboxPosition.getSelectedItem().toString().equals(tableModel.
                        getOneStudent().get(count).getPosition())
                        || comboboxComposition.getSelectedItem().toString().
                        equals(tableModel.getOneStudent().get(count).getComposition())) {
                    tableModel.getOneStudent().remove(count);

                    tableModel.fireTableDataChanged();
                    deleteStrudent++;
                    count--;
                }
            }
        }
        tableModel.changelist();

    }

    public void deleteNameFaculty(JTextField textFieldName, JTextField textFieldSurname, JTextField textFieldPatronomic, JComboBox comboboxFaculty) {
        if (comboboxFaculty.getSelectedIndex() != -1)
            for (int count = 0; count < tableModel.getOneStudent().size(); count++) {
                if ((textFieldName.getText().equals(tableModel.getOneStudent().get(count).getName()) && textFieldSurname.getText().equals(tableModel.getOneStudent().get(count).getSurname()) && textFieldPatronomic.getText().equals(tableModel.getOneStudent().get(count).getPatronomic())) || comboboxFaculty.getSelectedItem().toString().equals(tableModel.
                        getOneStudent().get(count).getFaculty())) {
                    tableModel.getOneStudent().remove(count);

                    tableModel.fireTableDataChanged();
                    deleteStrudent++;
                    count--;
                }
                tableModel.changelist();
                textFieldName.setText("");
                textFieldSurname.setText("");
                textFieldPatronomic.setText("");
            }

    }

    public void deleteFootbalTeam(JTextField textFieldName, JTextField textFieldSurname, JTextField textFieldPatronomic, JTextField textFieldFootballTeam) {

        for (int count = 0; count < tableModel.getOneStudent().size(); count++)

            if ((textFieldName.getText().equals(tableModel.getOneStudent().get(count).getName()) && textFieldSurname.getText().equals(tableModel.getOneStudent().get(count).getSurname()) && textFieldPatronomic.getText().equals(tableModel.getOneStudent().get(count).getPatronomic())) || textFieldFootballTeam.getText().equals(tableModel.getOneStudent().get(count).getFootballTeam())) {
                tableModel.getOneStudent().remove(count);

                tableModel.fireTableDataChanged();
                deleteStrudent++;
                count--;
            }
        tableModel.changelist();
        textFieldName.setText("");
        textFieldSurname.setText("");
        textFieldPatronomic.setText("");
        textFieldFootballTeam.setText("");
    }

    public int getCountDeleteStudent() {
        return deleteStrudent;

    }

    public void setCountStudentNull(int zero) {
        deleteStrudent = zero;
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
        mainWindow.setBool(false);
        delete.setBool(true);

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
