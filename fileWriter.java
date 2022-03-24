import java.io.FileWriter;
// import java.io.IOException;
import java.io.IOException;

public class fileWriter extends mainMenu {
    public static void main(String[] args) {
        try (
            FileWriter myWriter = new FileWriter(deckFileName + ".txt")) {
                // myWriter.write("Just had to add try and catch stuff");
                // myWriter.write("\n1Just had to add try and catch stuff");
                myWriter.write("\n2Just had to add try and catch stuff");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Successfully wrote to the file.");
    }
    
}
