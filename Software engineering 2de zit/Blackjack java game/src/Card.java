
/**
 * 
 * @author Imke Van Rompa
 *
 */
public class Card {

	
	private Suit mySuit;
	private int myNumber;
	
	/**
	 * Card constructor
	 * 
	 * @param aSuit  holds the suit of a card
	 * @param aNumber holds the number of a card
	 */
	
	public Card(Suit aSuit,int aNumber ){
		
		
		this.mySuit = aSuit;
		
		// check if aNumber is not a negative number or higher than 13 
		if (aNumber >= 1 && aNumber <= 13){
			
			this.myNumber = aNumber;
			
		}
		else{
			System.err.println(aNumber +" is not a valid card value");
			System.exit(-1); // exiit program
		}
	}
	/**
	 * Return the number of the card
	 * 
	 * @return the number
	 */
	
	public int getNumber(){
		
		return myNumber;
	}
	
	/**
	 * 
	 * returns the name of a card
	 */
	
	public String toString(){
		
		String numStr = "error"; // if numStr remains error at the end = bug 
		
		switch(this.myNumber){

		case 1:
			numStr = "Ace";
			break;
			
		case 2:
			numStr = "Two";
			break;

		case 3:
			numStr = "Three";
			break;
			
		case 4:
			numStr = "Four";
			break;
		
		case 5:
			numStr = "Five";
			break;
		
		case 6:
			numStr = "Six";
			break;
		
		case 7:
			numStr = "Seven";
			break;
			
		case 8:
			numStr = "Eight";
			break;
			
		case 9: 
			numStr = "Nine";
			break;
			
		case 10:
			numStr = "Ten";
			break;
			
		case 11: 
			numStr = "Jack";
			break;
			
		case 12:
			numStr = "Queen";
			break;
			
		case 13:
			numStr = "King";
			break;
			

		
		
		}
		
		return numStr + " of " + mySuit.toString();
	}
}
