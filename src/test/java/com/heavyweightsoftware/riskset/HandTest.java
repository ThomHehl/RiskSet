package com.heavyweightsoftware.riskset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HandTest {
    private Deck deck;
    private Hand hand;

    public static Hand getHand() {
        Hand result = new Hand();

        return result;
    }

    @BeforeEach
    public void setUp() {
        hand = getHand();

        deck = DeckTest.getDeck();
    }

    @Test
    public void isSet3Different() {
        addAllDifferent();

        assertEquals(hand.size(), 3);
        assertTrue(hand.isSet());
    }

    private void addAllDifferent() {
        boolean foundArtillery = false;
        boolean foundCavalry = false;
        boolean foundInfantry = false;

        while (!(foundArtillery && foundCavalry && foundInfantry)) {
            Card card = deck.draw();
            if (!foundArtillery && card.getSuit() == Card.Suit.Artillery) {
                hand.add(card);
                foundArtillery = true;
            }
            else if (!foundCavalry && card.getSuit() == Card.Suit.Cavalry) {
                hand.add(card);
                foundCavalry = true;
            }
            else if (!foundInfantry && card.getSuit() == Card.Suit.Infantry) {
                hand.add(card);
                foundInfantry = true;
            }
        }
    }

    @Test
    public void isSet3Same() {
        addSame(3, Card.Suit.Artillery);

        assertEquals(hand.size(), 3);
        assertTrue(hand.isSet());
    }

    private void addSame(int count, Card.Suit suit) {
        int foundSuit = 0;

        while (foundSuit < count) {
            Card card = deck.draw();
            if (card.getSuit() == suit) {
                hand.add(card);
                foundSuit++;
            }
        }
    }

    @Test
    public void isSet3Wild() {
        Card wild = null;

        while (hand.size() < 2) {
            Card card = deck.draw();
            if (card.isWild()) {
                wild = card;
            } else {
                hand.add(card);
            }
        }

        if (wild == null) {
            wild = Card.getWildCard();
        }
        hand.add(wild);

        assertEquals(hand.size(), 3);
        assertTrue(hand.isSet());
    }

    @Test
    public void isSet4Different() {
        addAllDifferent();

        while (hand.size() < 4) {
            Card card = deck.draw();
            if (!card.isWild()) {
                hand.add(card);
            }
        }

        assertTrue(hand.isSet());
    }

    @Test
    public void isSet4Same() {
        addSame(4, Card.Suit.Infantry);

        assertEquals(hand.size(), 4);
        assertTrue(hand.isSet());
    }

    @Test
    public void isSet4Wild() {
        addAllDifferent();
        Card card = Card.getWildCard();
        hand.add(card);

        assertTrue(hand.isSet());
    }

    @Test
    public void isSet5Different() {
        addAllDifferent();

        while (hand.size() < 5) {
            Card card = deck.draw();
            if (!card.isWild()) {
                hand.add(card);
            }
        }

        assertTrue(hand.isSet());
    }

    @Test
    public void isSet5Same() {
        addSame(5, Card.Suit.Cavalry);

        assertEquals(hand.size(), 5);
        assertTrue(hand.isSet());
    }

    @Test
    public void isSet5Wild() {
        addAllDifferent();

        while (hand.size() < 4) {
            Card card = deck.draw();
            if (!card.isWild()) {
                hand.add(card);
            }
        }

        Card card = Card.getWildCard();
        hand.add(card);

        assertTrue(hand.isSet());
    }
}