import java.util.Random;

/**
 * Created by Ashlee Ryland on 18/09/2016.
 */
public class TestRandomDealer {

    public static void main(String[] args)
    {
        int numPlayers = 6;
        for(int i =0; i < 100; i++) {
            Random rand = new Random();
            int num = rand.nextInt((numPlayers) + 1) + 1;
            System.out.println(num);
        }

    }
}
