package com.heavyweightsoftware.riskset;

public class Card {
    public enum Country {Alaska, Alberta, CentralAmerica, EasternUnitedStates, Greenland, NorthwestTerritory,
        Ontario, Quebec, WesternUnitedStates,
        Argentina, Brazil, Peru, Venezuela,
        GreatBritain, Iceland, NorthernEurope, Scandinavia, SouthernEurope, Ukraine, WesternEurope,
        Congo, EastAfrica, Egypt, Madagascar, NorthAfrica, SouthAfrica,
        Afghanistan, China, India, Irkutsk, Japan, Kamchatka, MiddleEast, Mongolia, Siam, Siberia, Ural, Yakutsk,
        EasternAustralia, Indonesia, NewGuinea, WesternAustralia,
        Wild}
    public enum Suit {Artillery, Cavalry, Infantry, Wild}

    public static Suit[] suitArray = {Suit.Artillery, Suit.Cavalry, Suit.Infantry};

    private Country country;

    private Suit suit;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setWild() {
        setCountry(Country.Wild);
        setSuit(Suit.Wild);
    }

    public boolean isWild() {
        return getCountry() == Country.Wild;
    }

    public static Card getWildCard() {
        Card result = new Card();
        result.setWild();
        return result;
    }

    public static Suit[] getSuitArray() {
        return suitArray;
    }

    @Override
    public String toString() {
        return "Card{" +
                "country=" + country +
                ", suit=" + suit +
                '}';
    }
}
