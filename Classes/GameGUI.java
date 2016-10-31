import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by rylan on 26/10/2016.
 */
public class GameGUI extends JFrame {
    private JFrame gameFrame;
    private JLabel headLabel;
    private JLabel statusLabel;
    private JPanel gamePanel;
    private JButton[] cardButtons = new JButton[8];
    private String[] cardTitles = new String[8];
    JLabel yourTurn = new JLabel("My Turn", JLabel.CENTER);
    public ArrayList<Integer> hand = new ArrayList<Integer>();
    public Game game;
    public static STDeck deck = new STDeck();
    public static STPlayer players;


    public GameGUI(){
        preGameGUI();
        showHand(deck);

    }

    private void preGameGUI() {
        gameFrame = new JFrame("Mineral Game");
        gameFrame.setSize(700, 700);
        gameFrame.setLayout(new GridLayout(3, 1));
        gameFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);


        statusLabel.setSize(350, 100);

        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(1, 8));

        gameFrame.add(headLabel);

        gameFrame.add(statusLabel);
        gameFrame.setVisible(true);
    }



    public void showHand(STDeck deck) {
        yourTurn.setText("Here are your cards!");

        for (int i = 0; i < 8; i++ ){//player.hand.size(); i++) {
            cardButtons[i] = new JButton();
            ImageIcon image1 = new ImageIcon("C:\\Users\\rylan\\Desktop\\Uni Work\\2406 Ass\\res\\Slide" + deck.cards[hand.get(i) + 1] +".jpg");
            cardButtons[i].setLayout(new FlowLayout(FlowLayout.CENTER));
            cardButtons[i].setPreferredSize(new Dimension(100, 200));
            ImageIcon images2 = new ImageIcon((image1.getImage().getScaledInstance(200, 400, Image.SCALE_SMOOTH)));
            cardButtons[i].setIcon(images2);
//            cardButtons.addActionListener(ButtonClickedListener);
            cardButtons[i].setVisible(true);
            gamePanel.add(cardButtons[i], FlowLayout.LEFT);
            gameFrame.add(gamePanel);


        }



    }




    public static void main(String[] args) {
        GameGUI gameGUI = new GameGUI();

    }
}

