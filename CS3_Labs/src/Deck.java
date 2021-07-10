// Deck03.java     12-26-14
// The <display> method is now replaced by the <toString> method.
// This version is implemented with "dynamic arrays".
// ********************************************************************
// The "Elevens" AP Lab is created for the College Board APCS
// curriculum by Michael Clancy, Robert Glen Martin and Judith Hromcik.
// Leon Schram has altered this "Elevens" AP Lab file to focus on 
// CS topics as the "Elevens" Lab is integrated into the curriculum.

import java.util.ArrayList;
import java.util.Scanner;

interface DeckInterface{

	final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"}; // All Suits
	final String[] ranks = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"}; // All Ranks
	final int[] values = {1,2,3,4,5,6,7,8,9,10,11,12,13}; // All Card Values

	String toString();
	void shuffle();
}

abstract class AbstractDeck implements DeckInterface{

	private ArrayList<Card> cards;
	private int size;

	public AbstractDeck(){
		size = 52; // Size of the deck is 52
		cards = new ArrayList<>(); // Instantiate ArrayList
		for(int i = 0; i<suits.length; i++){
			for(int j = 0; j<ranks.length; j++){ // Iterate through each type of suit and rank combination
				cards.add(new Card(suits[i], ranks[j], values[j])); // Add all possible card combination to ArrayList
			}
		}
		shuffle(); // Shuffle the deck
	}

	public int getSize() { return size; }

	public ArrayList<Card> getCards() { return cards; }

	@Override
	public void shuffle(){
		int i = 0;
		while(i<52){ // Continue iterating through ArrayList until all cards are shuffled
			int randoLeftover = (int)(Math.random()*(52-i))+i; // Get a random value between the indices not shuffled yet
			Card temp = cards.get(randoLeftover); // Get the random card that hasn't been shuffled yet
			cards.remove(temp);
			cards.add(0, temp); // Move random card to beginning of the ArrayList
			i++; // Increment amount of cards shuffled
		}
	}
}

public class Deck extends AbstractDeck{

	public Deck() {
		super(); // Call AbstractDeck construct
		ArrayList<Card> cards = super.getCards(); // Get superclass' cards arraylist
		System.out.println(cards+"\n"); // print out cards
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like the reshuffle the deck? (Y for yes/N for no)"); // Ask user if they want to reshuffle
		String ans = sc.next();
		if(ans.toLowerCase().equals("y")) // Shuffle if user wants to
			shuffle();
	}

	@Override
	public void shuffle() {
		super.shuffle(); // Call superclass shuffle method to shuffle deck
	}

	public String toString() {
  	 	 String temp = "";
    	 for (int k = 0; k < super.getSize(); k++)
    	    temp = temp + super.getCards().get(k).toString() + "\n";
    	 return temp;   
  	}
 
}


