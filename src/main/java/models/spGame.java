
package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class spGame extends Game {
    // For spanish version, we have: A, 2, 3, 4, 5, 6, 7, J, k (knight), K (King)
    // Total: 40
    public void buildDeck() {
        // i starts from 1 and i < 12 means until 10 (each suit 10 cards)
        for (int i = 1; i < 11; i++) {
            deck.add(new Card(i, Suit.Clubs));
            deck.add(new Card(i, Suit.Cups));
            deck.add(new Card(i, Suit.Swords));
            deck.add(new Card(i, Suit.Golds));
        }
    }
}