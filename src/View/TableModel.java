package View;

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
    List<Student> strStudent;
    List<Student> str2Strudent;
    private int visibleSize = 20; //количество записей на странице
    private int visible = visibleSize;
    private int current = 1;   //текущая страница
    int pageCount = 20;
    int balance = 0;

    public TableModel() {
        oneStudent = new ArrayList<>();
        strStudent = new ArrayList<>();
//        outpuStr = new OutpuStr(this);
    }

    public List<Student> getOneStudent() {
        return (ArrayList<Student>) oneStudent;
    }


    @Override
    public int getRowCount() {
        if (strStudent.size() >= visibleSize) {
            return visibleSize;
        } else {
            return oneStudent.size() % visibleSize;
        }
    }

    public void setVisibleSize(int visibleSize) {
        this.visibleSize = visibleSize;
        strStudent = oneStudent.subList(0, oneStudent.size());
        current = 1;
        visible = visibleSize;
        this.fireTableDataChanged();
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCurrent() {

        return current;
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
                return (strStudent.get(rowIndex).getSurname() + " " + strStudent.get(rowIndex).getName() + " " +strStudent.get(rowIndex).getPatronomic());
            case DATE_BIRTH:
                return strStudent.get(rowIndex).getDateBirthday();
            case FOOT:
                return strStudent.get(rowIndex).getFootballTeam();
            case FAC:
                return strStudent.get(rowIndex).getFaculty();
            case COMP:
                return strStudent.get(rowIndex).getComposition();
            case POSIT:
                return strStudent.get(rowIndex).getPosition();
        }
        return "";
    }

    public void pageUp() {
        if (current < oneStudent.size() / visibleSize) {
            if (visible == 0) {
                visible = visibleSize;
            }
            strStudent = oneStudent.subList(visible, visible + visibleSize);
            visible += visibleSize;
            current++;
        } else if (current == this.getNubmerStr()) {
            visible = oneStudent.size() - oneStudent.size() % visibleSize;
            strStudent = oneStudent.subList(visible, visible + oneStudent.size() % visibleSize);
           ;

        } else if (current > strStudent.size() % visibleSize) {
            strStudent = oneStudent.subList(visible, visible + oneStudent.size() % visibleSize);

            current++;
        }
        fireTableDataChanged();
    }

    public int getNubmerStr() {
        if (oneStudent.size() % visibleSize == 0)
            return oneStudent.size() / visibleSize;
        else
            return oneStudent.size() / visibleSize + 1;
    }

    public void pageDown() {

        if (current != 1) {
               strStudent = oneStudent.subList(visible - visibleSize, visible);
               visible -= visibleSize;
               current--;
        }
        fireTableDataChanged();
    }
    public void goFirstStr(){
        if(current!=1){
            visible=visibleSize;
            strStudent = oneStudent.subList(visible - visibleSize, visible);

            current=1;

        }
        fireTableDataChanged();
    }


    public void changelist() {
        strStudent = oneStudent.subList(0, oneStudent.size());
    }

    public void addData(Student student) {
        oneStudent.add(student);
        strStudent = oneStudent.subList(0, oneStudent.size());
        fireTableDataChanged();
    }


}
