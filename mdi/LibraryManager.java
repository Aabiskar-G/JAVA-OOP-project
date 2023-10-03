package mdi;

import library.Library;
import library.Patron;
import library.Publication;
import library.Video;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

class LibraryManager {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("Missing filename argument for publications / patrons");
            }

            Scanner scanner = new Scanner(System.in);
            String fileName = args[0];

            // Load the library from a file
            Library library = loadLibraryFromFile(fileName);

            while (true) {
                System.out.println("\nLibrary Management System");
                System.out.println("1. List all Publications and Videos");
                System.out.println("2. Add a new Publication");
                System.out.println("3. Add a new Video");
                System.out.println("4. Check out a Publication or Video");
                System.out.println("5. Check in a Publication or Video");
                System.out.println("6. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println(library);
                        break;
                    case 2:
                        addPublication(library, scanner);
                        break;
                    case 3:
                        addVideo(library, scanner);
                        break;
                    case 4:
                        checkOutPublication(library, scanner);
                        break;
                    case 5:
                        // Implement check-in logic if needed
                        System.out.println("Check-in feature is not implemented.");
                        break;
                    case 6:
                        // Exit the program
                        System.out.println("Exiting Library Management System.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        }
    }

    private static Library loadLibraryFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String name = br.readLine();
            Library library = new Library(name);

            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                if (line.equals("Publication")) {
                    library.addPublication(new Publication(br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
                } else if (line.equals("Video")) {
                    library.addPublication(new Video(br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine())));
                } else {
                    throw new IOException("Unable to load " + fileName);
                }
            }

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    break;
                }
                library.addPatron(new Patron(line, br.readLine()));
            }

            return library;
        }
    }

    private static void addPublication(Library library, Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Publication Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();

        Publication publication = new Publication(title, author, year);
        library.addPublication(publication);
        System.out.println("Publication added to the library.");
    }

    private static void addVideo(Library library, Scanner scanner) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Video Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Director: ");
        String director = scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        System.out.print("Enter Runtime (minutes): ");
        int runtime = scanner.nextInt();

        Video video = new Video(title, director, year, runtime);
        library.addPublication(video);
        System.out.println("Video added to the library.");
    }

    private static void checkOutPublication(Library library, Scanner scanner) {
        System.out.println(library);
        int selection;
        do {
            System.out.print("\nSelect a publication to check out (enter index): ");
            selection = scanner.nextInt();
        } while (selection < 0 || selection >= library.getPublications().size());

        System.out.println(library.patronMenu());
        int patron;
        do {
            System.out.print("\nSelect a patron (enter index): ");
            patron = scanner.nextInt();
        } while (patron < 0 || patron >= library.getPatrons().size());

        library.checkOut(selection, patron);
        System.out.println("Publication checked out successfully.");
    }
}

