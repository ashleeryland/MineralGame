import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public class STDeck {
    private static final int NUM_CARDS_INIT = 60;
    private String[][] cards;


    //todo; List of all cards

    public STDeck(){
        FileReader deckDoc = null;
            try {
                deckDoc = new FileReader(new File("res/STCards.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        BufferedReader reader = new BufferedReader(deckDoc);
        String line = new String();

        for (int i = 0; i < NUM_CARDS_INIT; i++) {
            line = reader.readLine();
            String[] currentLine = line.split(",");
            for (int j = 0; j < 12; j++){
                if (j < 11){
                    cards[i][j] = currentLine[j];
                }else{
                    cards[i][11]="false";
                }
            }

        }

    }

    public ArrayList<STCard> dealCards(int i)
    {
        return null;
    }
}
