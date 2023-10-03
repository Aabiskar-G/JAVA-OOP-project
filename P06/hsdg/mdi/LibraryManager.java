import library.Library;
import library.Patron;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LibraryManager {
    private Library library;
    private static Scanner sc = new Scanner(System.in);

    public LibraryManager(String libraryName) {
        this.library = new Library(libraryName);
    }

    public void displayMenu() {
        System.out.println("Main Menu");
        System.out.println("The " + library.getName() + " (Texas)");
        System.out.println("Publications");
        System.out.println("1) List");
        System.out.println("2) Add");
        System.out.println("3) Check out");
        System.out.println("4) Check in");
        System.out.println("Patrons");
        System.out.println("5) List");
        System.out.println("6) Add");
        System.out.println("Files");
        System.out.println("7) Load file");
        System.out.println("0) Exit");
    }

    public void listPublicationsAndVideos() {
        System.out.println(library);
    }

    public void addPublication(String title, String author, int copyright) {
        Publication publication = new Publication(title, author, copyright);
        library.addPublication(publication);
    }

    public void addVideo(String title, String author, int copyright, int runtime) {
        Video video = new Video(title, author, copyright, runtime);
        library.addPublication(video);
    }

    public void checkOutPublicationOrVideo() {
        System.out.println(library);
        int selection = getIntInput("Which item to check out? ");
        System.out.println(library.patronMenu());
        int patron = getIntInput("Who are you? ");
        library.checkOut(selection, patron);
        System.out.println("Item checked out successfully.");
    }

    public void checkInPublicationOrVideo() {
        System.out.println(library);
        int selection = getIntInput("Which item to check in? ");
        library.checkIn(selection);
        System.out.println("Item checked in successfully.");
    }

    public void listPatrons() {
        System.out.println(library.patronMenu());
    }

    public void addPatron(String name, String email) {
        Patron patron = new Patron(name, email);
        library.addPatron(patron);
    }

    public void loadData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals("Publication")) {
                    String title = br.readLine();
                    String author = br.readLine();
                    int copyright = Integer.parseInt(br.readLine());
                    addPublication(title, author, copyright);
                } else if (line.equals("Video")) {
                    String title = br.readLine();
                    String author = br.readLine();
                    int copyright = Integer.parseInt(br.readLine());
                    int runtime = Integer.parseInt(br.readLine());
                    addVideo(title, author, copyright, runtime);
                } else if (line.equals("Patron")) {
                    String name = br.readLine();
                    String email = br.readLine();
                    addPatron(name, email);
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error reading file " + fileName + " - " + e);
        }
    }

    private int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid integer: ");
            sc.next();
        }
        int input = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        return input;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java LibraryManager <library_file>");
            System.exit(1);
        }

        LibraryManager libraryManager = new LibraryManager("The Library at Alexandria");

        libraryManager.loadData(args[0]);

        boolean exit = false;
        while (!exit) {
            libraryManager.displayMenu();
            int choice = libraryManager.getIntInput("Selection: ");

            switch (choice) {
                case 1:
                    libraryManager.listPublicationsAndVideos();
                    break;
                case 2:
                    String title = sc.nextLine(); // Read title with spaces
                    String author = sc.nextLine(); // Read author with spaces
                    int copyright = libraryManager.getIntInput("Enter copyright year: ");
                    libraryManager.addPublication(title, author, copyright);
                    break;
                case 3:
                    title = sc.nextLine(); // Read title with spaces
                    author = sc.nextLine(); // Read author with spaces
                    copyright = libraryManager.getIntInput("Enter copyright year: ");
                    int runtime = libraryManager.getIntInput("Enter runtime (minutes): ");
                    libraryManager.addVideo(title, author, copyright, runtime);
                    break;
                case 4:
                    libraryManager.checkOutPublicationOrVideo();
                    break;
                case 5:
                    libraryManager.checkInPublicationOrVideo();
                    break;
                case 6:
                    libraryManager.listPatrons();
                    break;
                case 7:
                    String fileName = sc.nextLine();
                    libraryManager.loadData(fileName);
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        System.out.println("Exiting the Library Manager.");
    }
}

