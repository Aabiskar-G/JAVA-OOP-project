import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library("Stockholm Public Library");

        // Add 3 books to the library
        library.addPublication(new Publication("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addPublication(new Publication("1984", "George Orwell", 1949));
        library.addPublication(new Publication("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));

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
            System.out.println("Index Error");
            System.out.println(library);
        }
        scanner.close();
    }
}

