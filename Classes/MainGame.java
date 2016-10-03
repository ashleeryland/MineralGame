/**
 * Created by Ashlee Ryland on 12/09/2016.
 */
import sun.font.TrueTypeFont;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class MainGame
{

    private static final int NEW_GAME = 1;
    private static final String USERS_NAME = getUserName();
    private static final int END_GAME = 2;

    private static int numPlayers;
    private static ArrayList<STPlayer> players = new ArrayList<STPlayer>();
    private static int dealerID;

    public static ArrayList<Integer> pile;
    private static int playersTurn;
    private static int keyElement;

    public static void main(String[] args) {
        STDeck deck = new STDeck();

        showWelcome();
        showMenu();
        int choice = userMenuChoice();
        if (choice == NEW_GAME) {

            numPlayers = startNewGame(deck);

            showHand(0,players,1);

        }


        if (choice == END_GAME) {
            System.out.println("Good Bye!");
            System.exit(0);
        }

        boolean gameOver = false;

        pile = new ArrayList<Integer>();
        playersTurn = 1;
        if(playersTurn>numPlayers-1){
            playersTurn =0;
        }
        keyElement = 6;
        int passCounter = 0;

        while(!gameOver){

            boolean didPickUp = false;

            if(playersTurn!=0) {

               didPickUp =  players.get(playersTurn).takeTurn(keyElement, pile, deck);
                if(didPickUp == true){
                    passCounter+=1;
                    System.out.println("Player has passed, pass counter is now "+passCounter);
                }else{
                    passCounter = 0;
                }
            }else{
                System.out.println("Your Turn");
                showHand(0,players,1);

                boolean turnOver = true;

                while(turnOver){



                    Scanner input = new Scanner(System.in);
                    System.out.print("Enter card or P to pass: ");
                    String cardPicked = input.nextLine();



                    if(cardPicked.equals("P")){
                        System.out.println(cardPicked);
                        players.get(0).getsCard(deck);
                        System.out.println("You passed");
                        passCounter+=1;
                        turnOver=false;
                    }else{
                        if(Double.parseDouble(deck.cards[players.get(0).hand.get(Integer.parseInt(cardPicked))][keyElement])>Double.parseDouble(deck.cards[pile.get(pile.size()-1)][keyElement])){
                            System.out.println("You played card " + players.get(0).hand.get(Integer.parseInt(cardPicked)));
                            players.get(0).hand.remove(Integer.parseInt(cardPicked));
                            passCounter = 0;
                            pile.add(players.get(0).hand.get(Integer.parseInt(cardPicked)));
                            turnOver=false;
                        }else{
                            System.out.println("computer says no");
                        }
                    }
                }
            }

            if(passCounter>numPlayers-1){
                System.out.println("All players have passed, pile returned to deck and reset");
                deck.returnToDeck(pile);
                pile.clear();
            }

            if(players.get(playersTurn).getHandSize()==0){
                gameOver = true;
                System.out.println("Gameover");
            }

            playersTurn +=1;

            if(playersTurn>numPlayers-1){

                playersTurn =0;
            }

        }


    }

    private static String getUserName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        return name;
    }

    //method to start a new game
    private static int startNewGame(STDeck deck)
    {
        STPlayer newPlayer;
        int numPlayers = getNumPlayers();
        for(int i=0; i < numPlayers; i++){
            newPlayer = new STPlayer();
            players.add(newPlayer);

            for (int j = 0; j < 8; j++) {
                players.get(i).getsCard(deck);
            }
        }

        dealerID = selectDealer(numPlayers);
        return numPlayers;

    }

    public static void showHand(int player, ArrayList<STPlayer> players,  int keyElement){

       STPlayer playerInQuestion = players.get(player);

        playerInQuestion.showHand(keyElement);

    }


    public static int selectDealer(int numPlayers)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt(numPlayers) + 1;
        dealerID = randomNum;

        if (dealerID == 1)
            System.out.println("You are the dealer");
        else
            System.out.println("Dealer is player " + dealerID);

        return dealerID;
    }

    //user selects amount of players. Must be between 3 and 6
    private static int getNumPlayers()
    {
        int numPlayers;
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Players: ");
        numPlayers = input.nextInt();

        while (numPlayers <3 || numPlayers >6) {
            System.out.println("Invalid number of players. Must be 3 to 6 players");
            numPlayers= input.nextInt();
        }
        return numPlayers;
    }

    //users menu choice. Currently can only select 1 or 2 to start of exit game
    private static int userMenuChoice()
    {
        int menuChoice;
        Scanner input = new Scanner(System.in);
        menuChoice = input.nextInt();

        while (menuChoice <1 || menuChoice >2) {
            System.out.println("Invalid Choice. Please select either 1 or 2");
            menuChoice = input.nextInt();
        }
        return menuChoice;

    }


    private static void showMenu()
    {
        System.out.println("Game Menu:");
        System.out.println("  1 = Start a new game");
        System.out.println("  2 = Exit game");
    }

    private static void showWelcome()
    {
        System.out.println("Welcome " + USERS_NAME + " to Super Trump Mineral Card Game! Lets begin!");
    }
}
