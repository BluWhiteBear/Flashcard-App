import java.awt.*;
import javax.swing.*;
import java.io.IOException;

public class app extends JPanel
{
	Color backgroundColor = (new Color(24, 24, 24));
	Color buttonColor = (new Color(35, 35, 35));
	Color fontColor = (new Color(255, 255, 255));

	static String decks[];
	static String selectedDeckFileName;

	//Creates and displays GUI
	public static JFrame frame = new JFrame("Flash Cards | Java Swing");

	public static void main(String[] args)
    {
		ImageIcon img = new ImageIcon("images/app_icon.png");
		frame.setIconImage(img.getImage());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// Adds main menu to viewport at app start
		displayMenu(frame);
	}

	static void displayFlashcards(JFrame window) throws IOException
    {
		window.getContentPane().removeAll();
		window.getContentPane().add(new flashcard());
		window.revalidate();
		window.repaint();
		frame.pack();
	}

	static void displayMenu(JFrame window)
    {
		window.getContentPane().removeAll();
		window.getContentPane().add(new mainMenu());
		window.revalidate();
		window.repaint();
		frame.pack();
	}
}