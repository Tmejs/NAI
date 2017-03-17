/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import com.mycompany.nai.Logger;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.nai.Main;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class AEntity implements IEntity {

    private final String name;
    private ArrayList<Attribute> attributes;

    public AEntity(String name) {
        this.name = name;
    }

    @Override
    public void addAtribute(String attributeName, String attrbiuteValue) {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "addAtribute(" + attributeName + "," + attrbiuteValue + ")");
        if (getAttributes() == null) {
            attributes = new ArrayList<>();
        }

        attributes.add(new Attribute(attributeName, attrbiuteValue));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Object getAttribute(String attributeName) {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "getAttribute(" + attributeName + ")");
        for (Attribute atr : attributes) {
            if (atr.getAttributeName().equalsIgnoreCase(attributeName)) {
                return atr.getValue();
            }
        }
        return null;
    }

}
