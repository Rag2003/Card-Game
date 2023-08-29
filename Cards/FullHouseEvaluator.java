package hw4;

import java.util.ArrayList;
import java.util.Arrays;

import api.Card;
import api.Hand;
import util.SubsetFinder;

/**
 * Evaluator for a generalized full house.  The number of required
 * cards is equal to the hand size.  If the hand size is an odd number
 * n, then there must be (n / 2) + 1 cards of the matching rank and the
 * remaining (n / 2) cards must be of matching rank. In this case, when constructing
 * a hand, the larger group must be listed first even if of lower rank
 * than the smaller group</strong> (e.g. as [3 3 3 5 5] rather than [5 5 3 3 3]).
 * If the hand size is even, then half the cards must be of matching 
 * rank and the remaining half of matching rank.  Any group of cards,
 * all of which are the same rank, always satisfies this
 * evaluator.
 * 
 * The name of this evaluator is "Full House".
 */
//Note: You must edit this declaration to extend AbstractEvaluator
//or to extend some other class that extends AbstractEvaluator
public class FullHouseEvaluator extends AbstractEvaluator {
	
  /**
   * Constructs the evaluator.
   * @param ranking
   *   ranking of this hand
   * @param handSize
   *   number of cards in a hand
   */
  public FullHouseEvaluator(int ranking, int handSize) {
    // TODO: call appropriate superclass constructor and 
    // perform other initialization
	  super(ranking, handSize, "Full House", handSize);
	 // rank = ranking;
	  //sizeOfhand = handSize;
  }

@Override
/**public String getName() {
	// TODO Auto-generated method stub
	return "Full House";
}

@Override
public int getRanking() {
	// TODO Auto-generated method stub
	return rank;
}

@Override
public int cardsRequired() {
	// TODO Auto-generated method stub
	return sizeOfhand;
}

@Override
public int handSize() {
	// TODO Auto-generated method stub
	return sizeOfhand;
}**/

/**
 * this method checks if the conditions for the "Full House" evaluator are satisfied 
 * firstly declared variables
 * the checked the length for the input with other conditions
 * then sorted the array
 * first checked conditions for even number of required cards
 * then checked the conditions for odd number of required cards
 */
public boolean canSatisfy(Card[] mainCards) {
	int i;
	int c1 = 0;
	int c2 = 0;
	int rank1;
	int rank2;
	if(mainCards.length != cardsRequired()) {
		return false;
	}
	Arrays.sort(mainCards);
	rank1 = mainCards[0].getRank();
	//rank2 = mainCards[mainCards.lenght]
	rank2 = mainCards[mainCards.length - 1].getRank();
	if(cardsRequired() % 2 == 0) {
		for(i = 0; i < mainCards.length; ++i) {
			//for(i = 0; i < mainCards.length; ++i) {
			if(i < mainCards.length / 2) {
				if(mainCards[i].getRank() == rank1) {
					c1 += 1;
	            }
				else {
					return false;
	            }
	        }
			if(i >= mainCards.length / 2 && i < mainCards.length) {
				//]
				if(mainCards[i].getRank() == rank2) {
					c2 += 1;
	            }
				else {
					return false;
	            }
				//if(mainCards[i].getRank() == rank2) {
	        }
	    }
		if(c1 == c2) {
		    return true;
	    }
	}
	if(cardsRequired() % 2 != 0) {
		for(i = 0; i < mainCards.length; ++i) {
			if(i < mainCards.length / 2) {
				//i < mainCards.length / 2) 
				if(mainCards[i].getRank() == rank1) {
					c1 += 1;
				}
	            else {
	            	return false;
	            }
	        }
			if(i < mainCards.length && i >= mainCards.length / 2 + 1) {
				//}
				if(mainCards[i].getRank() == rank2) {
					c2 += 1;
  	            }
				else {
	            	return false;
	            }
			}
			if(i == 1 + mainCards.length / 2) {
				if(mainCards[i].getRank() == rank1) {
					c1 += 1;
				}
	//}
	//}
	//}
				if(mainCards[i].getRank() == rank2) {
					c2 += 1;
	            }
	        }
	    }
		if(c2 - c1 == 1 || c1 - c2 == 1) {
		   return true;
	    }
	}
	return false;
}

@Override
/**
*  this method returns the best prioritized combination of cards
* the cards of the highest priority is returned
* firstly created two arrays of type card
* one of size cardsRequired() and other "handSize()-cardsRequired()"
* then declared variables
* then created two ArrayList of type integer and used findsubsets 
* created variables of type Hand for future use
* checked if the length of the input is greater or equal to the sizeOfhand
* then checked conditions and made necessary modifications
* 
 */
public Hand getBestHand(Card[] allCards) {
	// TODO Auto-generated method stub
	Card[] mC = new Card[cardsRequired()];
//	Card[] temperorary = new Card[handSize()];
	Card[] sC = new Card[handSize() - cardsRequired()];
	Card[] card = new Card[mC.length];
	int i;
	int j;
	int k;
	int m;
    ArrayList<int[]> mCard = SubsetFinder.findSubsets(allCards.length, cardsRequired());
    //}
	ArrayList<int[]> sCard = SubsetFinder.findSubsets(allCards.length, handSize() - cardsRequired());
	Hand x1;
	Hand x = null;
//	 ArrayList<int[]> temp = SubsetFinder.findSubsets(allCards.length, cardsRequired() - handSize());
	
	
    if (allCards.length >= handSize()) {
    	for (i = 0; i < mCard.size(); ++i) {
    		for (j = 0; j < cardsRequired(); ++j) {
    			//}
    			mC[j] = allCards[mCard.get(i)[j]];
            }
    		for (k = 0; k < sCard.size(); ++k) {
    			//x1 = new Hand(mC, sC, this);
    			for (m = 0; m < sC.length; ++m) {
    				sC[m] = allCards[sCard.get(k)[m]];
    				//ArrayList<int[]> mCard = SubsetFinder.findSubsets(al);
                }
    			x1 = new Hand(mC, sC, this);
    			if (x == null) {
    				x = x1;
                } 
    			else if (canSatisfy(x1.getMainCards()) == true && (x.compareTo(x1) < 0)) {
    				x = x1;
    				//x1 = x;
                }
    			else {
    				//}
    			}
    		}
        }
    	if (card.length % 2 == 0) {
    		return x;
    	}
    	//}
    	
//}    	
//}
//}    	
    	else if ((x.getMainCards()[mC.length / 2].getRank()) != (x.getMainCards()[0].getRank())) {
    		for (i = 0; i < mC.length; ++i) {
    			//i >= mainCards.length / 2 + 1
    			if ((mC.length / 2) + i < mC.length) {
    				card[i] = x.getMainCards()[i + (mC.length / 2)];
                } 
    			else {
    				//Card[] mC = new Card[cardsRequired()];
    				card[i] = x.getMainCards()[(i - mC.length / 2) - 1];
                }
            }
    		//}
    		return new Hand(card, sC, this);
      }
    return x;
  }
return null;
}
}