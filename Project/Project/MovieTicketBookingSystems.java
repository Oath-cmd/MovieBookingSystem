package Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MovieTicketBookingSystems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<action> actionMovies = new ArrayList<>();
        actionMovies.add(new action("John Wick 4", 150));
        actionMovies.add(new action("The Dark Knight", 120));
        actionMovies.add(new action("The Matrix", 90));
        ArrayList<crime> crimeMovies = new ArrayList<>();
        crimeMovies.add(new crime("Catch me if u can", 155));
        crimeMovies.add(new crime("The Fast and The Furious", 150));
        crimeMovies.add(new crime("The Godfather", 125));
        ArrayList<comedy> comedyMovies = new ArrayList<>();
        comedyMovies.add(new comedy("The Hangover", 85));
        comedyMovies.add(new comedy("Airplane!", 90));
        comedyMovies.add(new comedy("Groundhog day", 75));
        ArrayList<drama> dramaMovies = new ArrayList<>();
        dramaMovies.add(new drama("Happening", 140));
        dramaMovies.add(new drama("TILL", 120));
        dramaMovies.add(new drama("AFTERSUN", 105));
        
        int choice;
do {
    System.out.println("=======================================");
    System.out.println("Welcome to Movie Ticket Booking System");
    System.out.println("=======================================");
    System.out.println("1. Action");
    System.out.println("2. Crime");
    System.out.println("3. Comedy");
    System.out.println("4. Drama");
    System.out.println("5. Exit");
    System.out.println("=======================================");
    System.out.print("Enter your choice (1-5): ");
    while (!sc.hasNextInt()) {
        System.out.println("Invalid input. Please enter a valid integer.");
        System.out.print("Enter your choice again: ");
        sc.next();
    }
    choice = sc.nextInt();
    if (choice >= 1 && choice <= 4) {
        System.out.println("=======================================");
        System.out.println("          Movies available");
        System.out.println("=======================================");
        ArrayList<? extends Movie> movies = null;
        switch (choice) {
            case 1:
                movies = actionMovies;
                break;
            case 2:
                movies = crimeMovies;
                break;
            case 3:
                movies = comedyMovies;
                break;
            case 4:
                movies = dramaMovies;
                break;
            default :
                System.out.print("Invalid input. Please enter a valid integer: ");
                break;
        }
        
        if (movies != null) {
    for (int i = 0; i < movies.size(); i++) {
        Movie movie = movies.get(i);
        System.out.println((i+1) + ". " + movie.getName() + " - " + movie.getPrice()+"Baht");
        
    }   System.out.println("=======================================");

    int movieNumber;
    
do {
    try {
        System.out.print("Enter the number of the movie you want to watch: ");
        movieNumber = sc.nextInt();
        if (movieNumber < 1 || movieNumber > movies.size()) {
            System.out.println("Invalid input. Please enter a number.");
        }
    
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid integer.");
        sc.next(); // clear scanner buffer
        movieNumber = -1; // set movieNumber to an invalid value to loop again
    }

} while (movieNumber < 1 || movieNumber > movies.size());

    Movie selectedMovie = movies.get(movieNumber-1);
    System.out.println("You have selected " + selectedMovie.getName() + " movie.");
    System.out.print("Enter the number of seats you want to buy: ");
    int numSeats = sc.nextInt();
    double totalCost = selectedMovie.calculateTicketCost(numSeats);
    double moviePrice = selectedMovie.getPrice();

    if (numSeats >= 3) {
        System.out.println("Discount for family 20%");
        totalCost = 0.8*(moviePrice*numSeats);
    }else {
        totalCost = moviePrice*numSeats;
    }
    
    System.out.println("=======================================");
    System.out.println("Total cost for " + numSeats + " seats: " + totalCost);
    
} else {
    System.out.println("No movies available.");
}
    } else if (choice == 5) {
        System.out.println("Thank you for using our system!");
    } else {
        System.out.println("Invalid choice. Please enter a value between 1 and 5.");
    }
    } while (choice != 5);
  }
}