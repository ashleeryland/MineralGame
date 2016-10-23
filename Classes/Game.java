/**
 * Created by rylan on 22/10/2016.
 */

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Game extends JFrame{
    public static final String USERS_NAME = getUserName();
    private static final int NUM_CARD_HAND_INIT = 8 ;


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
        STDeck deck = new STDeck();
        addPlayers(deck);
        JLabel youTurn = new JLabel("Your Turn!");
        showHand(0, players, 1, deck);
    }

    private static void addPlayers (STDeck deck)
    {
        STPlayer newPlayer;
        for(int i = 0; i < numPlayers; i++){
            newPlayer = new STPlayer();
            players.add(newPlayer);

            for (int j = 0; j < NUM_CARD_HAND_INIT; j++) {
                players.get(i).getsCard(deck);
            }
        }
        selectDealer(numPlayers);
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
        playerInQuestion.showHand(deck);
    }


    private static String getUserName() {
        String name = JOptionPane.showInputDialog("Enter name");
        return name;
    }

    public static int getNumPlayers(int numPlayers) {
        return numPlayers;
    }


}