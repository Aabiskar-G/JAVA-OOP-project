package library;

import java.util.ArrayList;

/**
 * Represents a library that manages a collection of publications and patrons.
 * This class is part of the "library" package.
 */
public class Library {
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;

    /**
     * Constructs a new Library object with the given name.
     *
     * @param name The name of the library.
     */
    public Library(String name) {
        this.name = name;
        publications = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    /**
     * Adds a publication to the library's collection.
     *
     * @param publication The publication to add.
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    /**
     * Adds a patron to the library's list of patrons.
     *
     * @param patron The patron to add.
     */
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    /**
     * Checks out a publication from the library to a specific patron.
     *
     * @param publicationIndex The index of the publication to check out.
     * @param patronIndex      The index of the patron checking out the publication.
     */
    public void checkout(int publicationIndex, int patronIndex) {
        try {
            Publication publication = publications.get(publicationIndex);

            if (patronIndex >= 0 && patronIndex < patrons.size()) {
                Patron patron = patrons.get(patronIndex);
                publication.checkout(patron);
            } else {
                System.out.println("Invalid patron index. Please choose a valid index.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index. Please choose a valid index.");
        }
    }

    /**
     * Retrieves the list of patrons in the library.
     *
     * @return An ArrayList of Patron objects.
     */
    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    /**
     * Generates a string representation of the library and its publications.
     *
     * @return A string containing information about the library and its publications.
     */
    @Override
    public String toString() {
        StringBuilder libraryInfo = new StringBuilder(name + "\n");
        for (int i = 0; i < publications.size(); i++) {
            libraryInfo.append(i).append(") ").append(publications.get(i)).append("\n");
        }
        return libraryInfo.toString();
    }
}

