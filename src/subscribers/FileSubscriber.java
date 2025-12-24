package subscribers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileSubscriber implements Subscriber {

    private final String filename;

    public FileSubscriber(String filename) {
        this.filename = filename;
    }

    @Override
    public void update(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))){
            String timestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
            );

            writer.println(timestamp + " - " + message);
            System.out.println("FileSubscriber wrote to " + filename + ": " + message);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
