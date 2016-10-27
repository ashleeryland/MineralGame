import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Created by rylan on 26/10/2016.
 */
public class GameGUI {
    private JFrame gameFrame;
    private JLabel headLabel;
    private JLabel statusLabel;
    private JPanel gamePanel;
    JLabel yourTurn = new JLabel("My Turn", JLabel.CENTER);
//    final JButton[] cardButtons = new JButton[]{};
    public Game game;
    public static STDeck deck = new STDeck();
    public static STPlayer players;

    public GameGUI(){
        preGameGUI();
        viewHand(deck);
    }

    private void preGameGUI(){
        gameFrame = new JFrame("Mineral Game");
        gameFrame.setSize(700,700);
        gameFrame.setLayout(new GridLayout(3, 1));
        gameFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);


        statusLabel.setSize(350,100);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(1,8));

        gameFrame.add(headLabel);
        gameFrame.add(gamePanel);
        gameFrame.add(statusLabel);
        gameFrame.setVisible(true);
    }

    public void viewHand(STDeck deck) {

        String[] butonNames = {};

        yourTurn.setText("Here are your cards!");
        Game.getNumPlayers(4);
        Game.addPlayers(deck);

        for (int i = 0; i < 8; i++ ){//player.hand.size(); i++) {
            JButton cardButtons = new JButton();
            ImageIcon image = new ImageIcon("res\\Slide"+ deck.cards[players.hand.get(i) +1]);
            cardButtons.setLayout(new FlowLayout(FlowLayout.CENTER));
            cardButtons.setPreferredSize(new Dimension(200, 400));
            ImageIcon images = new ImageIcon((image.getImage().getScaledInstance(200, 400, Image.SCALE_SMOOTH)));
            cardButtons.setIcon(images);
//            cardButtons.addActionListener();
            gamePanel.add(cardButtons, FlowLayout.LEFT);
        }

    }

    public static void main(String[] args) {
        GameGUI gameGUI = new GameGUI();

    }
}

