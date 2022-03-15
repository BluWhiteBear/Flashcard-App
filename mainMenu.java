import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class mainMenu extends app implements ActionListener {
    // UI Objects
    private JLabel deckName;
    private JButton newDeck;
    private JButton deckButton_1;
    private JButton deckButton_2;
    private JButton deckButton_3;
    private JButton deckButton_4;

    // Variable Declaration
    String deckFileName;

    public mainMenu() {
        // Construct components, sets command names, and sets their styles

        deckButton_1 = new JButton ("deckButton_1");
        deckButton_1.setActionCommand("deckButton_1");
        deckButton_1.setForeground(Color.BLACK);
        deckButton_1.setBackground(Color.WHITE);
        deckButton_1.setFocusPainted(false);

        deckButton_2 = new JButton ("deckButton_2");
        deckButton_2.setActionCommand("deckButton_2");
        deckButton_2.setForeground(Color.BLACK);
        deckButton_2.setBackground(Color.WHITE);
        deckButton_2.setFocusPainted(false);

        deckName = new JLabel ("Deck Name");

        deckButton_3 = new JButton ("deckButton_3");
        deckButton_3.setActionCommand("deckButton_3");
        deckButton_3.setForeground(Color.BLACK);
        deckButton_3.setBackground(Color.WHITE);
        deckButton_3.setFocusPainted(false);

        deckButton_4 = new JButton ("deckButton_4");
        deckButton_4.setActionCommand("deckButton_4");
        deckButton_4.setForeground(Color.BLACK);
        deckButton_4.setBackground(Color.WHITE);
        deckButton_4.setFocusPainted(false);

        newDeck = new JButton ("+");
        newDeck.setActionCommand("new_deck");
        newDeck.setForeground(Color.BLACK);
        newDeck.setBackground(Color.WHITE);
        newDeck.setFocusPainted(false);

        // Adjusts size and sets layout
        setPreferredSize(new Dimension(919, 333));
        setLayout(null);

        // Adds components
        add(deckButton_1);
        add(deckButton_2);
        add(deckButton_3);
        add(deckButton_4);
        add(deckName);
        add(newDeck);

        // Creates event listeners for buttons
        deckButton_1.addActionListener(this);
        deckButton_2.addActionListener(this);
        deckButton_3.addActionListener(this);
        deckButton_4.addActionListener(this);
        newDeck.addActionListener(this);

        // Sets component bounds
        deckButton_1.setBounds (190, 40, 550, 52);
        deckName.setBounds (430, 15, 70, 25);
        newDeck.setBounds (870, 5, 45, 45);
        deckButton_2.setBounds (190, 100, 550, 50);
        deckButton_3.setBounds (190, 160, 550, 50);
        deckButton_4.setBounds (190, 220, 550, 50);

    }

    // This is where the flashcards call their functions
    public void actionPerformed(ActionEvent e) {
        if ("deckButton_1".equals(e.getActionCommand())){
            System.out.println("Opening Deck Index 1...");
            openDeckIndex1();
        }
        else if ("deckButton_2".equals(e.getActionCommand())) {
            System.out.println("Opening Deck Index 2...");
            openDeckIndex2();
        }
        else if ("deckButton_3".equals(e.getActionCommand())) {
            System.out.println("Opening Deck Index 3...");
            openDeckIndex3();
        }
        else if ("deckButton_4".equals(e.getActionCommand())) {
            System.out.println("Opening Deck Index 4...");
            openDeckIndex4();
        }
        else if ("new_deck".equals(e.getActionCommand())) {
            System.out.println("Creating new deck...");
            createNewDeck();
        }
        else {
            System.out.println("Input error...");
            inputErrorMessage();
        }
    }

    static void openDeckIndex1() {
        displayFlashcards(frame);
    }

    static void openDeckIndex2() {

    }

    static void openDeckIndex3() {

    }

    static void openDeckIndex4() {

    }

    static void createNewDeck() {

    }

    static void inputErrorMessage() {
        JOptionPane.showMessageDialog(null, "Invalid input...", "Flash Cards | INPUT ERROR", 0);
    }
}
