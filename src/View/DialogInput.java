package View;

import Controller.ControllerButton;
import javafx.scene.control.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Created by Игорь on 15.04.2016.
 */
public class DialogInput {
    JFrame inputFrame;
    JTextField textFieldName;
    JTextField textFieldFootballTeam;
    JTextField textFieldDate;
    JTextField textFieldFaculty;
    JTextField textFieldComposition;
    JTextField textFieldPosition;
    ControllerButton controllerButton;

    public DialogInput(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
        inputFrame = new JFrame("Добавить нового студента");
        inputFrame.setSize(520, 430);
        inputFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE
        );
        inputFrame.setLayout(new BorderLayout());
        inputFrame.setLocationRelativeTo(null);
        inputFrame.add(this.addmainPanelDialog());

    }

    public void setBool(boolean bool) {
        inputFrame.setVisible(bool);
    }

    public JPanel addpanelForName() {
        JPanel panelForName = new JPanel();
        panelForName.setLayout(new BoxLayout(panelForName, BoxLayout.X_AXIS));
        panelForName.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Ф.И.О.:");
        panelForName.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(150, 30));

        textFieldName = new JTextField();
        textFieldName.setText("");
        textFieldName.setFont(textFieldName.getFont().deriveFont(15f));
        textFieldName.setMaximumSize(new Dimension(250, 30));
        panelForName.add(labelName);
        panelForName.add(textFieldName);
        return panelForName;

    }

    private JPanel addmainPanelDialog() {
        JPanel mainPanelDialog = new JPanel();
        mainPanelDialog.setLayout(new BoxLayout(mainPanelDialog, BoxLayout.Y_AXIS));
        mainPanelDialog.setSize(500, 500);
        mainPanelDialog.add(this.addpanelForName());
        mainPanelDialog.add(this.addpanelForDate());
        mainPanelDialog.add(this.addPanelFootballTeam());
        mainPanelDialog.add(this.addPanelFaculty());
        mainPanelDialog.add(this.addPanelComposition());
        mainPanelDialog.add(this.addPanelPosition());
        mainPanelDialog.add(this.addButtonTack());
        return mainPanelDialog;
    }

    private JPanel addpanelForDate() {
        JPanel panelForDate = new JPanel();
        panelForDate.setLayout(new BoxLayout(panelForDate, BoxLayout.X_AXIS));
        panelForDate.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelForDate.setMaximumSize(new Dimension(400, 60));
        JLabel labelDate = new JLabel("Дата Рождения:");
        labelDate.setMaximumSize(new Dimension(150, 30));
        textFieldDate = new JTextField();
        textFieldDate.setFont(textFieldDate.getFont().deriveFont(15f));
        textFieldDate.setMaximumSize(new Dimension(250, 30));
        panelForDate.add(labelDate);
        panelForDate.add(textFieldDate);
        return panelForDate;
    }

    private JPanel addPanelFootballTeam() {
        JPanel panelFootbalTeam = new JPanel();
        panelFootbalTeam.setLayout(new BoxLayout(panelFootbalTeam, BoxLayout.X_AXIS));
        panelFootbalTeam.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelFootbalTeam.setMaximumSize(new Dimension(400, 60));
        JLabel labelFootballTeam = new JLabel("Футбольная команда:");
        labelFootballTeam.setMaximumSize(new Dimension(150, 30));
        textFieldFootballTeam = new JTextField();
        textFieldFootballTeam.setFont(textFieldFootballTeam.getFont().deriveFont(15f));
        textFieldFootballTeam.setMaximumSize(new Dimension(250, 30));
        panelFootbalTeam.add(labelFootballTeam);
        panelFootbalTeam.add(textFieldFootballTeam);
        return panelFootbalTeam;
    }

    private JPanel addPanelFaculty() {
        JPanel panelFaculty = new JPanel();
        panelFaculty.setLayout(new BoxLayout(panelFaculty, BoxLayout.X_AXIS));
        panelFaculty.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelFaculty.setMaximumSize(new Dimension(400, 60));
        JLabel labelFaculty = new JLabel("Факультет:");
        labelFaculty.setMaximumSize(new Dimension(150, 30));
        textFieldFaculty = new JTextField();
        textFieldFaculty.setFont(textFieldFaculty.getFont().deriveFont(15f));
        textFieldFaculty.setMaximumSize(new Dimension(250, 30));
        panelFaculty.add(labelFaculty);
        panelFaculty.add(textFieldFaculty);
        return panelFaculty;
    }

    private JPanel addPanelComposition() {
        JPanel panelComposition = new JPanel();
        panelComposition.setLayout(new BoxLayout(panelComposition, BoxLayout.X_AXIS));
        panelComposition.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelComposition.setMaximumSize(new Dimension(400, 60));
        JLabel labelCompositon = new JLabel("Состав:");
        labelCompositon.setMaximumSize(new Dimension(150, 30));
        textFieldComposition = new JTextField();
        textFieldComposition.setFont(textFieldComposition.getFont().deriveFont(15f));
        textFieldComposition.setMaximumSize(new Dimension(250, 30));
        panelComposition.add(labelCompositon);
        panelComposition.add(textFieldComposition);
        return panelComposition;
    }

    private JPanel addPanelPosition() {
        JPanel panelPosition = new JPanel();
        panelPosition.setLayout(new BoxLayout(panelPosition, BoxLayout.X_AXIS));
        panelPosition.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        panelPosition.setMaximumSize(new Dimension(400, 60));
        JLabel labelPosition = new JLabel("Позиция:");
        labelPosition.setMaximumSize(new Dimension(150, 30));
        textFieldPosition = new JTextField();
        textFieldPosition.setFont(textFieldPosition.getFont().deriveFont(13f));
        textFieldPosition.setMaximumSize(new Dimension(250, 30));
        panelPosition.add(labelPosition);
        panelPosition.add(textFieldPosition);
        return panelPosition;
    }

    private JButton addButtonTack() {
        JButton buttonTack = new JButton("Дабваить Студента");
        buttonTack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controllerButton.setName(textFieldName, textFieldDate, textFieldFootballTeam, textFieldFaculty, textFieldComposition, textFieldPosition);
                controllerButton.goMainFrame();
                controllerButton.setTextFielNull(textFieldName);
                controllerButton.setTextFielNull(textFieldDate);
                controllerButton.setTextFielNull(textFieldComposition);
                controllerButton.setTextFielNull(textFieldFaculty);
                controllerButton.setTextFielNull(textFieldFootballTeam);
                controllerButton.setTextFielNull(textFieldPosition);
            }
        });
        buttonTack.setSize(150, 50);
        return buttonTack;
    }


}
