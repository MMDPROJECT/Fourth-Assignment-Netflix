package org.example;

import java.util.ArrayList;

public interface searchAndShow_Interface {
    public ArrayList<TVShow> searchByTitle(String title);

    public ArrayList<TVShow> searchByGenre(String genre);

    public ArrayList<TVShow> searchByReleaseYear(int year);

    public void showList(ArrayList<TVShow> list);

    public boolean doesTVShowExist(String title);
}
