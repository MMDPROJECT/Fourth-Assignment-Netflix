package org.example;

import java.util.ArrayList;
import java.util.Scanner;

////////BONUS TASKS THAT HAS BEEN COMPLETED : INPUT VALIDATION, IMPLEMENTED A EXTRA FEATURE (LIKE AND DISLIKE)

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        NetflixService netflix = new NetflixService(null);
        new MainMenu_Window(netflix);

        //INITIALIZING DEFAULT MOVIE IN SITE
        ArrayList<String> cast = new ArrayList<>();
        cast.add("Denzel Washington");
        cast.add("Marton Csokas");
        cast.add("Chloe Grace Moretz");

        Movie defaultMovie = new Movie(2, "The Equalizer", "Action", 2014, 7.2, cast);
        NetflixService.tvShows.add(defaultMovie);
    }
}
