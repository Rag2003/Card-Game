package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator for a hand containing (at least) four cards of the same rank.
 * The number of cards required is four.
 * 
 * The name of this evaluator is "Four of a Kind".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FourOfAKindEvaluator extends AbstractEvaluator {
	
	private int sizeOfhand;
	
//	private int rank;
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public FourOfAKindEvaluator(int ranking, int handSize) {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	  super(ranking, handSize, "Four of a kind", 4);
	//  rank = ranking;
	  sizeOfhand = handSize;
  }



/**
 * this method checks if the conditions for the "Four of a Kind" are satisfied
 * firstly sorted the array
 * then checked the length of the input with other conditions
 * returns false if length is less than the input
 * 
 */
public boolean canSatisfy(Card[] mainCards) {
	// TODO Auto-generated method stub
	boolean x = false;
	Arrays.sort(mainCards);
	if(mainCards.length != cardsRequired()) {
		x = false;
	}
	//}
	else if(mainCards[0].compareToIgnoreSuit(mainCards[1]) == 0 && mainCards[1].compareToIgnoreSuit(mainCards[2]) == 0 && mainCards[2].compareToIgnoreSuit(mainCards[3]) == 0) {
		x = true;
	}
  return x;
  //}
}


@Override
/**
* this method returns the best prioritized combination of cards
* the cards of the highest priority is returned
* firstly checked if the length of the input is greater or equal to the sizeOfhand
* then created the array of type card
* then created another array of integer type
 */
public Hand getBestHand(Card[] allCards) {
	// TODO Auto-generated method stub
	int i;
	if(allCards.length >= sizeOfhand) {
		Arrays.sort(allCards);
		for(i = 0; i < allCards.length - 3; ++i) {
			//mainCards[1].compareToIgnoreSuit(mainCards[2])
			Card[] card = new Card[cardsRequired()];
			card[0] = allCards[i];
			card[1] = allCards[i + 1];
			//}
			card[2] = allCards[i + 2];
			card[3] = allCards[i + 3];
		    if(canSatisfy(card)) {
		    	//}
		    	return createHand(allCards, new int[]{i, i + 1, i + 2, i + 3});
		    }
		}
	}
	return null;
}
}