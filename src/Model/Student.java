package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import Controller.ControllerButton;
import sun.util.resources.LocaleData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Игорь on 20.04.2016.
 */
public class Student {
    private String name;
    private String surname;
    private String patronomic;
    private String position;
    private String composition;
    private Faculty faculty;
    private FootbalTeam footbalTeam;
    private Date dateBirthday;
   private String strDateBirthday;
    SimpleDateFormat simpleDateFormat;
    public Student() {
        faculty = new Faculty();
        footbalTeam = new FootbalTeam();
        simpleDateFormat = new SimpleDateFormat("dd.MM.yyy");
    }

    public String getFootballTeam() {
        return footbalTeam.getNameFootballTeam();
    }

    public String getFaculty() {
        return faculty.getNameFaculty();
    }

    public void setFootbalTeam(String string) {
        footbalTeam.setNameFootballTeam(string);
    }

    public void setFaculty(String string) {
        faculty.setNameFaculty(string);
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

    public String getDateBirthday() {

        return strDateBirthday;
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

    public void setDateBirthday(Date dateBirthday){


        try {
            this.dateBirthday = simpleDateFormat.parse(simpleDateFormat.format(dateBirthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        strDateBirthday = DateFormat.getDateInstance().format(dateBirthday);
    }
public Date getBirthdayDate(){
    return dateBirthday;
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
