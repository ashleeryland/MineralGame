import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public  class STPlayer
{

    public ArrayList<Integer> hand = new ArrayList<Integer>();
    public static final int TRUMP_CARD_STARTS_FROM = 54;

    //this while see if card has been used yet. It it ha snot be used it will be placed in players hand
    public void getsCard(STDeck deck) {

        boolean cardFound = true;
        while(cardFound){

            int testCard = (int) (Math.random()*60);
            if(Objects.equals(deck.cards[testCard][11], "false")){

                hand.add(testCard);
                deck.cards[testCard][11] = "true";
                cardFound = false;
            }
        }
    }

    //this is for the computers turn. It will show what cards that have been played.
    public boolean takeTurn(int keyCategory, ArrayList<Integer> pile, STDeck deck, int playersTurn){

        int currentLeadingCard = 0;
        int leadingCardPosition = 0;
        double leadingCardVariable = 0;


        //checking too see what card to play first
        if(pile.size() == 0){

            leadingCardVariable = 100;

            for( int i = 0; i < hand.size(); i++){
                if(hand.get(i)<TRUMP_CARD_STARTS_FROM) {
                    Double playerCardCategory = Double.parseDouble(deck.cards[hand.get(i)][keyCategory]);
                    if (playerCardCategory < leadingCardVariable) {
                        currentLeadingCard = hand.get(i);
                        leadingCardPosition = i;
                        leadingCardVariable = playerCardCategory;
                    }
                }
            }

            pile.add(currentLeadingCard);
            hand.remove(leadingCardPosition);
            String categoryName = categoryNames(keyCategory);

            System.out.println("Player " + playersTurn + " has started this round playing card "+ currentLeadingCard + " " +
                    deck.cards[currentLeadingCard][0] + " the category is " + categoryName
                    + " amount to beat is " + leadingCardVariable);
            return false;
        }

        else {
            //finding possible cards for the computer to play
            ArrayList<Integer>ShortList = new ArrayList<Integer>();
            ArrayList<Integer>TrumpList = new ArrayList<Integer>();


            for (int i = 0; i < hand.size(); i++) {
                if(hand.get(i) < TRUMP_CARD_STARTS_FROM){
                    Double playerCard = Double.parseDouble(deck.cards[hand.get(i)][keyCategory]);
                    Double lastPlayedCard = Double.parseDouble(deck.cards[pile.get(pile.size()-1)][keyCategory]);
                    if(playerCard > lastPlayedCard){
                        ShortList.add(i);
                    }
                }
                else{
                    TrumpList.add(i);
                }
            }

//      if can play card, find smallest card to play first that is greater that previous card
            if(ShortList.size() > 0){

                for (int i=0; i < ShortList.size();i++){
                    Double playerCardCategory = Double.parseDouble(deck.cards[hand.get(i)][keyCategory]);
                    if (playerCardCategory > leadingCardVariable) {
                        currentLeadingCard = hand.get(i);
                        leadingCardVariable = playerCardCategory;

                    }

                }

                pile.add(currentLeadingCard);
                hand.remove(leadingCardPosition);
                String categoryName = categoryNames(keyCategory);
                System.out.println("Player " + playersTurn + " played a "+ currentLeadingCard + " " +
                        deck.cards[currentLeadingCard][0] + " the category is " + categoryName
                        + " amount to beat is " + leadingCardVariable);
                return false;

            }else{

//      find if we have a trump card to play if we do not have a mineral card
//      Unable to figure out how to play trump cards

                if(TrumpList.size()>0){
                    int trumpCard = TrumpList.get(0);
                    pile.add(trumpCard);
                    hand.remove(TrumpList.get(0));
                    System.out.println("Player " + playersTurn + " played a Trump. " + trumpCard + " This means " + deck.cards[trumpCard][3]);
                    return false;
                }

//       players will pick up a card and pass if they have no other cards to play
                else{
                    getsCard(deck);
                    System.out.println("Player " + playersTurn + " picked up a card");
                    return true;
                }
            }
        }
    }





    public void showHand(STDeck deck){

        System.out.println("Your hand of cards:");
        for(int i = 0; i < hand.size(); i++){
            if(hand.get(i)<54) {
                System.out.println("    Card " + i + " is a " + deck.cards[hand.get(i)][1] + " card.");
                System.out.println("        NAME: " + deck.cards[hand.get(i)][0]);
                System.out.println("        FORMULA: " + deck.cards[hand.get(i)][2]);
                System.out.println("        CLASSIFICATION: " + deck.cards[hand.get(i)][3]);
                System.out.println("        CRYSTAL SYSTEM: " + deck.cards[hand.get(i)][4]);
                System.out.println("        OCCURANCE: " + deck.cards[hand.get(i)][5]);
                System.out.println("        HARDNESS: " + deck.cards[hand.get(i)][6]);
                System.out.println("        SPECIFIC GRAVITY: " + deck.cards[hand.get(i)][7]);
                System.out.println("        CLEAVAGE: " + deck.cards[hand.get(i)][8]);
                System.out.println("        CRUSTAL ABUNDANCE: " + deck.cards[hand.get(i)][9]);
                System.out.println("        ECCONOMIC VALUE: " + deck.cards[hand.get(i)][10]);
                System.out.println(" **************************************** ");
            }
            else{
                System.out.println("    Card " + i + " is a " + deck.cards[hand.get(i)][1] + " card!");
                System.out.println("        You can: " + deck.cards[hand.get(i)][3]);
                System.out.println(" **************************************** ");
            }
        }
    }

    public  int getHandSize(){
        return hand.size();
    }

    //getting the name of the catergories
    public String categoryNames(int keyCategory) {
        int categoryNum = keyCategory;
        String categoryName = null;
        switch (categoryNum) {
            case 6:
                categoryName = "Hardeness";
                break;
            case 7:
                categoryName = "Specific gravity";
                break;
            case 8:
                categoryName = "Cleavage";
                break;
            case 9:
                categoryName = "Crustal abundance";
                break;
            case 10:
                categoryName = "Economic Value";
                break;
        }
        return categoryName;
    }
}
