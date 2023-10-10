package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;

/**
 * A library video that can be checked out by a patron.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Video extends Publication {
    /**
     * Thrown when a Video runtime is invalid.
     *
     * @since              1.0
     */
    public class InvalidRuntimeException extends ArithmeticException {
        /**
         * Constructs an InvalidRuntimeException with no detail message.
         *
         * @since              1.0
         */
        public InvalidRuntimeException() {
            super();
        }

        /**
         * Constructs an InvalidRuntimeException with the specified detail message.
         *
         * @param message      the detailed message
         * @since              1.0
         */
        public InvalidRuntimeException(String message) {
            super(message);
        }

        /**
         * Constructs an InvalidRuntimeException with a custom message.
         *
         * @param title        the name of the library
         * @param runtime      the (invalid) number of minutes required to play the video at standard speed
         * @since              1.0
         */
        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has invalid runtime " + runtime);
        }
    }

    /**
     * Creates a Video instance.
     *
     * The runtime is specified in minutes.
     *
     * @param title        the name of the video
     * @param author       the principal creator of this video, typically the producer
     * @param copyright    the year in which this video was released or registered
     * @param runtime      the number of minutes required to play the video at standard speed
     * @since              1.0
     * @throws             InvalidRuntimeException
     */
    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if (runtime < 1) {
            throw new InvalidRuntimeException(title, runtime);
        }
        this.runtime = Duration.ofMinutes(runtime);
    }

    /**
     * Formats the fields of the publication in human-readable form.
     *
     * @returns     the string representation of the publication
     * @since       1.0
     */
    @Override
    public String toString() {
        return toStringBuilder("Video", ", runtime " + runtime.toMinutes() + " minutes");
    }

    Duration runtime;

    public Video(BufferedReader br) throws IOException {
        // Call the superclass's constructor to restore inherited fields
        super(br);

        // Read the runtime in minutes as a long and create a Duration object
        long runtimeMinutes = Long.parseLong(br.readLine());
        this.runtime = Duration.ofMinutes(runtimeMinutes);
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        // Save the inherited fields using the superclass's save method
        super.save(bw);

        // Save the runtime in minutes as a long
        bw.write(Long.toString(runtime.toMinutes()));
        bw.newLine();
    }
}

