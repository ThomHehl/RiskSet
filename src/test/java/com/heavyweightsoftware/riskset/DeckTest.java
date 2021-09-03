package com.heavyweightsoftware.riskset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    private Deck deck;

    public static Deck getDeck() {
        Deck result = new Deck();
        return result;
    }

    @BeforeEach
    public void setUp() {
        deck = getDeck();
    }

    @Test
    public void testDrawn() {
        boolean foundArgentina = false;
        int wilds = 0;

        for (int ix = 0; ix < Deck.DECK_LENGTH; ++ix) {
            Card card = deck.draw();
            assertNotNull(card);

            if (card.getCountry() == Card.Country.Argentina) {
                foundArgentina = true;
            } else if (card.isWild()) {
                wilds++;
            }
        }

        assertNull(deck.draw());
        assertTrue(foundArgentina);
        assertEquals(wilds, 2);
    }
}