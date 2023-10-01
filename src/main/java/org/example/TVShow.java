package org.example;

import java.util.ArrayList;

class TVShow {
    private String title;
    private String genre;
    private int releaseYear;
    private double rating;
    private int likes;
    private ArrayList<String> cast = new ArrayList<>();

    //Constructor
    public TVShow(String title, String genre, int releaseYear, double rating, ArrayList<String> cast) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.cast = cast;
        this.likes = 0;
    }

    //Getter and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    @Override
    public String toString() {
        String Cast = "Cast: ";

        for (int i = 0; i < this.cast.size(); i++) {
            Cast += this.cast.get(i);
            if (i != this.cast.size() - 1) {
                Cast += ", ";
            }
        }
        return "TVShow{Title: " + this.title + ", " +
                "Genre: " + this.genre + ", " +
                "Release Year: " + this.releaseYear + ", " +
                "Rating: " + this.rating + ", " +
                Cast + "}";
    }
}
