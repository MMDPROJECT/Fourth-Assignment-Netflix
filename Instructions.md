# Fourth-Assignment-Netflix


## Introduction
In this assignment, you will create a simulation of Netflix. The program should allow users to create and manage their accounts and profiles, browse movies, and manage their movies. The program should be designed using object-oriented programming principles.

## Objectives
- Review the concepts of object-oriented programming (OOP) and utilize them correctly
- Familiarize yourself with the concept of Encapsulation
- Learn the difference between Static and Instance variables
- Learn about polymorphism
- Get familiar with Interfaces in java
- Get familiar with UML diagrams
- Use Git for version control and collaborate on a codebase
- Write a report on the assignment

## Tasks
1. Fork this repository and clone the fork to your local machine. Ensure to create a new Git branch before starting your work
2. Complete the following classes by adding the required parameters and implementing the predefined functions: `Movie`, `User`, `TVShow`, `NetflixService`.
3. In the `runMenu()` function of the `Main` class, Implement an interactive menu in the command line that allows users to use the functionalities of the program. 
4. Your menu should allow new Users to create an account by providing a username and a password. Prevent new users from choosing a previously taken username. Authenticate each user before logging in
5. Your program should keep a list of all users (and their favorite or previously seen movies), and all movies.
6. You should use inheritance efficiently for the `Movie` class (Read the comments). It has an attribute more than the `TVShow` class (`length`) which is the length of the movie.
7. Implement the predefined methods in the `NetflixService` class, based on the explanations below:
    - `createAccount`: Creates an account for a user with the provided username and password. A unique password should be provided.
    - `login`: Performs any needed operations of the login process, if there exists any user with such username and password.
    - `logout`: Performs any needed operations of the logout process (exiting from the account), if a user is logged in to their account.
    - `searchByTitle`: Searches among all the movies by the provided title. Returns an arraylist of the found movies.
    - `searchByGenre`: Searches among all the movies by the provided genre. Returns an arraylist of the found movies.
    - `searchByReleaseYear`: Searches among all the movies by the provided release year. Returns an arraylist of the found movies.
8. Implement the predefined methods in the `User` class, based on the explanations below:
    - `searchByTitle`: Searches among the user's favorite or previously seen movies, by the provided title. Returns an arraylist of the found movies.
    - `searchByGenre`: Searches among the user's favorite or previously seen movies, by the provided genre. Returns an arraylist of the found movies.
    - `searchByReleaseYear`: Searches among the user's favorite or previously seen movies, by the provided release year. Returns an arraylist of the found movies.
    - `addToFavorites`: Adds the provided TV show to the list of the favorite movies of the user.
    - `viewFavorites`: Shows the list of the favorite movies of the user.
    - `getRecommendations`: Gives the list of the user's recommended movies. Returns this list as an arraylist.
9. Commit your changes, push your commits to your own fork on Github, and create a pull request to merge your changes to the `main` branch of your own fork on Github.
10. Write a report. Your report should contain a UML diagram for each class.

## Notes
- The code provided in this repository gives you a template to work with and build your project. You are allowed to:
    - Add new functions and classes to your code wherever you see fit.
    - Change and swap the predefined functions as you wish, as long as the program satisfies all the requirements.
    
- Your report should focus on the structure you choose for each different class, as well as the OOP principles you follow while designing your project. Describe the design of your program, including the classes, objects, methods, and attributes.

- If you implement any bonus features, be sure to include additional details about them in your report. 

## Evaluation
- Your code should compile and run without any errors
- Your code should be well-organized, readable, properly commented, and follows clean code principles
- Your code should follow OOP principles and correctly use Java access modifiers
- OOP concepts like polymorphism and encapsulation should be efficiently used in your code.
- You should use Git for version control and include meaningful commit messages (The `main` branch will be used for evaluation)

**Attention: Using ChatGPT or any other AI generative model for any section of the assignment will result in a score of 0 without any warnings.**

## Bonus Objectives
1. Perform Input Validation: Ensure the data or information entered by a user or system is correct, complete, and appropriate for the intended use.

2. Extend the available classes to create a more secure login system. Use a hashing algorithm to hash the user's password. Give a brief explanation of the hashing process in your report.

3. Implement any other feature of the Netflix application. For instance, develop the ability for users to like or dislike movies. A user can like or dislike a movie one time. Make sure to include details about these additional features in your report.

4. Use a database in your program; You can choose between NoSQL databases like MongoDB and SQL databases like MySQL, PostgreSQL, etc. Get familiar with java database connectivity (JDBC).

5. Add a simple GUI (Graphical User Interface) to your project. It's recommended to use JavaFX. This GUI should include all of the options offered by the command line menu you implemented earlier. Displaying pictures or icons is optional.

## Submission
- Push your code to your fork on GitHub
- Upload your report to your fork on GitHub
- Create a pull request on the default branch of you own fork of the assignment on GitHub

The deadline for submitting your code is Wednesday, March 15 (24th of Esfand). Any commit made after this date will not affect your score.

Good luck and happy coding!
