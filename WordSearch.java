import java.lang.Math;
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
     /*
     String directions = "Please exit the program and retry \n The order of
                          parameters must be either: \n
                          java Driver rows(int) cols(int) filename(string) \n
                          java Driver rows(int) cols(int) filename(string) randomSeed(int) \n
                          java Driver rows(int) cols (int) filenamde(string) randomSeed(int) answers(string --> should read key) \n";
    */
     public static void main(String[] args) {
       try{
         if (args.length  == 3) {
           Random seedMake = new Random();
           int fillerSeed = seedMake.nextInt() % 100;
           WordSearch ws = new WordSearch(Integer.parseInt(args[0]),
                                         Integer.parseInt(args[1]), args[2], fillerSeed, "hey");
           System.out.println(ws);
         }
         else if (args.length == 4) {
           WordSearch ws = new WordSearch(Integer.parseInt(args[0]),
                                           Integer.parseInt(args[1]), args[2],
                                           Integer.parseInt(args[3]), "hey");
           System.out.println(ws);
         }
         else if (args.length == 5) {
           WordSearch ws = new WordSearch(Integer.parseInt(args[0]),
                                           Integer.parseInt(args[1]), args[2],
                                           Integer.parseInt(args[3]), args[4]);
           System.out.println(ws);
         }
         else {
           System.out.println("The order of parameters must be either: ");
           System.out.println("java WordSearch rows(int) cols(int) filename(string)");
           System.out.println("java WordSearch rows(int) cols(int) filename(string) randomSeed(int)");
           System.out.println("java WordSearch rows(int) cols (int) filenamde(string) randomSeed(int) answers(string --> should read key)");
         }
       }catch(FileNotFoundException e){
         System.out.println("Welcome to WordSearch2018! Here is how to input args: \n The order of parameters must be either: ");
         System.out.println("java WordSearch rows(int) cols(int) filename(string)");
         System.out.println("java WordSearch rows(int) cols(int) filename(string) randomSeed(int)");
         System.out.println("java WordSearch rows(int) cols (int) filenamde(string) randomSeed(int) answers(string --> should read key)");
         System.out.println("File not found: " + args[2]);
         System.exit(1);
       }catch(NegativeArraySizeException e){
         System.out.println("Welcome to WordSearch2018! Here is how to input args: \n The order of parameters must be either: ");
         System.out.println("java WordSearch rows(int) cols(int) filename(string)");
         System.out.println("java WordSearch rows(int) cols(int) filename(string) randomSeed(int)");
         System.out.println("java WordSearch rows(int) cols (int) filenamde(string) randomSeed(int) answers(string --> should read key)");
         System.out.println("Please rerun program and input positive integers for row and column size");
         System.exit(1);
       }catch(ArrayIndexOutOfBoundsException e){
         System.out.println("Welcome to WordSearch2018! Here is how to input args: \nThe order of parameters must be either: ");
         System.out.println("java WordSearch rows(int) cols(int) filename(string)");
         System.out.println("java WordSearch rows(int) cols(int) filename(string) randomSeed(int)");
         System.out.println("java WordSearch rows(int) cols (int) filenamde(string) randomSeed(int) answers(string --> should read key)");
         System.out.println("Must have at least 1 row, please retry");
         System.exit(1);
       }catch(NumberFormatException e){
         System.out.println("Welcome to WordSearch2018! Here is how to input args: \n The order of parameters must be either: ");
         System.out.println("java WordSearch rows(int) cols(int) filename(string)");
         System.out.println("java WordSearch rows(int) cols(int) filename(string) randomSeed(int)");
         System.out.println("java WordSearch rows(int) cols (int) filenamde(string) randomSeed(int) answers(string --> should read key)");
         System.out.println("Please input integers for rows and cols");
       }

     }
