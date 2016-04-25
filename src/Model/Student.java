package Model;

import Controller.ControllerButton;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Игорь on 20.04.2016.
 */
public class Student {
    private String name;
    private String surname;
    private String patronomic;
    private Calendar dateBirthday;
    private String position;
    private String composition;


    ControllerButton controllerButton;

    public Student() {


    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }


    public String getPatronomic() {
        return patronomic;
    }

    public Calendar getDateBirthday() {

        return dateBirthday;
    }

    public String getPosition() {
        return position;
    }

    public String getComposition() {
        return composition;
    }

    public void setSurname(String string) {
        this.surname = string;
    }

    public void setName(String string) {
        this.name = string;
    }

    public void setDateBirthday(Calendar calendar) {
        this.dateBirthday = calendar;
    }

    public void setPatronomic(String string) {
        this.patronomic = string;
    }

    public void setPosition(String string) {
        this.position = string;
    }

    public void setComposition(String string) {
        this.composition = string;
    }

}
