/**
 * Created by Ashlee Ryland on 12/09/2016.
 */

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
    private static final int USER_PLAYER_NUM = 0;

    public static void main(String[] args) {
        STDeck deck = new STDeck();

        showWelcome();
        showMenu();
        int choice = userMenuChoice();
        if (choice == NEW_GAME) {

            numPlayers = addPlayers(deck);

        }
        if (choice == END_GAME) {
            System.out.println("Good Bye!");
            System.exit(0);
        }

        boolean gameOver = false;
        if (players.get(playersTurn).getHandSize() == 0) {
            gameOver = true;
            System.out.println("Game Over");
        }


        pile = new ArrayList<Integer>();
        playersTurn = 0;//dealerID + 1;
        if (playersTurn > numPlayers + -1) {
            playersTurn = USER_PLAYER_NUM;
        }


        int keyCategory = 6;
        int passCounter = 0;

        while (!gameOver) {

            boolean didPickUp = false;

            if (playersTurn != USER_PLAYER_NUM) {
                didPickUp = players.get(playersTurn).takeTurn(keyCategory, pile, deck, playersTurn);
                if (didPickUp == true) {
                    passCounter += 1;
                } else {
                    passCounter = 0;
                }

            } else {
                //users turn to play
                System.out.println(USERS_NAME + " its your turn!");
                showHand(0, players, 1, deck);

                boolean turnOver = true;

                //if there are no cards on the pile user selects card and category
                if (pile.size() == 0) {
                    Scanner selectCard = new Scanner(System.in);
                    System.out.print("Enter card: ");
                    int userCardPlayed = selectCard.nextInt();

                    Scanner userCatInput = new Scanner(System.in);
                    System.out.print("Pick a Category:");
                    System.out.print("  6 = HARDNESS");
                    System.out.print("  7 = SPECIFIC GRAVITY");
                    System.out.print("  8 = CLEAVAGE");
                    System.out.print("  9 = CRUSTAL ABUNDANCE");
                    System.out.print("  10 = ECONOMIC VALUE");
                    keyCategory = userCatInput.nextInt();

                    int usersCard = players.get(0).hand.remove(userCardPlayed);
                    System.out.println("You played card " + usersCard + " with the category " + keyCategory);

                    pile.add(usersCard);
                    passCounter = 0;
                    turnOver = false;
                }

                while (turnOver) {

                        Scanner input = new Scanner(System.in);
                        System.out.print("Enter card or p to pick up a card: ");
                        String userCardInput = input.nextLine();

                        if (userCardInput.equals("p")) {
                            players.get(0).getsCard(deck);
                            System.out.println("You picked up a card");
                            passCounter += 1;
                            turnOver = false;
                        }

                        else {
                            //checking to see if users card is higher than the last card played
                            int userCardPlayed = Integer.parseInt(userCardInput);
                            Double usersCardCategory = Double.parseDouble(deck.cards[players.get(0).hand.get(userCardPlayed)][keyCategory]);
                            Double pileCategory = Double.parseDouble(deck.cards[pile.get(pile.size() - 1)][keyCategory]);

                            if (usersCardCategory > pileCategory) {
                                int usersCard = players.get(0).hand.remove(userCardPlayed);

                                System.out.println("You played card " + usersCard);

                                passCounter = 0;
                                pile.add(usersCard);
                                turnOver = false;
                            }

                            else {
                                System.out.println("Incorrect Choice");
                            }
                        }
                    }
                }

                //if all players pass new round starts and new kategory
                if (passCounter > numPlayers - 1) {
                    System.out.println("All players have passed, new round!");
                    deck.returnToDeck(pile);
                    pile.clear();
                    keyCategory = +1;
                }


                playersTurn += 1;
                if (playersTurn > numPlayers - 1) {
                    playersTurn = USER_PLAYER_NUM;
                }
            }
        }
//    }

//    this calls to get number of players and then adds them into array.
//    also calls select dealer and set dealerID
    private static int addPlayers(STDeck deck)
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

    private static void showHand(int player, ArrayList<STPlayer> players, int keyElement, STDeck deck){
        STPlayer playerInQuestion = players.get(player);
        playerInQuestion.showHand(deck);
    }

//  dealer is chosen at random and show to user
    private static int selectDealer(int numPlayers)
    {
        Random rand = new Random();
        dealerID = rand.nextInt(numPlayers) + 1;

        if (dealerID == 0) {
            System.out.println("You are the dealer");
        }
        else {
            System.out.println("Dealer is player " + dealerID);
        }
        return dealerID;
    }

//    user selects amount of players. Must be between 3 and 6
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

//    users menu choice. Currently can only select 1 or 2 to start of exit game
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

//following three methods get username, show a welcome, and shows the game menu. All at the start of the game.

    private static String getUserName() {
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.nextLine();
        return name;
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