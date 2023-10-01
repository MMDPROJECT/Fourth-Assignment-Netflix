package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage_Window {
    private NetflixService netflix;

    public UserPage_Window(NetflixService netflix) {
        this.netflix = netflix;

        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.setIconImage(new ImageIcon("Netflix Icon.png").getImage());
        frame.setLayout(null);

        //North panel including : SITE TITLE & CURRENT USER
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        panel1.setBounds(0, 0, 600, 100);
        panel1.setLayout(new GridLayout(2, 1));
        panel1.setBackground(Color.BLACK);

        //Central panel including : OPTION MENUS
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLACK);
        panel2.setBounds(0, 100, 600, 500);
        panel2.setLayout(new GridLayout(9, 1));
        panel2.setBackground(Color.BLACK);

        //SITE TITLE
        JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon("netflix main.jpg"));
        label1.setHorizontalAlignment(JLabel.CENTER);

        //CURRENT USER
        JLabel label2 = new JLabel();
        label2.setText("CURRENT USER: " + netflix.getCurrentUser().getUserName().toUpperCase());
        label2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        label2.setForeground(Color.red);
        label2.setHorizontalAlignment(JLabel.CENTER);

        JButton button1 = new JButton("SEARCH THROUGH ALL OF TV-SHOWS");
        button1.setFocusable(false);
        button1.setBackground(Color.red);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {

                    //open a SEARCH THROUGH ALL MOVIES window
                    new SearchThroughAll_Window(netflix);
                }
            }
        });
        JButton button2 = new JButton("SEARCH THROUGH ALL OF FAVORITE TV-SHOWS");
        button2.setFocusable(false);
        button2.setBackground(Color.red);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new SearchThroughFavorites_Window(netflix);
            }
        });
        JButton button3 = new JButton("RECOMMENDED TV-SHOWS FROM YOUR FAVORITES");
        button3.setFocusable(false);
        button3.setBackground(Color.RED);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "THE RESULTS WILL BE SHOWN IN TERMINAL PLEASE CHECKOUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                netflix.showList(netflix.getCurrentUser().getRecommendations());
            }
        });
        JButton button4 = new JButton("ADD TO YOUR FAVORITES");
        button4.setFocusable(false);
        button4.setBackground(Color.RED);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddTVShowToFavorites_Prompt(netflix);
            }
        });
        JButton button5 = new JButton("ADD TV-SHOW TO ALL THE MOVIES");
        button5.setFocusable(false);
        button5.setBackground(Color.RED);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddTVShowToAll_Prompt(netflix);
            }
        });
        JButton button6 = new JButton("LIKE OR DISLIKE A TV-SHOW");
        button6.setFocusable(false);
        button6.setBackground(Color.RED);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new UserOpinion_Window(netflix);
            }
        });
        JButton button7 = new JButton("SHOW A LIST OF SUBMITTED OPINIONS(LIKE & DISLIKES)");
        button7.setFocusable(false);
        button7.setBackground(Color.RED);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN TERMINAL PLEASE CHECKOUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                netflix.getCurrentUser().showList(netflix.getCurrentUser().getLikedTvShow());
            }
        });
        JButton button8 = new JButton("LOGOUT");
        button8.setFocusable(false);
        button8.setBackground(Color.RED);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "YOU HAVE BEEN SUCCESSFULLY LOGGED OUT", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                netflix.logout();
                frame.dispose();
                new MainMenu_Window(netflix);
            }
        });
        JButton button9 = new JButton("BACK TO MAIN MENU");
        button9.setFocusable(false);
        button9.setBackground(Color.RED);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.dispose();
                new MainMenu_Window(netflix);
            }
        });
        button1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button3.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button4.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button5.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button6.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button7.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button8.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
        button9.setFont(new Font("Tw Cen MT", Font.BOLD, 20));

        panel1.add(label1);
        panel1.add(label2);
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        panel2.add(button5);
        panel2.add(button6);
        panel2.add(button7);
        panel2.add(button8);
        panel2.add(button9);
        frame.add(panel1);
        frame.add(panel2);
        frame.setVisible(true);
    }
}
