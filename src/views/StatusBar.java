/*
 * File: StatusBar.java
 * Created Date: 2021-09-24 13:51:43
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

package views;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StatusBar extends JPanel {
    /**
     * A Java Swing és AWT csomag nem tartalmaz Status sávot. 
     * Minden programozói könyvtár, amely felhasználói felület
     * létrehozására képes, általában tartalmaz stuszsáv
     * megvalósítására alkalmas osztályt, vagy valamilyen
     * eszközt. A Java elég elterjedt, ennek ellenére nem
     * tette bele statuszsáv megvalósítására alkalmas 
     * osztály. 
     */
    // Ezen lesz a státuszsáv
    JLabel statusLabel;

    // Ez az osztály konstruktora
    public StatusBar(int width) {        
        setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        size(width, 25);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        statusLabel = new JLabel("Kész");
        this.setm("Kész");
        this.add(statusLabel);
    } // A StatusBar konstruktor vége
    
    //Ez állítja be a méretét státuszsornak
    public void size(int x, int y) {
        // A setMaximumSize() függvény csak Demension osztály képes fogadni
        // Nem tudtak jobbat?
        setMaximumSize(new Dimension(x, y));
        setMinimumSize(new Dimension(x, y));
        setPreferredSize(new Dimension(x, y));
    } //A size függvény vége

    //A státuszsor tartalmát állítjuk be
    public void setm(String message) {
        // A statusz üzenetnek külön függvényt csináltunk.
        this.statusLabel.setText(message);
    } // a setMessge() függvény vége
}
