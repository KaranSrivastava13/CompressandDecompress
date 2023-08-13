// Import necessary classes for file operations and compression
import java.io.*;
import java.util.zip.*;

// Define a class named Compressor
public class Compressor {

    // Define a static method named compress that takes input and output file paths and throws IOException
    public static void compress(String inputFilePath, String outputFilePath) throws IOException {
        // Create a FileInputStream to read the input file
        FileInputStream fis = new FileInputStream(inputFilePath);
        // Create a FileOutputStream to write the compressed output
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        // Create a GZIPOutputStream to apply GZIP compression to the output stream
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        // Create a buffer to read data from the input file
        byte[] buffer = new byte[1024];
        int bytesRead;
        // Read data from the input file and write to the compressed output
        while ((bytesRead = fis.read(buffer)) != -1) {
            gzipOS.write(buffer, 0, bytesRead);
        }
        // Close the GZIPOutputStream, FileOutputStream, and FileInputStream
        gzipOS.close();
        fos.close();
        fis.close();
        // Print a success message
        System.out.println("File compressed successfully.");
    }
}
