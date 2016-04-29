package View;

import Controller.ControllerButton;
import com.toedter.calendar.*;
import javafx.scene.control.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Locale;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Created by Игорь on 15.04.2016.
 */
public class DialogInput {
    JFrame inputFrame;
    JTextField textFieldName;
    JTextField textFieldFootballTeam;
    JTextField textFieldFaculty;
    JTextField textFieldComposition;
    JTextField textFieldPosition;
    JTextField textFieldSurname;
    JTextField textFieldPatronomic;
    JDateChooser dateChooser;
    ControllerButton controllerButton;


    public DialogInput(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
        inputFrame = new JFrame("Добавить нового студента");
        inputFrame.setSize(520, 430);
        inputFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        JLabel labelName = new JLabel("Имя:");
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

    public JPanel addPanelForSurname() {
        JPanel panelForSurname = new JPanel();
        panelForSurname.setLayout(new BoxLayout(panelForSurname, BoxLayout.X_AXIS));
        panelForSurname.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Фамилия");
        panelForSurname.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(150, 30));
        textFieldSurname = new JTextField();
        textFieldSurname.setText("");
        textFieldSurname.setFont(textFieldSurname.getFont().deriveFont(15f));
        textFieldSurname.setMaximumSize(new Dimension(250, 30));
        panelForSurname.add(labelName);
        panelForSurname.add(textFieldSurname);
        return panelForSurname;

    }

    public JPanel addPanelForPatronomic() {
        JPanel panelForPatronomic = new JPanel();
        panelForPatronomic.setLayout(new BoxLayout(panelForPatronomic, BoxLayout.X_AXIS));
        panelForPatronomic.setAlignmentX(JComponent.LEFT_ALIGNMENT);
        JLabel labelName = new JLabel("Отчество:");
        panelForPatronomic.setMaximumSize(new Dimension(400, 60));
        labelName.setMaximumSize(new Dimension(150, 30));
        textFieldPatronomic = new JTextField();
        textFieldPatronomic.setText("");
        textFieldPatronomic.setFont(textFieldPatronomic.getFont().deriveFont(15f));
        textFieldPatronomic.setMaximumSize(new Dimension(250, 30));
        panelForPatronomic.add(labelName);
        panelForPatronomic.add(textFieldPatronomic);
        return panelForPatronomic;

    }

    private JPanel addmainPanelDialog() {
        JPanel mainPanelDialog = new JPanel();
        mainPanelDialog.setLayout(new BoxLayout(mainPanelDialog, BoxLayout.Y_AXIS));
        mainPanelDialog.setSize(500, 500);
        mainPanelDialog.add(this.addPanelForSurname());
        mainPanelDialog.add(this.addpanelForName());
        mainPanelDialog.add(this.addPanelForPatronomic());
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
        dateChooser = new JDateChooser();
        dateChooser.setLocale(Locale.US);
        dateChooser.setMaximumSize(new Dimension(250, 30));
        panelForDate.add(labelDate);
        panelForDate.add(dateChooser);
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
                controllerButton.addNewStudent();
                controllerButton.setSurname(textFieldSurname);
                controllerButton.setName(textFieldName);
                controllerButton.setPatronomic(textFieldPatronomic);
                controllerButton.setPosition(textFieldPosition);
                controllerButton.setComposition(textFieldComposition);
                controllerButton.setFootbalTeam(textFieldFootballTeam);
                controllerButton.setFaculty(textFieldFaculty);
                controllerButton.setData(dateChooser);

                controllerButton.setDataTable();
                controllerButton.goMainFrame();
                controllerButton.setTextFielNull(textFieldSurname);
                controllerButton.setTextFielNull(textFieldComposition);
                controllerButton.setTextFielNull(textFieldFaculty);
                controllerButton.setTextFielNull(textFieldFootballTeam);
                controllerButton.setTextFielNull(textFieldPosition);
                controllerButton.setTextFielNull(textFieldName);
                controllerButton.setTextFielNull(textFieldPatronomic);
                controllerButton.setNullDate(dateChooser);
            }
        });
        buttonTack.setSize(150, 50);
        return buttonTack;
    }
}
