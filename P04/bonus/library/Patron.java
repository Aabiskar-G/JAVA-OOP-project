package library;

/**
 * Represents a patron (library user) with a name and an ID.
 * This class is part of the "library" package.
 */
public class Patron {
    private String name;
    private int patronId;

    /**
     * Constructs a new Patron object with the given name and patron ID.
     *
     * @param name     The name of the patron.
     * @param patronId The ID of the patron.
     */
    public Patron(String name, int patronId) {
        this.name = name;
        this.patronId = patronId;
    }

    /**
     * Retrieves the name of the patron.
     *
     * @return The name of the patron.
     */
    public String getName() {
        return name;
    }

    // Getter and setter methods for patronId can be added as needed

    /**
     * Generates a string representation of the patron.
     *
     * @return A string containing information about the patron, including name and ID.
     */
    @Override
    public String toString() {
        return "Patron: " + name + " (ID: " + patronId + ")";
    }

    // Additional methods and properties can be added as needed
}

