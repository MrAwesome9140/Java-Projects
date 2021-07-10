// Card.java     12-26-14
// This is the "unit" class that stores information about a single card. 
// *********************************************************************
// The "Elevens" AP Lab is created for the College Board APCS
// curriculum by Michael Clancy, Robert Glen Martin and Judith Hromcik.
// Leon Schram has altered this "Elevens" AP Lab file to focus on 
// CS topics as the "Elevens" Lab is integrated into the curriculum.

interface CardInterface{

   String getSuit();
   String getRank();
   int getValue();
   void setSuit(String suit);
   void setRank(String rank);
   void setValue(int value);
   String toString();
   boolean matches(Card otherCard);

}

abstract class AbstractCard implements CardInterface{

   private String suit;
   private String rank;
   private int value;

   public AbstractCard(String suit, String rank, int value){
      this.suit = suit; //Set suit
      this.rank = rank; // Set rank
      this.value = value; // Set value
   }

   @Override
   public String getSuit() { return suit; }
   @Override
   public String getRank() { return rank; }
   @Override
   public int getValue()   { return value; }

   @Override
   public void setSuit(String suit) {this.suit = suit;}
   @Override
   public void setRank(String rank) {this.rank = rank;}
   @Override
   public void setValue(int value)  {this.value = value;}

   public abstract boolean matches(Card otherCard);

   public abstract String toString();
}

public class Card extends AbstractCard{

   public Card(String s, String r, int v) {
      super(s, r, v); // Call AbstractCard constructor
   }

   @Override
   public boolean matches(Card otherCard) {
		return otherCard.getSuit().equals(super.getSuit())
			 && otherCard.getRank().equals(super.getRank())
			 && otherCard.getValue() == super.getValue(); //Check if cards are equal
	}

   @Override
   public String toString()
   {
      return "[" + super.getSuit() + ", " + super.getRank() + ", " + super.getValue() + "]";
   }
}

