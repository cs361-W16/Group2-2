package models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/25/16.
 */
public class testGame {

    // TEST TO CREATE GAME
    // US VERSION
    @Test
    public void testGameCreation(){
        usGame g = new usGame();
        assertNotNull(g);
    }

    // SP VERSION
    @Test
    public void testGameCreationSP(){
        spGame g = new spGame();
        assertNotNull(g);
    }

    // TEST FOR DECK
    // US VERSION
    @Test
    public void testGameBuildDeck() {
        usGame g = new usGame();
        // WHY I CANT USE BUILDDECKSP?
        g.buildDeck();
        assertEquals(52, g.deck.size());
    }

    // SP VERSION
    @Test
    public void testGameBuildDeckSP(){
        spGame g = new spGame();
        // WHY I CANT USE BUILDDECKSP?
        g.buildDeck();
        assertEquals(40,g.deck.size());
    }

    // TEST FOR INITIALIZATION
    // US VERSION
    @Test
    public void testGameInit(){
        usGame g = new usGame();
        g.buildDeck();
        g.shuffle();
        assertNotEquals(2,g.deck.get(0).getValue());
    }

    // SP VERSION
    public void testGameInitSP(){
        spGame g = new spGame();
        g.buildDeck();
        g.shuffle();
        // Has to be zero, since lowest card no longer 2
        assertNotEquals(0,g.deck.get(0).getValue());
    }

    // TEST FOR CARD DISTRIBUTION DURING GAME START
    // US VERSION
    @Test
    public void testGameStart(){
        usGame g = new usGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }

    // SP VERSION
    public void testGameStartSP(){
        spGame g = new spGame();
        g.buildDeck();
        g.shuffle();
        g.dealFour();
        assertEquals(1,g.cols.get(0).size());
        assertEquals(1,g.cols.get(1).size());
        assertEquals(1,g.cols.get(2).size());
        assertEquals(1,g.cols.get(3).size());
    }

    // TEST FOR CARD DEAL
    // US VERSION
    @Test
    public void testCustomDeal(){
        usGame g = new usGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.cols.get(0).get(0).toString());
        assertEquals("3Clubs",g.cols.get(1).get(0).toString());
        assertEquals("4Clubs",g.cols.get(2).get(0).toString());
        assertEquals("5Clubs",g.cols.get(3).get(0).toString());
    }

    // SP VERSION
    @Test
    public void testCustomDealSP(){
        spGame g = new spGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        assertEquals("2Clubs",g.cols.get(0).get(0).toString());
        assertEquals("3Clubs",g.cols.get(1).get(0).toString());
        assertEquals("4Clubs",g.cols.get(2).get(0).toString());
        assertEquals("5Clubs",g.cols.get(3).get(0).toString());
    }

    // TEST FOR CARD REMOVAL
    // US VERSION
    @Test
    public void testRemoveFunction(){
        usGame g = new usGame();
        g.buildDeck();
        g.customDeal(0,3,6,9);
        g.remove(2);
        assertEquals(0,g.cols.get(2).size());
    }


}
