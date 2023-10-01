package org.example;

import java.util.ArrayList;

class Movie extends TVShow {
    private double length;

    //Constructor
    public Movie(double length, String title, String genre, int releaseYear, double rating, ArrayList<String> cast) {
        super(title, genre, releaseYear, rating, cast);
        this.length = length;
    }

    //Getter and Setters
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        String Cast = "Cast: ";

        for (int i = 0; i < getCast().size(); i++) {
            Cast += getCast().get(i);
            if (i != getCast().size() - 1) {
                Cast += ", ";
            }
        }
        return "Movie{Title: " + getTitle() + ", " +
                "Genre: " + getGenre() + ", " +
                "Release Year: " + getReleaseYear() + ", " +
                "Rating: " + getRating() + ", " +
                "Movie Length: " + getLength() + "H, " +
                Cast + "}";
    }
}
