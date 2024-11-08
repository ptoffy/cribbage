package units.pillininitoffoloni.cribbage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HandCountingTests {
    @Test
    void testCountWithDefaultExample() {
        TestIO testIO = new TestIO("5♥5♦5♠J♣5♣");
        CribbageGame game = new CribbageGame(testIO, new CribbageService());

        game.play();

        Assertions.assertEquals(testIO.getDisplayedErrors().size(), 0);
        Assertions.assertEquals(testIO.getDisplayedScores(), List.of(29));
    }

    @Test
    void testCountWithSecondExample() {
        TestIO testIO = new TestIO("0♦J♥Q♠A♣9♦");
        CribbageGame game = new CribbageGame(testIO, new CribbageService());

        game.play();

        Assertions.assertEquals(testIO.getDisplayedErrors().size(), 0);
        Assertions.assertEquals(testIO.getDisplayedScores(), List.of(5));
    }
}
