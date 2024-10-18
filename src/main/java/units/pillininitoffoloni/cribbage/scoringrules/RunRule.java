package units.pillininitoffoloni.cribbage.scoringrules;

import units.pillininitoffoloni.cribbage.Card;

import java.util.Collections;
import java.util.List;

public class RunRule implements ScoringRule {
    @Override
    public int calculatePoints(List<Card> cards) {
        Collections.sort(cards);
        int maxRun = 1;
        int currentRun = 1;
        for (int i = 1; i < cards.size(); i++) {
            if ((cards.get(i).getCardValue() - cards.get(i - 1).getCardValue()) == 1) {
                currentRun += 1;
            } else {
                currentRun = 1;
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        }
        if (maxRun > 2) {
            return maxRun;
        }
        return 0;
    }
}
