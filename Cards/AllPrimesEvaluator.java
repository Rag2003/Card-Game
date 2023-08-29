package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator for a hand in which the rank of each card is a prime number.
 * The number of cards required is equal to the hand size. 
 * 
 * The name of this evaluator is "All Primes".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class AllPrimesEvaluator extends AbstractEvaluator {
	
	//private int sizeOfhand;
	
//	private int rank;
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public AllPrimesEvaluator(int ranking, int handSize) {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	  super(ranking, handSize, "All Primes", handSize);
	//  rank = ranking;
	  //sizeOfhand = handSize;
  }


/**
 * this method checks if the conditions for the "All Primes" are satisfied
 * firstly sorted the array
 * then checked if length is less than the required cards
 * 
 */
public boolean canSatisfy(Card[] mainCards) {
	// TODO Auto-generated method stub
	int i;
	int j;
	int c = 0;
	Arrays.sort(mainCards);
	if(mainCards.length != cardsRequired()) {
		return false;
		//Required()) {
	}
	for(i = 0; i < mainCards.length; ++i) {
		for(j = 2; j < mainCards.length; ++j) {
			//}
			if(mainCards[i].getRank() % j == 0) {
				c += 1;
	        }
			//}
			else {
				c = 0;
	        }
	    }
	}
	if(c == 0) {
		return true;
	}
	//}
   return false;
}
}

