package View;

import Controller.ControllerButton;
import Controller.OutpuStr;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Игорь on 16.04.2016.
 */
public class Search {
    ControllerButton controllerButton;
    JFrame frameSearch;
    JTextField textFieldName;
    JTextField textFieldSurname;
    JTextField textFieldPatronomic;
    JLabel labelName;
    JLabel labelSurname;
    JLabel labelPatronomic;
    JLabel labelDate;
    JPanel panelMainSearch;
    JComboBox comboBox;
    String searchNameDate = "Поиск по Ф.И.О. и дате рождения";
    String searchPosComp = "Поиск по позиции и составу";
    String searchNameFaculty = "Поиск по Ф.И.О. и факультету";
    String searchNameFootball = "Поиск по Ф.И.О. и футбольной команде";
    JDateChooser dateNameChooser;
    JTextField textFieldPosition;
    JTextField textFieldComposition;
    JTextField textFieldFootballTeam;
    DialogInput dialogInput;
    TableModel tableModel;
    TableModel searchModel;

    public Search(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
        tableModel = new TableModel();

        searchModel = new TableModel();
        frameSearch = new JFrame("Удаление Элементов");
        frameSearch.setSize(1000, 900);
        dialogInput = new DialogInput(controllerButton);
        frameSearch.setLayout(new BorderLayout());
        frameSearch.setLocationRelativeTo(null);
        frameSearch.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                tableModel.fireTableDataChanged();
                controllerButton.goMainFrame();
            }
        });
        frameSearch.add(this.addPanelFOrCombobox(), BorderLayout.LINE_START);
        frameSearch.add(this.addMainDeletePanel(), BorderLayout.LINE_END);
        OutpuStr outpuStr = new OutpuStr(searchModel);
        frameSearch.add(outpuStr, BorderLayout.PAGE_END);


    }

