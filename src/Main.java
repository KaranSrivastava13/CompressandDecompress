// Import necessary classes for creating user interface components
import javax.swing.*;
import java.awt.*;

// Define a class named Main
public class Main {

    public static void main(String[] args) {
        // Schedule the creation of the GUI on the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            // Create an instance of the CompressionApp class (a JFrame)
            JFrame frame = new CompressionApp();
            // Set the frame as visible to display the GUI
            frame.setVisible(true);
        });
    }
}
