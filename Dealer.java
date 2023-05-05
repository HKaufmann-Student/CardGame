/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that represents a card dealer
*/

import java.util.LinkedList; //imports linked lists

/* The Dealer class */
public class Dealer{
  protected Deck m_deck; //the dealers deck

  /*
  Dealer class
  default constructor
  */
  public Dealer(){
    m_deck = new Deck();
  }

  /*
  Dealer class
  deals
  n = length of cards to be removed
  returns a linked list of cards removed from the deck
  */
  public LinkedList<Card> deals(int n){
    LinkedList<Card> ll = new LinkedList<Card>();
    if(m_deck.m_cards.size() == 0){
      return ll;
    }
    for(int i = 0; i < n; i++){
      ll.add(m_deck.deal());
    }
    return ll;
  }

  /*
  Dealer class
  size
  returns an int representing the size of the dealer's deck
  */
  public int size(){
    return m_deck.size();
  }

  /*
  Dealer class
  toString
  returns a string that spells out all the cards in the dealer's deck
  */
  public String toString(){
    return m_deck.toString();
  }

  /*Accessors and Mutators*/

  public Deck getDeck(){
    return m_deck;
  }

  public void setDeck(Deck deck){
    m_deck = deck;
  }
}
