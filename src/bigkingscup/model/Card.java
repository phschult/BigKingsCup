/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigkingscup.model;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author schphil
 */
public class Card {
    private Suit suit;
    private int number;
    private int i;
    private final Map<Integer, String> cards = new TreeMap<>();
    
    public Card(final Suit aSuit, final int aNumber) {
        this.suit = aSuit;
        this.number = aNumber;
        createCards();
    }
    
    public int getNumber() {
        return number;
    }
    
    private void createCards(){
        String [] values = new String[]{"Ace", "Two", "Three", "Four", "Five", 
             "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", 
             "Ace"}; 
        for(String value : values) {
            insertCardValues(value);
        }
    }
    
    private void insertCardValues(final String num) {
        cards.put(i, num);
        i++;
    }
    
    public Suit getSuit(){
        return this.suit;
    }
    
    @Override
    public String toString() {
        return cards.get(number) + "Of" + suit.toString();
    }
}
