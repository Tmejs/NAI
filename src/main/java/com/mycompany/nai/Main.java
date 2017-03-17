/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nai;

import EntityMappers.AEntity;
import EntityMappers.Entities;
import java.util.ArrayList;
import utils.CSVReader;
import utils.EntitiesUtil;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class Main {

    public static Logger LOG;
    public static Params PARAMS;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Inicjacja paramsów
        try {
            PARAMS = new Params(null);
        } catch (Exception e) {
            e.printStackTrace();
            closeApp();
        }

        //Inicjalizacja LOG
        LOG = new Logger(PARAMS.LOG_FILE_PATH, PARAMS.IS_FILE_APPEND, PARAMS.VERBOSE_MODE);

        Main.LOG.addLog(Main.class, Logger.LogType.DEBUG, Main.PARAMS.PATH_TO_DB);
        LOG.addLog(Main.class, Logger.LogType.DEBUG, "Po inicjalizacji params i log");

        //Pobranie bazy danych do aplikacji
        try {
            EntitiesUtil.mapArrayListToObjects(CSVReader.getDataFromCSVFile(PARAMS.PATH_TO_DB, PARAMS.CSV_COLUMN_DELIMETER));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Entities.getInstance().printEntities();
        /* Set the Nimbus look and feel */ //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppModel().showFrame();
            }
        });
    }

    public static void closeApp() {
        System.exit(0);
    }
}
