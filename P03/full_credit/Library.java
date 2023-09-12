import java.util.ArrayList;

class Library {
    private String name;
    private ArrayList<Publication> publications;

    public Library(String name) {
        this.name = name;
        publications = new ArrayList<>();
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public void checkout(int publicationIndex, String patron) {
        try {
            Publication publication = publications.get(publicationIndex);
            publication.checkout(patron);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index. Please choose a valid index.");
        }
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

