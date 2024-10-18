package units.pillininitoffoloni.cribbage;

import java.util.Scanner;

public class ConsoleIO implements CribbageIO {
    private final Scanner scanner;

    public ConsoleIO() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String[] readHand() {
        while (true) {
            System.out.println("Enter a Cribbage hand (10 characters: 8 for hand cards, 2 for starter card):");
            String input = scanner.nextLine().trim();

            try {
                return parseInput(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println("Input should be exactly 10 characters (5 pairs of characters)");
            }
        }
    }

    private String[] parseInput(String input) {
        if (input.length() != 10) {
            throw new IllegalArgumentException("Invalid input length. Expected 10 characters (4 hand cards + 1 starter card)");
        }

        String[] cards = new String[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 2;
            cards[i] = input.substring(startIndex, startIndex + 2);
        }

        return cards;
    }

    @Override
    public void displayScore(int score) {
        System.out.println("Hand score: " + score);
    }

    @Override
    public void displayError(String message) {
        System.err.println("Error: " + message);
    }

    @Override
    public boolean playAgain() {
        System.out.println("Would you like to score another hand? (y/n):");
        String response = scanner.nextLine().trim().toLowerCase();
        return switch (response) {
            case "y", "yes" -> true;
            case "n", "no" -> false;
            default -> {
                System.out.println("Invalid answer. Possible answers are \"y\", \"yes\", \"n\" or \"no\"");
                yield playAgain();
            }
        };
    }

    @Override
    public void close() {
        scanner.close();
    }
}