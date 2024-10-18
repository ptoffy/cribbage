package units.pillininitoffoloni.cribbage.scoringrules;

import units.pillininitoffoloni.cribbage.Card;

import java.util.List;

public interface ScoringRule {
    int calculatePoints(List<Card> cards);
}
