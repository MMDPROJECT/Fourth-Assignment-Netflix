package org.example;

import javax.swing.*;

public class CreatingAccount_Window {
    private NetflixService netflix;

    public CreatingAccount_Window(NetflixService netflix) {
        this.netflix = netflix;

        String userName = JOptionPane.showInputDialog(null, "ENTER YOUR USERNAME");
        String passWord = JOptionPane.showInputDialog(null, "ENTER YOUR PASSWORD");
        if (NetflixService.createAccount(userName, passWord)) {                         //checks if it's possible creates an account otherwise shows a message
            JOptionPane.showMessageDialog(null, "AN ACCOUNT FOR USER HAS BEEN SUCCESSFULLY SUBMITTED", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "THIS USER ALREADY EXISTS", "NETFLIX ADMIN", JOptionPane.WARNING_MESSAGE);
        }
        new MainMenu_Window(netflix);
    }
}
