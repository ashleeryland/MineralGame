/**
 * Created by rylan on 23/10/2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainGUI {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    JButton startButton = new JButton("START");
    JButton quitButton = new JButton("QUIT");
    JButton helpButton = new JButton("HELP");
    JButton selectButton = new JButton("Select");
    final Choice playersChoice = new Choice();


    public MainGUI(){
        prepareGUI();
        showMenu();
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

    public void showMenu(){

        headerLabel.setText("Welcome " + Game.USERS_NAME +" to the Mineral Trump Card Game!");

        helpButton.setHorizontalTextPosition(SwingConstants.LEFT);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                quitButton.setVisible(false);
                helpButton.setVisible(false);
                showNumMenu();
                Game.startGame();
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


    private void showNumMenu() {
        STDeck deck = new STDeck();
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
                Game.getNumPlayers(numPlayers);
            }
        });
    }




}