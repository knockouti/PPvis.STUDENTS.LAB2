package View;

import Controller.ControllerButton;
import javafx.scene.control.Tab;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Игорь on 15.04.2016.
 */
public class MainWindow {
    JFrame mainFrame;
    TableModel tableModel;
    ControllerButton controllerButton;

    public MainWindow(ControllerButton controllerButton, TableModel tableModel) {
        this.controllerButton = controllerButton;
        this.tableModel = tableModel;
        mainFrame = new JFrame("Главное окно");
        mainFrame.setSize(1200, 700);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(this.addJToolBar(), BorderLayout.LINE_START);
        mainFrame.add(this.addJMenuBar(), BorderLayout.PAGE_START);
        mainFrame.add(this.addTableForManWindow(), BorderLayout.CENTER);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void setBool(boolean bool) {
        mainFrame.setVisible(bool);
    }

    private JScrollPane addTableForManWindow() {

JPanel panelForTable = new JPanel();
        panelForTable.setSize(600,600);
        JTable tableForMainMindow = new JTable(tableModel);
        JScrollPane scrollPaneMainTable = new JScrollPane(tableForMainMindow);

        return scrollPaneMainTable;
    }

    private JToolBar addJToolBar() {
        JToolBar mainToolBar = new JToolBar();
        mainToolBar.setSize(400, 400);
        mainToolBar.setVisible(true);
        mainToolBar.setFloatable(false);
        mainToolBar.setLayout(new BoxLayout(mainToolBar, BoxLayout.Y_AXIS));
        mainToolBar.add(addButtonOpen());
        mainToolBar.add(addButonSave());
        mainToolBar.add(buttonAddFrame());
        mainToolBar.add(addButtonDelete());
        mainToolBar.add(addButtonSearch());
        return mainToolBar;

    }

    private JMenuBar addJMenuBar() {
        JMenuBar mainMenBar = new JMenuBar();
        JMenu mainFile = new JMenu("Файл");
        JMenuItem mainOpen = new JMenuItem("Открыть");
        JMenuItem mainSave = new JMenuItem("Сохранить");
        JMenuItem mainExit = new JMenuItem("Выйти");
        mainFile.add(mainOpen);
        mainFile.add(mainSave);
        mainFile.add(mainExit);
        mainMenBar.add(mainFile);
        return mainMenBar;
    }

    private JButton addButtonOpen() {
        JButton buttonOpen = new JButton(new ImageIcon("images\\open.png"));
        return buttonOpen;
    }

    private JButton addButonSave() {
        JButton buttonSave = new JButton(new ImageIcon("images\\save.png"));
        return buttonSave;
    }

    private JButton buttonAddFrame() {
        JButton buttonAdd = new JButton(new ImageIcon("images\\add.png"));
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.add();
            }
        });
        return buttonAdd;
    }

    private JButton addButtonDelete()

    {
        JButton buttonDelete = new JButton(new ImageIcon("images\\delete.png"));
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.goMainDelete();
            }
        });
        return buttonDelete;
    }

    private JButton addButtonSearch() {
        JButton buttonSearch = new JButton(new ImageIcon("images\\find.png"));
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.goMainSearch();
            }
        });
        return buttonSearch;
    }


}
