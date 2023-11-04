import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Driver
{
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser();
        ArrayList<Round> rounds = new ArrayList<>(); // Initialized list to store Round objects
        int dialogResult = JOptionPane.YES_OPTION; // Initialize dialogResult
        do
        {
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File selectedFile = fileChooser.getSelectedFile();
                ArrayList<int[]> arrays = readDataFromFile(selectedFile);
                
                if (arrays != null && !arrays.isEmpty())
                {
                    int numIssues = arrays.get(0).length;
                    int numParticipants = arrays.size();
                    
                    Round round = new Round(numIssues, numParticipants);
                    round.setIssues(arrays);
                    rounds.add(round);
                
                    // Display the populated arrays for testing
                    for (int i = 0; i < arrays.size(); i++)
                    {
                        System.out.print("Array " + (i + 1) + ": ");
                        for (int val : arrays.get(i))
                        {
                            System.out.print(val + " ");
                        }
                        System.out.println();
                    }
                } //end of if for null arrays
            } //end of if for approving file choice
            
            dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to add " +
                "another round?", "Continue?", JOptionPane.YES_NO_OPTION);
        } while (dialogResult == JOptionPane.YES_OPTION);
    } //end of main method
    
    
    
    private static ArrayList<int[]> readDataFromFile(File file)
    {
        ArrayList<int[]> arrays = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            // Read header to determine the number of issues
            String line = reader.readLine();
            if (line == null) return null; // No content in file
        
            // Split the line by comma to get individual columns and determine the number of issues
            int numIssues = line.split(",").length - 1; // Subtracting 1 for "P#" column
            
            // Calculate the number of participants based on lines starting with "P"
            int numOfParticipants = 0;
            reader.mark(10000); // Mark the second line for reset
            while ((line = reader.readLine()) != null && line.startsWith("P"))
            {
                numOfParticipants++;
            }
            reader.reset(); // Reset to go back to the second line after header
        
            // Initialize the arrays. Each array can hold values for up to the number of participants..
            for (int i = 0; i < numIssues; i++)
            {
                arrays.add(new int[numOfParticipants]);
            }
        
            int rowIndex = 0;
        
            // Read each line of the file until we encounter "Total" or the end of the file
            while ((line = reader.readLine()) != null && !line.startsWith("Total"))
            {
                String[] parts = line.split(",");

                // Start reading from the second value (index 1) to skip the 'P#' value
                for (int i = 1; i < parts.length; i++)
                {
                    // Put the value in the appropriate array and index
                    arrays.get(i - 1)[rowIndex] = Integer.parseInt(parts[i]);
                }

                // Move to the next row for the next line of data
                rowIndex++;
            }
        }
        catch (IOException e)
        {
            // Handle potential IO exceptions
            e.printStackTrace();
            return null;
        }

        return arrays;
    }
    
} //end of class
