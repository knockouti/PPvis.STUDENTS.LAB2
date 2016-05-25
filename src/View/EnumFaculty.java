package View;

/**
 * Created by Игорь on 04.05.2016.
 */
public enum EnumFaculty {FITU("ФИТУ"),KSIS("КСИС"), IEF("ИЭФ"), FKP("ФКП"), FRE("ФРЭ");
    private final  String string;

    private EnumFaculty(String string)
    {
        this.string = string;
    }
    @Override
    public String toString(){
        return  string;
    }

}
