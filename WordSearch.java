import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
public class WordSearch{
    private char[][]data;
    //the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String>wordsToAdd = new ArrayList<String>();

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String>wordsAdded = new ArrayList<String>();

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols, String fileName){
      try {
        data = new char[rows][cols];
        for (int i = 0; i<data.length; i++) {
          for (int j = 0; j<data[i].length; j++) {
            data[i][j] = '_';
          }
        }
        randgen = new Random();
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        while (in.hasNext()) {
          String word = in.nextLine();
          word = word.trim();
          wordsToAdd.add(word);
        }
      }catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        System.exit(1);
      }
    }

    public WordSearch(int rows,int cols, String fileName, int randSeed){
      try {
        data = new char[rows][cols];
        for (int i = 0; i<data.length; i++) {
          for (int j = 0; j<data[i].length; j++) {
            data[i][j] = '_';
          }
        }
        randgen = new Random(randSeed);
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        while (in.hasNext()) {
          String word = in.next();
          wordsToAdd.add(word);
        }
      }catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        System.exit(1);
      }
    }

    public ArrayList<String> getWordsToAdd() {
      return wordsToAdd;
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int i = 0; i<data.length; i++) {
        for (int j = 0; j<data[i].length; j++) {
          data[i][j] = '_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String formatted = "";
      for (int i = 0; i<data.length; i++) {
        formatted+="| ";
        for (int j = 0; j<data[i].length; j++) {
          formatted+=(data[i][j] + " ");
        }
        formatted+=" |\n";
      }
      return formatted;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
      //if (word.length() > data[0].length) {
      //  return false;
      //}
      for (int i = 0; i<word.length(); i++) {
        if (col+i >= data[row].length || (word.charAt(i) != data[row][col+i] && data[row][col+i] != '_')) {
          return false;
        }
      }
      for (int i = 0; i<word.length(); i++) {
            data[row][col+i] = word.charAt(i);
      }
      return true;
    }



   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
      for (int i = 0; i<word.length(); i++) {
        if (row+i >= data.length || (word.charAt(i) != data[row+i][col] && data[row+i][col] != '_')) {
          return false;
        }
      }
      for (int i = 0; i<word.length(); i++) {
        data[row+i][col] = word.charAt(i);
      }
    return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
    *The word is added from top left to bottom right, must fit on the WordGrid,
    *and must have a corresponding letter to match any letters that it overlaps.
    *
    *@param word is any text to be added to the word grid.
    *@param row is the vertical locaiton of where you want the word to start.
    *@param col is the horizontal location of where you want the word to start.
    *@return true when the word is added successfully. When the word doesn't fit,
    *or there are overlapping letters that do not match, then false is returned.
    */
   public boolean addWordDiagonal(String word,int row, int col){
     for (int i = 0; i<word.length(); i++) {
       if (row+i >= data.length || col+i >= data[row].length || (word.charAt(i) != data[row+i][col+i] && data[row+i][col+i] != '_')) {
         return false;
       }
     }
     for (int i = 0; i<word.length(); i++) {
       data[row+i][col+i] = word.charAt(i);
     }
     return true;
   }
}
