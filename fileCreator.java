import java.io.FileWriter;
import java.io.IOException;

public class fileCreator extends app {

	public static void newFile(String deckName) {
		try (FileWriter myWriter = new FileWriter("decks/" + "deck_" + deckName + ".txt", true)) {
			myWriter.write(deckName);
		} catch (IOException e) {}

		System.out.println("Successfully created the file: " + deckName + ".txt");
		mainMenu.updateDeckArray();
		mainMenu.populateDeckButtons();
	}
}