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
 */

package controllers;

import java.util.ArrayList;

import models.Page;
import views.MainWindow;



/* 
    FIXME Az öröklés felesleges. 
    Ha megszüntetjük szükség lesz egy mainWindow adattagra. 
*/
public class CollectorController extends MainController {
    
    public CollectorController(MainWindow mainWindow) {
        super(mainWindow);

        mainWindow.pasteButton.addActionListener(event -> {
            System.out.println("beillesztés");
            mainWindow.urlField.paste();
        });

        mainWindow.startButton.addActionListener(event -> {
            String url = mainWindow.urlField.getText();
            if (url.isEmpty()) {
                url = "https://index.hu";
            }
            Page page = new Page();
            page.setUrl(url);
            ArrayList<String> wordList = page.getContent();

            for(String word : wordList) {
                if (mainWindow.wordsModel.indexOf(word)<0) {
                    mainWindow.wordsModel.addElement(word);
                }                
            }
            Integer wordCount = mainWindow.wordsModel.getSize();
            mainWindow.statusBar.setMessage("Szavak: " + wordCount.toString());
        });

    }   
}
