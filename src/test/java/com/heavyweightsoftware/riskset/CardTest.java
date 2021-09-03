package com.heavyweightsoftware.riskset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    private Card card;

    public static Card getCard() {
        Card result = new Card();
        result.setCountry(Card.Country.Afghanistan);
        result.setSuit(Card.Suit.Artillery);
        return result;
    }

    public static Card getWild() {
        Card result = new Card();
        result.setWild();
        return result;
    }

    @BeforeEach
    void setUp() {
        card = getCard();
    }

    @Test
    void testIsWild() {
        assertFalse(card.isWild());

        Card wildCard = getWild();
        assertTrue(wildCard.isWild());
    }
}