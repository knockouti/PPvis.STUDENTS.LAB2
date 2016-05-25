package View;

/**
 * Created by Игорь on 04.05.2016.
 */
public enum EnumComposition {OSN("основа"), ZAP("запас");
    private final String text;
    /**
     * @param text
     */
    private EnumComposition(String text){
        this.text =text;
    }
    /*(non-Javadoc)
    * @see java.lang.Enum#toString()
     */

    @Override
    public String toString() {
        return  text;
    }
}


