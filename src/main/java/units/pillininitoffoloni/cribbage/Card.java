package units.pillininitoffoloni.cribbage;

import java.util.Set;

public class Card implements Comparable<Card> {
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

            return switch (symbol) {
                case 'd' -> DIAMONDS;
                case 'h' -> HEARTS;
                case 's' -> SPADES;
                case 'c' -> CLUBS;
                default -> throw new IllegalArgumentException("Unknown suit " + symbol);
            };

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

    private final char kind;
    private final Suit suit;

    Card(char kind, char suit) {
        this(kind, Suit.fromSymbol(suit));
    }

    Card(int kind, char suit) {
        this(kind, Suit.fromSymbol(suit));
    }

    Card(char kind, Suit suit) {
        if (!Character.isDigit(kind) && !Set.of('A', 'J', 'Q', 'K').contains(kind)) {
            throw new IllegalArgumentException("Invalid card value: " + kind);
        }
        this.kind = kind;
        this.suit = suit;
    }

    Card(int kind, Suit suit) {
        if (kind < 0 || kind > 10) {
            throw new IllegalArgumentException("Invalid card value: " + kind + ", must be between 1 and 9");
        }
        this.kind = kind == 10 ? '0' : Integer.toString(kind).charAt(0);
        this.suit = suit;
    }

    @Override
    public String toString() {
        return switch (kind) {
            case 'A' -> "Ace of " + suit;
            case 'J' -> "Jack of " + suit;
            case 'Q' -> "Queen of " + suit;
            case 'K' -> "King of " + suit;
            case '0' -> "10 of " + suit;
            default -> kind + " of " + suit;
        };
    }

    public Suit getSuit() {
        return suit;
    }

    public char getKind() {
        return kind;
    }

    public int getValue() {
        if (Character.isDigit(kind)) {
            int parsed = Character.getNumericValue(kind);
            return parsed == 0 ? 10 : parsed;
        }
        return switch (this.kind) {
            case 'A' -> 1;
            case 'J', 'Q', 'K' -> 10;
            default -> throw new IllegalArgumentException("Invalid card value: " + kind);
        };
    }

    /**
     * This compare method is used for ordering an array of Cards,
     * and the values used here are not the Cribbage values but rather
     * values to order the array in a standard fashion, e.g.:
     * A, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K.
     * Unfortunately we can't use ASCII values for obvious reasons
     */
    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.getCardValue(), o.getCardValue());
    }

    /**
     * This returns the actual card value, used for comparison when
     * ordering and checking for runs. This does NOT represent the
     * card's value in Cribbage.
     */
    public int getCardValue() {
        if (Character.isDigit(kind)) {
            int parsed = Character.getNumericValue(kind);
            return parsed == 0 ? 10 : parsed;
        }
        return switch (this.kind) {
            case 'A' -> 1;
            case 'J' -> 11;
            case 'Q' -> 12;
            case 'K' -> 13;
            default -> throw new IllegalArgumentException("Invalid card value: " + kind);
        };
    }
}
