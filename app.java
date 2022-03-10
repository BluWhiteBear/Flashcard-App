import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

public class app
{
    private static void buildGUI()
    {
        //Create window
        //Window name, resolution & close behavior
        JFrame frame = new JFrame("Flash Cards | Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(640, 360));
        frame.setLayout(null);
        //Window icon
        ImageIcon icon = new ImageIcon("images/app_icon.png");
        frame.setIconImage(icon.getImage());



        //Window Content
        JLabel label = new JLabel("Body Text :)");
        frame.getContentPane().add(label);

        JButton button1 = new JButton("Button 1 Text");
        button1.setVerticalTextPosition(AbstractButton.CENTER);
        button1.setHorizontalTextPosition(AbstractButton.LEADING);
        Dimension size = button1.getPreferredSize();
        button1.setBounds(100, 50, size.width, size.height);

        frame.getContentPane().add(button1);




        JButton button2 = new JButton("Button 2 Text");
        button2.setVerticalTextPosition(AbstractButton.CENTER);
        button2.setHorizontalTextPosition(AbstractButton.CENTER);

        button2.setBounds(300, 180, size.width, size.height);

        frame.getContentPane().add(button2);






        //Display window in center of screen
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                buildGUI();
            }
        });
    }
}

//harry
