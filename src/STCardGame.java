import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public class STCardGame {
    private static final int NUM_CARDS_TO_DEAL = 8;
    private int numPlayers;
    private int dealerID;
    private STPlayer[] players;
    private STDeck deck;

    public STCardGame(int numPlayers)
    {
        this.numPlayers = numPlayers;
    }

    public void selectDealer()
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((numPlayers) + 1) + 1;
        dealerID = randomNum;
    }


    public void dealRandCardsToPlayers()
    {
        players = new STPlayer[numPlayers];

        for (STPlayer player : players){
            ArrayList<STCard> card = deck.dealCards(NUM_CARDS_TO_DEAL);
            player.getsCards();
        }
    }
}
