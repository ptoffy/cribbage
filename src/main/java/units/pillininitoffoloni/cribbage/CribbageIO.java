package units.pillininitoffoloni.cribbage;

public interface CribbageIO {
    /**
     * Reads raw card input from the user
     * @return Array of strings where each element is a two-character string (value and suit)
     * @throws IllegalArgumentException if the input format is invalid (wrong length or character pairs)
     */
    String[] readHand();
    void displayScore(int score);
    void displayError(String message);
    boolean playAgain();
    void close();
}
