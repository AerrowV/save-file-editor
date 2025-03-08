package editor;

import java.io.File;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        String inputFile = "decrypted_save.txt";
        String outputFile = "modified_save.txt";

        try {
            String content = new String(Files.readAllBytes(new File(inputFile).toPath()));

            content = content.replace("9988328", "1000000000000");

            Files.write(new File(outputFile).toPath(), content.getBytes());

            System.out.println("Modification successful! Saved as: " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
