package View;

import Controller.ControllerButton;
import Model.Faculty;
import Model.FootbalTeam;
import Model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 22.04.2016.
 */
public class TableModel extends AbstractTableModel {
    public static final int FIO_COL = 0;
    private int  columnCount = 6;
    List<Student>oneStudent;
    List<FootbalTeam> oneFootbalTeam;
    List<Faculty> oneFaculty;
    private final int visibleSize = 20; //количество записей на странице
    private int pageCount;   //количество страниц
    private int ostatok;     //количество записей на последней странице
    private int current = 1;   //текущая страница
    private int visible = 0;
    private boolean flag = true;  //флаг для отреления первой и последней страницы


    public TableModel() {

        oneStudent = new ArrayList<>();
        oneFootbalTeam = new ArrayList<>();
        oneFaculty = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return oneStudent.size();

    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case FIO_COL:
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
            case FIO_COL:
                return (oneStudent.get(rowIndex).getSurname() + " " + oneStudent.get(rowIndex).getName() + " " + oneStudent.get(rowIndex).getPatronomic());
            case 1:
                return oneStudent.get(rowIndex).getDateBirthday();
            case 2:
                return oneStudent.get(rowIndex).getFootballTeam();
            case 3:
                return oneStudent.get(rowIndex).getFaculty();
            case 4:
                return oneStudent.get(rowIndex).getComposition();
            case 5:
                return oneStudent.get(rowIndex).getPosition();
        }
        return "";
    }

    public void addData(Student student) {

        oneStudent.add(student);
        fireTableDataChanged();

    }




}
