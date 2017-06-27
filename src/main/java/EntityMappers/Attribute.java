/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import com.mycompany.nai.Main;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Attribute(String atributteName, String stringValue) {
        this.atributteName = atributteName;
        setValue(stringValue);
    }

    public String getAttributeName() {
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
//
//    public void setBooleanValues() {
//        if (Main.PARAMS.TRUE_STRING_VALUE != null) {
//            trueStringValue = Main.PARAMS.TRUE_STRING_VALUE;
//        }
//
//        if (Main.PARAMS.FALSE_STRING_VALUE != null) {
//            falseStringValue = Main.PARAMS.FALSE_STRING_VALUE;
//        }
//        setBooleanValues();
//    }

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

    public static List<Object> getAttributeDistinctValues(List<AEntity> entitiesList, Attribute attr) {
        List<Object> list = new ArrayList<>();
        entitiesList.forEach(a -> {
            list.add(a.getAttributeValue(attr.atributteName));
        });
        return list.stream().distinct().collect(Collectors.toList());

    }

}
