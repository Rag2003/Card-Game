package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator for a hand containing (at least) two cards of the same rank.
 * The number of cards required is two.
 * 
 * The name of this evaluator is "One Pair".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class OnePairEvaluator extends AbstractEvaluator {
	private int sizeOfhand;
	
	private int rank;
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public OnePairEvaluator(int ranking, int handSize)
  {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	  super(ranking, handSize, "One pair", 2);
	  rank = ranking;
	  sizeOfhand = handSize;
  }


/**
 * this method checks if the conditions for the "One pair" evaluator are satisfied 
 * firstly declared a boolean variable
 * the checked the length for the input with other conditions
 * then sorted the array
 */
public boolean canSatisfy(Card[] mainCards) {
	// TODO Auto-generated method stub
	boolean x = false;
	Arrays.sort(mainCards);
	if(mainCards.length != cardsRequired()) {
		x = false;
	}
	//}
	else if(mainCards[0].compareToIgnoreSuit(mainCards[1]) == 0) {
		x = true;
	}
  return x;
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
	int i;
	Arrays.sort(allCards);
	if(allCards.length >= sizeOfhand) {
		Arrays.sort(allCards);
		for(i = 0; i < allCards.length - 1; ++i) {
			//}
			Card[] t = new Card[cardsRequired()];
	        t[0] = allCards[i];
	        t[1] = allCards[i + 1];
	        //}
	        if(canSatisfy(t)) {
	        	return createHand(allCards, new int[]{i, i + 1});
	        }
		}
	}
return null;
}
}
