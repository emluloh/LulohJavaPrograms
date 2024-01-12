
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
import java.util.Collections;
import java.util.Comparator;

public class Driver {
    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        int userInput = 0;

        while (userInput < 1 || userInput > 20) {
            try {
                System.out.println("Enter the number of rounds: ");
                userInput = readLine.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("User did not enter integer.");
                e.printStackTrace();
                readLine.next(); // Clear the scanner's buffer
            }
        }

        // Create Round objects per user's input dynamically
        Round[] rounds = new Round[userInput];

        for (int i = 0; i < userInput; i++) {
            rounds[i] = new Round();
            System.out.println("Round " + (i + 1) + " created.");

            List<Double> meanRanks = new ArrayList<>();

            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Map<String, String> issueNames = new HashMap<>();

                // Reading the file to find issue names
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) // Keeps reading lines until it finds correct line
                    {
                        if (line.contains("Mean Rank")) {
                            // System.out.println("reading mean ranks"); // Debug print
                            String[] meanTokens = line.split(",");
                            for (int j = 1; j < meanTokens.length - 2; j++) {
                                double meanRank = Double.parseDouble(meanTokens[j].trim());
                                meanRanks.add(meanRank);

                            }
                            // System.out.println("Mean ranks: " + meanRanks); // Debug print
                            break;
                        }
                    }
                    while ((line = br.readLine()) != null) // Keeps reading lines until it finds correct line
                    {
                        if (line.contains("ISSUE KEY")) {
                            while ((line = br.readLine()) != null && !line.trim().isEmpty()) {
                                String[] tokens = line.split(",");
                                for (int k = 0; k < tokens.length - 1; k++) {
                                    if (tokens.length >= 2 && tokens[k].startsWith("I")) {
                                        issueNames.put(tokens[k].trim(), tokens[k + 1].trim());
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
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line = br.readLine();
                    String[] issues = line.split(",");
                    for (int l = 1; l < issues.length; l++) // cycling through issues
                    {
                        if (!issues[l].isEmpty()) {
                            String issueKey = "I" + l;
                            String issueName = issueNames.get(issueKey);
                            double meanRank = meanRanks.get(l - 1);
                            if (issueName != null) {
                                Issue issue = new Issue(issueName, l, meanRank);
                                rounds[i].addIssue(issue);
                            } else {
                                System.out.println("No issue name found for key: " + issueKey);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                }
            }

            // Print the issues for the current round
            System.out.println("Issues for Round " + (i + 1) + ":");
            for (Issue issue : rounds[i].getIssues()) {
                System.out.println("Issue Name: " + issue.getName() + ", Value: " + issue.getValue() + ", Mean Rank: "
                        + issue.getMeanRank());
            }

            // Sort the issues in the current round based on meanRank
            Collections.sort(rounds[i].getIssues(), new Comparator<Issue>() {
                @Override
                public int compare(Issue issue1, Issue issue2) {
                    return Double.compare(issue1.getMeanRank(), issue2.getMeanRank());
                }
            });

            // Print the sorted issues for the current round
            System.out.println("Sorted Issues for Round " + (i + 1) + ":");
            for (Issue issue : rounds[i].getIssues()) {
                System.out.println("Issue Name: " + issue.getName() + ", Value: " + issue.getValue() + ", Mean Rank: "
                        + issue.getMeanRank());
            }
        } // end of looping rounds

        readLine.close();
    } // end of main function
} // end of Driver class
