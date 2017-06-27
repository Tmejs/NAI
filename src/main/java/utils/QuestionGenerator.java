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
public class QuestionGenerator {
    
    private static String generateQuestion(String attributeName, Object attributeValue){
    
        String questionString = "Czy wybrany przez Ciebie obiekt ma cechę "+ attributeName +" o wartosci:";
        
        if(attributeValue.getClass() == String.class){
            questionString = questionString + "   " + ((String)attributeValue);
        }else 
        {
            questionString = questionString + "   "+ ((Boolean)attributeValue).toString();
        }
        
        
        
        return questionString;
    }
    
//    private String objectValueConverter(Object value){
//        if(value.getClass()==Boolean.class){
//            if(value) return "tak";
//        }
//    }
    
    public static Question generateQuestion(Attribute attribute, Object value){
      return new Question(attribute,generateQuestion(attribute.getAttributeName(), value),value);
    }
    
    
}
