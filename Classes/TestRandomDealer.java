import java.util.Random;

/**
 * Created by Ashlee Ryland on 18/09/2016.
 */
public class TestRandomDealer {

    public static void main(String[] args)
    {
        int numPlayers = 6;
        for(int i =0; i < 100; i++) {
            STCardGame game = new STCardGame(numPlayers);
            game.selectDealer();
        }

    }
}
