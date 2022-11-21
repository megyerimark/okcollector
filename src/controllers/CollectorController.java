/*
 * File: CollectorController.java
 * Created Date: 2021-09-24 10:42:41
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Sallai Andras
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 * 
 *  * Refaktorálta Megyeri Márk Máté
 * 2022.11.21
 */

package controllers;

import java.util.ArrayList;

import models.Page;
import views.MainWindow;

/**********************KEZDÉS************************************* */

/* 
    FIXME Az öröklés felesleges. 
    Ha megszüntetjük szükség lesz egy mainWindow adattagra. 
*/

// A CollectorController osztály
public class CollectorController extends MainController {
    //A CollectorController osztály konstruktora    
    public CollectorController(MainWindow mainWindow) {
        super(mainWindow);
        //A vágólap tartalmát beillesztjük


        /**************** pasteButton ****************************/

        mainWindow.pasteButton.addActionListener(event -> {
            System.out.println("beillesztés");
            mainWindow.urlField.paste();
        }); // A pasteButton eseménykezelő vége


        /**************** startButton ****************************/


        //Indul a szógyűjtés
        mainWindow.startButton.addActionListener(event -> {
            // URL
            String utvonal = mainWindow.urlField.getText();
            if (utvonal.isEmpty()) {
                utvonal = "https://index.hu";
            }
            //Egy weblap
            Page page = new Page();
            page.setUrl(utvonal);
            //Gyűjtött szavak ide kerülnek:
            ArrayList<String> words = page.getContent();

            for(String word : words) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            } // for ciklus vége
            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setm("Szavak: " + wordCount.toString());
        }); //A start eseménykezelő vége

         /**************** VÉGE ****************************/


    }   
}
