public class Patron {
    private String name;
    private int patronId;

    public Patron(String name, int patronId) {
        this.name = name;
        this.patronId = patronId;
    }

    public String getName() {
        return name;
    }

    // Getter and setter methods for patronId

    @Override
    public String toString() {
        return "Patron: " + name + " (ID: " + patronId + ")";
    }

    // Additional methods and properties can be added as needed
}

