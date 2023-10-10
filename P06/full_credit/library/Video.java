package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.Duration;

public class Video extends Publication {
    Duration runtime;

    public class InvalidRuntimeException extends ArithmeticException {
        public InvalidRuntimeException() {
            super();
        }

        public InvalidRuntimeException(String message) {
            super(message);
        }

        public InvalidRuntimeException(String title, int runtime) {
            super(title + " has invalid runtime " + runtime);
        }
    }

    public Video(String title, String author, int copyright, int runtime) {
        super(title, author, copyright);
        if (runtime < 1) {
            throw new InvalidRuntimeException(title, runtime);
        }
        this.runtime = Duration.ofMinutes(runtime);
    }

    @Override
    public String toString() {
        return toStringBuilder("Video", ", runtime " + runtime.toMinutes() + " minutes");
    }

    public Video(BufferedReader br) throws IOException {
        super(br);  // Initialize Publication fields from BufferedReader

        // Read the runtime in minutes as a long and create a Duration object
        long runtimeMinutes = Long.parseLong(br.readLine());
        this.runtime = Duration.ofMinutes(runtimeMinutes);
    }

    @Override
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);  // Save the inherited fields using the superclass's save method

        // Save the runtime in minutes as a long
        bw.write(Long.toString(runtime.toMinutes()));
        bw.newLine();
    }
}

