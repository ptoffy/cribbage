package units.pillininitoffoloni.cribbage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestIO implements CribbageIO {
    private String[] handsToTest;

    private final List<Integer> displayedScores = new ArrayList<>();
    private final List<String> displayedErrors = new ArrayList<>();

    TestIO(String... handsToTest) {
        this.handsToTest = handsToTest;
    }

    @Override
    public String[] readHand() {
        String hand = handsToTest[handsToTest.length - 1];
        this.handsToTest = Arrays.copyOf(handsToTest, handsToTest.length - 1);
        return parseInput(hand);
    }

    @Override
    public void displayScore(int score) {
        displayedScores.add(score);
    }

    @Override
    public void displayError(String message) {
        displayedErrors.add(message);
    }

    @Override
    public boolean playAgain() {
        return handsToTest.length != 0;
    }

    @Override
    public void close() {}

    private String[] parseInput(String input) {
        String[] cards = new String[5];
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 2;
            cards[i] = input.substring(startIndex, startIndex + 2);
        }
        return cards;
    }

    public List<Integer> getDisplayedScores() {
        return displayedScores;
    }

    public List<String> getDisplayedErrors() {
        return displayedErrors;
    }
}
