import java.time.LocalDate;

class Publication {
    private String title;
    private String author;
    private int copyright;
    private Patron loanedTo; // Change from String to Patron
    private LocalDate dueDate;

    public Publication(String title, String author, int copyright) {
        // Data validation for copyright year
        if (copyright < 1900 || copyright > LocalDate.now().getYear()) {
            throw new IllegalArgumentException("Invalid copyright year");
        }

        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    public void checkout(Patron patron) { // Update to accept Patron as a parameter
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(14);
    }

    @Override
    public String toString() {
        String publicationInfo = "\"" + title + "\" by " + author + ", copyright " + copyright;
        if (loanedTo != null) {
            publicationInfo += "\n--> loaned to " + loanedTo.getName() + " until " + dueDate;
        }
        return publicationInfo;
    }
}

