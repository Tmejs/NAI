/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import com.mycompany.nai.Main;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Attribute {

    private final String atributteName;
    private Boolean boolValue;
    private String stringValue;

    private static String trueStringValue = "true";
    private static String falseStringValue = "false";
    private static Boolean isValueSet = false;

    public Attribute(String atributteName, String stringValue) {
        this.atributteName = atributteName;
        setValue(stringValue);

        if (!isValueSet) {
            setBooleanValues();
        }
    }
    
    public String getAttributeName(){
        return atributteName;
    }

    public Object getValue() {
        if (checkIsValueBool()) {
            return boolValue;
        } else {
            return stringValue;
        }
    }

    public Boolean checkIsValueBool() {
        return boolValue != null;
    }

    public void setBooleanValues() {
        if (Main.PARAMS.TRUE_STRING_VALUE != null) {
            trueStringValue = Main.PARAMS.TRUE_STRING_VALUE;
        }

        if (Main.PARAMS.FALSE_STRING_VALUE != null) {
            falseStringValue = Main.PARAMS.FALSE_STRING_VALUE;
        }

        isValueSet = true;

    }

    private void setValue(String stringValue) {

        //Ustawienie wartości bool
        if (stringValue.equalsIgnoreCase(trueStringValue)) {
            boolValue = true;
            return;
        }
        if (stringValue.equalsIgnoreCase(falseStringValue)) {
            boolValue = false;
            return;
        }

        this.stringValue = stringValue;

    }

}
