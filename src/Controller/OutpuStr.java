package Controller;

import Model.Student;
import View.TableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Created by Игорь on 28.05.2016.
 */
public class OutpuStr extends JPanel{
    List<Student> oneStudent;
    List<Student> strStudent;
    private int visibleSize = 20; //количество записей на странице
    private int visible = visibleSize;
    private int current = 1;   //
    private TableModel tableModel;
public OutpuStr(TableModel tableModel){
    this.tableModel =tableModel;
    JTextField textFieldForVisibleSize = new JTextField();
    textFieldForVisibleSize.setFont(textFieldForVisibleSize.getFont().deriveFont(15f));
    textFieldForVisibleSize.setPreferredSize(new Dimension(30, 30));
    JButton next = new JButton("next");
    JButton firstElement = new JButton("1");
    JButton lateElement = new JButton();
    if(tableModel.getOneStudent().size() == 0){
        lateElement.setText("-");
    }
    JLabel labelCurrentPage =  new JLabel();
    labelCurrentPage.setPreferredSize(new Dimension(30,30));
    labelCurrentPage.setText(String.valueOf(getCurrent()));
    next.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pageUp();
            labelCurrentPage.setText(String.valueOf(getCurrent()));

        }
    });
    JButton prev = new JButton("Prev");
    lateElement.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            lateElement.setText(String.valueOf(getNubmerStr()));
            setCurrent(getNubmerStr());
           pageUp();
            labelCurrentPage.setText(String.valueOf(getCurrent()));
        }
    });
    firstElement.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            setCurrent(getNubmerStr());
            goFirstStr();
            labelCurrentPage.setText(String.valueOf(getCurrent()));
        }
    });
    prev.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            pageDown();
            labelCurrentPage.setText(String.valueOf(getCurrent()));

        }
    });
    textFieldForVisibleSize.addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                setVisibleSize(Integer.valueOf(textFieldForVisibleSize.getText()).intValue());
                labelCurrentPage.setText(String.valueOf(getCurrent()));
            }
        }
    });
    this.add(prev);
    this.add(firstElement);
    this.add(labelCurrentPage);
    this.add(lateElement);
    this.add(next);
    this.add(textFieldForVisibleSize);
}

    public void setVisibleSize(int visibleSize) {
        this.visibleSize = visibleSize;
        strStudent = tableModel.getOneStudent().subList(0, tableModel.getOneStudent().size());
        current = 1;
        visible = visibleSize;
        tableModel.setStrStudent(strStudent);
        tableModel.fireTableDataChanged();
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getCurrent() {

        return current;
    }

    public void pageUp() {
        if (current < tableModel.getOneStudent().size() / visibleSize) {
            if (visible == 0) {
                visible = visibleSize;
            }
            strStudent = tableModel.getOneStudent().subList(visible, visible + visibleSize);
            visible += visibleSize;
            current++;
        } else if (current == this.getNubmerStr()) {
            visible = tableModel.getOneStudent().size() - tableModel.getOneStudent().size() % visibleSize;
            strStudent = tableModel.getOneStudent().subList(visible, visible + tableModel.getOneStudent().size() % visibleSize);


        } else if (current > strStudent.size() % visibleSize) {
            strStudent = tableModel.getOneStudent().subList(visible, visible + tableModel.getOneStudent().size() % visibleSize);

            current++;
        }
        tableModel.setStrStudent(strStudent);
        tableModel.fireTableDataChanged();
    }

    public int getNubmerStr() {
        if (tableModel.getOneStudent().size() % visibleSize == 0)
            return tableModel.getOneStudent().size() / visibleSize;
        else
            return tableModel.getOneStudent().size() / visibleSize + 1;
    }

    public void pageDown() {

        if (current != 1) {
            strStudent = tableModel.getOneStudent().subList(visible - visibleSize, visible);
            visible -= visibleSize;
            current--;
        }
        tableModel.setStrStudent(strStudent);
        tableModel.fireTableDataChanged();
    }
    public void goFirstStr(){
        if(current!=1){
            visible=visibleSize;
            strStudent = tableModel.getOneStudent().subList(visible - visibleSize, visible);

            current=1;

        }
        tableModel.setStrStudent(strStudent);
        tableModel.fireTableDataChanged();
    }

}
