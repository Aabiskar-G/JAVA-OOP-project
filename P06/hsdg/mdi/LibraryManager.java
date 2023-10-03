package mdi;

import library.Library;
import library.Publication;
import library.Video;
import library.InvalidRuntimeException;
import library.Patron;

import java.util.Scanner;

public class LibraryManager {
    private static Library library;
    private static Scanner scanner;

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
                    checkoutItem();
                    break;
                case 4:
                    checkinItem();
                    break;
                case 5:
                    listPatrons();
                    break;
                case 6:
                    addPatron();
                    break;
                case 7:
                    loadData();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void populateInitialLibrary() {
        // Implement code to populate the library with initial data.
        // For example:
        Publication book1 = new Publication("Book 1", "Author 1");
        library.addPublication(book1);

        Video video1 = new Video("Video 1", "Director 1");
        library.addVideo(video1);

        // Add more publications, videos, and patrons as needed.
    }

    private static void displayMenu() {
        System.out.println("Library Management System");
        System.out.println("1. List Publications and Videos");
        System.out.println("2. Add Publication or Video");
        System.out.println("3. Checkout Item");
        System.out.println("4. Checkin Item");
        System.out.println("5. List Patrons");
        System.out.println("6. Add Patron");
        System.out.println("7. Load Data from File");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void listPublicationsAndVideos() {
        System.out.println("List of Publications:");
        for (Publication publication : library.getPublications()) {
            System.out.println(publication.getTitle() + " by " + publication.getAuthor());
        }

        System.out.println("\nList of Videos:");
        for (Video video : library.getVideos()) {
            System.out.println(video.getTitle() + " by " + video.getDirector());
        }
    }

    private static void addPublicationOrVideo() {
        System.out.print("Enter the type (1 for Publication, 2 for Video): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the title: ");
        String title = scanner.nextLine();

        System.out.print("Enter the creator: ");
        String creator = scanner.nextLine();

        if (type == 1) {
            Publication publication = new Publication(title, creator);
            library.addPublication(publication);
        } else if (type == 2) {
            Video video = new Video(title, creator);
            library.addVideo(video);
        } else {
            System.out.println("Invalid type!");
        }
    }

    private static void checkoutItem() {
        System.out.print("Enter the index of the item to checkout: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Patron name: ");
        String patronName = scanner.nextLine();

        try {
            library.checkout(index, patronName);
            System.out.println("Item checked out successfully!");
        } catch (InvalidRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkinItem() {
        System.out.print("Enter the index of the item to checkin: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        library.checkin(index);
        System.out.println("Item checked in successfully!");
    }

    private static void listPatrons() {
        System.out.println("List of Patrons:");
        for (Patron patron : library.getPatrons()) {
            System.out.println(patron.getName());
        }
    }

    private static void addPatron() {
        System.out.print("Enter Patron name: ");
        String patronName = scanner.nextLine();

        try {
            Patron patron = new Patron(patronName);
            library.addPatron(patron);
            System.out.println("Patron added!");
        } catch (InvalidRuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void loadData() {
        System.out.print("Enter the file path to load data from: ");
        String filePath = scanner.nextLine();

        // Implement code to read data from the specified file and populate the library.
        // You might use libraries like Jackson for JSON or JAXB for XML if needed.

        System.out.println("Data loaded successfully!");
    }
}

