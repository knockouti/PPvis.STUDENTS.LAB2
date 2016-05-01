package View;

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
    private static final int DATE_BIRTH = 1;
    private static final int FOOT = 2;
    private static final int FAC = 3;
    private static final int COMP = 4;
    private static final int POSIT = 5;
    private int columnCount = 6;
    List<Student> oneStudent;
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

    }

    public ArrayList<Student> getOneStudent() {
        return (ArrayList<Student>) oneStudent;
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
            case DATE_BIRTH:
                return "Дата Рождения";
            case FOOT:
                return "Футбольная команда";
            case FAC:
                return "Факультет";
            case COMP:
                return "Состав";
            case POSIT:
                return "Позиция";
        }
        return "";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case FIO_COL:
                return (oneStudent.get(rowIndex).getSurname() + " " + oneStudent.get(rowIndex).getName() + " " + oneStudent.get(rowIndex).getPatronomic());
            case DATE_BIRTH:
                return oneStudent.get(rowIndex).getDateBirthday();
            case FOOT:
                return oneStudent.get(rowIndex).getFootballTeam();
            case FAC:
                return oneStudent.get(rowIndex).getFaculty();
            case COMP:
                return oneStudent.get(rowIndex).getComposition();
            case POSIT:
                return oneStudent.get(rowIndex).getPosition();
        }
        return "";
    }

    public void addData(Student student) {

        oneStudent.add(student);
        fireTableDataChanged();

    }


}
