package units.pillininitoffoloni.cribbage.scoringrules;

import units.pillininitoffoloni.cribbage.Card;

import java.util.List;

public class FifteenTwoRule implements ScoringRule {
    @Override
    public int calculatePoints(List<Card> cards) {
        return findFifteens(cards, 0, 0) * 2;
    }

    private int findFifteens(List<Card> cards, int startIndex, int currentSum) {
        if (currentSum == 15) {
            return 1;
        }
        if (currentSum > 15 || startIndex >= cards.size()) {
            return 0;
        }

        int withCurrentCard = findFifteens(
                cards, startIndex + 1, currentSum + cards.get(startIndex).getValue()
        );

        int withoutCurrentCard = findFifteens(cards, startIndex + 1, currentSum);

        return withCurrentCard + withoutCurrentCard;
    }
}
