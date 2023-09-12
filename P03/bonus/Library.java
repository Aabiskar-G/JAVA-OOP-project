import java.util.ArrayList;

class Library {
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Patron> patrons;

    public Library(String name) {
        this.name = name;
        publications = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

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

    public ArrayList<Patron> getPatrons() {
        return patrons;
    }

    @Override
    public String toString() {
        StringBuilder libraryInfo = new StringBuilder(name + "\n");
        for (int i = 0; i < publications.size(); i++) {
            libraryInfo.append(i).append(") ").append(publications.get(i)).append("\n");
        }
        return libraryInfo.toString();
    }
}

