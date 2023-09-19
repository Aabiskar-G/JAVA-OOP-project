package library;

import java.time.Duration;

/**
 * Represents a video (movie) in the library's collection.
 * Extends the Publication class and is part of the "library" package.
 */
public class Video extends Publication {
    private int runtime; // Runtime in minutes

    /**
     * Constructs a new Video object with the given title, director, release year, and runtime.
     *
     * @param title     The title of the video.
     * @param director  The director of the video.
     * @param year      The release year of the video.
     * @param runtime   The runtime of the video in minutes.
     * @throws InvalidRuntimeException if the provided runtime is less than or equal to zero.
     */
    public Video(String title, String director, int year, int runtime) {
        super(title, director, year);
        if (runtime <= 0) {
            throw new InvalidRuntimeException(title, runtime);
        }
        this.runtime = runtime;
    }

    /**
     * Generates a string representation of the video.
     *
     * @return A string containing information about the video, including title, director, release year,
     *         and runtime (in minutes).
     */
    @Override
    public String toString() {
        return super.toString() + ", Runtime: " + runtime + " minutes";
    }
}

