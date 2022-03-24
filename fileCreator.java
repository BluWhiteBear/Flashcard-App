import java.io.FileWriter;
import java.io.IOException;

public class fileCreator extends app {

    public static void newFile(String deckFileName) {
        try (
            FileWriter myWriter = new FileWriter(deckFileName + ".txt", true)) {

                myWriter.write(deckFileName + " Deck");
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Successfully wrote to the file.");
    }

    public static void delFile() {
        
    }

    public static void editFile() {
        
    }
    
}
