package units.pillininitoffoloni.cribbage;

import units.pillininitoffoloni.cribbage.scoringrules.*;

import java.util.ArrayList;
import java.util.List;

public class CribbageService {
    private final List<ScoringRule> scoringRules;

    CribbageService() {
        scoringRules = List.of(
                new FlushRule(),
                new PairRule(),
                new FifteenTwoRule(),
                new RunRule()
        );
    }

    public List<Card> parseAndValidateCards(String[] cards) {
        List<Card> parsedCards = new ArrayList<>();
        for (String stringCard : cards) {
            try {
                Card card = new Card(stringCard.charAt(0), stringCard.charAt(1));
                parsedCards.add(card);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid card: " + stringCard + ". Reason: " + e.getMessage());
            }
        }

        return parsedCards;
    }

    public int count(List<Card> cards) {
        return scoringRules.stream().mapToInt(rule -> rule.calculatePoints(cards)).sum();
    }
}

