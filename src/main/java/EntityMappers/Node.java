/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityMappers;

import utils.Question;

/**
 *
 * @author Tmejs
 */
public class Node {
    
    private Question node;
    private Question yesQuestion;
    private Question noQuestion;
    
    
    public Question getNode() {
        return node;
    }

    public Question getYesQuestion() {
        return yesQuestion;
    }

    public Question getNoQuestion() {
        return noQuestion;
    }

    public void setNode(Question node) {
        this.node = node;
    }

    public void setYesQuestion(Question yesQuestion) {
        this.yesQuestion = yesQuestion;
    }

    public void setNoQuestion(Question noQuestion) {
        this.noQuestion = noQuestion;
    }
    
    
    
    
}
