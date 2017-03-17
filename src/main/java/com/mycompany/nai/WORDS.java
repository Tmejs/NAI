/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nai;

/**
 *
 * @author Tmejs (mateusz.rzad@gmail.com)
 */
public class WORDS {

    //Excpetions
    public final static String NO_PARAMS_FILE = "Brak pliku konfiguracyjnego ";
    public final static String CONF_FILE_ERROR = "Błąd w pliku konfiguracyjnym";
    public final static String WRONG_DEFINED_PARAM = "Błędnie zdefiniowany parametr w pliku konfiguracyjnym lub w klasie parametrów";
    public final static String CANT_OPEN_LOG_FILE = "Nie można otworzyć pliku logowania";

    public final static String WELCOME_STRING = "<div text-align=\"center\">Witaj. <br>"
            + "Aplikacja została stworzona na ptorzeby przedmiotu NAI.<br>"
            + "Realizcuję model sztucznej inteligencji oparty na budowania drzew binarnych. <br>"
            + "Aplikacja działa na bazie danych w pliku "+Main.PARAMS.PATH_TO_DB+"<br>"
            + "Aby rozpocząć grę wybierz element z bazy, sprawdz czy na pewno jest ok i kliknij \"START\".</div>";
}
