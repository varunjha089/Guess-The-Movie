package com.varuncertificate.guessTheMovie;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{

        int numOfMovies = 0;
        ArrayList movies = new ArrayList();


        /*
         * will check for any kind of file related exception in this program
         */

        try {
            File file = new File("movie.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine() == true) {
                String movie = fileScanner.nextLine();
                movies.add(movie);

                //counting for no of movies by counting the itteration made by while loop
                numOfMovies++;
            }
        }catch (FileNotFoundException exception){
            System.out.println("File is not available at desired location");
        }


        /*
         *  getting a random movie from the list to guess
         */

        int randomNumber = (int) (Math.random()*numOfMovies);

        // this is getting the movie name for the randomely selected movie no
        String randomMovie = (String) movies.get(randomNumber);
        System.out.println(randomMovie);





        /*
         *printing the instruction to the user
         */
        System.out.println("Welcome to Guess the Movie!");
        System.out.println("Your goal is to figure out the movie by guessing one letter at a time.");
        System.out.println("Enter your response in lower case");
        System.out.println();


        /*
         * itterating for 10 times
         */

        for (int _10times =1; _10times<=10; _10times++){

            // scanning the user input
            Scanner userInput = new Scanner(System.in);
            String guess = userInput.next();

            //extracting the first character of the movie chossen
            char movieChar = randomMovie.charAt(0);

            //converting the character to string for comparision
            String movieString = String.valueOf(movieChar);

            //comparing the both result
            boolean resultCheck = new String(guess).equals(movieString);

            // checking the status of the game
            if(resultCheck){
                System.out.println("You Won!");
                break;
            }else {
                System.out.println("You lost! the correct movie is \"" + randomMovie + "\"");
            }

            //printing the no of attempts left
            System.out.println("You have used " + _10times + " attempt");
        }

    }
}
