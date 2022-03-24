import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.io.FileWriter;
// import java.io.IOException;
import java.io.IOException;

public class mainMenu extends app implements ActionListener {
    // UI Objects
    private JLabel deckName;
    private JButton newDeck;
    private JButton deckButton_1;
    private JButton deckButton_2;
    private JButton deckButton_3;
    private JButton deckButton_4;
    private JButton trash_1;
    private JButton trash_2;
    private JButton trash_3;
    private JButton trash_4;
    private JButton decrementPage;
    private JButton incrementPage;

    // Variable Declaration
    static String deckFileName;

    public mainMenu() {
        // Construct components, sets command names, and sets their styles

        deckButton_1 = new JButton ("deckButton_1");
        deckButton_1.setActionCommand("deckButton_1");
        deckButton_1.setForeground(fontColor);
        deckButton_1.setBackground(buttonColor);
        deckButton_1.setFocusPainted(false);
        deckButton_1.setBorderPainted(false);

        deckButton_2 = new JButton ("deckButton_2");
        deckButton_2.setActionCommand("deckButton_2");
        deckButton_2.setForeground(fontColor);
        deckButton_2.setBackground(buttonColor);
        deckButton_2.setFocusPainted(false);
        deckButton_2.setBorderPainted(false);

        deckName = new JLabel ("Deck Name");
        deckName.setForeground(fontColor);

        deckButton_3 = new JButton ("deckButton_3");
        deckButton_3.setActionCommand("deckButton_3");
        deckButton_3.setForeground(fontColor);
        deckButton_3.setBackground(buttonColor);
        deckButton_3.setFocusPainted(false);
        deckButton_3.setBorderPainted(false);

        deckButton_4 = new JButton ("deckButton_4");
        deckButton_4.setActionCommand("deckButton_4");
        deckButton_4.setForeground(fontColor);
        deckButton_4.setBackground(buttonColor);
        deckButton_4.setFocusPainted(false);
        deckButton_4.setBorderPainted(false);

        newDeck = new JButton ("+");
        newDeck.setActionCommand("new_deck");
        newDeck.setForeground(fontColor);
        newDeck.setBackground(buttonColor);
        newDeck.setFocusPainted(false);
        newDeck.setBorderPainted(false);

        trash_1 = new JButton ("🗑");
        trash_1.setActionCommand("trash_1");
        trash_1.setForeground(fontColor);
        trash_1.setBackground(buttonColor);
        trash_1.setFocusPainted(false);
        trash_1.setBorderPainted(false);

        trash_2 = new JButton ("🗑");
        trash_2.setActionCommand("trash_2");
        trash_2.setForeground(fontColor);
        trash_2.setBackground(buttonColor);
        trash_2.setFocusPainted(false);
        trash_2.setBorderPainted(false);

        trash_3 = new JButton ("🗑");
        trash_3.setActionCommand("trash_3");
        trash_3.setForeground(fontColor);
        trash_3.setBackground(buttonColor);
        trash_3.setFocusPainted(false);
        trash_3.setBorderPainted(false);

        trash_4 = new JButton ("🗑");
        trash_4.setActionCommand("trash_4");
        trash_4.setForeground(fontColor);
        trash_4.setBackground(buttonColor);
        trash_4.setFocusPainted(false);
        trash_4.setBorderPainted(false);

        decrementPage = new JButton ("<<");
        decrementPage.setActionCommand("");
        decrementPage.setForeground(fontColor);
        decrementPage.setBackground(buttonColor);
        decrementPage.setFocusPainted(false);
        decrementPage.setBorderPainted(false);

        incrementPage = new JButton (">>");
        incrementPage.setActionCommand("");
        incrementPage.setForeground(fontColor);
        incrementPage.setBackground(buttonColor);
        incrementPage.setFocusPainted(false);
        incrementPage.setBorderPainted(false);

        // Adjusts size and sets layout
        setPreferredSize(new Dimension(919, 333));
        setBackground(backgroundColor);
        setLayout(null);

        // Adds components
        add(deckButton_1);
        add(deckButton_2);
        add(deckButton_3);
        add(deckButton_4);
        add(deckName);
        add(newDeck);
        add(trash_1);
        add(trash_2);
        add(trash_3);
        add(trash_4);
        add(decrementPage);
        add(incrementPage);

        // Creates event listeners for buttons
        deckButton_1.addActionListener(this);
        deckButton_2.addActionListener(this);
        deckButton_3.addActionListener(this);
        deckButton_4.addActionListener(this);
        newDeck.addActionListener(this);
        trash_1.addActionListener(this);
        trash_2.addActionListener(this);
        trash_3.addActionListener(this);
        trash_4.addActionListener(this);
        decrementPage.addActionListener(this);
        incrementPage.addActionListener(this);
        

        // Sets component bounds
        deckButton_1.setBounds (190, 40, 495, 52);
        deckName.setBounds (430, 15, 70, 25);
        newDeck.setBounds (870, 5, 45, 45);
        deckButton_2.setBounds (190, 100, 495, 52);
        deckButton_3.setBounds (190, 160, 495, 52);
        deckButton_4.setBounds (190, 220, 495, 52);
        trash_1.setBounds (690, 40, 55, 52);
        trash_2.setBounds (690, 100, 55, 53);
        trash_3.setBounds (690, 160, 55, 52);
        trash_4.setBounds (690, 220, 55, 52);
        decrementPage.setBounds (190, 280, 100, 25);
        incrementPage.setBounds (645, 280, 100, 25);
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
            System.out.println("Opening new deck UI...");
            String deckFileName = JOptionPane.showInputDialog("What is the name of the deck.");
            createNewDeck(deckFileName);
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

    static void createNewDeck(String deckFileName) {
        try (
            FileWriter myWriter = new FileWriter(deckFileName + ".txt")) {
                myWriter.write(deckFileName + " Deck");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Successfully wrote to the file.");
    }

    static void inputErrorMessage() {
        JOptionPane.showMessageDialog(null, "Invalid input...", "Flash Cards | INPUT ERROR", 0);
    }
}
