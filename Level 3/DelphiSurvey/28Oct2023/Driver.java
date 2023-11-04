
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Driver 
{
    public static void main(String[] args) 
    {
        
        DelphiMethod delphi = new DelphiMethod();
        Round round1 = new Round();
        
        String path = "Round1KMOData.txt"; // Replace if needed
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {
            String line;
            int lineCount = 0;
            
            while ((line = br.readLine()) != null && !line.startsWith("Total"))
            {
                String[] values = line.split(",");
                
                // If line ends with ",,," skip to the next line
                if (values.length > 1 && ",,,".equals(values[values.length - 3] + 
                        values[values.length - 2] + values[values.length - 1]))
                {
                    continue;
                }
               
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
            } // end of while loop
        } // end of try
      
        catch (IOException e)
        {
            System.out.println("An error occurred: " + e.getMessage());
        }

        delphi.addRound(round1);
        
        int k = delphi.getRound(0).getParticipant(0).getNumberOfIssues();
        int m = delphi.getRound(0).getNumberOfParticipants();
      
        // Accessing values - i refers to participantIndex
        for (int i = 0; i < m; i++) 
        {
            System.out.println("Participant " + (i + 1) + ":");
            // j refers to issueIndex
            for (int j = 0; j < delphi.getRound(0).getParticipant(i).getNumberOfIssues(); j++) 
            {
                int issueValue = delphi.getRound(0).getParticipant(i).getIssue(j).getValue();
                System.out.println("    Issue " + (j + 1) + ": " + issueValue);
            }
        }
        
        // Declare an array of doubles accumulatedValues with length k
        double[] accumulatedValues = new double[k]; // k refers to numIssues
        
        // loop for each participant
        for (int i = 0; i < m; i++) // while participantIndex < numParticipants
        {
            // 
            for (int j = 0; j < k; j++) // while issueIndex < numIssues
            {
                int issueValue = delphi.getRound(0).getParticipant(i).getIssue(j).getValue();
                accumulatedValues[j] += issueValue;
            }
        }
        
        // Store accumulatedValues in the Round object
        delphi.getRound(0).setAccumulatedValues(accumulatedValues);
        
        // Declare an array of doubles meanValues with length k
        double[] meanValues = new double[k]; // k refers to numIssues
        
        // Declare an array of doubles deviations with length k
        double[] sqDeviations = new double[k]; // k refers to numIssues
        
        double devSq = 0;
        double total = 0;
        double totalMean = 0;
        
        for (int i = 0; i < k; i++) // k refers to numIssues
        {
            total += delphi.getRound(0).getAccumulatedValues()[i];
        }
        
        System.out.println("Total: " + total);
        totalMean = total / k;
        
        // Calculate mean for each issue and for all issues
        // Comments loop through and print accumulatedValues and meanValues arrays
        for (int i = 0; i < k; i++)
        {
            System.out.println("Total for Issue " + (i + 1) + ": " + delphi.getRound(0).getAccumulatedValues()[i]);
            meanValues[i] = delphi.getRound(0).getAccumulatedValues()[i] / m;
            System.out.println("Issue mean " + (i + 1) + ": " + meanValues[i]);
            sqDeviations[i] = Math.pow(delphi.getRound(0).getAccumulatedValues()[i] - totalMean, 2);
            devSq += sqDeviations[i]; 
        }
        
        delphi.getRound(0).setDevSq(devSq);
        //System.out.println("DEVSQ: " + delphi.getRound(0).getDevSq());
        
        // Calculate Kendall's W
        double w = 12 * delphi.getRound(0).getDevSq() / (Math.pow(m, 2) * (Math.pow(k, 3) - k));
        System.out.println("w           " + w);
        
        // Calculate r
        double r = (m * w - 1) / (m - 1);
        System.out.println("r           " + r);
        
        // Calculate x2
        double x2 = m * (k - 1) * w;
        System.out.println("x2          " + x2);
        
        // Calculate degrees of freedom
        double df = m - 1;
        System.out.println("df          " + df);
        
        // Calculate right-tail p-value for chi-square distribution
        double pval = 0; // cant figure this out for now
        System.out.println("pval        " + pval);
        
        // Calculate Grand Mean
        double grandMean = 0;
        double sumOfMeanRanks = 0;
        
        for (int i = 0; i < k; i++)
        {
            sumOfMeanRanks += meanValues[i];
        }
        
        grandMean = sumOfMeanRanks / k;
        System.out.println("Grand Mean  " + grandMean);
        
        
        
        // Store meanValues in the Round object
        delphi.getRound(0).setMeanValues(meanValues);
        
        // Store sqDeviations in the Round object
        delphi.getRound(0).setSqDeviations(sqDeviations);
        

    } // end of main function
} // end of Driver class