/*
    public WordSearch(int rows, int cols, String fileName) throws FileNotFoundException{
      //try {
        data = new char[rows][cols];
        for (int i = 0; i<data.length; i++) {
          for (int j = 0; j<data[i].length; j++) {
            data[i][j] = '_';
          }
        }
        Random seedMake = new Random();
        seed = seedMake.nextInt() % 100;
        randgen = new Random(seed);
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        while (in.hasNext()) {
          String word = in.nextLine();
          word = word.trim();
          word = word.toUpperCase();
          wordsToAdd.add(word);
        }
        addAllWords();
        fillRest();
      }catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        System.exit(1);
      }catch(NegativeArraySizeException e){
        System.out.println("Please rerun program and input positive integers for row and column size");
        System.exit(1);
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Must have at least 1 row, please retry");
        System.exit(1);
      }
    }

    public WordSearch(int rows,int cols, String fileName, int randSeed) throws FileNotFoundException{
      //try {
        data = new char[rows][cols];
        for (int i = 0; i<data.length; i++) {
          for (int j = 0; j<data[i].length; j++) {
            data[i][j] = '_';
          }
        }
        seed = randSeed;
        randgen = new Random(seed);
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        while (in.hasNext()) {
          String word = in.next();
          word = word.trim();
          word = word.toUpperCase();
          wordsToAdd.add(word);
        }
        addAllWords();
        fillRest();
      }catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        System.exit(1);
      }catch(NegativeArraySizeException e){
        System.out.println("Please rerun program and input positive integers for row and column size");
        System.exit(1);
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Must have at least 1 row, please retry");
        System.exit(1);
      }
    }
  */
    public WordSearch(int rows,int cols, String fileName, int randSeed, String answers) throws FileNotFoundException{
      //try {
        data = new char[rows][cols];
        for (int i = 0; i<data.length; i++) {
          for (int j = 0; j<data[i].length; j++) {
            data[i][j] = '_';
          }
        }
        seed = randSeed;
        randgen = new Random(seed);
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        while (in.hasNext()) {
          String word = in.next();
          word = word.trim();
          word = word.toUpperCase();
          wordsToAdd.add(word);
        }
        addAllWords();
        if (!answers.equals("key")) {
          fillRest();
        }
        else {
          removeUnderscores();
        }
        //fillRest(); without this, it's just the answers
      /*}catch(FileNotFoundException e){
        System.out.println("File not found: " + fileName);
        System.exit(1);
      }catch(NegativeArraySizeException e){
        System.out.println("Please rerun program and input positive integers for row and column size");
        System.exit(1);
      }catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Must have at least 1 row, please retry");
        System.exit(1);
      }*/
    }

    private void removeUnderscores() {
      for (int i = 0; i<data.length; i++) {
        for (int j = 0; j<data[i].length; j++) {
          if (data[i][j] == '_') {
            data[i][j] = ' ';
          }
        }
      }
    }

    private void fillRest() {
      //Random index = new Random();
      String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      for (int i = 0; i<data.length; i++) {
        for (int j = 0; j<data[i].length; j++) {
          if (data[i][j] == '_') {
            data[i][j] = letters.charAt(Math.abs(randgen.nextInt()%26));
          }
        }
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
      formatted+="Words: ";
      for (int i = 0; i<wordsAdded.size(); i++) {
        if (i < wordsAdded.size() - 1) {
          String word = wordsAdded.get(i);
          formatted+=word.toUpperCase() + ", ";
        }
        else {
          String word = wordsAdded.get(i);
          formatted+=word.toUpperCase();
        }
      }
      formatted+= " (seed: " + seed + ")";
      return formatted;
    }
    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added in the direction rowIncrement,colIncrement
     *Words must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
     *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
     *@return true when: the word is added successfully.
     *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
     *        OR there are overlapping letters that do not match
     */
     //REMEMBER TO TURN THIS BACK INTO PUBLIC AFTER DOING WordSearch_TEST!!!!!
    private boolean addWord(String word, int r, int c, int rowIncrement, int colIncrement) {
      if (r>data.length ||
          c>data[r].length ||
          (c+(word.length() * colIncrement)) > data[r].length ||
          (c+(word.length() * colIncrement)) < -1 || //word.length() doesn't start at 0 it starts at 1, modify it to start at 0
          (r+(word.length() * rowIncrement)) > data.length ||
          (r+(word.length() * rowIncrement)) < -1 || //same here, since datastarts at 0 not 1 we want word to be in line w that
          (rowIncrement == 0 && colIncrement == 0) ||
          word.equals("") ||
          word.equals(" "))
          {
            return false;
      }
      else {
        for (int i = 0; i<word.length(); i++) {
          if (word.charAt(i) != data[r + (rowIncrement * i)][c + (colIncrement * i)] &&
              data[r + (rowIncrement * i)][c + (colIncrement * i)] != '_'){
                return false;
          }
        }
        for (int i = 0; i<word.length(); i++) {
          data[r + (rowIncrement * i)][c + (colIncrement * i)] = word.charAt(i);
        }
      }
    return true;
    }

    /**private method Attempts to add all given words using the addWord method.
     *Does so by cycling through random row, col, rowIncrement and colIncrement parameters
     *Over and over until a successfull addition occurs. Then selects another word from given
     *text file randomly and attempts to add that. Will cease trying after X amount of failed attempts
     *
     *@return void
     */
     private void addAllWords() {
       while (wordsToAdd.size() > 0) {
         int wtaIndex = Math.abs(randgen.nextInt() % wordsToAdd.size());
         String word = wordsToAdd.get(wtaIndex);
         while (wordsToAdd.contains(word)) {
           boolean added = false;
           int j = 0;
           while (j<15 && !added) {
             int rowIncrement = Math.abs(randgen.nextInt() % 3);
             if (rowIncrement == 2) {
               rowIncrement = -1;
             }
             int colIncrement = Math.abs(randgen.nextInt() % 3);
             if (colIncrement == 2) {
               colIncrement = -1;
             }
             for (int i = 0; i<(data.length * data[0].length); i++) {
               //int r = i % data.length; BEFORE, there was a central tendency b/c the #s weren't random, just kept cycling through
               //(0,0), (1,1)... over and over 
               Random rnd = new Random();
               int r = rnd.nextInt(data.length);
               //int c = i % data[0].length;
               int c = rnd.nextInt(data[0].length);
               if (this.addWord(word, r, c, rowIncrement, colIncrement)) {
                 wordsToAdd.remove(word);
                 wordsAdded.add(word);
                 //System.out.println(word + ", " + rowIncrement + ", " + colIncrement);
                 i = data.length * data[0].length;
                 added = true;
                 //fix that it's adding words with letters not consecutive and adding same word over and over
               }
             }
             j++;
           }
           if (wordsToAdd.contains(word)) {
             wordsToAdd.remove(word);
           }
           //do stuff
           //if done correctly, wordsToAdd.remove(word), wordsAdded.add(word)
         }
       }
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
