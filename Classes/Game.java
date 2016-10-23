/**
 * Created by rylan on 22/10/2016.
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Game {
    private static final String USERS_NAME = getUserName();
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    JButton startButton = new JButton("START");
    JButton quitButton = new JButton("QUIT");
    JButton helpButton = new JButton("HELP");
    JButton selectButton = new JButton("Select");
    final Choice playersChoice = new Choice();

    private static final int NEW_GAME = 1;
    private static final int END_GAME = 2;
    private static final int NUM_CARD_HAND_INIT = 8 ;

    private static int numPlayers;
    private static ArrayList<STPlayer> players = new ArrayList<STPlayer>();
    private static int dealerID;

    public static ArrayList<Integer> pile;
    private static int playersTurn;
    private static final int USER_PLAYER_NUM = 0;

    public Game(){
        prepareGUI();
    }

    public static void main(String[] args){
        STDeck deck = new STDeck();
        Game gameMenu = new Game();
        gameMenu.showMenu();

    }

    private void prepareGUI(){
        mainFrame = new JFrame("Mineral Game");
        mainFrame.setSize(700,700);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);

        statusLabel.setSize(350,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showMenu(){

        headerLabel.setText("Welcome " + USERS_NAME + " to the Mineral Trump Card Game!");

        helpButton.setHorizontalTextPosition(SwingConstants.LEFT);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                quitButton.setVisible(false);
                helpButton.setVisible(false);
                getNumPlayers();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Yep here are the rules");
            }
        });

        controlPanel.add(startButton);
        controlPanel.add(quitButton);
        controlPanel.add(helpButton);

        mainFrame.setVisible(true);
    }


    private void getNumPlayers(){
        headerLabel.setText("Pick number of players!");

        playersChoice.add("3");
        playersChoice.add("4");
        playersChoice.add("5");
        playersChoice.add("6");


        controlPanel.add(playersChoice);
        controlPanel.add(selectButton);
        mainFrame.setVisible(true);

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numPlayers = Integer.parseInt(playersChoice.getItem(playersChoice.getSelectedIndex()));
                statusLabel.setText("You have picked " + numPlayers + " number of players!");
            }
        });
    }

//    private static int showNum(int numPlayers) {
//        System.out.println("HELLO " + numPlayers);
//        return numPlayers;
//    }


    private static int addPlayers(STDeck deck)
    {
        STPlayer newPlayer;
        for(int i = 0; i < Game.numPlayers; i++){
            newPlayer = new STPlayer();
            players.add(newPlayer);

            for (int j = 0; j < NUM_CARD_HAND_INIT; j++) {
                players.get(i).getsCard(deck);
            }
        }
        dealerID = selectDealer(Game.numPlayers);
        System.out.println("HELLLLLO" + players);
        return Game.numPlayers;
    }

    private static int selectDealer(int numPlayers)
    {
        Random rand = new Random();
        dealerID = rand.nextInt(Game.numPlayers) + 1;

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
}