package units.pillininitoffoloni.cribbage.scoringrules;

import units.pillininitoffoloni.cribbage.Card;

import java.util.ArrayList;
import java.util.List;

public class PairRule implements ScoringRule {
    @Override
    public int calculatePoints(List<Card> cards) {
        int points = 0;
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Cards must have exactly 5 elements");
        }

        List<Character> countedKinds = new ArrayList<>();
        for (Card card : cards) {
            int sameKindCounter = 1;
            for (Card secondCard : cards) {
                if (card.getKind() == (secondCard.getKind())
                        && !countedKinds.contains(secondCard.getKind())
                        && !card.equals(secondCard)
                ) {
                    sameKindCounter += 1;
                }
            }
            countedKinds.add(card.getKind());
            switch (sameKindCounter) {
                case 2: points += 2; break;
                case 3: points += 6; break;
                case 4: points += 12; break;
                default: break; // unreachable
            }
        }

        return points;
    }
}
