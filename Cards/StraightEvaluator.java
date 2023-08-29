package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator for a hand consisting of a "straight" in which the
 * card ranks are consecutive numbers.  The number of required 
 * cards is equal to the hand size.  An ace (card of rank 1) 
 * may be treated as the highest possible card or as the lowest
 * (not both).  To evaluate a straight containing an ace it is
 * necessary to know what the highest card rank will be in a
 * given game; therefore, this value must be specified when the
 * evaluator is constructed.  In a hand created by this
 * evaluator the cards are listed in descending order with high 
 * card first, e.g. [10 9 8 7 6] or [A K Q J 10], with
 * one exception: In case of an ace-low straight, the ace
 * must appear last, as in [5 4 3 2 A]
 * 
 * The name of this evaluator is "Straight".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class StraightEvaluator extends AbstractEvaluator {
	
	private int sizeOfhand;
	
	private int rank;
	
	private int maxRank;
  /**
   * Constructs the evaluator. Note that the maximum rank of
   * the cards to be used must be specified in order to 
   * correctly evaluate a straight with ace high.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   * @param maxCardRank
   *   largest rank of any card to be used
   */
  public StraightEvaluator(int ranking, int handSize, int maxCardRank) {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	  super(ranking, handSize, "Straight", handSize);
	 rank = ranking;
	  //sizeOfhand = handSize;
	 // maxRank = maxCardRank;
  }


//public String getName() {
	// TODO Auto-generated method stub
	//return "Straight";
//}

/**
 * this method checks if the conditions for the "Straight" evaluator are satisfied 
 * firstly declared variables
 * then sorted the array
 * the checked the length for the input with other conditions
 * 
 */
public boolean canSatisfy(Card[] mainCards) {
	// TODO Auto-generated method stub
	int i;
	int c = 0;
	Arrays.sort(mainCards);
		if(mainCards.length != cardsRequired()) {
			return false;
		} 
		for(i = 0; i < mainCards.length - 1; ++i) {
			if(maxRank == 1) {
				if(mainCards[i].getRank() - mainCards[i + 1].getRank() == 1 && mainCards[1].getRank() == 13) {
					c += 1;
				}
	     	}
			//}
			else if(maxRank != 1) {
				if(mainCards[i].getRank() - mainCards[i + 1].getRank() == 1) {
					c += 1;
				}
		    }
		}
//}		
		if(c == mainCards.length - 1) {
			return true;
		}
	return false;
}
}
