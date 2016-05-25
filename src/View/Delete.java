package View;

import Controller.ControllerButton;
import Model.Student;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

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
    JTextField textFieldSurname;
    JTextField textFieldPatronomic;
    JTextField getTextFieldNameFootballTeam;
    JTextField getTextFieldNameFaculty;
    JPanel panelForDeleteItems;
    JLabel labelName;
    JLabel labelSurname;
    JLabel labelPatronomic;
    JLabel labelDate;
    JPanel panelMainDelete;
    JComboBox comboBox;
    String deleteNameDate = "Удаление по Ф.И.О. и дате рождения";
    String deletePosComp = "Удаление по позиции и составу";

    String deleteNameFaculty = "Удаление по Ф.И.О. и факультету";

    String deleteNameFootbalTeam = "Удаление по Ф.И.О. и футбольной команде";
    JTextField textFieldNameDate;
    JDateChooser dateNameChooser;
    JTextField textFieldPosition;
    JTextField textFieldComposition;
    JTextField textFieldFootballTeam;
    JTextField textFieldFaculty;
    DialogInput dialogInput;
    TableModel tableModel;
    JPanel panelResultDelete;
    public Delete(ControllerButton controllerButton) {
        this.controllerButton = controllerButton;
        tableModel = new TableModel();
        panelResultDelete = new JPanel();
        panelResultDelete.setSize(400, 800);
        panelResultDelete.setLayout(new BoxLayout(panelResultDelete,BoxLayout.X_AXIS));

        frameDelete = new JFrame("Удаление Элементов");
        frameDelete.setSize(1000, 900);
        dialogInput = new DialogInput(controllerButton);
        frameDelete.setLayout(new BorderLayout());
        frameDelete.setLocationRelativeTo(null);
        frameDelete.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                controllerButton.goMainFrame();
            }
        });
        frameDelete.add(this.addPanelFOrCombobox(), BorderLayout.LINE_START);
        frameDelete.add(this.addMainDeletePanel(), BorderLayout.CENTER);
        frameDelete.add(panelResultDelete, BorderLayout.LINE_END);




    }

    private JPanel addPanelFOrCombobox() {
        JPanel panelForCombobox = new JPanel();
        panelForCombobox.setLayout(new BoxLayout(panelForCombobox, BoxLayout.Y_AXIS));
        panelForCombobox.setMaximumSize(new Dimension(400, 60));
        String[] items = {
                deleteNameDate,
                deletePosComp,
                deleteNameFootbalTeam,
                deleteNameFaculty
        };

        comboBox = new JComboBox(items);
        comboBox.setPreferredSize(new Dimension(250,100));
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (comboBox.getSelectedItem() == deleteNameDate) {

                    panelMainDelete.removeAll();
                    panelMainDelete.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), addPanelDeleteDate()));
                    panelMainDelete.add(buttonDelete());
                    panelMainDelete.revalidate();


                } else if (comboBox.getSelectedItem() == deletePosComp) {

                    panelMainDelete.removeAll();
                    panelMainDelete.add(addPanelDeletePositionComposition(dialogInput.addPanelPosition(), dialogInput.addPanelComposition()));
                    panelMainDelete.add(buttonDelete());
                    panelMainDelete.revalidate();


                } else if (comboBox.getSelectedItem() == deleteNameFootbalTeam) {

                    panelMainDelete.removeAll();
                    panelMainDelete.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), addPanelDeleteFootballTeam()));
                    panelMainDelete.add(buttonDelete());
                    panelMainDelete.revalidate();


                }
                if (comboBox.getSelectedItem().toString() == deleteNameFaculty) {

                    panelMainDelete.removeAll();
                    panelMainDelete.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), dialogInput.addPanelFaculty()));
                    panelMainDelete.add(buttonDelete());
                    panelMainDelete.revalidate();

