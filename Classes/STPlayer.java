import java.util.ArrayList;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public  class STPlayer
{

    public ArrayList<Integer> hand = new ArrayList<Integer>();

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

    public boolean takeTurn(int keyElement, ArrayList<Integer> pile, STDeck deck){

        int currentLeadingCard = 0;
        int leadingCardPosition = 0;
        double leadingCardVariable = 0;
//check too see if first
        if(pile.size()==0){

            leadingCardVariable = 100;

            for( int i=0; i<hand.size(); i++){
                if(hand.get(i)<54) {
                    if (Double.parseDouble(deck.cards[hand.get(i)][keyElement]) < leadingCardVariable) {
                        currentLeadingCard = hand.get(i);
                        leadingCardPosition = i;
                        leadingCardVariable = Double.parseDouble(deck.cards[hand.get(i)][keyElement]);

                    }
                }
            }

            pile.add(currentLeadingCard);
            hand.remove(leadingCardPosition);
            System.out.println("Player has played card "+currentLeadingCard+" the new amount to beat is "+leadingCardVariable);
            return false;

        }else {
//find possible cards to play
            ArrayList<Integer>ShortList = new ArrayList<Integer>();
            ArrayList<Integer>TrumpList = new ArrayList<Integer>();


            for (int i = 0; i < hand.size(); i++) {
                if(hand.get(i)<54){
                    if(Double.parseDouble(deck.cards[hand.get(i)][keyElement]) > Double.parseDouble(deck.cards[pile.get(pile.size()-1)][keyElement])){
                        ShortList.add(i);
                    }
                }else{
                    TrumpList.add(i);
                }
            }
    //if can play card, find smallest card to play
            if(ShortList.size()>0){

                leadingCardVariable = 100;

                for (int i=0; i<ShortList.size();i++){
                    if (Double.parseDouble(deck.cards[hand.get(i)][keyElement]) < leadingCardVariable) {
                        currentLeadingCard = hand.get(i);
                        leadingCardVariable = Double.parseDouble(deck.cards[hand.get(i)][keyElement]);

                    }

                }
                pile.add(currentLeadingCard);
                hand.remove(leadingCardPosition);
                System.out.println("Player played card "+currentLeadingCard+" score to beat is" + leadingCardVariable);
                return false;

            }else{
                //find if we have a trump card to play
                if(TrumpList.size()>0){
                    pile.add(TrumpList.get(0));
                    hand.remove(TrumpList.get(0));
                    System.out.println("Played a Trump");
                    return false;
                }else{
                    getsCard(deck);
                    System.out.println("Picked up a card");
                    return true;

                }


            }

        }
    }

    public  void showHand(int keyElement){

        for(int i = 0; i<hand.size(); i++){

            System.out.println(hand.get(i));

        }
    }

    public  int getHandSize(){
        return hand.size();
    }
}
