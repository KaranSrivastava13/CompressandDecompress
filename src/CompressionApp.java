// Import necessary classes from Swing library
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Define a class named CompressionApp that extends JFrame and implements ActionListener
public class CompressionApp extends JFrame implements ActionListener {

    // Declare private instance variables for buttons and file selector
    private JButton compressButton;
    private JButton decompressButton;
    private FileSelector fileSelector;

    // Constructor for the CompressionApp class
    CompressionApp() {
        // Set default close operation, title, size, layout, and location of the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Compression and Decompression App");
        this.setSize(300, 150);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        // Initialize buttons and file selector
        compressButton = new JButton("Compress");
        decompressButton = new JButton("Decompress");
        fileSelector = new FileSelector();

        // Add action listeners to the buttons
        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        // Add buttons to the frame and make it visible
        this.add(compressButton);
        this.add(decompressButton);
        this.setVisible(true);
    }

    // ActionListener interface method implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // If the compressButton is clicked
        if (e.getSource() == compressButton) {
            // Get selected input file path from the file selector
            String inputPath = fileSelector.getSelectedFilePath();
            if (inputPath != null) {
                // Specify the default output file name
                String outputPath = fileSelector.getOutputFilePath("compressed.gz");
                // Create an instance of Compressor
                Compressor compressor = new Compressor();
                try {
                    // Compress the file
                    compressor.compress(inputPath, outputPath);
                    // Show success message
                    JOptionPane.showMessageDialog(null, "File compressed successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        // If the decompressButton is clicked
        else if (e.getSource() == decompressButton) {
            // Get selected input file path from the file selector
            String inputPath = fileSelector.getSelectedFilePath();
            if (inputPath != null) {
                // Specify the default output file name
                String outputPath = fileSelector.getOutputFilePath("decompressed.txt");
                // Create an instance of Decompressor
                Decompressor decompressor = new Decompressor();
                try {
                    // Decompress the file
                    decompressor.decompress(inputPath, outputPath);
                    // Show success message
                    JOptionPane.showMessageDialog(null, "File decompressed successfully.");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    // Main method to create an instance of CompressionApp
    public static void main(String[] args) {
        new CompressionApp();
    }
}