//        panelMainSearch.add(this.addPanelDeletePositionComposition(dialogInput.addPanelPosition(), dialogInput.addPanelComposition()));
//    panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(), this.addPanelDeleteName(), this.addPanelDeletePatronomic(), this.addPanelDeleteFootballTeam()));
//        panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(), this.addPanelDeleteName(), this.addPanelDeletePatronomic(),dialogInput.addPanelFaculty()));

                }
            }
        });

        panelForCombobox.add(comboBox, BorderLayout.PAGE_START);
        return panelForCombobox;
    }

    private JPanel addMainDeletePanel() {
        panelMainDelete = new JPanel();
        panelMainDelete.setLayout(new BoxLayout(panelMainDelete, BoxLayout.Y_AXIS));
        panelMainDelete.setPreferredSize(new Dimension(400, 800));
        panelMainDelete.setAlignmentX(Component.CENTER_ALIGNMENT);

//this.addComboboxDelete().addActionListener(new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(addComboboxDelete().getSelectedItem() == deleteNameDate){
//            panelForCombobox.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), addPanelDeleteDate()),BorderLayout.CENTER);
//            panelMainSearch.add(panelForCombobox);
//        }
//        else if (addComboboxDelete().getSelectedItem() == deleteNameFaculty ){
//            panelForCombobox.add(addPanelDeleteNameWithAnything(addPanelDeleteSurname(), addPanelDeleteName(), addPanelDeletePatronomic(), addPanelDeleteDate()),BorderLayout.CENTER);
//            panelMainSearch.add(panelForCombobox);
//
//        }
//    }
//});


//        else if(this.addComboboxDelete().getSelectedItem().toString() == deleteNameFootbalTeam){
//           panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(),this.addPanelDeleteName(), this.addPanelDeletePatronomic(), this.addPanelDeleteFootballTeam()),BorderLayout.CENTER);
//       }
//        else if(this.addComboboxDelete().getSelectedItem().toString() == deleteNameFaculty){
//           panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(),this.addPanelDeleteName(), this.addPanelDeletePatronomic(), this.addPanelDeleteFaculty()),BorderLayout.CENTER);
//       }
//        panelForCombobox.add(this.addComboboxDelete(), BorderLayout.PAGE_START);

//        panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(), this.addPanelDeleteName(), this.addPanelDeletePatronomic(), this.addPanelDeleteDate()));
//        panelMainSearch.add(this.addPanelDeletePositionComposition(dialogInput.addPanelPosition(), dialogInput.addPanelComposition()));
//    panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(), this.addPanelDeleteName(), this.addPanelDeletePatronomic(), this.addPanelDeleteFootballTeam()));
//        panelMainSearch.add(this.addPanelDeleteNameWithAnything(this.addPanelDeleteSurname(), this.addPanelDeleteName(), this.addPanelDeletePatronomic(),dialogInput.addPanelFaculty()));

        return panelMainDelete;

    }



    public void setBool(boolean bool) {
        frameDelete.setVisible(bool);
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

    private JPanel addPanelDeleteFaculty() {
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
        return panelForFaculty;
    }

    private JButton buttonDelete() {


        JButton buttonDelete = new JButton("Удалить");
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedItem() == deleteNameDate)
                {
                    controllerButton.deleteNameDate(textFieldName, textFieldSurname, textFieldPatronomic, dateNameChooser);
                }
                else if(comboBox.getSelectedItem() == deletePosComp) {
                    controllerButton.deletePosComp(dialogInput.getComboBoxPosition(), dialogInput.getComboBoxComposition());
                }
                else if(comboBox.getSelectedItem() == deleteNameFaculty){
                    controllerButton.deleteNameFaculty(textFieldName, textFieldSurname, textFieldPatronomic, dialogInput.getComboBoxFaculty());
                }
                else if(comboBox.getSelectedItem() == deleteNameFootbalTeam) {
                    controllerButton.deleteFootbalTeam(textFieldName, textFieldSurname, textFieldPatronomic, textFieldFootballTeam);
                }
                JLabel countStudent = new JLabel();
                JLabel label = new JLabel("Студентов удалено: ");
                countStudent.setText(String.valueOf(controllerButton.getCountDeleteStudent()));
                panelResultDelete.removeAll();

                panelResultDelete.add(label);
                panelResultDelete.add(countStudent);
                panelResultDelete.revalidate();
                controllerButton.setCountStudentNull(0);





            }
        });
        return buttonDelete;
    }


    /**
     * Created by Игорь on 19.04.2016.
     */

}
