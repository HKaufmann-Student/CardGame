/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that simulates the game of Crazy Eights
*/

import java.util.LinkedList; //imports linked lists

/* The Simulation class */
public class Simulation{
  private int m_gamesToPlay; //given quantity of games to play
  private int m_player1Wins = 0; //the amount of games won by player1
  private int m_player2Wins = 0; //the amount of games won by player2
  private int m_player1Points = 0; //the amount of points gotten by player1
  private int m_player2Points = 0; //the amount of points gotten by player2
  private double m_cardsHeldByLoser = 0; //the amount of cards on average held by the loser
  private double m_stockEmpty = 0; //the number of times that the stock ran out before the game could end
  private double m_averageEightsPlayed = 0; //the average number of times 8 was played per game

  /*
  Simulation class
  default constructor
  gamesToPlay = how many games should be simulated
  */
  public Simulation(int gamesToPlay){
    m_gamesToPlay = gamesToPlay;
  }

  /*
  Simulation class
  simulate
  simulates given amount of times
  */
  public void simulate(){
    for(int i = 0; i < m_gamesToPlay; i++){
      Game temp = new Game();
      Player p = temp.playQ();
      if(temp.getDeck().size() > 0){
        m_stockEmpty++;
      }
      if(p == temp.getPlayer1()){
        m_player1Wins++;
        m_player1Points += temp.getPlayer2().getPoints();
        m_cardsHeldByLoser += (double) temp.getPlayer2().getHand().size();
      }
      else{
        m_player2Wins++;
        m_player2Points += temp.getPlayer1().getPoints();
        m_cardsHeldByLoser += (double) temp.getPlayer1().getHand().size();
      }
      m_averageEightsPlayed = (double) temp.getTotalEightsPlayed();
    }
  }

  /*
  Simulation class
  calculate
  turns the m_cardsHeldByLoser and m_averageEightsPlayed into averages
  */
  public void calculate(){
    m_cardsHeldByLoser = m_cardsHeldByLoser / m_gamesToPlay;
    m_averageEightsPlayed = m_averageEightsPlayed / m_gamesToPlay;
  }

  /*
  Simulation class
  report
  prints formatted statistics from games
  */
  public void report(){
    System.out.println("In " + m_gamesToPlay + " games, the stats were:");
    System.out.println("\tPlayer1 won " + m_player1Wins + " times");
    System.out.println("\tPlayer1 got " + m_player1Points + " points");
    System.out.println("\tPlayer2 won " + m_player2Wins + " times");
    System.out.println("\tPlayer2 got " + m_player2Points + " points");
    System.out.println("\tThe average number of cards held by the losing player was " + m_cardsHeldByLoser);
    System.out.println("\tThe number of times the stock went empty was " + m_stockEmpty);
    System.out.println("\tThe averge number of eights played per game was " + m_averageEightsPlayed);
  }

  /*
  Simulation class
  main method
  */
  public static void main(String[] args) {
    int simulations = Integer.parseInt(args[0]);
    Simulation s = new Simulation(simulations);
    s.simulate();
    s.calculate();
    s.report();
  }

  /*Accessors and Mutators*/

  public int getGamesToPlay(){
    return m_gamesToPlay;
  }

  public int getPlayer1Wins(){
    return m_player1Wins;
  }

  public int getPlayer2Wins(){
    return m_player2Wins;
  }

  public int getPlayer1Points(){
    return m_player1Points;
  }

  public int getPlayer2Points(){
    return m_player2Points;
  }

  public double getAvgCardsHeldByLoser(){
    return m_cardsHeldByLoser;
  }

  public double getStockEmpty(){
    return m_stockEmpty;
  }

  public double getAverageEightsPlayed(){
    return m_averageEightsPlayed;
  }

  public void setGamesToPlay(int games){
    m_gamesToPlay = games;
  }

  public void setPlayer1Wins(int wins){
    m_player1Wins = wins;
  }

  public void setPlayer2Wins(int wins){
    m_player2Wins = wins;
  }

  public void setPlayer1Points(int points){
    m_player1Points = points;
  }

  public void setPlayer2Points(int points){
    m_player2Points = points;
  }

  public void setCardsHeldByLoser(double cards){
    m_cardsHeldByLoser = cards;
  }

  public void setStockEmpty(double amnt){
    m_stockEmpty = amnt;
  }

  public void setAverageEightsPlayed(double amnt){
    m_averageEightsPlayed = amnt;
  }
}
