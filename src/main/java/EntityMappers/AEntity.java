/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class AEntity implements IEntity {

    private final String name;
    private List<Attribute> attributes;

    public AEntity(String name) {
        this.name = name;
    }

    @Override
    public void addAtribute(String attributeName, String attrbiuteValue) {
        if (getAttributes() == null) {
            attributes=new ArrayList<>();
        }
        
        attributes.add(new Attribute(attributeName, attrbiuteValue));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List getAttributes() {
        return attributes;
    }

    @Override
    public Object getAttribute(String attributeName) {
        for (Attribute atr : attributes) {
            if (atr.getAttributeName().equalsIgnoreCase(attributeName)) {
                return atr.getValue();
            }
        }
        return null;
    }

}
