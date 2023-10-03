package mdi;

import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;

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
        library = new Library("The Library at Alexandria (Texas)");
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
        System.out.println("Welcome to The Library at Alexandria (Texas)\n");
        System.out.println("0) Exit");
        System.out.println("1) List");
        System.out.println("2) Add Publication or Video");
        System.out.println("3) Check out");
        System.out.println("4) Check in\n");
        System.out.print("Selection: ");
    }

    /**
     * Populates the initial library with some example publications and videos.
     */
    private static void populateInitialLibrary() {
        library.addPublication(new Publication("The Cat in the Hat", "Dr. Seuss", 1957));
        library.addPublication(new Publication("The Firm", "John Grisham", 1992));
        library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
        library.addPublication(new Video("Citizen Kane", "Orson Welles", 1941, 119));
        library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121));
        library.addPublication(new Video("七人の侍 (Seven Samurai)", "Akira Kurosawa", 1954, 207));
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
            System.out.println("Invalid index. No item checked out.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
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
            System.out.println("Invalid index. No item checked in.");
        } catch (Exception e) {
            System.out.println("Invalid input.");
        }
    }
}

