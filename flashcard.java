import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class flashcard extends app implements ActionListener
{
    // UI Objects
    private JButton flipCard;
    private JButton increaseCard;
    private JButton decreaseCard;
    private JLabel deckName;
    private JButton shuffleDeck;
    private JCheckBox markedOnlyToggle;
    private JCheckBox markedToggle;
    private JButton newCard;
    private JButton returnToMenu;

    // Variable Declaration
    // Output
    static String deckTitle = "Deck 1";
    static String cardText = "Card 1";
    static boolean cardIsMarked = false;

    // Input
    static int selectedCardIndex = 0;
    static boolean showOnlyMarked = false;

    public flashcard()
    {
        //Construct components, sets command names, and sets their styles
        flipCard = new JButton ("Card Text");
        flipCard.setActionCommand("flip_card");
        flipCard.setForeground(Color.BLACK);
        flipCard.setBackground(Color.WHITE);
        flipCard.setFocusPainted(false);

        increaseCard = new JButton (">");
        increaseCard.setActionCommand("increase_card");
        increaseCard.setForeground(Color.BLACK);
        increaseCard.setBackground(Color.WHITE);
        increaseCard.setFocusPainted(false);

        decreaseCard = new JButton ("<");
        decreaseCard.setActionCommand("decrease_card");
        decreaseCard.setForeground(Color.BLACK);
        decreaseCard.setBackground(Color.WHITE);
        decreaseCard.setFocusPainted(false);

        deckName = new JLabel ("Deck Name");

        shuffleDeck = new JButton ("Shuffle");
        shuffleDeck.setActionCommand("shuffle");
        shuffleDeck.setForeground(Color.BLACK);
        shuffleDeck.setBackground(Color.WHITE);
        shuffleDeck.setFocusPainted(false);

        markedOnlyToggle = new JCheckBox ("Marked cards only?");
        markedOnlyToggle.setActionCommand("toggle_show_marked");
        markedOnlyToggle.setFocusPainted(false);

        markedToggle = new JCheckBox ("Mark for later");
        markedToggle.setActionCommand("toggle_marked");
        markedToggle.setFocusPainted(false);

        newCard = new JButton ("+");
        newCard.setActionCommand("new_card");
        newCard.setForeground(Color.BLACK);
        newCard.setBackground(Color.WHITE);
        newCard.setFocusPainted(false);

        returnToMenu = new JButton ("Back");
        returnToMenu.setActionCommand("back");
        returnToMenu.setForeground(Color.BLACK);
        returnToMenu.setBackground(Color.WHITE);
        returnToMenu.setFocusPainted(false);

        //Adjusts size and sets layout
        setPreferredSize (new Dimension (919, 333));
        setLayout (null);

        //Adds components
        add (flipCard);
        add (increaseCard);
        add (decreaseCard);
        add (deckName);
        add (shuffleDeck);
        add (markedOnlyToggle);
        add (markedToggle);
        add (newCard);
        add (returnToMenu);

        //Creates event listeners for buttons
        flipCard.addActionListener(this);
        increaseCard.addActionListener(this);
        decreaseCard.addActionListener(this);
        shuffleDeck.addActionListener(this);
        markedOnlyToggle.addActionListener(this);
        markedToggle.addActionListener(this);
        newCard.addActionListener(this);
        returnToMenu.addActionListener(this);

        //Sets component bounds
        flipCard.setBounds (190, 45, 550, 192);
        increaseCard.setBounds (745, 110, 60, 60);
        decreaseCard.setBounds (125, 110, 60, 60);
        deckName.setBounds (430, 15, 70, 25);
        shuffleDeck.setBounds (350, 245, 220, 50);
        markedOnlyToggle.setBounds (5, 40, 145, 25);
        markedToggle.setBounds (570, 245, 110, 50);
        newCard.setBounds (870, 5, 45, 45);
        returnToMenu.setBounds (5, 5, 105, 30);
        
    }

    // This is where the flashcards call their functions
    public void actionPerformed(ActionEvent e) {
        if ("increase_card".equals(e.getActionCommand())) {
            System.out.println("Showing next card...");
            flashcard_input.increaseCardIndex();
        } else if ("decrease_card".equals(e.getActionCommand())) {
            System.out.println("Showing previous card...");
            flashcard_input.decreaseCardIndex();
        } else if ("shuffle".equals(e.getActionCommand())) {
            System.out.println("Deck of cards has been shuffled...");
        } else if ("flip_card".equals(e.getActionCommand())) {
            System.out.println("Flipping current card...");
            flashcard_input.flipCard();
        } else if ("toggle_show_marked".equals(e.getActionCommand())) {
            System.out.println("Now showing only marked cards...");
            flashcard_input.showOnlyMarked();
        } else if ("toggle_marked".equals(e.getActionCommand())) {
            System.out.println("This card has been marked for later...");
            flashcard_input.markCard();
        } else if ("new_card".equals(e.getActionCommand())) {
            System.out.println("Opening new card UI...");
            flashcard_input.newCard();
        } else if ("back".equals(e.getActionCommand())) {
            System.out.println("Returning to main menu...");
            flashcard_input.backToMenu();
        } else {
            System.out.println("Input error...");
            flashcard_input.inputErrorMessage();
        }
    }
}