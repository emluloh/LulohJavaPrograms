package luloh.eileen.delphisurvey;

import java.util.ArrayList;
import java.util.List;


public class DelphiMethod {
    private List<Round> rounds;

    public DelphiMethod() {
        this.rounds = new ArrayList<>();
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public Round getRound(int index) {
        return rounds.get(index);
    }

    public int getNumberOfRounds() {
        return rounds.size();
    }
}
