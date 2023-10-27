package luloh.eileen.delphisurvey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Driver 
{
    public static void main(String[] args) 
    {
        // Example usage
        DelphiMethod delphi = new DelphiMethod();
        Round round1 = new Round();
        
        String path = "dhillonRound1KMOData.txt"; // Replace if needed
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String line;
            int lineCount = 0;
            
            while ((line = br.readLine()) != null)
            {
                String[] values = line.split(",");
                        
                // Assigning number of issues to values.length?
                if (lineCount == 0)
                {
                    System.out.println("Total issues: " + (values.length - 1));
                }
                else
                {
                    // Participant data starts from line 2
                    Participant p = new Participant();
                    
                    for (int i = 1; i < values.length; i++)
                    {
                        int issueValue = Integer.parseInt(values[i]);
                        p.addIssue(new Issue(issueValue));
                    }
                    
                    round1.addParticipant(p);
                }
                
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        //p1.addIssue(new Issue(5)); // Here, I'm assuming issue has an integer value for simplicity. Adjust as needed.
        //p1.addIssue(new Issue(7));
        delphi.addRound(round1);

        // Accessing values
        int value = delphi.getRound(0).getParticipant(0).getIssue(0).getValue();
        System.out.println("Value of Round 1, Participant 1, Issue 1: " + value);
    }
}
