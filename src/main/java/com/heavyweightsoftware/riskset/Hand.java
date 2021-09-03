package com.heavyweightsoftware.riskset;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private static final int MAX_HAND = 5;

    List<Card> cards = new ArrayList<>(MAX_HAND);

    public void add(Card card) {
        if (cards.size() >= MAX_HAND) {
            throw new IllegalStateException("Exceded max cards.");
        }

        cards.add(card);
    }

    public int size() {
        return cards.size();
    }

    public boolean isSet() {
        boolean result = false;
        int countArtillery = 0;
        int countCavalry = 0;
        int countInfantry = 0;
        int countWild = 0;

        for (Card card : cards) {
            if (card.isWild()) {
                countWild++;
            }
            else if (card.getSuit() == Card.Suit.Artillery) {
                countArtillery ++;
            }
            else if (card.getSuit() == Card.Suit.Cavalry) {
                countCavalry ++;
            }
            else if (card.getSuit() == Card.Suit.Infantry) {
                countInfantry ++;
            }
        }

        if (countArtillery >= 3 || countCavalry >= 3 || countInfantry >= 3) {
            result = true;
        }
        else if (countArtillery >= 1 && countCavalry >= 1 && countInfantry >= 1) {
            result = true;
        }
        else if (countWild > 0 && size() >= 3) {
            result = true;
        }

        return result;
    }
}
