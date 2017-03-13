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
public class Entities {

    private List<AEntity> entities;
    private static Entities instance;

    public static Entities getInstance() {
        if (instance == null) {
            instance = new Entities();
        }
        return instance;
    }

    public List<AEntity> getEntitites() {
        if (entities == null) {
            entities = new ArrayList<AEntity>();
        }
        return entities;
    }

    public void addEntity(AEntity entity) {
        getEntitites().add(entity);
    }

    public AEntity getEntity(String entityName) {
        for (AEntity entity : getEntitites()) {
            if (entity.getName().equalsIgnoreCase(entityName)) {
                return entity;
            }
        }
        return null;
    }

    public void filterList(Attribute atribute, Boolean isOk) {
        for (int i = getEntitites().size() - 1; i > 0; i--) {
            Object atributeValue = getEntitites().get(i).getAttribute(atribute.getAttributeName());
            if (atributeValue != null) {
                if (atributeValue.equals(atribute.getValue())) {
                    if (!isOk) {
                        getEntitites().remove(getEntitites().get(i));
                    }
                }
            }
        }
    }
}
