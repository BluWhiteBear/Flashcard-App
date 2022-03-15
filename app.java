import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class app extends JPanel
{
    //Creates and displays GUI
    public static void main (String[] args)
    {
        JFrame frame = new JFrame ("Flash Cards | Java Swing");
        ImageIcon img = new ImageIcon("images/app_icon.png");
        frame.setIconImage(img.getImage());
        frame.setResizable(false);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new flashcard());
        frame.pack();
        frame.setVisible (true);
    }
}