//    public JPanel panelForStr() {
//        JPanel panelStr = new JPanel();
//        panelStr.setLayout(new FlowLayout());
//
//        JButton firstElement = new JButton("1");
//        JButton lateElement = new JButton();
//        if(tableModel.getOneStudent().size() == 0){
//            lateElement.setText("-");
//        }
//        JLabel labelCurrentPage =  new JLabel();
//        labelCurrentPage.setPreferredSize(new Dimension(30,30));
//        labelCurrentPage.setText(String.valueOf(tableModel.getCurrent()));
//        lateElement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lateElement.setText(String.valueOf(searchModel.getNubmerStr()));
//                searchModel.setCurrent(searchModel.getNubmerStr());
//                searchModel.pageUp();
//                labelCurrentPage.setText(String.valueOf(searchModel.getCurrent()));
//            }
//        });
//        firstElement.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                searchModel.setCurrent(searchModel.getNubmerStr());
//                searchModel.goFirstStr();
//                labelCurrentPage.setText(String.valueOf(searchModel.getCurrent()));
//            }
//        });
//        JButton next = new JButton("Next");
//        next.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                searchModel.pageUp();
//                searchModel.fireTableDataChanged();
//            }
//        });
//        JButton prev = new JButton("Pred");
//        prev.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                searchModel.pageDown();
//                searchModel.fireTableDataChanged();
//            }
//        });
//        panelStr.add(prev);
//        panelStr.add(firstElement);
//        panelStr.add(labelCurrentPage);
//        panelStr.add(lateElement);
//        panelStr.add(next);
//
//        return panelStr;
//    }

    private JScrollPane addTableForPanelSearch(TableModel tableModel) {


        JTable tableForSearch = new JTable(tableModel);
        JScrollPane scrollPaneMainTable = new JScrollPane(tableForSearch);

        return scrollPaneMainTable;
    }

    private JPanel addPanelFOrCombobox() {
        JPanel panelForCombobox = new JPanel();
        panelForCombobox.setLayout(new BoxLayout(panelForCombobox, BoxLayout.Y_AXIS));
        panelForCombobox.setMaximumSize(new Dimension(400, 70));
        String[] items = {
                searchNameDate,
                searchPosComp,
                searchNameFootball,
                searchNameFaculty
        };

        comboBox = new JComboBox(items);
        comboBox.setPreferredSize(new Dimension(250, 100));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox.getSelectedItem() == searchNameDate) {

                    panelMainSearch.removeAll();
                    panelMainSearch.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), addPanelDeleteDate()));
                    panelMainSearch.add(buttonDelete());
                    panelMainSearch.revalidate();


                } else if (comboBox.getSelectedItem() == searchPosComp) {

                    panelMainSearch.removeAll();
                    panelMainSearch.add(addPanelDeletePositionComposition(dialogInput.addPanelPosition(), dialogInput.addPanelComposition()));
                    panelMainSearch.add(buttonDelete());
                    panelMainSearch.revalidate();


                } else if (comboBox.getSelectedItem() == searchNameFootball) {

                    panelMainSearch.removeAll();
                    panelMainSearch.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), addPanelDeleteFootballTeam()));
                    panelMainSearch.add(buttonDelete());
                    panelMainSearch.revalidate();


                }
                if (comboBox.getSelectedItem().toString() == searchNameFaculty) {

                    panelMainSearch.removeAll();
                    panelMainSearch.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), dialogInput.addPanelFaculty()));
                    panelMainSearch.add(buttonDelete());
                    panelMainSearch.revalidate();

                }
            }
        });

        panelForCombobox.add(comboBox, BorderLayout.PAGE_START);
        return panelForCombobox;
    }

    private JPanel addMainDeletePanel() {
        panelMainSearch = new JPanel();
        panelMainSearch.setLayout(new BoxLayout(panelMainSearch, BoxLayout.Y_AXIS));
        panelMainSearch.setPreferredSize(new Dimension(400, 800));
        panelMainSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        return panelMainSearch;

    }


    public void setBool(boolean bool) {
        frameSearch.setVisible(bool);
    }


    private JPanel addPanelDeleteName() {

        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        labelName = new JLabel("Имя:");
        panelForName.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(150, 30));
        textFieldName = new JTextField();
        textFieldName.setFont(textFieldName.getFont().deriveFont(15f));
        textFieldName.setMaximumSize(new Dimension(250, 30));
        panelForName.add(labelName);
        panelForName.add(textFieldName);
        return panelForName;

    }

    private JPanel addPanelDeleteDate() {

        JPanel panelForDate = new JPanel();
        panelForDate.setLayout(new BoxLayout(panelForDate, BoxLayout.X_AXIS));
        panelForDate.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForDate.setMaximumSize(new Dimension(400, 60));
        labelDate = new JLabel("<html>Дата<br>рождения</html>");
        labelDate.setMaximumSize(new Dimension(150, 30));
        dateNameChooser = new JDateChooser();
        dateNameChooser.setFont(dateNameChooser.getFont().deriveFont(15f));
        dateNameChooser.setMaximumSize(new Dimension(250, 30));
        panelForDate.add(labelDate);
        panelForDate.add(dateNameChooser);
        return panelForDate;
    }

    private JPanel addPanelDeleteSurname() {
        JPanel panelForSurname = new JPanel();
        panelForSurname.setLayout(new BoxLayout(panelForSurname, BoxLayout.X_AXIS));
        panelForSurname.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        labelSurname = new JLabel("Фамилия:");
        panelForSurname.setMaximumSize(new Dimension(400, 60));
        labelSurname.setMaximumSize(new Dimension(150, 30));
        textFieldSurname = new JTextField();
        textFieldSurname.setFont(textFieldSurname.getFont().deriveFont(15f));
        textFieldSurname.setMaximumSize(new Dimension(250, 30));
        panelForSurname.add(labelSurname);
        panelForSurname.add(textFieldSurname);
        return panelForSurname;
    }

    private JPanel addPanelDeletePatronomic() {
        JPanel panelForPatronomic = new JPanel();
        panelForPatronomic.setLayout(new BoxLayout(panelForPatronomic, BoxLayout.X_AXIS));
        panelForPatronomic.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        labelPatronomic = new JLabel("Отчество:");
        panelForPatronomic.setMaximumSize(new Dimension(400, 60));
        labelPatronomic.setMaximumSize(new Dimension(150, 30));
        textFieldPatronomic = new JTextField();
        textFieldPatronomic.setFont(textFieldPatronomic.getFont().deriveFont(15f));
        textFieldPatronomic.setMaximumSize(new Dimension(250, 30));
        panelForPatronomic.add(labelPatronomic);
        panelForPatronomic.add(textFieldPatronomic);
        return panelForPatronomic;
    }

    private JPanel addPanelDeleteNameWithAnything(JPanel panelForSurname, JPanel panelForName, JPanel panelForPatronomic, JPanel panel) {
        JPanel panelNameWithAnything = new JPanel();
        panelNameWithAnything.setSize(500, 400);
        panelNameWithAnything.setMaximumSize(new Dimension(700, 400));
        panelNameWithAnything.setLayout(new BoxLayout(panelNameWithAnything, BoxLayout.Y_AXIS));
        panelNameWithAnything.add(panelForSurname);
        panelNameWithAnything.add(panelForName);
        panelNameWithAnything.add(panelForPatronomic);
        panelNameWithAnything.add(panel);

        return panelNameWithAnything;

    }

    private JPanel addPanelDeletePosition() {

        JPanel panelForPosition = new JPanel();
        panelForPosition.setLayout(new BoxLayout(panelForPosition, BoxLayout.X_AXIS));
        panelForPosition.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelPosition = new JLabel("Позиция:");
        panelForPosition.setMaximumSize(new Dimension(400, 60));
        labelPosition.setMaximumSize(new Dimension(150, 30));
        textFieldPosition = new JTextField();
        textFieldPosition.setFont(textFieldPosition.getFont().deriveFont(15f));
        textFieldPosition.setMaximumSize(new Dimension(250, 30));
        panelForPosition.add(labelPosition);
        panelForPosition.add(textFieldPosition);
        return panelForPosition;
    }

    private JPanel addPanelDeleteComposition() {
        JPanel panelForComposition = new JPanel();
        panelForComposition.setLayout(new BoxLayout(panelForComposition, BoxLayout.X_AXIS));
        panelForComposition.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForComposition.setMaximumSize(new Dimension(400, 60));
        JLabel labelComposition = new JLabel("Состав:");
        labelComposition.setMaximumSize(new Dimension(150, 30));
        textFieldComposition = new JTextField();
        textFieldComposition.setFont(textFieldComposition.getFont().deriveFont(15f));
        textFieldComposition.setMaximumSize(new Dimension(250, 30));
        panelForComposition.add(labelComposition);
        panelForComposition.add(textFieldComposition);
        return panelForComposition;
    }

    private JPanel addPanelDeletePositionComposition(JPanel panelForPosition, JPanel panelForComposition) {
        JPanel panelForCheakBoxPositionComposition = new JPanel();
        panelForCheakBoxPositionComposition.setSize(500, 400);
        panelForCheakBoxPositionComposition.setMaximumSize(new Dimension(700, 400));
        panelForCheakBoxPositionComposition.setLayout(new BoxLayout(panelForCheakBoxPositionComposition, BoxLayout.Y_AXIS));
        panelForCheakBoxPositionComposition.add(panelForPosition);
        panelForCheakBoxPositionComposition.add(panelForComposition);
        return panelForCheakBoxPositionComposition;
    }

    private JPanel addPanelDeleteFootballTeam() {
        JPanel panelForFotballTeam = new JPanel();
        panelForFotballTeam.setLayout(new BoxLayout(panelForFotballTeam, BoxLayout.X_AXIS));
        panelForFotballTeam.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForFotballTeam.setMaximumSize(new Dimension(400, 60));
        JLabel labelFootballTeam = new JLabel("<html>Футбольная<br>команда</html>");
        labelFootballTeam.setMaximumSize(new Dimension(150, 30));
        textFieldFootballTeam = new JTextField();
        textFieldFootballTeam.setFont(textFieldFootballTeam.getFont().deriveFont(15f));
        textFieldFootballTeam.setMaximumSize(new Dimension(250, 30));
        panelForFotballTeam.add(labelFootballTeam);
        panelForFotballTeam.add(textFieldFootballTeam);
        return panelForFotballTeam;
    }


    private JButton buttonDelete() {


        JButton buttonSearch = new JButton("Поиск");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == searchNameDate) {
                    searchModel = controllerButton.searchNameDate(textFieldName, textFieldSurname, textFieldPatronomic, dateNameChooser);
                    frameSearch.add(addTableForPanelSearch(searchModel));
                    frameSearch.validate();

                } else if (comboBox.getSelectedItem() == searchPosComp) {
                    searchModel = controllerButton.searchPosComp(dialogInput.getComboBoxPosition(), dialogInput.getComboBoxComposition());
                    frameSearch.add(addTableForPanelSearch(searchModel));
                    frameSearch.validate();
                } else if (comboBox.getSelectedItem() == searchNameFaculty) {
                    searchModel = controllerButton.searchNameFaculty(textFieldName, textFieldSurname, textFieldPatronomic, dialogInput.getComboBoxFaculty());
                    frameSearch.add(addTableForPanelSearch(searchModel));
                    frameSearch.validate();
                } else if (comboBox.getSelectedItem() == searchNameFootball) {
                    searchModel = controllerButton.searchNameFootball(textFieldName, textFieldSurname, textFieldPatronomic, textFieldFootballTeam);
                    frameSearch.add(addTableForPanelSearch(searchModel));
                    frameSearch.validate();
                }
            }
        });
        return buttonSearch;
    }


    /**
     * Created by Игорь on 19.04.2016.
     */

}

