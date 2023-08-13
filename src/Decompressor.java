// Import necessary classes for file operations and compression
import java.io.*;
import java.util.zip.*;

// Define a class named Decompressor
public class Decompressor {

    // Define a static method named decompress that takes input and output file paths and throws IOException
    public static void decompress(String inputFilePath, String outputFilePath) throws IOException {
        // Create a FileInputStream to read the input file
        FileInputStream fis = new FileInputStream(inputFilePath);
        // Create a GZIPInputStream to read the compressed input stream
        GZIPInputStream gzipIS = new GZIPInputStream(fis);
        // Create a FileOutputStream to write the decompressed output
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        // Create a buffer to read data from the GZIPInputStream
        byte[] buffer = new byte[1024];
        int bytesRead;
        // Read data from the GZIPInputStream and write to the decompressed output
        while ((bytesRead = gzipIS.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        // Close the FileOutputStream, GZIPInputStream, and FileInputStream
        fos.close();
        gzipIS.close();
        fis.close();
        // Print a success message
        System.out.println("File decompressed successfully.");
    }
}
