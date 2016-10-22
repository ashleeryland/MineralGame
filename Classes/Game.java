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
        JButton okButton = new JButton("START");
        JButton javaButton = new JButton("QUIT");
        JButton cancelButton = new JButton("HELP");
        cancelButton.setHorizontalTextPosition(SwingConstants.LEFT);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Yep, we are starting");
            }
        });

        javaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Ok Bye");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Yep here are the rules");
            }
        });

        controlPanel.add(okButton);
        controlPanel.add(javaButton);
        controlPanel.add(cancelButton);

        mainFrame.setVisible(true);
    }

    private static String getUserName() {
        String name = JOptionPane.showInputDialog("Enter name");
        return name;
    }
}