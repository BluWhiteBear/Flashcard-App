import javax.swing.JOptionPane;

public class flashcard_input extends app
{
    static void increaseCardIndex ()
    {
        if ((selectedCardIndex + 1) <= 10)
        selectedCardIndex ++;
    }

    static void decreaseCardIndex ()
    {
        if ((selectedCardIndex - 1) > 0)
        selectedCardIndex --;
    }

    static void flipCard ()
    {

    }

    static void showOnlyMarked ()
    {

    }

    static void markCard ()
    {

    }

    static void newCard ()
    {

    }

    static void backToMenu ()
    {
        
    }

    static void inputErrorMessage ()
    {
        JOptionPane.showMessageDialog(null, "Invalid input...", "Flash Cards | INPUT ERROR", 0);
    }
}
