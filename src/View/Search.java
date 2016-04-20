package View;

import Controller.ControllerButton;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

/**
 * Created by Игорь on 16.04.2016.
 */
public class Search {
    ControllerButton controllerButton;
    JFrame frameSearch;
    JTextField textFieldName;
    JTextField textFieldDate;
    JTextField textFieldPosition;
    JTextField textFieldComposition;
    JTextField textFieldFootballTeam;
    JTextField textFieldFaculty;
    DialogInput dialogInput;

    public Search(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
        frameSearch = new JFrame("Поиск");
        frameSearch.setSize(1000, 900);
        frameSearch.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameSearch.setLayout(new BorderLayout());
        frameSearch.setLocationRelativeTo(null);
        frameSearch.add(this.addMainSearchpanel(), BorderLayout.LINE_START);
        frameSearch.add(this.addTablePanel(), BorderLayout.CENTER);

    }

    private JPanel addMainSearchpanel() {
        JPanel panelMainSearch = new JPanel();
        panelMainSearch.setLayout(new BoxLayout(panelMainSearch, BoxLayout.Y_AXIS));
        panelMainSearch.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelMainSearch.add(this.addPanelSearchNameDate());
        panelMainSearch.add(this.addPanelSearchPositionComposition());
        panelMainSearch.add(this.addPanelSearchNameFootballTeam());
        panelMainSearch.add(this.addPanelSearchFacultyName());
        panelMainSearch.add(this.buttonSearch());
        return panelMainSearch;
    }

    private JPanel addTablePanel() {
        JPanel panelTable = new JPanel();
        panelTable.setSize(600, 500);
        panelTable.setBackground(Color.black);
        return panelTable;
    }


    private JPanel addPanelSearchNameDate() {
        JPanel panelForCheakBoxNameDate = new JPanel();
        panelForCheakBoxNameDate.setSize(500, 400);
        panelForCheakBoxNameDate.setMaximumSize(new Dimension(700, 400));
        JCheckBox checkBoxNameDate = new JCheckBox("Поиск по Ф.И.О и дате рождения");
        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(160, 30));
        textFieldName = new JTextField();
        textFieldName.setFont(textFieldName.getFont().deriveFont(15f));
        textFieldName.setMaximumSize(new Dimension(250, 30));
        panelForName.add(labelName);
        panelForName.add(textFieldName);
        JPanel panelForDate = new JPanel();
        panelForDate.setLayout(new BoxLayout(panelForDate, BoxLayout.X_AXIS));
        panelForDate.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForDate.setMaximumSize(new Dimension(400, 60));
        JLabel labelDate = new JLabel("<html>Дата<br>рождения</html>");
        labelDate.setMaximumSize(new Dimension(150, 30));
        textFieldDate = new JTextField();
        textFieldDate.setFont(textFieldDate.getFont().deriveFont(15f));
        textFieldDate.setMaximumSize(new Dimension(250, 30));
        panelForDate.add(labelDate);
        panelForDate.add(textFieldDate);
        panelForCheakBoxNameDate.setLayout(new BoxLayout(panelForCheakBoxNameDate, BoxLayout.Y_AXIS));
        panelForCheakBoxNameDate.add(checkBoxNameDate);
        panelForCheakBoxNameDate.add(panelForName);
        panelForCheakBoxNameDate.add(panelForDate);
        return panelForCheakBoxNameDate;

    }

    public void setBool(boolean bool) {
        frameSearch.setVisible(bool);
    }

    private JPanel addPanelSearchPositionComposition() {
        JPanel panelForCheakBoxPositionComposition = new JPanel();
        panelForCheakBoxPositionComposition.setSize(500, 400);
        panelForCheakBoxPositionComposition.setMaximumSize(new Dimension(700, 400));
        JCheckBox checkBoxNameDate = new JCheckBox("Поиск по позиции и составу:");
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
        panelForCheakBoxPositionComposition.add(checkBoxNameDate);
        panelForCheakBoxPositionComposition.add(panelForPosition);
        panelForCheakBoxPositionComposition.add(panelForComposition);
        return panelForCheakBoxPositionComposition;

    }

    private JPanel addPanelSearchNameFootballTeam() {
        JPanel panelForCheakBoxNameFootballTeam = new JPanel();
        panelForCheakBoxNameFootballTeam.setSize(500, 400);
        panelForCheakBoxNameFootballTeam.setMaximumSize(new Dimension(700, 400));
        JCheckBox checkBoxNameFootballTeam = new JCheckBox("Поиск по Ф.И.О и футбольно команде:");
        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(600, 60));
        labelName.setMaximumSize(new Dimension(200, 30));
        textFieldName = new JTextField();
        textFieldName.setFont(textFieldName.getFont().deriveFont(15f));
        textFieldName.setMaximumSize(new Dimension(350, 30));
        panelForName.add(labelName);
        panelForName.add(textFieldName);
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

    private JPanel addPanelSearchFacultyName() {
        JPanel panelForCheakBoxFacultyName = new JPanel();
        panelForCheakBoxFacultyName.setSize(500, 400);
        panelForCheakBoxFacultyName.setMaximumSize(new Dimension(700, 400));
        JCheckBox checkBoxNameFootballTeam = new JCheckBox("Поиск по факультету и Ф.И.О.:");
        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(170, 30));
        textFieldName = new JTextField();
        textFieldName.setFont(textFieldName.getFont().deriveFont(15f));
        textFieldName.setMaximumSize(new Dimension(250, 30));
        panelForName.add(labelName);
        panelForName.add(textFieldName);
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

    private JButton buttonSearch() {


        JButton buttonSearch = new JButton("Поиск");
        buttonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.goMainFrame();
            }
        });
        return buttonSearch;
    }

}
