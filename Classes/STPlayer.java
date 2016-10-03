import java.util.ArrayList;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public class STPlayer
{

    private ArrayList<Integer> hand;

    public void getsCard( STDeck deck) {

        boolean cardFound = false;

        while(!cardFound){

             int testCard = (int) Math.random()*61;

            if(deck.cards[testCard][11] == "false"){

                hand.add(testCard);
                deck.cards[testCard][11] = "true";
                cardFound = true;

            }

        }

    }
}
