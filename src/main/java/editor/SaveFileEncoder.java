package editor;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.zip.Deflater;

public class SaveFileEncoder {

    public static void main(String[] args) {
        String inputFile = "modified_save.txt";
        String outputFile = "saveslot_2_modified.save";

        try {
            byte[] modifiedData = Files.readAllBytes(new File(inputFile).toPath());

            byte[] compressedData = compressZlib(modifiedData);

            String base64Encoded = Base64.getEncoder().encodeToString(compressedData);

            Files.write(new File(outputFile).toPath(), base64Encoded.getBytes());

            System.out.println("Re-encryption successful! Saved as: " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] compressZlib(byte[] data) throws IOException {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];

        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }

        deflater.end();
        return outputStream.toByteArray();
    }
}
