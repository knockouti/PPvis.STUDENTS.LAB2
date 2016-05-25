package View;

/**
 * Created by Игорь on 04.05.2016.
 */
public enum EnumPosition {GK("голкипер"), ZAS("защитник"),POL("полузащитник"), NAP("нападающий");
private final String text;
    /**
     * @param text
     */
    private EnumPosition(String text){
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

