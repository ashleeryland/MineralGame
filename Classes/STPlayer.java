import java.util.ArrayList;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public  class STPlayer
{

    private ArrayList<Integer> hand = new ArrayList<Integer>();

    public void getsCard( STDeck deck) {

        boolean cardFound = true;

        while(cardFound){

             int testCard = (int) (Math.random()*60);


            if(deck.cards[testCard][11] == "false"){

                hand.add(testCard);
                deck.cards[testCard][11] = "true";
                cardFound = false;

            }

        }

    }

    public  void showHand(){

        for(int i = 0; i<hand.size(); i++){

            System.out.println(hand.get(i));

        }
    }

    public  int getHandSize(){
        return hand.size();
    }
}
