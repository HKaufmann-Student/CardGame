/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that represents a Crazy Eights player
*/

import java.util.LinkedList; //imports linked lists

/* The Player class */
public class Player{
  private int m_numPlayer; //represents what number this player is (1 or 2)
  private LinkedList<Card> m_hand; //the player's linked list of cards
  private Dealer m_dealer; //the current dealer
  private LinkedList<Card> m_starterPile; //the current starter pile
  private int m_eightsPlayed; //the amount of eights this player has played

  /*
  Player class
  default constructor
  numPlayer = what number player this
  dealer = the game's dealer
  starterPile = the game's starterPile
  creates a Player
  */
  public Player(int numPlayer, Dealer dealer, LinkedList<Card> starterPile){
    m_hand = new LinkedList<Card>();
    m_numPlayer = numPlayer;
    m_dealer = dealer;
    m_hand = m_dealer.deals(5);
    m_starterPile = starterPile;
  }

  /*
  Player class
  takeTurn
  returns a card that can be played based on the starterPile and removes it from hand
  */
  public Card takeTurn(){
    Card c = null;
    for(int i = 0; i < m_hand.size(); i++){
      if((int) Math.floor(Math.random() * (10)) == 1 && m_hand.get(i).getValue() == 8){ //10% chance to use an 8
        c = m_hand.get(i);
        m_hand.remove(i);
        c.setSuit(newSuit());
        System.out.println("Player" + m_numPlayer + " changed the suit to " + c.suitToString());
        m_eightsPlayed++;
        return c;
      }
      if(m_hand.get(i).getSuit() == m_starterPile.getLast().getSuit() || m_hand.get(i).getValue() == m_starterPile.getLast().getValue()){ //first card that has the same suit or same value
        c = m_hand.get(i);
        m_hand.remove(i);
        if(c.getValue() == 8){
          c.setSuit(newSuit());
          System.out.println("Player" + m_numPlayer + " changed the suit to " + c.suitToString());
          m_eightsPlayed++;
        }
        return c;
      }
    }
    for(int i = 0; i < m_hand.size(); i++){
      if(m_hand.get(i).getValue() == 8){ //uses 8 if no other card works
        c = m_hand.get(i);
        m_hand.remove(i);
        c.setSuit(newSuit());
        System.out.println("Player" + m_numPlayer + " changed the suit to " + c.suitToString());
        m_eightsPlayed++;
        return c;
      }
    }
    for(int i = 0; i < m_hand.size(); i++){
      if(m_hand.get(i).getValue() != m_starterPile.getLast().getValue() && m_hand.get(i).getSuit() != m_starterPile.getLast().getSuit() && m_dealer.getDeck().size() > 0){ //draws a card if no other option
        Card t = m_dealer.getDeck().deal();
        m_hand.add(t);
        System.out.println("Player" + m_numPlayer + " drew a " + t.toString());
        return takeTurn();
      }
    }
    return c;
  }

  /*
  Player class
  takeTurnQ
  returns a card that can be played based on the starterPile and removes it from hand - without print / println for better formatting
  */
  public Card takeTurnQ(){
    Card c = null;
    for(int i = 0; i < m_hand.size(); i++){
      if((int) Math.floor(Math.random() * (10)) == 1 && m_hand.get(i).getValue() == 8){ //10% chance to use 8
        c = m_hand.get(i);
        m_hand.remove(i);
        c.setSuit(newSuit());
        m_eightsPlayed++;
        return c;
      }
      if(m_hand.get(i).getSuit() == m_starterPile.getLast().getSuit() || m_hand.get(i).getValue() == m_starterPile.getLast().getValue()){ //first card that has the same suit or same value
        c = m_hand.get(i);
        m_hand.remove(i);
        if(c.getValue() == 8){
          c.setSuit(newSuit());
          m_eightsPlayed++;
        }
        return c;
      }
    }
    for(int i = 0; i < m_hand.size(); i++){
      if(m_hand.get(i).getValue() == 8){ //uses 8 if no other card works
        c = m_hand.get(i);
        m_hand.remove(i);
        c.setSuit(newSuit());
        m_eightsPlayed++;
        return c;
      }
    }
    for(int i = 0; i < m_hand.size(); i++){
      if(m_hand.get(i).getValue() != m_starterPile.getLast().getValue() && m_hand.get(i).getSuit() != m_starterPile.getLast().getSuit() && m_dealer.getDeck().size() > 0){ //draws a card if no other option
        Card t = m_dealer.getDeck().deal();
        m_hand.add(t);
        return takeTurnQ();
      }
    }
    return c;
  }

  /*
  Player class
  newSuit
  returns a random number between 1 - 4 to represent a random
  */
  public int newSuit(){
    return (int) Math.floor(Math.random() * (4));
  }

  /*
  Player class
  getPoints
  returns the points of the player's hand
  */
  public int getPoints(){
    int points = 0;
    for(int i = 0; i < m_hand.size(); i++){
      switch(m_hand.get(i).getValue()){
        case 8:
          points += 50;
          break;
        case 13:
        case 12:
        case 11:
        case 10:
          points += 10;
          break;
        case 14:
          points += 1;
        default:
          points += m_hand.get(i).getValue();
          break;
      }
    }
    return points;
  }

  /*Accessors and Mutators*/

  public LinkedList<Card> getHand(){
    return m_hand;
  }

  public int getEightsPlayed(){
    return m_eightsPlayed;
  }

  public int getNumPlayer(){
    return m_numPlayer;
  }

  public void setNumPlayer(int num){
    m_numPlayer = num;
  }

  public void setHand(LinkedList<Card> hand){
    m_hand = hand;
  }

  /*
  Player class
  toString
  returns a string that spells out Player and its number
  */
  public String toString(){
    return "Player" + m_numPlayer;
  }
}
