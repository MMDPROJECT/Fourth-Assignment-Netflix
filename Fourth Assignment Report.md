![](https://s2.uupload.ir/files/sbu_y116.png)

# 						  						  					      Fourth Assignment Report

## 												    						 Mohammad Hossein Basouli 	401222020

















## Introduction:

- #### A brief description of the assignment:

  - This program will represent a very simple simulation of **Netflix**.

- #### Objectives of the program:

  - Letting the **users** **sign up** for an account.
  - Providing a structure for **users** to be able to sign in and make use of their abilities, such as adding **TV-Show** / **Movie** to their favorites, and ...

- #### A high-level overview of the approach taken to complete my task:

  - At first, we have to define a few classes such as **User**, **Netflix Service**, and... .
    The structure of each class should be very well organized, clear, and understandable.
    In the picture below I have brought a **UML** of classes that could show very clearly what attributes and functionalities we have implemented for each class:

    <img src="https://s2.uupload.ir/files/uml1_rpl0.png" style="zoom: 67%;" />  ![](https://s2.uupload.ir/files/uml2_b68g.png)
    
  - The second step is to build up each segment of the program corresponding to what the **user** wants to be done.
  
    For each segment, we provide some functionalities and some new frames to be opened or disposed of.
  
    Here is a Flowchart for a better understanding of the flow of the program:
  
    ![](https://s2.uupload.ir/files/flowchart1_9syz.png)
  
     

## Design and implementation:

- #### A description of the design of the solution:

  1. First, we initialize a new **NetflixService** named **netflix**, and initialize a **default Movie** for it, which is named "**The Equalizer**".

     ```java
     public static void main(String[] args) {
             NetflixService netflix = new NetflixService(null);
     
             //INITIALIZING DEFAULT MOVIE IN SITE
             ArrayList<String> cast = new ArrayList<>();
             cast.add("Denzel Washington");
             cast.add("Marton Csokas");
             cast.add("Chloe Grace Moretz");
     
             Movie defaultMovie = new Movie(2, "The Equalizer", "Action", 2014, 7.2, cast);
             NetflixService.tvShows.add(defaultMovie);
         }
     ```

  2. Then we open a **Main Menu window**, which contains all the options to continue the work of the program.

     ```java
             new MainMenu_Window(netflix);
     ```

  3. The **Main Menu window** is designed using two **JPanels**, one **north JPanel** with a Grid Layout of 2 rows and 1 column and a **central** one with a Grid Layout of 3 rows and 1 column.

     1. The **north JPanel** contains two **JLabels**, the first one displays the **Netflix site** icon at the top, and the second one displays the **username** of the **current user** that has logged in if there is any.

     2. The **central JPanel** including 3 **JButtons** is designed to show the **main menu** options and make the **user** able to choose what happens next. Each button is connected to an **action listener** which specifies what to do if this button is clicked. Every single one of the buttons is designed with a beautiful font style, appropriate color, and size for better readability.
     3. *every window of the program will have the **north panel** that I have explained above, so to avoid congestion I prevent explaining its properties or implementation again*
     4. *every **JButton** designed in each segment of the program will have the same properties explained above,  so to avoid congestion I prevent  explaining their properties or implementation again*

     ```java
     public class MainMenu_Window implements ActionListener {    //Main Menu Window Including 3 Options: 1-Creating An Account 2-Login As User 3-Exit
         private JFrame frame;
         private NetflixService netflix;
     
         public MainMenu_Window(NetflixService netflix) {
     
             this.netflix = netflix;
             this.frame = new JFrame();
     
             //Making up menu frame
             this.frame.setSize(600, 600);
             this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             this.frame.setLayout(null);
             this.frame.setIconImage(new ImageIcon("Netflix Icon.png").getImage());
     
             //North panel including : current user & site title
             JPanel panel1 = new JPanel();
             panel1.setLayout(new GridLayout(2, 1));
             panel1.setBounds(0, 0, 600, 100);
             panel1.setBackground(Color.BLACK);
     
             //Central panel including : menu options
             JPanel panel2 = new JPanel();
             panel2.setLayout(new GridLayout(3, 1, 0, 10));
             panel2.setBounds(0, 100, 600, 500);
             panel2.setBackground(Color.BLACK);
     
             //making up north panel components
             JLabel userLabel = new JLabel();
             JLabel siteImage = new JLabel();
             ImageIcon netflixImage = new ImageIcon("netflix main.jpg");
             siteImage.setIcon(netflixImage);
             if (netflix.getCurrentUser() != null) {
                 userLabel.setText("CURRENT USER: " + netflix.getCurrentUser().getUserName());
             } else {
                 userLabel.setText("CURRENT USER: NULL");
             }
             userLabel.setForeground(Color.RED);
             userLabel.setHorizontalAlignment(JLabel.CENTER);
             siteImage.setHorizontalAlignment(JLabel.CENTER);
             userLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
     
     
             //Making up central panel components
             JButton button1 = new JButton();
             JButton button2 = new JButton();
             JButton button3 = new JButton();
             button1.setText("CREATE AN ACCOUNT");
             button2.setText("LOGIN AS USER");
             button3.setText("EXIT");
             button1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
             button2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
             button3.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
             button1.setBackground(Color.red);
             button2.setBackground(Color.red);
             button3.setBackground(Color.red);
             button1.setFocusable(false);
             button2.setFocusable(false);
             button3.setFocusable(false);
     
             button1.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     //if user clicked CREATE AN ACCOUNT button then :
                     if (e.getSource() == button1) {
                         frame.dispose();
                         new CreatingAccount_Window(netflix);
                     }
                 }
             });
     
             button2.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     //if user clicked LOGIN AS USER button then :
                     if (e.getSource() == button2) {
     
                         frame.dispose();
                         new UserLogin_Prompt(netflix);
                     }
                 }
             });
     
             button3.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     //if user clicked LOGIN AS USER button then :
                     if (e.getSource() == button2) {
     
                         frame.dispose();
                     }
                 }
             });
     
             //adding components to north panel
             panel1.add(siteImage);
             panel1.add(userLabel);
     
             //adding components to central panel
             panel2.add(button1);
             panel2.add(button2);
             panel2.add(button3);
     
             //adding panels to main frame
             this.frame.add(panel1);
             this.frame.add(panel2);
             this.frame.setVisible(true);
         }
     ```

  4. Corresponding to what button the **user** chooses to click, a different action will be happen.

     1. If a user clicks on "**CREATE AN ACCOUNT BUTTON**", The **Main Menu frame** will be disposed of immediately and then a new window pops up called "**CreatingAccount_Window**".

        ```java
        button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //if user clicked CREATE AN ACCOUNT button then :
                        if (e.getSource() == button1) {
                            frame.dispose();
                            new CreatingAccount_Window(netflix);
                        }
                    }
                });
        ```

        - "**CreatingAccount_Window**" Contains two  **JOptionpanes** that prompt the **user** to enter a **username** and **password**.

        - After that system checks whether it's possible to **create an account** for this **username** or not and then shows a message and sends back the **user** to **Main Menu** 

          ```java
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
          ```

     2. If a **user** clicks on the "**LOGIN AS USER**" button, the **Main Menu frame** will be disposed of and a new window will come up called "**UserLogin_Prompt**".

        ```java
        button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //if user clicked LOGIN AS USER button then :
                        if (e.getSource() == button2) {
        
                            frame.dispose();
                            new UserLogin_Prompt(netflix);
                        }
                    }
                });
        ```

        - The "**UserLogin_Prompt**" window contains two **JOptionpanes** that prompt the **user** to enter a **username** and **password**.

        - After that, the system will validate the entered information and if that it's valid lets the **user** enter the **User Page**, otherwise sends a message and returns back the **user** to the **Main Menu**.

          ```java
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
          ```

        3. If a **user** clicks on the "**EXIT**" button program will be terminated

           ```java
           button3.addActionListener(new ActionListener() {
                       @Override
                       public void actionPerformed(ActionEvent e) {
                           //if user clicked LOGIN AS USER button then :
                           if (e.getSource() == button2) {
           
                               frame.dispose();
                           }
                       }
                   });
           ```

           

  5. If everything goes fine and the **user** successfully logged in, a new window named "**UserPage_Window**" pops up.

     ```java
     public class UserPage_Window {
         private NetflixService netflix;
     
         public UserPage_Window(NetflixService netflix) {
             this.netflix = netflix;
     
             JFrame frame = new JFrame();
             //Some implementation of frame
             .......
     
             //North panel including : SITE TITLE & CURRENT USER
             //Some implementation of north panel
             .......
     
             //Central panel including : OPTION MENUS
             //Some implementation of central panel
             .......
     
             //SITE TITLE
             //Some implementation of site title label
             .......
     
             //CURRENT USER
             //Some implementation of current user label
             .......
     
             JButton button1 = new JButton("SEARCH THROUGH ALL OF TV-SHOWS");
             //Some implementation of button1
             .......
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
             //Some implementation of button2
             .......
             button2.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     new SearchThroughFavorites_Window(netflix);
                 }
             });
             JButton button3 = new JButton("RECOMMENDED TV-SHOWS FROM YOUR FAVORITES");
             //Some implementation of button3
             .......
             button3.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     JOptionPane.showMessageDialog(null, "THE RESULTS WILL BE SHOWN IN TERMINAL PLEASE CHECKOUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                     netflix.showList(netflix.getCurrentUser().getRecommendations());
                 }
             });
             JButton button4 = new JButton("ADD TO YOUR FAVORITES");
             //Some implementation of button4
             .......
             button4.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     new AddTVShowToFavorites_Prompt(netflix);
                 }
             });
             JButton button5 = new JButton("ADD TV-SHOW TO ALL THE MOVIES");
             //Some implementation of button5
             .......
             button5.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     new AddTVShowToAll_Prompt(netflix);
                 }
             });
             JButton button6 = new JButton("LIKE OR DISLIKE A TV-SHOW");
             //Some implementation of button6
             .......
             button6.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     new UserOpinion_Window(netflix);
                 }
             });
             JButton button7 = new JButton("SHOW A LIST OF SUBMITTED OPINIONS(LIKE & DISLIKES)");
             //Some implementation of button7
             .......
             button7.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN TERMINAL PLEASE CHECKOUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                     netflix.getCurrentUser().showList(netflix.getCurrentUser().getLikedTvShow());
                 }
             });
             JButton button8 = new JButton("LOGOUT");
             //Some implementation of button8
             .......
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
             //Some implementation of button9
             .......
             button9.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
     
                     frame.dispose();
                     new MainMenu_Window(netflix);
                 }
             });
             //Setting font for buttons
             ......
     
             //Adding labels to panels
             .....
             //Adding buttons to panels
             .....
             frame.add(panel1);
             frame.add(panel2);
             frame.setVisible(true);
         }
     }
     ```

     - This window is designed using two **JPanels**, one on the **north** and a **central** one.

     - The **north** one is explained before.

     - The **central panel** is designed using a Grid Layout of 9 rows and 1 column. it includes 9 **JButtons**.

     

     1. If a **user** clicks on "**SEARCH THROUGH ALL OF TV-SHOWS**", a new window called "**SearchThroughAll_Window**" will be opened.

        ```java
        public class SearchThroughAll_Window {
            private NetflixService netflix;
        
            public SearchThroughAll_Window(NetflixService netflix){
                this.netflix = netflix;
        
                JFrame frame = new JFrame();
                //Some implementation of frame
                .......
        
                //North panel including : SITE TITLE & CURRENT USER
                //Some implementation of north panel
                .......
        
                //Central panel including : OPTION MENUS
                //Some implementation of central panel
                .......
        
                //SITE TITLE
                //Some implementation of site title label
                .......
               
        
                //CURRENT USER
                //Some implementation of current user label
                .......
        
                JButton button1 = new JButton("SEARCH BY TITLE");
                //Some implementation of button1
                .......
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == button1){
        
                           String title = JOptionPane.showInputDialog(null, "ENTER THE TITLE");
                           JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN THE TERMINAL PLEASE CHECK OUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                           netflix.showList(netflix.searchByTitle(title));
                        }
                    }
                });
                JButton button2 = new JButton("SEARCH BY GENRE");
                //Some implementation of button2
                .......
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        String genre = JOptionPane.showInputDialog(null, "ENTER THE GENRE");
                        JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN THE TERMINAL PLEASE CHECK OUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                        netflix.showList(netflix.searchByGenre(genre));
                    }
                });
                JButton button3 = new JButton("SEARCH BY RELEASE YEAR");
                //Some implementation of button3
                .......
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        int releaseYear = Integer.parseInt(JOptionPane.showInputDialog(null, "ENTER THE RELEASE YEAR"));
                        JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN THE TERMINAL PLEASE CHECK OUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                        netflix.showList(netflix.searchByReleaseYear(releaseYear));
                    }
                });
                //Adding labels to panels
              	....
                //Adding buttons to panels
                ....
                //Adding panels to frame
                .....
                frame.setVisible(true);
            }
        }
        ```

        

        - "**SearchThroughAll_Window**" is designed using 2 **JPanels**, a **north panel** and, a **central** one.
        - The **north panel** is explained before.
        - The **central panel** is designed using a Grid Layout of 3 rows and 1 column. it contains 3 **JButtons** for displaying options that the **user** can choose in this segment of the program.
        - Corresponding to what button the **user** chooses to click, a different action will begin to happen; For example, if the user clicks on "**SEARCH BY TITLE**" a **JOptionpane** will pop up and prompt the **user** to enter a **title**, and then searche and shows result in the terminal.
        - *For the two other buttons everything is gonna be the same as the one I have explained above*.

     2. If a **user** clicks on "**SEARCH THROUGH USER FAVORITES TV-SHOWS**", a new window called "**SearchThroughFavorites_Window**" will be opened and everything is gonna be the same as previous the button.

     3. If a **user** clicks on the "**RECOMMENDED TV-SHOWS FROM YOUR FAVORITES**" button, a new **JOptionpane** window will pop and based on how many TV Shows/Movies the **user** has added to his favorites, the system decides to give a recommendation or not (or how many recommendations should give), the system sorts the **TV Shows** and then recommend the **top threes.** 

        ```java
        JButton button3 = new JButton("RECOMMENDED TV-SHOWS FROM YOUR FAVORITES");
                //Some stuff for button
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        JOptionPane.showMessageDialog(null, "THE RESULTS WILL BE SHOWN IN TERMINAL PLEASE CHECKOUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                        netflix.showList(netflix.getCurrentUser().getRecommendations());
                    }
                });
        ```

     4. If a **user** clicks on the "**ADD TO YOUR FAVORITES**" button, a new **JOptionpane window** will pop up and prompt the **user** to enter the title of the **movie** that he wants to add to his favorites, then the system checks and inform the **user** that if he can have this **TV Show** added to his favorites or not.

        ```java
        public class AddTVShowToFavorites_Prompt {
            private NetflixService netflix;
        
            public AddTVShowToFavorites_Prompt(NetflixService netflix) {
                this.netflix = netflix;
        
                String title = JOptionPane.showInputDialog(null, "ENTER TITLE");
        
                if (netflix.doesTVShowExist(title)) {
                    if (!netflix.getCurrentUser().doesTVShowExist(title)) {
                        netflix.getCurrentUser().addToFavorites(NetflixService.getASingleTVShow(title));
                        JOptionPane.showMessageDialog(null, "TV-SHOW HAS BEEN SUCCESSFULLY ADDED TO YOUR FAVORITES", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "USER HAS ALREADY HAVE THIS TV-SHOW IN HIS FAVORITES", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "THIS TV-SHOW DOESN'T EXIST IN SITE", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        ```

     5. If a **user** clicks on the "**ADD TV-SHOW TO ALL THE MOVIES**" button, four **JOptionpanes windows** will come up and prompt the user to enter the **title**, **genre**, **release year** and the **rating** of the **TV Show** that he wants to add, then system checks if this **TV Show** exists or not and then if there isn't any of that, a new other **JOptionpane window** will pop up and prompt the **user** to enter **cast** one by one and enter -1 at the end. after that system checks and informs the **user** if everything went well or not.

        ```java
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
        ```

     6. If a **user** clicks on the "**LIKE OR DISLIKE A TV-SHOW**" button, a completely new **window** will come up.

        This window is made of two **JPanels**, one on the **north** that as we have explained earlier and, the **central** one.

        The **central panel** is designed using a Grid Layout of 2 rows and 1 column, including 2 **JButtons** that are implemented similarly to the previous **JButtons** that we have explained earlier.

        ```java
        public class UserOpinion_Window {
            private NetflixService netflix;
        
            public UserOpinion_Window(NetflixService netflix) {
                this.netflix = netflix;
        
                JFrame frame = new JFrame();
                //Some stuff for frame
                .....
        
                //North panel including : SITE TITLE & CURRENT USER
                JPanel panel1 = new JPanel();
                //Some stuff for panel
        
                //Central panel including : OPTION MENUS
                JPanel panel2 = new JPanel();
                //Some stuff for panel
                ......
        
                //SITE TITLE
                JLabel label1 = new JLabel();
                //Some stuff for site title
                .....
        
                //CURRENT USER
                JLabel label2 = new JLabel();
                //Some stuff for current user label
                .....
        
                JButton button1 = new JButton("LIKE A TV-SHOW");
                //Some implementation of button1
                .......
        
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == button1) {
        
                            String title = JOptionPane.showInputDialog(null, "ENTER THE TITLE");
                            if (netflix.doesTVShowExist(title)) {
                                netflix.getCurrentUser().likeTvShow(NetflixService.getASingleTVShow(title));
                                JOptionPane.showMessageDialog(null, "TV-SHOW HAS BEEN SUCCESSFULLY LIKED", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "THIS TV-SHOW DOESN'T EXIST", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                });
                JButton button2 = new JButton("DISLIKE A TV-SHOW");
                //Some implementation of button2
                .......
        
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        String title = JOptionPane.showInputDialog(null, "ENTER THE TITLE");
                        if (netflix.doesTVShowExist(title)) {
                            netflix.getCurrentUser().dislikeTvShow(NetflixService.getASingleTVShow(title));
                            JOptionPane.showMessageDialog(null, "TV-SHOW HAS BEEN SUCCESSFULLY DISLIKED", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "THIS TV-SHOW DOESN'T EXIST", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                //Adding Labels to panels
                //Adding Buttons to panels
                //Adding panels to frames
                frame.setVisible(true);
            }
        }
        ```

        - Based on what button the **user** chooses to click, a different process will happen:

          1. If a **user** clicks on the "**LIKE A TV-SHOW**" button a **JOptionpane window** will pop up and prompt the **user** to enter the **title** of the **TV Show** that he wants to **like**. After that system checks if it's possible to **like** this **TV Show** or not and then sends proper messages to inform the user.

             ```java
             button1.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             if (e.getSource() == button1) {
             
                                 String title = JOptionPane.showInputDialog(null, "ENTER THE TITLE");
                                 if (netflix.doesTVShowExist(title)) {
                                     netflix.getCurrentUser().likeTvShow(NetflixService.getASingleTVShow(title));
                                     JOptionPane.showMessageDialog(null, "TV-SHOW HAS BEEN SUCCESSFULLY LIKED", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                                 } else {
                                     JOptionPane.showMessageDialog(null, "THIS TV-SHOW DOESN'T EXIST", "NETFLIX ADMIN", JOptionPane.ERROR_MESSAGE);
                                 }
                             }
                         }
                     });
             ```

          2. If a **user** clicks on the "**DISLIKE A TV-SHOW**" button a **JOption window** will pop up and prompt the **user** to enter the **title** of the **TV Show** and everything is gonna be similar to the previous button.
          
             ```java
             JButton button7 = new JButton("SHOW A LIST OF SUBMITTED OPINIONS(LIKE & DISLIKES)");
                     //Some imeplementation of button 7
                     button7.addActionListener(new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
             
                             JOptionPane.showMessageDialog(null, "RESULTS WILL BE SHOWN IN TERMINAL PLEASE CHECKOUT THERE", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                             netflix.getCurrentUser().showList(netflix.getCurrentUser().getLikedTvShow());
                         }
                     });
             ```
          
             

        
  
     7. If a **user** clicks on the "**LOGOUT**" button, the **current user** of **Netflix** will be set to **null** and then the **User Page window** will be disposed immediately and the **user** will be sent back to the **Main Menu window**.
  
        ```java
        JButton button8 = new JButton("LOGOUT");
                //Some implementation of button 8
                button8.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        JOptionPane.showMessageDialog(null, "YOU HAVE BEEN SUCCESSFULLY LOGGED OUT", "NETFLIX ADMIN", JOptionPane.INFORMATION_MESSAGE);
                        netflix.logout();
                        frame.dispose();
                        new MainMenu_Window(netflix);
                    }
                });
        public void logout() {
                System.out.println("User " + this.currentUser.getUserName() + " Successfully Logged Out!");
                this.currentUser = null;
            }
        ```
  
     8. If a user clicks on "BACK TO MAIN MENU" button, User Page window will disposed immediately and the Main Menu window will be opened.
  
        ```java
        Button button9 = new JButton("BACK TO MAIN MENU");
                button9.setFocusable(false);
                button9.setBackground(Color.RED);
                button9.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
        
                        frame.dispose();
                        new MainMenu_Window(netflix);
                    }
                });
        ```





## Testing and evaluation:

- #### A few tests to make sure the solution works well:

  1. In the first test case we want to make sure everything works perfectly with the buttons: "**CREATE AN ACCOUNT**" & "**SEARCH THROUGH ALL OF TV-SHOWS**" & "**SEARCH THROUGH ALL OF FAVORITES**".

     - first, run the Main class to see how what the **Main Menu window** looks like:

       <img src="https://s2.uupload.ir/files/1_wmu6.png" style="zoom:67%;" />

       - Then we click on the "**CREATE AN ACCOUNT**" button. a new window pops up and asks for a **username**, I will just pass my **Mentor's name**.

         <img src="https://s2.uupload.ir/files/2_y8ec.png" style="zoom:67%;" />

       - Then we click "**OK**", and a new window pops up again, asking for a **password**. I will pass "**1381**".

         <img src="https://s2.uupload.ir/files/3_b1c7.png" style="zoom:67%;" />

       - Then we click "**OK**", and the system sends a message saying that everything worked fine and we can **create a new account** for my mentor.

         <img src="https://s2.uupload.ir/files/4_voit.png" style="zoom:67%;" />

       - Now let's try to **create an account** with this **username** again, and see what happens. I will just do the exact same what we did above and see what happens.

         <img src="https://s2.uupload.ir/files/forgotten_after_4_kq8c.png" style="zoom:67%;" />

       - As you can see a window comes up and says that we cannot do this.

       - Now lets login to my **mentor's account** and do some tests. We click on "**LOGIN AS USER**".

         <img src="https://s2.uupload.ir/files/5_4l8p.png" style="zoom:67%;" />

       - As you can see we can also pass **username** in lowercase, uppercase, and ..., it doesn't really matter.

         <img src="https://s2.uupload.ir/files/6_88jv.png" style="zoom:67%;" />

       - But for the **password**, we are forced to enter the exact same thing that we have typed while "**CREATING ACCOUNT**".

         <img src="https://s2.uupload.ir/files/7_8g05.png" style="zoom:67%;" />

       - Then we click "**OK**" and will see a page comeing up showing our **username**  at the top and options down of it.

         <img src="https://s2.uupload.ir/files/8_fv39.png" style="zoom:67%;" />

         - Click on "**SEARCH THOROUGH ALL OF TV-SHOWS**".

           <img src="https://s2.uupload.ir/files/9_xqxb.png" style="zoom:50%;" />

         - Choose "**SEARCH BY TITLE**".

           <img src="https://s2.uupload.ir/files/10_i1jb.png" style="zoom:67%;" />

         - Enter title of **TV-Show / Movie.**

           <img src="https://s2.uupload.ir/files/11_043.png" style="zoom:67%;" />

         - Checking out the terminal, and see a result has been shown.

           ![](https://s2.uupload.ir/files/12_vy6j.png)

         - Lets get back to **user page** and add this **TV-Show to favorites**.

         - Click on "**ADD TO YOUR FAVORITES**".

           <img src="https://s2.uupload.ir/files/13_yit4.png" style="zoom: 67%;" />

         - Enter the **title**.

           <img src="https://s2.uupload.ir/files/11_043.png" style="zoom:67%;" />

         - Check out the terminal and see the result.

           ![](https://s2.uupload.ir/files/14_wo1e.png)

         - Now, lets search through favorite **movies** and see if can find the **movie** we have just add to favorites.

         - Click on "**SEARCH THROUGH FAVORITE TV-SHOWS**".

           <img src="https://s2.uupload.ir/files/9_xqxb.png" style="zoom:67%;" />

         - Choose "**SEARCH BY TITLE"**.

           <img src="https://s2.uupload.ir/files/10_i1jb.png" style="zoom:67%;" />

         - Click on "**OK**", and check out the terminal.

           <img src="https://s2.uupload.ir/files/11_043.png" style="zoom:67%;" />

           <img src="https://s2.uupload.ir/files/12_vy6j.png" style="zoom:80%;" />

         - Now lets choose "**ADD TV-SHOW TO ALL THE MOVIES**" and then add it to favorites and then choose "**RECOMMENDED TV-SHOWS FROM YOUR FAVORITES**" and see what happens. we click on it.

         - Enter **title**.

           <img src="https://s2.uupload.ir/files/20_ecla.png" style="zoom:67%;" />

         - Enter **genre**.

           <img src="https://s2.uupload.ir/files/21_c7dv.png" style="zoom:67%;" />

         - Enter **release year**.

           <img src="https://s2.uupload.ir/files/22_h9ge.png" style="zoom:67%;" />

         - Enter **rating**.

           <img src="https://s2.uupload.ir/files/23_ilny.png" style="zoom:67%;" />

         <img src="https://s2.uupload.ir/files/24_oqtm.png" style="zoom:67%;" />

         - Enter **cast** one by one and enter -1.

           <img src="https://s2.uupload.ir/files/25_3g6o.png" style="zoom:67%;" />

           <img src="https://s2.uupload.ir/files/26_q8tm.png" style="zoom:67%;" />

           

         

         - Add **TV Show** to your favorites and then click on "**RECOMMENDED TV-SHOWS FROM YOUR FAVORITES**".(I will prevent reputation and not will show how to add a **TV Show** to favorites again.)

         - This time when we check the terminal for the result we see that movie we have just added is there too, and it's different from the last one we had in our favorites, it's a TV Show while the last one was a **movie**.

           <img src="https://s2.uupload.ir/files/screenshot_2023-03-16_074834_rw1u.png" style="zoom:80%;" />

         - Now lets **like** one of these **TV Shows** and finish our work.

         - Click on "**LIKE & DISLIKE A TV-SHOW**".

           <img src="https://s2.uupload.ir/files/30_n893.png" style="zoom:67%;" />

         - Click on Like a **TV SHOW**.

           <img src="https://s2.uupload.ir/files/10_p1n5.png" style="zoom:67%;" />

           

         <img src="https://s2.uupload.ir/files/32_74od.png" style="zoom:67%;" />

         - We see that everything works great. Thanks to my mentor "**Mobin Nesar**i" for his advices and helps.

         

         



