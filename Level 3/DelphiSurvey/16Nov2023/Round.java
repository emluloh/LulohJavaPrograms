import java.util.ArrayList;

public class Round {
    private ArrayList<int[]> issues;
    private int numIssues;
    private int numParticipants;

    public Round(int numIssues, int numParticipants) {
        this.numIssues = numIssues;
        this.numParticipants = numParticipants;
        this.issues = new ArrayList<>(numIssues);
        for (int i = 0; i < numIssues; i++) {
            this.issues.add(new int[numParticipants]);
        }
    }

    public ArrayList<int[]> getIssues() {
        return issues;
    }

    public void setIssues(ArrayList<int[]> issues) {
        if (issues.size() != numIssues) {
            throw new IllegalArgumentException("The list size does not match the number of issues.");
        }
        for (int[] issueScores : issues) {
            if (issueScores.length != numParticipants) {
                throw new IllegalArgumentException("One of the arrays' length does not match the number of participants.");
            }
        }
        this.issues = issues;
    }

    public void setNumParticipants(int numP) {
        numParticipants = numP;
    }

    // Additional methods as needed
}
