/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
public class MainGame
{

    private static final int NEW_GAME = 1;

    public static void main(String[] args) {
        showWelcome();
        showMenu();
        int option = userMenuChoice();
        if (option == NEW_GAME) {
            startNewGame();
        }
    }

    private static void startNewGame()
    {
        int numPlayers = getNumPlayers();
        STCardGame game = new STCardGame(numPlayers);
        game.selectDealer();
        game.dealRandCardsToPlayers();
    }

    private static int getNumPlayers()
    {
        //See prac how to get number
        //just for test
        return 3;
    }


    private static int userMenuChoice()
    {
        //Add choice for menu
        //just a test value atm
        return 1;
    }

    private static void showMenu()
    {
        System.out.println("Start Game = 1");
    }

    private static void showWelcome()
    {
        System.out.println("Welcome to this amazing Mineral Card Game made by Ashlee Ryland");
    }
}
