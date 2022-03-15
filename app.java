import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class app extends JPanel
{
    //Creates and displays GUI
    public static JFrame frame = new JFrame("Flash Cards | Java Swing");

    public static void main (String[] args)
    {
        ImageIcon img = new ImageIcon("images/app_icon.png");
        frame.setIconImage(img.getImage());
        frame.setResizable(false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        displayFlashcards(frame);
    }

    static void displayFlashcards (JFrame window)
    {
        window.getContentPane().removeAll();
        window.getContentPane().add(new flashcard());
        window.revalidate();
        window.repaint();
        frame.pack();
    }

    static void displayMenu (JFrame window)
    {
        window.getContentPane().removeAll();
        window.getContentPane().add(new mainMenu());
        window.revalidate();
        window.repaint();
        frame.pack();
    }
}
