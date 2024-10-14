package units.pillininitoffoloni.cribbage;

import java.util.Set;

public class Card {
    public enum Suit {
        HEARTS('♥'),
        DIAMONDS('♦'),
        CLUBS('♣'),
        SPADES('♠');

        private final char symbol;

        static Suit fromSymbol(char symbol) {
            for (Suit suit : Suit.values()) {
                if (suit.symbol == symbol) {
                    return suit;
                }
            }

            throw new IllegalArgumentException("Unknown suit " + symbol);
        }

        Suit(char symbol) {
            switch (symbol) {
                case '♥', '♦', '♣', '♠': this.symbol = symbol; break;
                default: throw new IllegalArgumentException("Invalid symbol: " + symbol);
            }
        }

        @Override
        public String toString() {
            return name().toLowerCase() + " (" + symbol + ")";
        }
    }

    private final char value;
    private final Suit suit;

    Card(char value, char suit) {
        this(value, Suit.fromSymbol(suit));
    }

    Card(int value, char suit) {
        this(value, Suit.fromSymbol(suit));
    }

    Card(char value, Suit suit) {
        if (!Character.isDigit(value) && !Set.of('A', 'J', 'Q', 'K').contains(value)) {
            throw new IllegalArgumentException("Invalid card value: " + value);
        }
        this.value = value;
        this.suit = suit;
    }

    Card(int value, Suit suit) {
        if (value <= 0 || value > 9) {
            throw new IllegalArgumentException("Invalid card value: " + value + ", must be between 1 and 9");
        }
        this.value = Integer.toString(value).charAt(0);
        this.suit = suit;
    }

    @Override
    public String toString() {
        return switch (value) {
            case 'A' -> "Ace of " + suit;
            case 'J' -> "Jack of " + suit;
            case 'Q' -> "Queen of " + suit;
            case 'K' -> "King of " + suit;
            default -> value + " of " + suit;
        };
    }
}
