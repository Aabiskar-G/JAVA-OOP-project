import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        // Create a library
        Library library = new Library("Stockholm Public Library ");

        // Add 3 books to the library
        library.addPublication(new Publication("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addPublication(new Publication("1984", "George Orwell", 1949));
        library.addPublication(new Publication("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));

        // Print the library
        System.out.println(library);

        // Ask the user which book to check out
        Scanner scanner = new Scanner(System.in);
        try{
        	
        	System.out.print("Enter the index of the book to check out: ");
        	int publicationIndex = scanner.nextInt();
        	scanner.nextLine(); // Consume the newline character
        	System.out.print("Enter the name of the patron: ");
        	String patron = scanner.nextLine();
	
        // Check out the book and handle exceptions
       		library.checkout(publicationIndex, patron);

        // Print the library again
        	System.out.println(library);
	} catch (IndexOutOfBoundsException e){
		System.out.println(" Index Error ");
		System.out.println(library);
	
	}
        scanner.close();
    }
}


