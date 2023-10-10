package mdi;

import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 * The LibraryManager class represents a simple library management system.
 * It allows users to interact with the library by listing items, adding publications or videos,
 * checking out items, and checking in items.
 *@author Aabiskar-G
 *@version 1.0
 */
public class LibraryManager {
    private static Library library;
    private static Scanner scanner;

    /**
     * The main method initializes the library, populates it with initial items,
     * and provides a menu for user interaction.
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        library = new Library("The Library at Kathmandu");
        scanner = new Scanner(System.in);

        populateInitialLibrary();

        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    listPublicationsAndVideos();
                    break;
                case 2:
                    addPublicationOrVideo();
                    break;
                case 3:
                    checkoutItem(library, scanner);
                    break;
                case 4:
                    checkinItem();
                    break;
                case 5:
                    openLibrary();
                    break;
                case 6:
                    saveLibrary();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("==========");
        System.out.println("Main Menu");
        System.out.println("==========\n");
        System.out.println("Welcome to The Library at Kathmandu\n");
        System.out.println("0) Exit");
        System.out.println("1) List");
        System.out.println("2) Add Publication or Video");
        System.out.println("3) Check out");
        System.out.println("4) Check in");
        System.out.println("5) open");
        System.out.println("6) save\n");
        System.out.print("Selection: ");
    }

    /**
     * Populates the initial library with some example publications and videos.
     */
    private static void populateInitialLibrary() {
        // Add 3 books to the library
        library.addPublication(new Publication("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addPublication(new Publication("1984", "George Orwell", 1949));
        library.addPublication(new Publication("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));
        
         // Add 3 videos to the library
        library.addPublication(new Video("The Matrix", "Wachowskis", 1999, 136));
        library.addPublication(new Video("Inception", "Christopher Nolan", 2010, 148));
        library.addPublication(new Video("Avatar", "James Cameron", 2009, 162));

    }

    /**
     * Lists the publications and videos in the library.
     */
    private static void listPublicationsAndVideos() {
        System.out.println("Library Contents:");
        System.out.println(library);
    }

    /**
     * Prompts the user to choose between adding a publication or a video.
     */
    private static void addPublicationOrVideo() {
        System.out.print("Enter 1 to add a Publication or 2 to add a Video: ");
        int publicationType = scanner.nextInt();
        scanner.nextLine();

        switch (publicationType) {
            case 1:
                addPublication();
                break;
            case 2:
                addVideo();
                break;
            default:
                System.out.println("Invalid choice! Please enter 1 for Publication or 2 for Video.");
        }
    }

    /**
     * Adds a publication to the library based on user input.
     */
    private static void addPublication() {
        System.out.println("Enter publication title:");
        String title = scanner.nextLine();

        System.out.println("Enter author:");
        String author = scanner.nextLine();

        System.out.println("Enter copyright year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        Publication pub = new Publication(title, author, year);
        library.addPublication(pub);
        System.out.println("Publication added!");
    }

    /**
     * Adds a video to the library based on user input.
     */
    private static void addVideo() {
        System.out.println("Enter video title:");
        String title = scanner.nextLine();

        System.out.println("Enter director:");
        String director = scanner.nextLine();

        System.out.println("Enter release year:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter runtime in minutes:");
        int minutes = scanner.nextInt();
        scanner.nextLine();

        try {
            Video vid = new Video(title, director, year, minutes);
            library.addPublication(vid);
            System.out.println("Video added!");
        } catch (InvalidRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Checks out an item from the library based on user input.
     */
    private static void checkoutItem(Library library, Scanner scanner) {
        listPublicationsAndVideos();
        System.out.print("Enter the index of the item to check out: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter patron name: ");
            String patronName = scanner.nextLine();
            library.checkOut(index, patronName);
            System.out.println("Item checked out!");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid index. No item checked out.");
        } catch (Exception e) {
            System.err.println("Invalid input.");
        }
    }

    /**
     * Checks in an item to the library based on user input.
     */
    private static void checkinItem() {
        listPublicationsAndVideos();
        System.out.print("Enter the index of the item to check in: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();
            library.checkIn(index);
            System.out.println("Item checked in!");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Invalid index. No item checked in.");
        } catch (Exception e) {
            System.err.println("Invalid input.");
        }
    }
    
    
	private static void openLibrary() 
	{
	    System.out.print("Enter the filename to open: ");
	    String filename = scanner.nextLine();
	    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
		library.load(reader); 
		System.out.println("Library opened!! " + filename);
	    } catch (NumberFormatException e) {
		System.err.println("Error: Issue with the content format in the file. Details: " + e.getMessage());
	    } catch (IOException e) {
		System.err.println("Error: Unable to open the library from the file. Details: " + e.getMessage());
	    }
	}



    private static void saveLibrary() {
        System.out.print("Enter the filename to save: ");
        String filename = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            library.save(writer);
            System.out.println("Library saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error: Unable to save the library to the file.");
        }
    }
}
