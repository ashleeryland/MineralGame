import java.util.ArrayList;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public class STDeck {
    private static final int NUM_CARDS_INIT = 60;
    private ArrayList<STCard> cards;


    //todo; List of all cards

    public STDeck(){
        cards = new ArrayList<STCard>();

        for (int i = 0; i < NUM_CARDS_INIT; i++) {
            cards.add(new STCard());
            //google how to create random array of integers
        }

    }

    public ArrayList<STCard> dealCards(int i)
    {
        return null;
    }
}
