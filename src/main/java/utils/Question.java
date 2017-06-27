/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import EntityMappers.Attribute;

/**
 *
 * @author Tmejs
 */
public class Question {
 
    private final Attribute questionAttribute;
    
    private final String questionString;
    
    private final Object attributeValue;

    public Question(Attribute questionAttribute, String questionString, Object attributeValue) {
        this.questionAttribute = questionAttribute;
        this.questionString = questionString;
        this.attributeValue=attributeValue;
    }

    public Attribute getQuestionAttribute() {
        return questionAttribute;
    }

    public String getQuestionString() {
        return questionString;
    }

    public Object getAttributeValue() {
        return attributeValue;
    }
    
    
    
    
    
}
    
