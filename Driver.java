import java.util.ArrayList;
public class Driver {
  public static void main(String[] args) {
    WordSearch ws = new WordSearch(5, 5, "words.txt");
    ArrayList<String>wta = ws.getWordsToAdd();
    System.out.println("Words to add: " + wta);
    System.out.println(ws);

    /*/
    System.out.println("Initializing new WordSearch with 5 rows and 4 columns");
    WordSearch fiveFour = new WordSearch(5, 4);
    System.out.println("This is how it looks: ");
    System.out.println(fiveFour);
    //
    System.out.println("Let's try adding HELLO vertically starting at top left corner: ");
    fiveFour.addWordVertical("HELLO", 0, 0);
    System.out.println(fiveFour);
    //
    System.out.println("Let's try adding HEYA horizontally from the same place as HELLO: ");
    fiveFour.addWordHorizontal("HEYA", 0, 0);
    System.out.println(fiveFour);
    //
    System.out.println("Let's try adding HERA diagonally from the same H in the top left corner");
    fiveFour.addWordDiagonal("HERA", 0, 0);
    System.out.println(fiveFour);
    //
    System.out.println("Can we add HELLO vertically from the first row second column?: (no, expect no change in fiveFour)");
    fiveFour.addWordVertical("HELLO", 0, 1);
    System.out.println(fiveFour);
    //
    System.out.println("Can we add HEYA from the first row second column?: (no, expect no change in fiveFour)");
    fiveFour.addWordHorizontal("HEYA", 0, 1);
    System.out.println(fiveFour);
    //
    System.out.println("Can we add HERA from the first row second column?: (no, expect no change in fiveFour)");
    fiveFour.addWordDiagonal("HERA", 0, 1);
    System.out.println(fiveFour);
    //
    System.out.println("Adding words that are too long?: (expect no change)");
    fiveFour.addWordHorizontal("CATASTROPHE", 1, 1);
    fiveFour.addWordVertical("CATASTROPHE", 1, 1);
    fiveFour.addWordDiagonal("CATASTROPHE", 1, 1);
    System.out.println(fiveFour);
    /*/


  }
}
