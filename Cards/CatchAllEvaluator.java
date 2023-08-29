package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator satisfied by any set of cards.  The number of
 * required cards is equal to the hand size.
 * 
 * The name of this evaluator is "Catch All".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class CatchAllEvaluator extends AbstractEvaluator {
	
	private int sizeOfhand;
	
	//private int rank;
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public CatchAllEvaluator(int ranking, int handSize) {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	  super(ranking, handSize, "Catch All", handSize);
	//  rank = ranking;
	  sizeOfhand = handSize;
  }


/**
 * this method checks if the conditions for the "Catch All" evaluator are satisfied
 * firstly sorted the array
 * then checked if the length of the input is less than the cards required
 * 
 */
public boolean canSatisfy(Card[] mainCards) {
	// TODO Auto-generated method stub
	Arrays.sort(mainCards);
	if (mainCards.length != cardsRequired()) {
		return false;
	}
	//}
	else if (mainCards.length == sizeOfhand) {
		return true;
	}
	return false;
}
}
