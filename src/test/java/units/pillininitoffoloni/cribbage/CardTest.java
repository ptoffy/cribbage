package units.pillininitoffoloni.cribbage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {
    @Test
    void testIntInit() {
        Card card = new Card(3, '♣');
        Assertions.assertEquals(card.toString(), "3 of clubs (♣)");
    }

    @Test
    void testCharInit() {
        Card card = new Card('A', '♥');
        Assertions.assertEquals(card.toString(), "Ace of hearts (♥)");
    }
}