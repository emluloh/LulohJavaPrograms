
import java.util.ArrayList;
import java.util.List;


public class Participant 
{
    private List<Issue> issues;

    public Participant() 
    {
        this.issues = new ArrayList<>();
    }

    public void addIssue(Issue issue) 
    {
        issues.add(issue);
    }

    public Issue getIssue(int index) 
    {
        return issues.get(index);
    }

    public int getNumberOfIssues() 
    {
        return issues.size();
    }
}
