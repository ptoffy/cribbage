package units.pillininitoffoloni.cribbage;

import java.util.List;

public class CribbageGame {
    private final CribbageIO io;
    private final CribbageService service;

    CribbageGame(CribbageIO io, CribbageService service) {
        this.io = io;
        this.service = service;
    }

    public static void main(String[] args) {
        CribbageGame game = new CribbageGame(new ConsoleIO(), new CribbageService());
        game.play();
    }

    public void play() {
        try {
            do {
                try {
                    String[] hand = io.readHand();
                    List<Card> cards = service.parseAndValidateCards(hand);
                    // TODO: calculate score here
                } catch (IllegalArgumentException e) {
                    io.displayError(e.getMessage());
                    break;
                }
            } while (io.playAgain());
        } finally {
            io.close();
        }
    }
}