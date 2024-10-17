package units.pillininitoffoloni.cribbage;

import java.util.ArrayList;
import java.util.List;

public class CribbageService {
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
}
