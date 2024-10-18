package units.pillininitoffoloni.cribbage.scoringrules;

import units.pillininitoffoloni.cribbage.Card;

import java.util.List;

public class FlushRule implements ScoringRule {
    @Override
    public int calculatePoints(List<Card> cards) {
        int count = 0;
        if (cards.stream().anyMatch(card -> (card.getSuit() == cards.getLast().getSuit() && card.getKind() == 'J'))) {
            count += 1;
        }
        for (int i = 1; i < 4; i++) {
            if (cards.get(i).getSuit() != cards.get(i - 1).getSuit()) {
                return count;
            }
        }
        if (cards.get(4).getSuit() != cards.get(5).getSuit()) {
            return count + 4;
        }
        return count + 6;
    }
}
