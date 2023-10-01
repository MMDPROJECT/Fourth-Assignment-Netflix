package org.example;

import java.util.ArrayList;

class NetflixService implements searchAndShow_Interface {
    private static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<TVShow> tvShows = new ArrayList<>();
    private User currentUser;

    //Constructors
    public NetflixService(User currentUser) {
        this.currentUser = currentUser;
    }

    //Getters and Setters
    public static TVShow getASingleTVShow(String Title) {
        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().equalsIgnoreCase(Title)) {
//                System.out.println("BANG");;
                return tvShow;
            }
        }
        return null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    //Overriding
    @Override
    public void showList(ArrayList<TVShow> list) {
        if (list != null) {
            for (TVShow tvShow : list) {
                System.out.println(tvShow.toString());
            }

        } else {
            System.out.println("NOTHING FOUND TO SHOW");
        }
        System.out.println();
    }

    @Override
    public boolean doesTVShowExist(String title) {
        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    //Service - Related Functions

    public static boolean doesUserExist(String username) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean createAccount(String username, String password) {
        if (!doesUserExist(username)) {
            User newUser = new User(username, password);
            users.add(newUser);
            return true;
        } else {
            return false;
        }
    }

    public boolean login(String username, String password) {
        for (User user : users) {
            if (user.getUserName().equalsIgnoreCase(username) && user.getPassWord().equals(password)) {
                setCurrentUser(user);
                return true;
            }
        }
        return false;
    }

    public void logout() {
//        System.out.println("User " + this.currentUser.getUserName() + " Successfully Logged Out!");
        this.currentUser = null;
    }

    public ArrayList<TVShow> searchByTitle(String title) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getTitle().equalsIgnoreCase(title)) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public ArrayList<TVShow> searchByGenre(String genre) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getGenre().equalsIgnoreCase(genre)) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }

    public ArrayList<TVShow> searchByReleaseYear(int year) {
        ArrayList<TVShow> list = new ArrayList<>();

        for (TVShow tvShow : tvShows) {
            if (tvShow.getReleaseYear() == year) {
                list.add(tvShow);
            }
        }
        if (list.size() != 0) {
            return list;
        }
        return null;
    }
}

