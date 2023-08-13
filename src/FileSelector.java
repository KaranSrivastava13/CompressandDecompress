// Import necessary classes for file operations and user interface
import javax.swing.*;
import java.io.File;

// Define a class named FileSelector
public class FileSelector {

    // Define a method to get the selected input file path
    public String getSelectedFilePath() {
        // Create a JFileChooser for selecting files
        JFileChooser fileChooser = new JFileChooser();
        // Show the file chooser dialog and store the user's choice
        int returnValue = fileChooser.showOpenDialog(null);
        // If the user selected a file, return its absolute path
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        // If no file was selected, return null
        return null;
    }

    // Define a method to get the selected output file path
    public String getOutputFilePath(String defaultName) {
        // Create a JFileChooser for selecting the output file location
        JFileChooser fileChooser = new JFileChooser();
        // Set the default file name
        fileChooser.setSelectedFile(new File(defaultName));
        // Show the file chooser dialog for saving files and store the user's choice
        int returnValue = fileChooser.showSaveDialog(null);
        // If the user selected a location, return the chosen file's absolute path
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        // If no location was selected, return null
        return null;
    }
}
