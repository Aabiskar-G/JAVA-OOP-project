package library;

import java.time.LocalDate;

/**
 * Represents a publication (book) in the library's collection.
 * This class is part of the "library" package.
 */
public class Publication {
    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo; // Change from String to Patron
    private LocalDate dueDate;

    /**
     * Constructs a new Publication object with the given title, author, and copyright year.
     *
     * @param title     The title of the publication.
     * @param author    The author of the publication.
     * @param copyright The copyright year of the publication.
     * @throws IllegalArgumentException if the provided copyright year is invalid.
     */
    public Publication(String title, String author, int copyright) {
        // Data validation for copyright year
        if (copyright < 1900 || copyright > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid copyright year");
        }

        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    /**
     * Checks out the publication to a patron and sets the due date.
     *
     * @param patron The patron who is checking out the publication.
     */
    public void checkout(Patron patron) { // Update to accept Patron as a parameter
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(14);
    }

    /**
     * Generates a string representation of the publication.
     *
     * @return A string containing information about the publication, including title, author, copyright,
     *         and loaned status (if checked out).
     */
    @Override
    public String toString() {
        String publicationInfo = "\"" + title + "\" by " + author + ", copyright " + copyright;
        if (loanedTo != null) {
            publicationInfo += "\n--> loaned to " + loanedTo.getName() + " until " + dueDate;
        }
        return publicationInfo;
    }
}

