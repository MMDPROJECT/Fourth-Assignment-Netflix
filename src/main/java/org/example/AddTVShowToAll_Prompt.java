package org.example;

import javax.swing.*;
import java.util.ArrayList;

public class AddTVShowToAll_Prompt {
    private NetflixService netflix;

    public AddTVShowToAll_Prompt(NetflixService netflix) {
        this.netflix = netflix;

        String title = JOptionPane.showInputDialog(null, "ENTER TITLE");
        String genre = JOptionPane.showInputDialog(null, "ENTER GENRE");
        int releaseYear = Integer.parseInt(JOptionPane.showInputDialog(null, "ENTER RELEASE YEAR"));
        double rating = Double.parseDouble(JOptionPane.showInputDialog(null, "ENTER RATING"));

        if (netflix.doesTVShowExist(title)) {
            JOptionPane.showMessageDialog(null, "THIS TV-SHOW ALREADY EXIST, YOU CAN'T ADD IT", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "ENTER CAST ONE BY ONE AND ENTER A -1 AT THE END");
            ArrayList<String> cast = new ArrayList<>();
            while (true) {
                String menuOption = JOptionPane.showInputDialog(null, "ENTER CAST");
                ;
                if (!menuOption.equals("-1")) {
                    cast.add(menuOption);
                } else {
                    break;
                }
            }
            TVShow tvShow = new TVShow(title, genre, releaseYear, rating, cast);
            NetflixService.tvShows.add(tvShow);
            JOptionPane.showMessageDialog(null, "TV-SHOW HAS BEEN SUCCESSFULLY ADDED");
        }
    }
}

