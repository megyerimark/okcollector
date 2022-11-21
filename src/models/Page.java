/*
 * File: Page.java
 * Created Date: 2021-09-24 14:26:47
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
 */

package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Page {
    public String url;
    public ArrayList<String> getContent() {
        String result = "semmi";
        ArrayList<String> wordList = new ArrayList<>();
        if (!url.isEmpty()) {
            try {
                Connection conn = Jsoup.connect(this.url);
                Document doc = conn.get();
                result = doc.body().text();
                
                } catch (IOException e) {
                    System.err.println("Hiba! A weblap nem olvasható");
                }
                result = result.replaceAll("\\p{Punct}", "");
                result = result.replaceAll("[©0-9]", "");
                result = result.trim().replaceAll(" +", "\n");
        
        }else {
            System.err.println("Hiba! Az url nincs beállítva!");
        }

        Scanner scanner = new Scanner(result);
        while(scanner.hasNextLine()) {
            wordList.add(scanner.nextLine());
        }
        scanner.close();
        Collections.sort(wordList);
        return wordList;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
