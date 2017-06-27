/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public interface IEntity {
    
    public String getName();
    
    public ArrayList<Attribute> getAttributes();
    
    public Object getAttributeValue(String attributeName);
    
    public void addAtribute(String attributeName, String attrbiuteValue);
    
    
    
    
}
