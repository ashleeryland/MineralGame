/**
 * Created by rylan on 22/10/2016.
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;

public class Game extends JFrame{
    public static final String USERS_NAME = getUserName();
    private static final int NUM_CARD_HAND_INIT = 8 ;
    private static MainGame mainGUI;
    public Game game;
    public static STDeck deck = new STDeck();



    private static int numPlayers = 4;
    private static ArrayList<STPlayer> players = new ArrayList<STPlayer>();
    private static int dealerID;

    public static ArrayList<Integer> pile;
    private static int playersTurn;
    private static final int USER_PLAYER_NUM = 0;



    public static void main(String[] args){

        MainGUI mainFrame = new MainGUI();
    }

    public static void startGame(){
        addPlayers(deck);
        showHand(0, players, 1, deck);

//        boolean gameOver = false;
//
//
//        pile = new ArrayList<Integer>();
//        playersTurn = dealerID + 1;
//        if (playersTurn > numPlayers + -1) {
//            playersTurn = USER_PLAYER_NUM;
//        }
//
//
//        int keyCategory = 6;
//        int passCounter = 0;
//
//        while (!gameOver) {
//
//
//            boolean didPickUp = false;
//
//            if (playersTurn != USER_PLAYER_NUM) {
//                didPickUp = players.get(playersTurn).takeTurn(keyCategory, pile, deck, playersTurn);
//                if (didPickUp == true) {
//                    passCounter += 1;
//                } else {
//                    passCounter = 0;
//                }
//
//            } else {
//                //users turn to play
//                JLabel yourTurn = new JLabel("", JLabel.CENTER);
//                showHand(0, players, 1, deck);
//
//
//                boolean turnOver = true;
//
//                //if there are no cards on the pile user selects card and category
//                if (pile.size() == 0) {
//                    Scanner selectCard = new Scanner(System.in);
//                    System.out.print("Enter card: ");
//                    int userCardPlayed = selectCard.nextInt();
//
//                    Scanner userCatInput = new Scanner(System.in);
//                    System.out.print("Pick a Category:");
//                    System.out.print("  6 = HARDNESS");
//                    System.out.print("  7 = SPECIFIC GRAVITY");
//                    System.out.print("  8 = CLEAVAGE");
//                    System.out.print("  9 = CRUSTAL ABUNDANCE");
//                    System.out.print("  10 = ECONOMIC VALUE");
//                    keyCategory = userCatInput.nextInt();
//
//                    int usersCard = players.get(0).hand.remove(userCardPlayed);
//                    System.out.println("You played card " + usersCard + " with the category " + keyCategory);
//
//                    pile.add(usersCard);
//                    passCounter = 0;
//                    turnOver = false;
//                }
//
//                while (turnOver) {
//
//                    Scanner input = new Scanner(System.in);
//                    System.out.print("Enter card or p to pick up a card: ");
//                    String userCardInput = input.nextLine();
//
//                    //if the user is picking up a card
//                    if (userCardInput.equals("p")) {
//                        players.get(0).getsCard(deck);
//                        System.out.println("You picked up a card");
//                        passCounter += 1;
//                        turnOver = false;
//                    }
//
//                    else {
//                        //checking to see if users card is higher than the last card played
//                        int userCardPlayed = Integer.parseInt(userCardInput);
//                        Double usersCardCategory = Double.parseDouble(deck.cards[players.get(0).hand.get(userCardPlayed)][keyCategory]);
//                        Double pileCategory = Double.parseDouble(deck.cards[pile.get(pile.size() - 1)][keyCategory]);
//
//                        if (usersCardCategory > pileCategory) {
//                            int usersCard = players.get(0).hand.remove(userCardPlayed);
//
//                            System.out.println("You played card " + usersCard);
//
//                            passCounter = 0;
//                            pile.add(usersCard);
//                            turnOver = false;
//                        }
//
//                        else {
//                            System.out.println("Incorrect Choice");
//                        }
//                    }
//                }
//            }
//
//            //if all players pass new round starts and new category
//            if (passCounter > numPlayers - 2) {
//                System.out.println("All players have passed, new round!");
//                deck.returnToDeck(pile);
//                pile.clear();
//                passCounter = 0;
//                keyCategory = +1;
//            }
//
//
//            playersTurn += 1;
//            if (playersTurn > numPlayers - 1) {
//                playersTurn = USER_PLAYER_NUM;
//            }
//
//            if (players.get(playersTurn).getHandSize() == 0) {
//                gameOver = true;
//                if (playersTurn == 0) {
//                    System.out.println("Game Over!" + " Congratulations " + USERS_NAME + " you won!" );
//                }
//                else {
//                    System.out.println("Game Over!" + " Winner is player " + playersTurn);
//                }
//                System.exit(0);
//            }
//
//        }

    }











    public static void addPlayers(STDeck deck)
    {
        STPlayer newPlayer;
        for(int i = 0; i < numPlayers; i++){
            newPlayer = new STPlayer();
            players.add(newPlayer);

            for (int j = 0; j < NUM_CARD_HAND_INIT; j++) {
                players.get(i).getsCard(deck);
            }
        }
        System.out.println("Add Players done");
    }

    private static int selectDealer(int numPlayers)
    {
        Random rand = new Random();
        dealerID = rand.nextInt(numPlayers) + 1;

        if (dealerID == 1) {
            JOptionPane.showMessageDialog(null, "You are the dealer!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Dealer is player " + dealerID);
        }

        return dealerID;
    }

    private static void showHand(int player, ArrayList<STPlayer> players, int keyElement, STDeck deck){
        STPlayer playerInQuestion = players.get(player);

    }


    private static String getUserName() {
        String name = JOptionPane.showInputDialog("Enter name");
        return name;
    }

    public static int getNumPlayers(int numPlayers) {
        selectDealer(numPlayers);
        return numPlayers;
    }


}