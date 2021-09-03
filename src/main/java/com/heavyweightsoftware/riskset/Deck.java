package com.heavyweightsoftware.riskset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    public static final int DECK_LENGTH = 44;

    private List<Card> cards = new ArrayList<>(DECK_LENGTH);
    private List<Card> drawn = new ArrayList<>(DECK_LENGTH);

    public Deck() {
        addCountryCards();
        addWildCards();
        shuffle();
    }

    private void addCountryCards() {
        Card.Suit[] suits = Card.getSuitArray();
        int suitIdx = 0;

        for (Card.Country country : Card.Country.values()) {
            if (country != Card.Country.Wild) {
                Card card = new Card();
                card.setCountry(country);
                card.setSuit(suits[suitIdx]);
                cards.add(card);

                suitIdx++;
                if (suitIdx >= suits.length) {
                    suitIdx = 0;
                }
            }
        }
    }

    private void addWildCards() {
        cards.add(Card.getWildCard());
        cards.add(Card.getWildCard());
    }

    public Card draw() {
        Card result = null;

        if (!cards.isEmpty()) {
            result = cards.get(0);
            cards.remove(result);
            drawn.add(result);
        }

        return result;
    }

    public void reset() {
        cards.addAll(drawn);
        drawn.clear();
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }
}
