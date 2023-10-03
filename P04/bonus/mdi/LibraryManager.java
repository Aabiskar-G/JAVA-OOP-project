import library.Publication;
import library.Video;
import library.Patron;
import library.Library;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

class InvalidRuntimeException extends ArithmeticException {

    public InvalidRuntimeException(String message) {
        super(message);
    }

    public InvalidRuntimeException(String title, int runtime) {
        this(title + " has invalid runtime " + runtime);
    }
}

public class LibraryManager {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library("Stockholm Public Library");

        // Add 3 books to the library
        library.addPublication(new Publication("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addPublication(new Publication("1984", "George Orwell", 1949));
        library.addPublication(new Publication("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));

        // Add 3 videos to the library
        library.addPublication(new Video("The Matrix", "Wachowskis", 1999, Duration.ofMinutes(136)));
        library.addPublication(new Video("Inception", "Christopher Nolan", 2010, Duration.ofMinutes(148)));
        library.addPublication(new Video("Avatar", "James Cameron", 2009, Duration.ofMinutes(162)));

        // Add at least one Patron to the Library with a name and an ID
        Patron patron1 = new Patron("Avi", 1); // Provide both name and ID
        library.addPatron(patron1);

        // Print the library
        System.out.println(library);

        // Ask the user which book to check out
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the index of the book to check out: ");
            int publicationIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Display the patron menu to select a patron
            System.out.println("Patron Menu:");
            for (int i = 0; i < library.getPatrons().size(); i++) {
                System.out.println(i + ") " + library.getPatrons().get(i));
            }

            System.out.print("Enter the index of the patron checking out the book: ");
            int patronIndex = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // Check out the book and handle exceptions
            library.checkout(publicationIndex, patronIndex);

            // Print the library again
            System.out.println(library);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Index Error");
            System.err.println(library);
        }
        scanner.close();
    }
}

