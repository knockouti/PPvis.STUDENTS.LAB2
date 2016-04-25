package View;

import Controller.ControllerButton;
import Model.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * Created by Игорь on 17.04.2016.
 */
public class Delete {
    ControllerButton controllerButton;
    JFrame frameDelete;
    JCheckBox checkBoxNameFootballTeam;
    JCheckBox checkBoxPositionComposition;
    JCheckBox checkBoxNameDate;
    JTextField textFieldName;
    JTextField getTextFieldNameFootballTeam;
    JTextField getTextFieldNameFaculty;
    JLabel labelNameDate;
    JLabel labelDateName;
    JTextField textFieldNameDate;
    JTextField textFieldDateName;
    JTextField textFieldPosition;
    JTextField textFieldComposition;
    JTextField textFieldFootballTeam;
    JTextField textFieldFaculty;

    public Delete(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
        frameDelete = new JFrame("Удаление Элементов");
        frameDelete.setSize(1000, 900);
        frameDelete.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameDelete.setLayout(new BorderLayout());
        frameDelete.setLocationRelativeTo(null);
        frameDelete.add(this.addMainDeletePanel(), BorderLayout.LINE_START);
        frameDelete.add(this.addTablePanelDelete(), BorderLayout.CENTER);
        frameDelete.add(this.addPanelResultDelete(), BorderLayout.LINE_END);

    }

    private JPanel addMainDeletePanel() {
        JPanel panelMainDelete = new JPanel();
        panelMainDelete.setLayout(new BoxLayout(panelMainDelete, BoxLayout.Y_AXIS));
        panelMainDelete.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        this.addPanelDeleteFacultyName().setEnabled(false);

        panelMainDelete.add(this.addPanelDeleteNameDate());
        panelMainDelete.add(this.addPanelDeletePositionComposition());
        panelMainDelete.add(this.addPanelDeleteNameFootballTeam());
        panelMainDelete.add(this.addPanelDeleteFacultyName());
        panelMainDelete.add(this.buttonDelete());
        return panelMainDelete;
    }

    private JPanel addTablePanelDelete() {
        JPanel panelTable = new JPanel();

        panelTable.setBackground(Color.black);
        return panelTable;
    }

    private JPanel addPanelResultDelete() {
        JPanel panelResultDelete = new JPanel();
        panelResultDelete.setSize(400, 800);
        JButton button = new JButton("Реузльтаты удаления");
        panelResultDelete.add(button);
        panelResultDelete.setBackground(Color.white);
        return panelResultDelete;
    }

