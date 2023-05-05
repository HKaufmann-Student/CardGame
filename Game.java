/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that represents a game of cards
*/


import java.util.LinkedList; //imports linked lists

/* The Game class */
public class Game{
  private Player m_player1; //Player1 in the game
  private Player m_player2; //Player2 in the game
  private Dealer m_dealer; //Game's dealer
  private LinkedList<Card> m_starterPile; //the starter pile of the game
  private Deck m_deck; //the stock / deck

  /*
  Game class
  default constructor
  */
  public Game(){
    m_dealer = new Dealer();
    m_deck = m_dealer.getDeck();
    m_starterPile = m_dealer.deals(1);
    m_player1 = new Player(1, m_dealer, m_starterPile);
    m_player2 = new Player(2, m_dealer, m_starterPile);
  }

  /*
  Game class
  play
  returns the winning player of a simulated game
  */
  public Player play(){
    Card temp = new Card();
    int turn = 1;
    boolean p1b = false;
    boolean p2b = false;
    while(m_player1.getHand().size() > 0 && m_player2.getHand().size() > 0){
      if(p1b == true && p2b == true){
        System.out.println("Game Over");
        if(m_player1.getHand().size() > m_player2.getHand().size()){
          return m_player2;
        }
        else{
          return m_player1;
        }
      }
      System.out.println("Player 1: " + m_player1.getHand().toString());
      System.out.println("Starter pile: " + m_starterPile.toString());
      System.out.println("Player 2: " + m_player2.getHand().toString());
      System.out.println();
      if(turn == 1){
        temp = m_player1.takeTurn();
        if(temp == null){
          System.out.println("Player 1 passes");
          turn = 2;
          p1b = true;
          continue;
        }
        m_starterPile.add(temp);
        turn = 2;
        p1b = false;
        System.out.println("Player1 plays " + temp.toString());
        continue;
      }
      if(turn == 2){
        temp = m_player2.takeTurn();
        if(temp == null){
          System.out.println("Player 2 passes");
          turn = 1;
          p2b = true;
          continue;
        }
        m_starterPile.add(temp);
        turn = 1;
        p2b = false;
        System.out.println("Player2 plays " + temp.toString());
        continue;
      }
    }
    System.out.println("Game Over");
    if(m_player1.getHand().size() > m_player2.getHand().size()){
      return m_player2;
    }
    else{
      return m_player1;
    }
  }

  /*
  Game class
  playQ
  returns the winning player of a simulated game - without print / println for better formatting
  */
  public Player playQ(){
    Card temp = new Card();
    int turn = 1;
    boolean p1b = false;
    boolean p2b = false;
    while(m_player1.getHand().size() > 0 && m_player2.getHand().size() > 0){
      if(p1b == true && p2b == true){
        if(m_player1.getHand().size() > m_player2.getHand().size()){
          return m_player2;
        }
        else{
          return m_player1;
        }
      }
      if(turn == 1){
        temp = m_player1.takeTurnQ();
        if(temp == null){
          turn = 2;
          p1b = true;
          continue;
        }
        m_starterPile.add(temp);
        turn = 2;
        p1b = false;
        continue;
      }
      if(turn == 2){
        temp = m_player2.takeTurnQ();
        if(temp == null){
          turn = 1;
          p2b = true;
          continue;
        }
        m_starterPile.add(temp);
        turn = 1;
        p2b = false;
        continue;
      }
    }
    if(m_player1.getHand().size() > m_player2.getHand().size()){
      return m_player2;
    }
    else{
      return m_player1;
    }
  }

  /*
  Game class
  getTotalEightsPlayed
  returns the number of eights played in a game;
  */
  public int getTotalEightsPlayed(){
    return m_player1.getEightsPlayed() + m_player2.getEightsPlayed();
  }

  /*Accessors and Mutators*/

  public Player getPlayer1(){
    return m_player1;
  }

  public Player getPlayer2(){
    return m_player2;
  }

  public Dealer getDealer(){
    return m_dealer;
  }

  public LinkedList<Card> getStarterPile(){
    return m_starterPile;
  }

  public Deck getDeck(){
    return m_deck;
  }

  public void setPlayer1(Player player1){
    m_player1 = player1;
  }

  public void setPlayer2(Player player2){
    m_player2 = player2;
  }

  public void setDealer(Dealer dealer){
    m_dealer = dealer;
  }

  public void setStarterPile(LinkedList<Card> pile){
    m_starterPile = pile;
  }

  public void setDeck(Deck deck){
    m_deck = deck;
  }
}
