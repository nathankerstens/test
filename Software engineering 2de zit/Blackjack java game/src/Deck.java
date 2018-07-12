
import java.util.Random;

/**
 *
 * 
 * @author Imke Van Rompa
 *
 */
public class Deck {

	/**
	 * Array of cards , where the top card is the first index
	 */
	private Card[] myCards;
	
	/**
	 * The number of cards currently still in deck
	 */
	private int numCards;
	
	/**
	 * Constructor with a default of one deck and no shuffle
	 */
	public Deck()
	{
		//call other constructor, defining one deck without shuffling
		this(1, false);
		
	}
	/**
	 * Constructor defines the number of decks that will be used and if they are shuffled 
	 * 
	 * @param numDeck number of decks that will be used (each deck consist of 52 cards)
	 * @param shuffle whether the cards need to be shuffled 
	 */
	
	public Deck(int numDecks, boolean shuffle){
		
		this.numCards = numDecks *52;
		this.myCards =  new Card[this.numCards];
		
		// initiate card index
		int cIndex = 0;
		
		// loop deck
		for(int d = 0; d < numDecks; d++){
			
			// loop suit
			for(int s = 0; s < 4; s++)
			{
				
				//loop number
				for (int n = 1; n <= 13; n++){
					
					// add a new card to deck
					this.myCards[cIndex] = new Card(Suit.values()[s], n);
					cIndex ++;
					
				}
			}
		}
		// end for loops
		
		//shuffle if necessary
		
		if(shuffle){
			this.shuffle();
		}
	}

	public void shuffle(){
		//new Random
		Random rnd = new Random();
		//temporary card
		Card temp;
		
		int j;
		for( int i = 0; i < this.numCards; i++){
			
			//get a random card j to swap i's value with
			j = rnd.nextInt(this.numCards);
			
			// swap
			temp = this.myCards[i];
			this.myCards[i] = this.myCards[j];
			this.myCards[j] = temp;
		}
	}

	public Card dealNextCard(){
		
		// get the top card
		
		Card top = this.myCards[0];
		
		//shift all the subsequent cards to the left by one index
		
		for(int c = 1; c < this.numCards; c++){
			
			this.myCards[c-1] = this.myCards[c];
			
		}
		this.myCards[this.numCards-1] = null;
		
		//-- the number of cards in our deck
		this.numCards--;
		
		return top;
	}

public void printDeck(int numToPrint){
	
	for (int c = 0; c < numToPrint; c++){
		
		System.out.printf("% 3d/%d %s\n", c+1, this.numCards, this.myCards[c].toString());
	}
	System.out.printf("\t\t[%d others]\n", this.numCards-numToPrint);
}


}
