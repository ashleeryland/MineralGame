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
    public String[][] cards = new String[60][12];


    //this reads the file of the card information and puts into the deck

    public STDeck(){
        FileReader deckDoc = null;
            try {
                deckDoc = new FileReader(new File("res/STCards.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        BufferedReader reader = new BufferedReader(deckDoc);
        String line = new String();

        try {
            for (int i = 0; i < NUM_CARDS_INIT; i++) {
                line = reader.readLine();
                String[] currentLine = line.split(",");
                for (int j = 0; j < 12; j++) {
                    if (j < 11) {
                        cards[i][j] = currentLine[j];
                    } else {
                        cards[i][11] = "false";
                    }
                }

            }
        } catch(Exception ie){

        }

    }
public void returnToDeck(ArrayList<Integer> pile){
    for(int i=0; i<pile.size()-1; i++){
        cards[pile.get(i)][11]="false";
    }
}

}
