package com.game.bj.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.game.bj.dto.Card;
import com.game.bj.exception.DeckException;
import java.util.Stack;
import org.junit.jupiter.api.Test;

class DeckServiceTest {

    @Test
    void createDeck() {
        DeckService ds =  new DeckService();
        ds.createDeck(1);
        assertEquals(52, ds.getDeck().size());

        ds.createDeck(2);
        assertEquals(104, ds.getDeck().size());
    }

    @Test
    void createDeck_EXCEPTION() {
        DeckService ds =  new DeckService();
        assertThrows(DeckException.class, () -> ds.createDeck(0));
        assertThrows(DeckException.class, () -> ds.createDeck(9));
        assertDoesNotThrow(() -> ds.createDeck(5));
    }

    @Test
    void getDeck() {
        DeckService ds =  new DeckService();
        ds.createDeck(1);
        assertNotNull(ds.getDeck());
        assertTrue(ds.getDeck() instanceof Stack<Card>);
    }

    @Test
    void getCardCount() {
        DeckService ds =  new DeckService();
        ds.createDeck(1);
        assertEquals(52, ds.getCardCount());
    }

    @Test
    void dealCard() {
        DeckService ds =  new DeckService();
        ds.createDeck(1);
        ds.dealCard();
        assertEquals(51, ds.getCardCount());
    }
}
