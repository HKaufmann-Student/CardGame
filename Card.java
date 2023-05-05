/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that represents a card
*/

/* The Card class */
public class Card{
  public static final int HEARTS = 0; //0 represents the Hearts suit
  public static final int SPADES = 1; //1 represents the Spades suit
  public static final int CLUBS = 2; //2 represents the Clubs suit
  public static final int DIAMONDS = 3; //3 represents the Diamonds suit

  public static final int JACK = 11; //11 represents a Jack
  public static final int QUEEN = 12; //12 represents a Queen
  public static final int KING = 13; //13 represents a King
  public static final int ACE = 14; //14 represents an Ace

  protected int m_value; //value of the card
  protected int m_suit; //suit of the card

  /*
  Card class
  default constructor
  */
  public Card(){
    m_value = 0;
    m_suit = 5;
  }

  /*
  Card class
  overloaded constructor
  value = value of the card
  suit = suit of the card
  */
  public Card(int value, int suit){
    m_value = value;
    m_suit = suit;
  }

  /*
  Card class
  copy constructor
  c = card that is being copied
  */
  public Card(Card c){
    this.m_value = c.m_value;
    this.m_suit = c.m_suit;
  }

  /*
  Card class
  toString
  returns a string that spells out the value and suit of the card
  */
  public String toString(){
    String ret = "";
    switch(m_value){
      case 11:
        ret += "Jack";
        break;
      case 12:
        ret += "Queen";
        break;
      case 13:
        ret += "King";
        break;
      case 14:
        ret += "Ace";
        break;
      default:
        ret += m_value;
    }
    ret += " of ";
    switch(m_suit){
      case 0:
        ret += "Hearts";
        break;
      case 1:
        ret += "Spades";
        break;
      case 2:
        ret += "Clubs";
        break;
      case 3:
        ret += "Diamonds";
        break;
      default:
        ret += "Not a Suit";
    }
    return ret;
  }

  /*
  Card class
  equals
  o = object to compare to
  returns a boolean by comparing a Card to other objects
  */
  public boolean equals(Object o){
    if(this == o){
      return true;
    }
    if(!(o instanceof Card)){
      return false;
    }
    Card c = (Card) o;
    return(this.m_value == c.m_value);
  }

  //accessors and mutators

  //mutators

  public void setValue(int value){
    m_value = value;
  }

  public void setSuit(int suit){
    m_suit = suit;
  }

  //accessors

  public int getValue(){
    return m_value;
  }

  public int getSuit(){
    return m_suit;
  }

  /*
  Card class
  suitToString
  returns a string representing the suit of a card
  */
  public String suitToString(){
    String ret = "";
    switch(m_suit){
      case 0:
        ret += "Hearts";
        break;
      case 1:
        ret += "Spades";
        break;
      case 2:
        ret += "Clubs";
        break;
      case 3:
        ret += "Diamonds";
        break;
      default:
        ret += "Not a Suit";
    }
  return ret;
  }
}
