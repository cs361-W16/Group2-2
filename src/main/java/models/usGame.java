
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class usGame extends Game {
    // For normal version, we have: 2, 3, 4, 5, 6, 7, 8, 9, J, Q, K, A
    // Total: 52
    public void buildDeck() {
        // i < 15 means until 14 (each suit 14 cards)
        for (int i = 2; i < 15; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Hearts));
            deck.add(new Card(i, Suit.Diamonds));
            deck.add(new Card(i, Suit.Spades));
        }
    }

}