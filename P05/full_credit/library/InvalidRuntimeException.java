package library;

/**
 * Custom exception class for representing invalid runtime in a video.
 * Extends the ArithmeticException class and is part of the "library" package.
 */
public class InvalidRuntimeException extends ArithmeticException {

    /**
     * Constructs a new InvalidRuntimeException with a custom error message.
     *
     * @param title   The title of the video with an invalid runtime.
     * @param runtime The invalid runtime value.
     */
    public InvalidRuntimeException(String title, int runtime) {
        // Call the superclass constructor and provide a custom error message.
        super(title + " has invalid runtime " + runtime);
    }
}

