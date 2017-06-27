/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import com.mycompany.nai.Logger;
import com.mycompany.nai.Main;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import utils.Question;
import utils.QuestionGenerator;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Entities {

    private static Entities instance;

    private List<AEntity> entities;

    private Question currentQuestion;

    private Entities() {
    }

    public Question getNewQuestion() {
        return getNewQuestion(this.entities);
    }

    public void filterByAskedQuestion(Boolean answer) {
        entities = filterList(entities, currentQuestion.getQuestionAttribute(), answer);
    }

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

    private Double calculateEntropy(List<AEntity> entiteis, Attribute attr, Object attrValue) {
        //Wzor wyliczania entropi
        //https://pl.wikipedia.org/wiki/Teoria_informacji
        Double count = ((Integer) entiteis.size()).doubleValue();
        Double correct = ((Integer) filterList(entiteis, new Attribute(attr.getAttributeName(), attrValue.toString()), Boolean.TRUE).size()).doubleValue();
        Double inncorect = count - correct;

        Double entropy = (0 - (correct / count) * (Math.log10(correct / count) / Math.log10(2))) - (inncorect / count) * (Math.log10(inncorect / count) / Math.log10(2));

        if (entropy == Double.NaN) {
            return new Double("0");
        }
        return entropy;
    }

    private Question getNewQuestion(List<AEntity> ent) {
        Attribute finalAttr = null;
        Object finalVal = null;
        Double lastValue = Double.valueOf("0");
        //Iteracja po wsyztskich atrybutach(kolumnach)
        for (Attribute attr : ent.get(0).getAttributes()) {

            //Bierzemy wszystkie wartości atrybutu
            List<Object> values = Attribute.getAttributeDistinctValues(ent, attr);
            for (Object val : values) {
                //Wyliczamy entropie dla wykorzystania danego atrybutu
                if (calculateEntropy(getEntitites(), attr, val) >= lastValue) {
                    lastValue=calculateEntropy(getEntitites(), attr, val);
                    finalAttr = new Attribute(attr.getAttributeName(), val.toString());
                }
            }
        }
        currentQuestion = QuestionGenerator.generateQuestion(finalAttr, finalAttr.getValue());
        return currentQuestion;
    }

    public void addEntity(AEntity entity) {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "addEntity(" + entity.getName() + ")");

        getEntitites().add(entity);
    }

//    
//    public List<Attribute.AttributeStat> getAtributesList(){
//        List<Attribute.AttributeStat> attrList= new ArrayList<>();
//        
//        getEntitites().forEach(a->{
//            a.getAttributes().stream().forEach(b->
//            {
//                attrList.add(new Attribute.AttributeStat(b.getAttributeName(), b.getValue()));
//            });
//        });
//            
//        
//        return attrList;
//        
//    }
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

    public List<AEntity> filterList(List<AEntity> list, Attribute atribute, Boolean isOk) {
        List<AEntity> filteredList = new ArrayList<>();
        list.forEach((aa) -> {
            Object atributeValue = aa.getAttributeValue(atribute.getAttributeName());
            if (atributeValue != null) {
                if (atributeValue.getClass() == Boolean.class) {
                    if (atributeValue.equals(atribute.getValue())) {
                        if (isOk) {
                            filteredList.add(aa);
                        }
                    } else if (!isOk) {
                        filteredList.add(aa);
                    }
                }else{
                    if (((String)atributeValue).equalsIgnoreCase((String)atribute.getValue())) {
                        if (isOk) {
                            filteredList.add(aa);
                        }
                    } else if (!isOk) {
                        filteredList.add(aa);
                    }
                }
            }
        });
        return filteredList;
    }

}
