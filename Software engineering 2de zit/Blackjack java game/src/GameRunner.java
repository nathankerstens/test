/**
 * 
 * @author Imke Van Rompa
 *
 */
import java.util.Scanner;

public class GameRunner {

	public static void main(String[] args) {
		

		//initiate scanner
		Scanner scanner = new Scanner(System.in);
		//initiate deck
		Deck theDeck = new Deck(1, true);
		
		//initiate player objects
		Player me = new Player("Imke");
		Player dealer = new Player("Dealer");
		
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		me.addCard(theDeck.dealNextCard());
		dealer.addCard(theDeck.dealNextCard());
		
		//print initial hands
		System.out.println("Cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		//flags for when each player is finished hitting
		boolean meDone	   = false;
		boolean dealerDone = false;
		String answer;
		
		while (!meDone || !dealerDone)
		{
			// player"s turn
			if(!meDone){
				
				System.out.print("Hit or Stay (enter H or S: ");
				answer = scanner.next();
				System.out.println();
				
				// if the player hits
				if (answer.compareToIgnoreCase("H") == 0){
					
					// add next card in the deck and store whether player is 
					//busted
					meDone = !me.addCard(theDeck.dealNextCard());
					me.printHand(true);
					
				}
				else{
					meDone =  true;
					
				}
			}
			
			//dealer's turn
			
			if(!dealerDone){
				if(dealer.getHandSum() < 17){
					System.out.println("The dealer hits\n");
					dealerDone = !dealer.addCard(theDeck.dealNextCard());
					dealer.printHand(false);
				}
				else{
					System.out.println("The dealer stays\n");
					dealerDone = true;
				}
				
			}
			System.out.println();
		}
		
		scanner.close();
		
		// print final hands
		me.printHand(true);
		dealer.printHand(true);
		
		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();
		
		if(mySum > dealerSum && mySum <= 21 || dealerSum > 21){
			System.out.println("Awesome , you Win!");
		}else{
			System.out.println("Dealer wins! ");
		}

	}

}
