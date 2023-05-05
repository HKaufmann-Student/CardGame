/*
Hayden Kaufmann
2402222
hkaufmann@chapman.edu
CPSC 231-03
MP3, Part B: Crazy Eights!

This assignment implements a class that tests cards
*/

/* The TestCards class */
public class TestCards{

  /*
  TestCards class
  main method
  */
  public static void main(String[] args) {
    Card c1 = new Card(); //default card
    System.out.println(c1.toString()); //prints default card
    Card c2 = new Card(11,3); //creates c2
    System.out.println(c2.toString()); //prints c2
    Card c3 = new Card(11,3); //creates same card as c2
    System.out.println(c3.toString()); //prints c3
    System.out.println(c2.equals(c3)); //compares c2 to c3
    Card c4 = new Card(c3); //copy constructs c4 from c3
    System.out.println(c2.equals(c4)); //compares c4 to c2

    Deck d1 = new Deck(); //default deck
    System.out.println(d1.toString()); //prints default deck
    System.out.println(d1.size()); //prints size of default deck
    System.out.println(d1.deal()); //prints the random card removed from the deck
    System.out.println(d1.size()); //shows the decreased size of the deck
    Deck d2 = new Deck(d1); //creates same deck as d1
    System.out.println(d2.toString()); //prints d2
    System.out.println(d2.size()); //shows that d2 is the same size as d1

    Dealer de1 = new Dealer(); //creates defauly dealer
    System.out.println(de1.toString()); //prints the dealers deck
    System.out.println(de1.size()); //prints the size of the dealers deck
    System.out.println(de1.deals(4)); //prints the linked list of size 4 that was removed from the deck
    System.out.println(de1.toString()); //prints the smaller deck
    System.out.println(de1.size()); //shows the new size of the deck
  }
}
