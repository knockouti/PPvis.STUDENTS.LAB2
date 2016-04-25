package View;

import Controller.ControllerButton;
import Model.Faculty;
import Model.FootbalTeam;
import Model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Игорь on 22.04.2016.
 */
public class TableModel extends AbstractTableModel {
    private int columnCount = 6;
    public int n=0;
    Student student;
    TableModel tableModel;
    ControllerButton controllerButton;

    ArrayList<Student> oneStudent;
    ArrayList<FootbalTeam> oneFootbalTeam;
    ArrayList<Faculty> oneFaculty;

    public TableModel() {

        oneStudent = new ArrayList<>();
        oneFootbalTeam = new ArrayList<>();
        oneFaculty = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return oneStudent.size();
        //        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Ф.И.О";
            case 1:
                return "Дата Рождения";
            case 2:
                return "Футбольная команда";
            case 3:
                return "Факультет";
            case 4:
                return "Состав";
            case 5:
                return "Позиция";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return (oneStudent.get(rowIndex).getSurname() + " " + oneStudent.get(rowIndex).getName() + " " + oneStudent.get(rowIndex).getPatronomic());
            case 1:
                return oneStudent.get(rowIndex).getDateBirthday();
            case 2:
                return  oneFootbalTeam.get(rowIndex).getNameFootballTeam();
            case 3:
                return  oneFaculty.get(rowIndex).getNameFaculty();
            case 4:
                return oneStudent.get(rowIndex).getComposition();
            case 5:
                return oneStudent.get(rowIndex).getPosition();
        }
        return "";
    }

  public void addData(Student student){

      oneStudent.add(student);
fireTableDataChanged();

  }
    public void addData(FootbalTeam footballTeam){
        oneFootbalTeam.add(footballTeam);
        fireTableDataChanged();
    }
    public void addData(Faculty faculty){
        oneFaculty.add(faculty);
        fireTableDataChanged();
    }


}
