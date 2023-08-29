package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import api.IEvaluator;
import util.SubsetFinder;

/**
 * @author Raghuram
 */
/**
 * The class AbstractEvaluator includes common code for all evaluator types.
 *
 * TODO: Expand this comment with an explanation of how your class hierarchy is
 * organized.
 */
public abstract class AbstractEvaluator implements IEvaluator {
/**
 * the length of the hand
 */
private int sizeOfhand;

/**
 * the ranking for the cards
 */
private int rank;

/**
 * the minimum cards required
 */
private int minCards;

/**
 * the name of the class evaluator
 */
private String names;



protected AbstractEvaluator(int ranking, int handSize, String name, int cardsRequired) {
	sizeOfhand = handSize;
	
	rank = ranking;
	
	names = name;
	
	minCards = cardsRequired;
}

/**
* @return returns the name of the evaluator
*/
@Override
public String getName() {
// TODO Auto-generated method stub
	return names;
}

/**
* @return returns the ranking of the evaluator
*/
@Override
public int getRanking() {
	return rank;
}

/**
* @return returns the minimum number of cards required for the evaluator
*/
@Override
public int cardsRequired() {
// TODO Auto-generated method stub
	return minCards;
}

/**
* @return returns the cards present in hand
*/
@Override
public int handSize() {
	// TODO Auto-generated method stub
	return sizeOfhand;

}

/**
* this method checks if the subsets of the cards satisfy the evaluator
* first sorted the array
* then made a temporary arrayList and used subset finder
* then made another array named card of type card
*
* @param 
*/
@Override
public boolean canSubsetSatisfy(Card[] allCards) {
// TODO Auto-generated method stub
	int i;
	int j;
	boolean y = false;
	Arrays.sort(allCards);
	ArrayList<int[]> temp = SubsetFinder.findSubsets(allCards.length, cardsRequired());
	Card[] card = new Card[cardsRequired()];
	if(allCards.length < cardsRequired()) {
		y = false;
	}
	for(i = 0; i < temp.size(); ++i) {
	//	Card[] card = new Card[cardsRequired()];
		//}
		for(j = 0; j < cardsRequired(); ++j) {
			card[j] = allCards[temp.get(i)[j]];
		}
		//}
		if(canSatisfy(card) == true) {
			//SubsetFinder.findSubsets(allCards.length, cardsRequired());
			y = true;
		}
	}
return y;
}

/**
* this method creates a hand for the evaluator
* firstly sorted the array
* then made two arrays of type card
* 
*
* @param allCards- list of cards to evaluate
* @param subset-   a array list of indices of the main cards
*/
@Override
public Hand createHand(Card[] allCards, int[] subset) {
// TODO Auto-generated method stub
	int i;
	int j;
	int k;
	int c = 0;
	boolean x = true;
	Arrays.sort(allCards);
	Card[] mCards= new Card[cardsRequired()];
	//ArrayList<int[]> temp = Subs
	Card[] sCards= new Card[handSize() - mCards.length];
	if(allCards.length < handSize()) {
		return null;
	}
	for(i = 0; i < subset.length; ++i) {
		mCards[i] = allCards[subset[i]];
	}
	for(j = 0; j < allCards.length; ++j) {
		//}
		for(k = 0; k < subset.length; ++k) {
			if(j == subset[k]) {
				x = false;
				//}
				//}
				break;
	        }
	     }
		if(x && c < sCards.length) {
			sCards[c] = allCards[j];
	        c += 1;
	    }
	}
	if(canSatisfy(mCards) == true) {
		return new Hand(mCards, sCards, this);
	}
	return null;
}

/**
* this method returns the best prioritized combination of cards
* the cards of the highest priority is returned
* firstly checked if the length of the input is greater or equal to the sizeOfhand
* then created the array of type card
* then created another array of integer type
*
* @param allCards- the list of cards to evaluate
*/
@Override
public Hand getBestHand(Card[] allCards) {
	int i;
	int j;
	if(allCards.length >= sizeOfhand) {
		Arrays.sort(allCards);
		for(i = 0; i < allCards.length - 1; ++i) {
			Card[] card = new Card[cardsRequired()];
		//	if(canSatisfy(mCards) =
		    int[] p = new int[cardsRequired()];
		   // for(i = 0; 
		    for(j = 0; j < cardsRequired(); ++j) {
		    	card[j] = allCards[j];
		    	if(i < cardsRequired()) {
		    		p[i] = i;
		        }
		    	//}
		     }
		    if(canSatisfy(card)) {
		    	return createHand(allCards, p);
		    }
		}
	}
	return null;
	}
}