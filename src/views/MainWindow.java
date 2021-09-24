/*
 * File: MainWindow.java
 * Created Date: 2021-09-24 10:36:27
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

package views;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MainWindow extends JFrame {

    public JLabel appLabel;
    public JTextField urlField;

    public JPanel collectorPanel;
    public JButton pasteButton;
    public JButton startButton;
    public JButton aboutButton;
    public JButton exitButton;


    public JPanel listPanel;
    public JLabel wordsLabel;

    public DefaultListModel<String> wordsModel;
    public JList<String> wordsList;
    public JScrollPane wordsScrollPane;

    public JButton deleteButton;
    public JButton lowercaseButton;
    public JButton filterButton;
    public JButton saveButton;

    public JPanel listButtonsPanel;

    public JPanel bottomPanel;
    public StatusBar statusBar;

    public MainWindow() {
        appLabel = new JLabel("Szógyűjtő");
        urlField = new JTextField();        

        collectorPanel = new JPanel();
        collectorPanel.setLayout(new BoxLayout(collectorPanel, BoxLayout.LINE_AXIS));
        pasteButton = new JButton("Beillesztés");
        startButton = new JButton("Start");
        aboutButton = new JButton("Névjegy");
        exitButton = new JButton("Kilépés");

        this.collectorPanel.add(pasteButton);
        this.collectorPanel.add(startButton);
        this.collectorPanel.add(aboutButton);
        this.collectorPanel.add(exitButton);


        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
        wordsLabel = new JLabel("Talált szavak");

        wordsModel = new DefaultListModel<>();
        wordsList = new JList<>(wordsModel);
        wordsScrollPane = new JScrollPane(wordsList);
        listPanel.add(wordsLabel);
        listPanel.add(wordsScrollPane);

        deleteButton = new JButton("Törlés");
        deleteButton.setMinimumSize(new Dimension(110, 25));
        deleteButton.setMaximumSize(new Dimension(110, 25));
        deleteButton.setPreferredSize(new Dimension(110, 25));
        deleteButton.setMargin(new Insets(20, 20, 20, 20));

        lowercaseButton = new JButton("Kisbetű");
        lowercaseButton.setMinimumSize(new Dimension(110, 25));
        lowercaseButton.setMaximumSize(new Dimension(110, 25));
        lowercaseButton.setPreferredSize(new Dimension(110, 25));
        
        filterButton = new JButton("Szűrés");
        filterButton.setMinimumSize(new Dimension(110, 25));
        filterButton.setMaximumSize(new Dimension(110, 25));
        filterButton.setPreferredSize(new Dimension(110, 25));

        saveButton = new JButton("Mentés");
        saveButton.setMinimumSize(new Dimension(110, 25));
        saveButton.setMaximumSize(new Dimension(110, 25));
        saveButton.setPreferredSize(new Dimension(110, 25));
        


        listButtonsPanel = new JPanel();
        listButtonsPanel.setLayout(new BoxLayout(listButtonsPanel, BoxLayout.PAGE_AXIS));
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(deleteButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(lowercaseButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(filterButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.add(saveButton);
        listButtonsPanel.add(Box.createVerticalGlue());
        listButtonsPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(listPanel);
        bottomPanel.add(listButtonsPanel);
        


        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        this.add(appLabel);
        this.add(urlField);
        this.add(collectorPanel);
        this.add(bottomPanel);
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setSize(300, 250);
        this.pack();
        /**
         * A pack() után kell szerepeljen, mert az ablak mérete
         * csak az után van meg.
         */
        statusBar = new StatusBar(this.getWidth());
        this.add(statusBar);

    }
    
}
