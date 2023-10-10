package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Publication> publications;
    private ArrayList<Video> videos; // Add a list of videos

    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
        this.videos = new ArrayList<>(); // Initialize the videos list
    }

    public Library(BufferedReader br) throws IOException {
        publications = new ArrayList<>();
        videos = new ArrayList<>();

        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("Publication")) {
                String title = br.readLine();
                String author = br.readLine();
                int year = Integer.parseInt(br.readLine());
                publications.add(new Publication(title, author, year));
            } else if (line.equals("Video")) {
                String title = br.readLine();
                String director = br.readLine();
                int year = Integer.parseInt(br.readLine());
                int runtime = Integer.parseInt(br.readLine());
                videos.add(new Video(title, director, year, runtime));
            }
        }
    }

    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch (Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex
                    + ": " + e.getMessage() + "\n");
        }
    }

    public void checkIn(int publicationIndex) {
        try {
            publications.get(publicationIndex).checkIn();
        } catch (Exception e) {
            System.err.println("\nUnable to check in publication #" + publicationIndex
                    + ": " + e.getMessage() + "\n");
        }
    }

    public void save(BufferedWriter bw) throws IOException {
        bw.write(name);
        bw.newLine();

        // Save the number of publications in the library
        bw.write(Integer.toString(publications.size()));
        bw.newLine();

        // Iterate over the publications and save them
        for (Publication publication : publications) {
            if (publication instanceof Video) {
                bw.write("video");
            } else if (publication instanceof Publication) {
                bw.write("publication");
            }
            bw.newLine();

            // Tell the object to write itself to the stream
            publication.save(bw);
        }
    }
    
    public void load(BufferedReader br) throws IOException
    {
    	name = br.readLine();
    	int numPublications = Integer.parseInt(br.readLine());
    	
    	publications.clear();
    	
    	for (int i = 0; i < numPublications; i++)
    	{
    		String type =  br.readLine();
    		if(type.equals("Publication"))
    		{
    			Publication publication = new Publication(br);
    			publications.add(publication);
		}
		else if (type.equals("Video"))
		{
			Video video =  new Video(br);
			videos.add(video);
		}
	}
    }
	    	

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for (int i = 0; i < publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
}

