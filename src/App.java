/*
 * File: App.java
 * Created Date: 2021-09-24 10:19:52
 * Author: Sallai Andras
 * Github: https://github.com/andteki
 * -----
 * Last Modified: 2021-09-24
 * Modified By: Sallai Andras
 * -----
 * Copyright (c) 2021 Sallai Andras
 * 
 * GNU GPL v2
 * *  * Refaktorálta Megyeri Márk Máté
 * 2022.11.21
 */

import controllers.CollectorController;
import controllers.MainController;
import controllers.WordsController;
import views.MainWindow;

public class App {
public static void main(String[] args) throws Exception {
MainWindow mainWindow = new MainWindow();
new MainController(mainWindow);
new CollectorController(mainWindow);
new WordsController(mainWindow);
mainWindow.setVisible(true);
}
}
