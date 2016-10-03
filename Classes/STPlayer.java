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

    public void takeTurn(int keyElement, ArrayList<Integer> pile, STDeck deck){

        int currentLeadingCard = 0;
        int leadingCardVariable = 0;

        if(pile.size()==0){

            leadingCardVariable = 100;

            for( int i=0; i<hand.size(); i++){
                if(deck.cards[hand.get(i)][2]=="Trump") {
                    if (Integer.parseInt(deck.cards[hand.get(i)][keyElement]) < leadingCardVariable) {
                        currentLeadingCard = hand.get(i);
                        leadingCardVariable = Integer.parseInt(deck.cards[hand.get(i)][keyElement]);

                    }
                }
            }

            pile.add(currentLeadingCard);
            hand.remove(currentLeadingCard);

        }else {

            ArrayList<Integer>ShortList

            for (int i = 0; i < hand.size(); i++) {


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
