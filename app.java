import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class app
{
    private static void buildGUI()
    {
        //Create window
        //Window name & close behavior
        JFrame frame = new JFrame("Flash Cards | Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Window icon
        ImageIcon icon = new ImageIcon("images/app_icon.png");
        frame.setIconImage(icon.getImage());

        

        //Window Content
        JLabel label = new JLabel("Body Text :)");
        frame.getContentPane().add(label);




        //Display window
        frame.pack();
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