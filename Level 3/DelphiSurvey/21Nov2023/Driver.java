
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Driver 
{
    public static void main(String[] args) 
    {
        Scanner readLine = new Scanner(System.in);
        int userInput = 0;
        
        while (userInput < 1 || userInput > 20)
        {
            try
            {        
                System.out.println("Enter the number of rounds: ");
                userInput = readLine.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("User did not enter integer.");
                e.printStackTrace();
                readLine.next(); // Clear the scanner's buffer
            }
        }
        
        // Create Round objects per user's input dynamically
        Round[] rounds = new Round[userInput];
        
        for (int i = 0; i < userInput; i++) 
        {
            rounds[i] = new Round();
            System.out.println("Round " + (i + 1) + " created.");

            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
            {
                File file = fileChooser.getSelectedFile();
                Map<String, String> issueNames = new HashMap<>();

                try (BufferedReader br = new BufferedReader(new FileReader(file))) 
                {
                    String line;
                    // Reading the file to find issue names
                    while ((line = br.readLine()) != null) 
                    {
                        if (line.contains("ISSUE KEY")) 
                        {
                            while ((line = br.readLine()) != null && !line.trim().isEmpty())
                            {
                                String[] tokens = line.split(",");
                                for (int j = 0; j < tokens.length - 1; j++)
                                {
                                    if (tokens.length >= 2 && tokens[j].startsWith("I"))
                                    {
                                        issueNames.put(tokens[j].trim(), tokens[j + 1].trim());
                                    }
                                }
                            }
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
                
                // Debug print to check issue names map
                // System.out.println("Issue Names Map: " + issueNames);
                
                // Assign names to issues in the current round 
                try (BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    String line = br.readLine();
                    String[] issues = line.split(",");
                    for (int k = 1; k < issues.length; k++) 
                    {
                        if (!issues[k].isEmpty()) 
                        {
                            String issueKey = "I" + k;
                            String issueName = issueNames.get("I" + k);
                            if (issueName != null)
                            {
                                Issue issue = new Issue(issueName, k);
                                rounds[i].addIssue(issue);
                            }
                            else
                            {
                                System.out.println("No issue name found for key: " + issueKey);
                            }
                        }
                    }
                } 
                catch (IOException e) 
                {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }
            
            // Print the issues for the current round
            System.out.println("Issues for Round " + (i + 1) + ":");
            for (Issue issue : rounds[i].getIssues())
            {
                System.out.println("Issue Name: " + issue.getName() + ", Value: " + issue.getValue());
            }
        }
        
        readLine.close();
    } // end of main function
} // end of Driver class
