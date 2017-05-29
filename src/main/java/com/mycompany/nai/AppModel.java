/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nai;

import EntityMappers.AEntity;
import EntityMappers.Attribute;
import EntityMappers.Entities;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class AppModel {

    private final App frame = new App(this);

    public AppModel() {
        frame.setModel(this);
        frame.setStartInfoText(WORDS.WELCOME_STRING);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public Boolean sheckIsInDatabase(String name) {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "sheckIsInDatabase("+name+")");
        return (Entities.getInstance().getEntity(name) != null);
    }
    
    public List<String> getDatabase(){
        List<String> aa = Entities.getInstance().getEntitites().stream().map(d->d.getName()).distinct().collect(Collectors.toList());
        aa.sort(String.CASE_INSENSITIVE_ORDER);
        return aa;
    }

    public void prepareToStartGame(){
        frame.showAnswerPanel(false);
        frame.showQuestionPanel(false);
        frame.showStartPanel(true);
    }
    
    public void startGame() {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "startGame()");
        frame.showStartPanel(false);
        frame.showQuestionPanel(true);
        frame.showAnswerPanel(false);
        askNewQuestion();
    }

    public void askNewQuestion() {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "askNewQuestion()");
        //Tworzenie statystyk

        //Tworzenie pytania
        
        //Wyświetlenie pytania
    }

    public void getAnswer(Boolean answer) {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "getAnswer("+answer+")");
        Entities.getInstance().printEntities();
        //Przefiltrowanie listy
        Entities.getInstance().filterList(new Attribute("Costam", "aa"), true);
        //Log z pozostałą listą
        Entities.getInstance().printEntities();
        //Sprawdzenie czy został tylko jeden elements
        if (Entities.getInstance().getEntitites().size() == 1) {
            endGame(Entities.getInstance().getEntitites().get(0).getName());
        } else {
            //Zadanie nowego pytania
            askNewQuestion();
        }
    }

    private void endGame(String name) {
        Main.LOG.addLog(this, Logger.LogType.DEBUG, "endGame("+name+")");
        frame.endGame(name);
    }
}
