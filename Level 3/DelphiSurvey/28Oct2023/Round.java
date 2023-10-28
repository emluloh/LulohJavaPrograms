
import java.util.ArrayList;
import java.util.List;


public class Round 
{
    private List<Participant> participants;
    private double[] meanValues;
    private double[] accumulatedValues;
    private double[] sqDeviations;
    private double devSq;

    public Round() 
    {
        this.participants = new ArrayList<>();
        this.meanValues = new double[0];
        this.accumulatedValues = new double[0];
        this.sqDeviations = new double[0];
    }

    public void addParticipant(Participant participant) 
    {
        participants.add(participant);
    }

    public Participant getParticipant(int index) 
    {
        return participants.get(index);
    }

    public int getNumberOfParticipants() 
    {
        return participants.size();
    }
    
    public void setMeanValues(double[] meanValues)
    {
        this.meanValues = meanValues;
    }
    
    public double[] getMeanValues()
    {
        return meanValues;
    }
    
    public void setAccumulatedValues(double[] accumulatedValues)
    {
        this.accumulatedValues = accumulatedValues;
    }
    
    public double[] getAccumulatedValues()
    {
        return accumulatedValues;
    }
    
    public void setSqDeviations(double[] sqDeviations)
    {
        this.sqDeviations = sqDeviations;
    }
    
    public double[] getSqDeviations()
    {
        return sqDeviations;
    }
    
    public void setDevSq(double devSq)
    {
        this.devSq = devSq;
    }
    
    public double getDevSq()
    {
        return devSq;
    }
}
