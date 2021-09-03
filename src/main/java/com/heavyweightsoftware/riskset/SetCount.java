package com.heavyweightsoftware.riskset;

public class SetCount {
    public static void main(String[] args) {
        Deck deck = new Deck();
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;

        for (int ix = 0; ix < 100000; ++ix) {
            Hand hand = new Hand();

            while (!hand.isSet()) {
                hand.add(deck.draw());
            }

            switch (hand.size()) {
                case 3:
                    count3++;
                    break;

                case 4:
                    count4++;
                    break;

                case 5:
                    count5++;
                    break;
            }

            deck.reset();
        }

        System.out.println("count3:" + count3);
        System.out.println("count4:" + count4);
        System.out.println("count5:" + count5);
    }
}
