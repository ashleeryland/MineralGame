/**
 * Created by rylan on 22/10/2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Game {
    private static final String USERS_NAME = getUserName();
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public Game(){
        prepareGUI();
    }

    public static void main(String[] args){
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
        JButton startButton = new JButton("START");
        JButton quitButton = new JButton("QUIT");
        JButton helpButton = new JButton("HELP");
        helpButton.setHorizontalTextPosition(SwingConstants.LEFT);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                quitButton.setVisible(false);
                helpButton.setVisible(false);
                showPlayerChoice();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Ok Bye");
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

    private void showPlayerChoice(){

        headerLabel.setText("Pick number of players!");
        final Choice playersChoice = new Choice();

        playersChoice.add("3");
        playersChoice.add("4");
        playersChoice.add("5");
        playersChoice.add("6");

        Button selectButton = new Button("Select");

        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Number of Players selected: "
                        + playersChoice.getItem(playersChoice.getSelectedIndex());
                statusLabel.setText(data);
            }
        });

        controlPanel.add(playersChoice);
        controlPanel.add(selectButton);

        mainFrame.setVisible(true);
    }


    private static String getUserName() {
        String name = JOptionPane.showInputDialog("Enter name");
        return name;
    }
}