
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            // notes
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
            {
                File file = fileChooser.getSelectedFile();

                try (BufferedReader br = new BufferedReader(new FileReader(file))) 
                {
                    String line;
                    Map<String, String> issueNames = new HashMap<>();
                    
                    // Reading the file to find issue names
                    while ((line = br.readLine()) != null) 
                    {
                        if (line.startsWith("I")) 
                        {
                            String[] tokens = line.split(",");
                            for (String token : tokens) 
                            {
                                if (token.startsWith("I")) 
                                {
                                    String issueKey = token.trim();
                                    if (br.ready()) 
                                    {
                                        String issueName = br.readLine().trim();
                                        issueNames.put(issueKey, issueName);
                                    }
                                }
                            }
                        }
                    }

                    // Now, assign names to issues in the current round based on the map
                    for (Issue issue : rounds[i].getIssues()) {
                        String issueName = issueNames.get(issue.getName());
                        if (issueName != null) {
                            issue.setName(issueName);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }
        /*for (int i = 0; i < userInput; i++)
        {
            rounds[i] = new Round(); // Create new round and store in array
            System.out.println("Round " + (i + 1) + " created.");
            
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                File file = fileChooser.getSelectedFile();
                
                try (BufferedReader br = new BufferedReader(new FileReader(file)))
                {
                    String line = br.readLine();
                    if (line != null)
                    {
                        String[] issues = line.split(",");
                        for (int j = 1; j < issues.length; j++)
                        {
                            if (!issues[j].isEmpty())
                            {
                                Issue issue = new Issue(issues[j], 0); //Assuming initial value is 0
                                rounds[i].addIssue(issue);
                            }
                        }
                    }
                }
                catch (IOException e)
                {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }*/
            
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
