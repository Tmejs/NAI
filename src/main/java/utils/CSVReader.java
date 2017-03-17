/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.mycompany.nai.Logger;
import com.mycompany.nai.Main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class CSVReader {

    public static ArrayList<ArrayList<String>> getDataFromCSVFile(String pathToFile, String columnDelimeter) throws IOException {
        Main.LOG.addLog(CSVReader.class, Logger.LogType.DEBUG, "getDataFromCSVFile(\"" + pathToFile + "\")");
        ArrayList<ArrayList<String>> rowsArray = new ArrayList();

        try {
            //Pobieramy plik
            BufferedReader CSVFile
                    = new BufferedReader(new FileReader(pathToFile));
            //Czytamy z pliku
            String dataRow;
            while ((dataRow = CSVFile.readLine()) != null) {
                ArrayList<String> arr = new ArrayList<>();

                //podział na kolumny
                for (String col : dataRow.split(columnDelimeter)) {
                    arr.add(col);
                }
                //Dodanie listy(wiersza) do Listy(tabeli)
                rowsArray.add(arr);
            }

        } catch (IOException e) {
            Main.LOG.addLog(CSVReader.class, Logger.LogType.WARRNING, e);
            throw e;
        }

        return rowsArray;
    }

}
