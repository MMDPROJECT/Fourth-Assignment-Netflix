package org.example;

import javax.swing.*;

public class UserLogin_Prompt {
    private NetflixService netflix;

    public UserLogin_Prompt(NetflixService netflix){
        this.netflix = netflix;

        String username = JOptionPane.showInputDialog(null, "ENTER YOUR USERNAME");
        String password = JOptionPane.showInputDialog(null, "ENTER YOUR PASSWORD");

        if (netflix.login(username, password)) {
            JOptionPane.showMessageDialog(null, "YOU ARE SUCCESSFULLY LOGGED IN!", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
            new UserPage_Window(netflix);
        } else {
            JOptionPane.showMessageDialog(null, "USERNAME OR PASSWORD IS WRONG", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
            new MainMenu_Window(netflix);
        }
    }
}
