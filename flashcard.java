import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class flashcard extends app implements ActionListener {
	// UI Objects
	private static JLabel deckName;
	private static JButton flipCard;
	private JButton increaseCard;
	private JButton decreaseCard;
	private JButton shuffleDeck;
	private JCheckBox markedOnlyToggle;
	private JCheckBox markedToggle;
	private JButton newCard;
	private JButton returnToMenu;

	// Variable Declaration

	// static String newCardData;
	// Output

	static String deckTitle;
	static String cardText;
	static String cardTextBack;
	static boolean cardIsMarked;

	static int deckLength;

	// Input
	static int selectedCardIndex = 0;
	static boolean showOnlyMarked = false;
	static String newCardDataFront;
	static String newCardDataBack;

	public flashcard() throws IOException {

		//Construct components, sets command names, and sets their styles
		flipCard = new JButton(cardText);
		flipCard.setActionCommand("flip_card");
		flipCard.setForeground(fontColor);
		flipCard.setBackground(buttonColor);
		flipCard.setFocusPainted(false);
		flipCard.setBorderPainted(false);

		increaseCard = new JButton(">");
		increaseCard.setActionCommand("increase_card");
		increaseCard.setForeground(fontColor);
		increaseCard.setBackground(buttonColor);
		increaseCard.setFocusPainted(false);
		increaseCard.setBorderPainted(false);

		decreaseCard = new JButton("<");
		decreaseCard.setActionCommand("decrease_card");
		decreaseCard.setForeground(fontColor);
		decreaseCard.setBackground(buttonColor);
		decreaseCard.setFocusPainted(false);
		decreaseCard.setBorderPainted(false);

		deckName = new JLabel(deckTitle, SwingConstants.CENTER);
		deckName.setForeground(fontColor);

		shuffleDeck = new JButton("Shuffle");
		shuffleDeck.setActionCommand("shuffle");
		shuffleDeck.setForeground(fontColor);
		shuffleDeck.setBackground(buttonColor);
		shuffleDeck.setFocusPainted(false);
		shuffleDeck.setBorderPainted(false);

		markedOnlyToggle = new JCheckBox("Marked cards only?");
		markedOnlyToggle.setActionCommand("toggle_show_marked");
		markedOnlyToggle.setForeground(fontColor);
		markedOnlyToggle.setBackground(backgroundColor);
		markedOnlyToggle.setFocusPainted(false);
        markedOnlyToggle.setEnabled(false);

		markedToggle = new JCheckBox("Mark for later");
		markedToggle.setActionCommand("toggle_marked");
		markedToggle.setForeground(fontColor);
		markedToggle.setBackground(backgroundColor);
		markedToggle.setFocusPainted(false);
        markedToggle.setEnabled(false);

		newCard = new JButton("+");
		newCard.setActionCommand("new_card");
		newCard.setForeground(fontColor);
		newCard.setBackground(buttonColor);
		newCard.setFocusPainted(false);
		newCard.setBorderPainted(false);

		returnToMenu = new JButton("Back");
		returnToMenu.setActionCommand("back");
		returnToMenu.setForeground(fontColor);
		returnToMenu.setBackground(buttonColor);
		returnToMenu.setFocusPainted(false);
		returnToMenu.setBorderPainted(false);

		//Adjusts size and sets layout
		setPreferredSize(new Dimension(919, 333));
		setBackground(backgroundColor);
		setLayout(null);

		//Adds components
		add(flipCard);
		add(increaseCard);
		add(decreaseCard);
		add(deckName);
		add(shuffleDeck);
		add(markedOnlyToggle);
		add(markedToggle);
		add(newCard);
		add(returnToMenu);

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
		flipCard.setBounds(190, 45, 550, 192);
		increaseCard.setBounds(745, 110, 60, 60);
		decreaseCard.setBounds(125, 110, 60, 60);
		deckName.setBounds(190, 15, 550, 30);
		shuffleDeck.setBounds(350, 245, 220, 50);
		markedOnlyToggle.setBounds(5, 40, 145, 25);
		markedToggle.setBounds(570, 245, 110, 50);
		newCard.setBounds(855, 10, 50, 50);
		returnToMenu.setBounds(5, 5, 105, 30);

		updateCurrentCard();
	}

	// Updates the current card based on the selected deck and index
	public static void updateCurrentCard() throws IOException {

		// List that holds strings of a file
		List<String> listOfCards = new ArrayList<String> ();

		// Loads data from txt file
		BufferedReader fileFinder = new BufferedReader(new FileReader("decks/" + selectedDeckFileName));

		// Converts txt file lines into strings
		String line = fileFinder.readLine();

		// Checks for end of txt file
		while (line != null) {
			listOfCards.add(line);
			line = fileFinder.readLine();
		}

		// Closes bufferreader object
		fileFinder.close();

		// Stores the data in arraylist to array
		String cardInfo[] = listOfCards.toArray(new String[0]);
		deckLength = cardInfo.length;
		try {
			deckTitle = cardInfo[0];
			cardText = cardInfo[1 + (selectedCardIndex * 3)];
			cardTextBack = cardInfo[2 + (selectedCardIndex * 3)];
			cardIsMarked = Boolean.parseBoolean(cardInfo[3 + (selectedCardIndex * 3)]);
			updateFlashcardText();
		} catch (Exception e) {}
	}

	public static void updateFlashcardText()

	{
		try {
			deckName.setText(deckTitle);
			flipCard.setText(cardText);
		} catch (Exception e) {}
	}

	// This is where the flashcards call their functions
	public void actionPerformed(ActionEvent e) {
		if ("increase_card".equals(e.getActionCommand())) {
			System.out.println("Showing next card...");
			try {
				increaseCardIndex();
			} catch (IOException e1) {}
		} else if ("decrease_card".equals(e.getActionCommand())) {
			System.out.println("Showing previous card...");
			try {
				decreaseCardIndex();
			} catch (IOException e2) {}
		} else if ("shuffle".equals(e.getActionCommand())) {
			System.out.println("Deck of cards has been shuffled...");
			try {
				shuffle();
			} catch (IOException e1) {}
		} else if ("flip_card".equals(e.getActionCommand())) {
			System.out.println("Flipping current card...");
			flipCard();
		} else if ("toggle_show_marked".equals(e.getActionCommand())) {
			System.out.println("Now showing only marked cards...");
			showOnlyMarked();
		} else if ("toggle_marked".equals(e.getActionCommand())) {
			System.out.println("This card has been marked for later...");
			markCard();
		} else if ("new_card".equals(e.getActionCommand())) {
			System.out.println("Opening new card UI...");
			newCardDataFront = JOptionPane.showInputDialog("Card info \nFront");
			newCardDataBack = JOptionPane.showInputDialog("Card info \nBack");
			newCard();
            try {
                updateCurrentCard();
            } catch (IOException e1) {}
		} else if ("back".equals(e.getActionCommand())) {
			System.out.println("Returning to main menu...");
			backToMenu();
		} else {
			System.out.println("Input error...");
			inputErrorMessage();
		}
	}

	static void increaseCardIndex() throws IOException {
		if ((selectedCardIndex + 1)<= (deckLength / 3 - 1)) {
			selectedCardIndex++;
			updateCurrentCard();
		}
	}

	static void decreaseCardIndex() throws IOException {
		if ((selectedCardIndex - 1) >= 0) {
			selectedCardIndex--;
			updateCurrentCard();
		}
	}
	static void flipCard() {
		if (flipCard.getText() == cardText) {
			flipCard.setText(cardTextBack);
		} else {
			flipCard.setText(cardText);
		}
	}
	static void shuffle() throws IOException {
		selectedCardIndex = (int)((Math.random() * ((deckLength / 3))));
		updateCurrentCard();
	}
	static void showOnlyMarked() {}
	static void markCard() {}
	static void newCard() {
		try (FileWriter myWriter = new FileWriter("decks/" + selectedDeckFileName, true)) {
			myWriter.write("\n" + newCardDataFront);
			myWriter.write("\n" + newCardDataBack);
			myWriter.write("\nFALSE");
		} catch (IOException e) {}
	}
	static void backToMenu() {
		displayMenu(frame);
	}
	static void inputErrorMessage() {
		JOptionPane.showMessageDialog(null, "Invalid input...", "Flash Cards | INPUT ERROR", 0);
	}
}