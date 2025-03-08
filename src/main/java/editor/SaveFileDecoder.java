package editor;

import java.io.*;
import java.nio.file.Files;
import java.util.Base64;
import java.util.zip.InflaterInputStream;

public class SaveFileDecoder {
    public static void main(String[] args) {
        String inputFile = "saveslot_2.save";
        String outputFile = "decrypted_save.txt";

        try {
            String fileContent = new String(Files.readAllBytes(new File(inputFile).toPath())).trim();

            fileContent = fileContent.replaceAll("[^A-Za-z0-9+/=]", "");

            byte[] decodedData;
            try {
                decodedData = Base64.getDecoder().decode(fileContent);
                System.out.println("Base64 decoding successful!");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: File is NOT Base64-encoded or has corruption.");
                return;
            }

            byte[] decompressedData = decompressZlib(decodedData);
            System.out.println("Zlib decompression successful!");

            Files.write(new File(outputFile).toPath(), decompressedData);
            System.out.println("Decryption successful! Saved as: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] decompressZlib(byte[] compressedData) throws IOException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(compressedData);
        InflaterInputStream inflaterStream = new InflaterInputStream(byteStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inflaterStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inflaterStream.close();
        return outputStream.toByteArray();
    }
}
