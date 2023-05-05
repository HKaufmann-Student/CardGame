/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that represents a deck of cards
*/

import java.util.LinkedList; //imports linked lists

/* The Deck class */
public class Deck{
  protected LinkedList<Card> m_cards; //the linked list of cards

  /*
  Deck class
  default constructor
  */
  public Deck(){
    LinkedList<Card> d = new LinkedList<Card>();
    for(int i = 0; i <= 3; i++){
      for(int j = 2; j <= 14; j++){
        Card c = new Card(j,i);
        d.add(c);
      }
    }
    m_cards = d;
  }

  /*
  Deck class
  copy constructor
  d = deck that is being copied
  */
  public Deck(Deck d){
    LinkedList<Card> e = new LinkedList<Card>();
    for(int i = 0; i < d.m_cards.size(); i++){
      Card c = new Card(d.m_cards.get(i));
      e.add(i, c);
    }
    m_cards = e;
  }

  /*
  Deck class
  toString
  returns a string that spells out all the cards in the deck
  */
  public String toString(){
    String ret = m_cards.get(0).toString();
    for(int i = 1; i < m_cards.size(); i++){
      ret += ", " + m_cards.get(i).toString();
    }
    return ret;
  }

  /*
  Deck class
  size
  returns an int representing the size of the deck
  */
  public int size(){
    return m_cards.size();
  }

  /*
  Deck class
  deal
  returns an random card and removes it from the deck
  */
  public Card deal(){
    int rand = (int) Math.floor(Math.random() * (m_cards.size() - 1)); //a random number between 0 and the length of the deck of cards
    Card temp = m_cards.get(rand);
    m_cards.remove(rand);
    return temp;
  }
}