    private void setEnableCheackBox(JCheckBox checkBox) {
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    checkBoxPositionComposition.setEnabled(false);
                    textFieldPosition.setEnabled(false);
                    textFieldComposition.setEnabled(false);
                } else {
                    checkBoxPositionComposition.setEnabled(true);
                    textFieldPosition.setEnabled(true);
                    textFieldComposition.setEnabled(true);
                }
            }
        });
    }

    private JCheckBox addCheackBoxNameDate() {
        checkBoxNameDate = new JCheckBox("Удаление по Ф.И.О и дате рождения");
        checkBoxNameDate.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    checkBoxPositionComposition.setEnabled(false);
                    textFieldPosition.setEnabled(false);
                    textFieldComposition.setEnabled(false);
                    textFieldFaculty.setEnabled(false);
                    textFieldFootballTeam.setEnabled(false);
                    getTextFieldNameFootballTeam.setEnabled(false);
                    getTextFieldNameFaculty.setEnabled(false);
                } else {
                    checkBoxPositionComposition.setEnabled(true);
                    textFieldPosition.setEnabled(true);
                    textFieldComposition.setEnabled(true);
                    textFieldFaculty.setEnabled(true);
                    textFieldFootballTeam.setEnabled(true);
                    getTextFieldNameFootballTeam.setEnabled(true);
                    getTextFieldNameFaculty.setEnabled(true);
                }
            }
        });
        return checkBoxNameDate;
    }

    public void setBool(boolean bool) {
        frameDelete.setVisible(bool);
    }

    private JCheckBox addCheackBoxPositionComposition() {
        checkBoxPositionComposition = new JCheckBox("Удаление по позиции и составу:");
        checkBoxPositionComposition.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    checkBoxNameDate.setEnabled(false);
                    textFieldNameDate.setEnabled(false);
                    textFieldDateName.setEnabled(false);
                } else {
                    textFieldNameDate.setEnabled(true);
                    checkBoxNameDate.setEnabled(true);
                    textFieldDateName.setEnabled(true);
                }
            }
        });
        return checkBoxPositionComposition;

    }

    private JPanel addPanelDeleteNameDate() {
        JPanel panelForCheakBoxNameDate = new JPanel();
        panelForCheakBoxNameDate.setSize(500, 400);
        panelForCheakBoxNameDate.setMaximumSize(new Dimension(700, 400));


        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        labelNameDate = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(400, 60));
        labelNameDate.setMaximumSize(new Dimension(160, 30));
        textFieldNameDate = new JTextField();
        textFieldNameDate.setFont(textFieldNameDate.getFont().deriveFont(15f));
        textFieldNameDate.setMaximumSize(new Dimension(250, 30));

        panelForName.add(labelNameDate);
        panelForName.add(textFieldNameDate);
        JPanel panelForDate = new JPanel();
        panelForDate.setLayout(new BoxLayout(panelForDate, BoxLayout.X_AXIS));
        panelForDate.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForDate.setMaximumSize(new Dimension(400, 60));
        labelDateName = new JLabel("<html>Дата<br>рождения</html>");
        labelDateName.setMaximumSize(new Dimension(150, 30));
        textFieldDateName = new JTextField();
        textFieldDateName.setFont(textFieldDateName.getFont().deriveFont(15f));
        textFieldDateName.setMaximumSize(new Dimension(250, 30));
        panelForDate.add(labelDateName);
        panelForDate.add(textFieldDateName);
        panelForCheakBoxNameDate.setLayout(new BoxLayout(panelForCheakBoxNameDate, BoxLayout.Y_AXIS));
        panelForCheakBoxNameDate.add(this.addCheackBoxNameDate());
        panelForCheakBoxNameDate.add(panelForName);
        panelForCheakBoxNameDate.add(panelForDate);

        return panelForCheakBoxNameDate;

    }

    private JPanel addPanelDeletePositionComposition() {
        JPanel panelForCheakBoxPositionComposition = new JPanel();
        panelForCheakBoxPositionComposition.setSize(500, 400);
        panelForCheakBoxPositionComposition.setMaximumSize(new Dimension(700, 400));

        JPanel panelForPosition = new JPanel();
        panelForPosition.setLayout(new BoxLayout(panelForPosition, BoxLayout.X_AXIS));
        panelForPosition.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelPosition = new JLabel("Позиция:");
        panelForPosition.setMaximumSize(new Dimension(400, 60));
        labelPosition.setMaximumSize(new Dimension(140, 30));
        textFieldPosition = new JTextField();
        textFieldPosition.setFont(textFieldPosition.getFont().deriveFont(15f));
        textFieldPosition.setMaximumSize(new Dimension(250, 30));
        panelForPosition.add(labelPosition);
        panelForPosition.add(textFieldPosition);
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
        panelForCheakBoxPositionComposition.setLayout(new BoxLayout(panelForCheakBoxPositionComposition, BoxLayout.Y_AXIS));
        panelForCheakBoxPositionComposition.add(this.addCheackBoxPositionComposition());
        panelForCheakBoxPositionComposition.add(panelForPosition);
        panelForCheakBoxPositionComposition.add(panelForComposition);
        return panelForCheakBoxPositionComposition;

    }

    private JPanel addPanelDeleteNameFootballTeam() {
        JPanel panelForCheakBoxNameFootballTeam = new JPanel();
        panelForCheakBoxNameFootballTeam.setSize(500, 400);
        panelForCheakBoxNameFootballTeam.setMaximumSize(new Dimension(700, 400));
        checkBoxNameFootballTeam = new JCheckBox("Удаление по Ф.И.О и футбольно команде:");

        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(600, 60));
        labelName.setMaximumSize(new Dimension(200, 30));
        getTextFieldNameFootballTeam = new JTextField();
        getTextFieldNameFootballTeam.setFont(getTextFieldNameFootballTeam.getFont().deriveFont(15f));
        getTextFieldNameFootballTeam.setMaximumSize(new Dimension(350, 30));
        panelForName.add(labelName);
        panelForName.add(getTextFieldNameFootballTeam);
        JPanel panelForFotballTeam = new JPanel();
        panelForFotballTeam.setLayout(new BoxLayout(panelForFotballTeam, BoxLayout.X_AXIS));
        panelForFotballTeam.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForFotballTeam.setMaximumSize(new Dimension(400, 60));
        JLabel labelFootballTeam = new JLabel("<html>Футбольная<br>команда</html>");
        labelFootballTeam.setMaximumSize(new Dimension(130, 30));
        textFieldFootballTeam = new JTextField();
        textFieldFootballTeam.setFont(textFieldFootballTeam.getFont().deriveFont(15f));
        textFieldFootballTeam.setMaximumSize(new Dimension(250, 30));
        panelForFotballTeam.add(labelFootballTeam);
        panelForFotballTeam.add(textFieldFootballTeam);
        panelForCheakBoxNameFootballTeam.setLayout(new BoxLayout(panelForCheakBoxNameFootballTeam, BoxLayout.Y_AXIS));
        panelForCheakBoxNameFootballTeam.add(checkBoxNameFootballTeam);
        panelForCheakBoxNameFootballTeam.add(panelForName);
        panelForCheakBoxNameFootballTeam.add(panelForFotballTeam);
        return panelForCheakBoxNameFootballTeam;

    }

    private JPanel addPanelDeleteFacultyName() {
        JPanel panelForCheakBoxFacultyName = new JPanel();
        panelForCheakBoxFacultyName.setSize(500, 400);
        panelForCheakBoxFacultyName.setMaximumSize(new Dimension(700, 400));
        JCheckBox checkBoxNameFootballTeam = new JCheckBox("Удаление по факультету и Ф.И.О.:");
        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(170, 30));
        getTextFieldNameFaculty = new JTextField();
        getTextFieldNameFaculty.setFont(getTextFieldNameFaculty.getFont().deriveFont(15f));
        getTextFieldNameFaculty.setMaximumSize(new Dimension(250, 30));
        panelForName.add(labelName);
        panelForName.add(getTextFieldNameFaculty);
        JPanel panelForFaculty = new JPanel();
        panelForFaculty.setLayout(new BoxLayout(panelForFaculty, BoxLayout.X_AXIS));
        panelForFaculty.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForFaculty.setMaximumSize(new Dimension(400, 60));
        JLabel labelForFaculty = new JLabel("Факультет:");
        labelForFaculty.setMaximumSize(new Dimension(150, 30));
        textFieldFaculty = new JTextField();
        textFieldFaculty.setFont(textFieldFaculty.getFont().deriveFont(15f));
        textFieldFaculty.setMaximumSize(new Dimension(250, 30));
        panelForFaculty.add(labelForFaculty);
        panelForFaculty.add(textFieldFaculty);
        panelForCheakBoxFacultyName.setLayout(new BoxLayout(panelForCheakBoxFacultyName, BoxLayout.Y_AXIS));
        panelForCheakBoxFacultyName.add(checkBoxNameFootballTeam);
        panelForCheakBoxFacultyName.add(panelForName);
        panelForCheakBoxFacultyName.add(panelForFaculty);
        return panelForCheakBoxFacultyName;

    }

    private JButton buttonDelete() {


        JButton buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.goMainFrame();
            }
        });
        return buttonDelete;
    }


    /**
     * Created by Игорь on 19.04.2016.
     */

}
