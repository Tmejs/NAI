/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import EntityMappers.AEntity;
import EntityMappers.Entities;
import java.util.ArrayList;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class EntitiesUtil {

    public static void mapArrayListToObjects(ArrayList<ArrayList<String>> arr) {
        //pobieramy nazwy kolumn
        ArrayList<String> colNames = arr.get(0);

        //Pobieramy resztę danych
        for (int i = 1; i < arr.size(); i++) {
            //Wypelnienie mapera entity w aplikacji
            AEntity newEntity = new AEntity(arr.get(i).get(0));
            for (int j = 1; j < arr.get(i).size(); j++) {
                newEntity.addAtribute(colNames.get(j), arr.get(i).get(j));
            }
            Entities.getInstance().addEntity(newEntity);
        }
    }
    
    private static void loadData(ArrayList<ArrayList<String>> arr){
        Entities.getInstance().getEntitites().clear();
        mapArrayListToObjects(arr);
    };
    
    
//    public static void generateQuestion();

}
