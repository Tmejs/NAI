/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import com.mycompany.nai.Logger;
import com.mycompany.nai.Main;
import java.rmi.Naming;
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

    public void printEntities() {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "printEntities()");
        for (AEntity entity : entities) {
            System.out.print(entity.getName());
            for (Attribute atr : entity.getAttributes()) {
                System.out.print(atr.getAttributeName() + ":" + atr.getValue());
            }
            System.out.println("");
        }

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
        for (int i = getEntitites().size() - 1; i >= 0; i--) {
            Object atributeValue = getEntitites().get(i).getAttribute(atribute.getAttributeName());
            if (atributeValue != null) {
                if (atributeValue.equals(atribute.getValue())) {
                    if (!isOk) {
                        getEntitites().remove(getEntitites().get(i));
                    }
                } else if (isOk) {
                    getEntitites().remove(getEntitites().get(i));
                }
            }
        }
    }
}
