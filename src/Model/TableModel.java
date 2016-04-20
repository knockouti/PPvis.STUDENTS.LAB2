package Model;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * Created by Игорь on 19.04.2016.
 */
public class TableModel extends AbstractTableModel{
private int columnCount = 6;
    private ArrayList<String []>  dataArrayList;
    public TableModel(){
        dataArrayList = new ArrayList<String []>();
        for(int i=0; i < dataArrayList.size();i++)
        {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }
    @Override
    public int getRowCount() {
        return dataArrayList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }
@Override
public String getColumnName(int columnIndex)
{
switch (columnIndex) {
    case 0:
        return "Ф.И.О";
    case 1:
        return  "Дата Рождения";
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
        String []rows =dataArrayList.get(rowIndex);
        return rows[columnIndex];
    }
    public void addDataTable(String [] row){
        String []rowTable = new String[getColumnCount()];
        rowTable = row;
        dataArrayList.add(rowTable);
        this.fireTableDataChanged();
    }
public void deleteDataTable(int rowIndex)
{
    dataArrayList.remove(rowIndex);
}

}
