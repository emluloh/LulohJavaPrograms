import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Issue> issues;

    public Round() {
        this.issues = new ArrayList<>();
    }

    public void addIssue(Issue issue) {
        issues.add(issue);
    }

    public Issue getIssue(int index) {
        return issues.get(index);
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public int getNumberOfIssues() {
        return issues.size();
    }

}
