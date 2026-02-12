package com.game.bj.service;

import com.game.bj.dto.Card;
import com.game.bj.dto.Rank;
import com.game.bj.dto.Suit;
import com.game.bj.exception.DeckException;
import java.util.Collections;
import java.util.Stack;
import lombok.SneakyThrows;

public class DeckService {
    private Stack<Card> deck = new Stack<>();

    @SneakyThrows
    public void createDeck(int deckNumber){
        deck.clear();

        if (deckNumber < 1 || deckNumber > 8){
            throw  new DeckException("Number og deck must be between 1 to 8");
        }

        for (int i = 0; i < deckNumber; i++){
            for (Rank rank : Rank.values()){
                for (Suit suit : Suit.values()){
                    deck.add(new Card(suit, rank));
                }
            }
        }
        Collections.shuffle(deck);
    }

    public Stack<Card> getDeck(){
        return deck;
    }

    public int getCardCount(){
        return deck.size();
    }

    public Card dealCard(){
        return deck.pop();
    }

}
