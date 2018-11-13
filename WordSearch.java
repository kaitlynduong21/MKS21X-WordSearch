import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][]data;

  //the random seed used to produce this WordSearch
  private int seed;

  //a random Object to unify your random calls
  private Random randgen;

  //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
  private ArrayList<String>wordsToAdd;

  //all words that were successfully added get moved into wordsAdded.
  private ArrayList<String>wordsAdded;

  public WordSearch(int rows,int cols){
    data = new char[rows][cols];
    clear();
  }

  public ArrayList<String> getWordsAdded() {
    return wordsAdded;
  }

  public WordSearch( int rows, int cols, String fileName) {
    data = new char[rows][cols];
    randgen = new Random ();
    File f  = new File(fileName);
    clear();
  }

  public WordSearch( int rows, int cols, String fileName, int randSeed) {
    data = new char[rows][cols];
    File f  = new File(fileName);
    randgen = new Random(randSeed);
    seed = randSeed;

    clear();
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear(){
    for (int x = 0; x < data.length; x ++) {
      for (int y = 0; y < data[x].length; y++) {
        data[x][y] = '_' ;
      }
    }
  }

  /**Each row is a new line, there is a space between each letter
  *@return a String with each character separated by spaces, and rows
  *separated by newlines.
  */
  public String toString(){
    String s = "";
    for (int x = 0; x < data.length; x++) {
      s += "|";
      for (int y = 0; y < data[x].length; y++) {
        if (y != data[x].length - 1) {
          s = s + data[x][y] + " ";
        } else {
          s = s + data[x][y] + "|\n";
        }
      }
    }
    s = s + "\n Words: " + wordsAdded;
    return s;
  }

  public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
    int length = word.length();
    int x = row;
    int y = col;
    for (int i = 0; i < length; i++) {
      if (rowIncrement == 0 && colIncrement == 0) {
        return false;
      }
      try {
      if (data[x][y] != '_' && data[x][y] != word.charAt(i)) {
        return false;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
        return false;
      }
      x += rowIncrement;
      y += colIncrement;
    }
    y = col;
    x = row;
      for (int i = 0; i < length; i ++) {
        data[x][y] = word.charAt(i);
        x += rowIncrement;
        y += colIncrement;
      }
      return true;
    }

/*  private boolean addAllWords() {
    int row = (randgen % 2);
    int col = (randgen.nextInt % 2);
    for (int i = 0; i < wordsToAdd.length; i ++) {
      addWord(wordsToAdd[i], )
    }
    addWord
  }*/

  public boolean addWordHorizontal(String word,int row, int col){
    int length = word.length();
    if (row < 0 || col < 0 || row > data.length || col > data[row].length || col + length > data[row].length) {
      return false;
    }
    int index = 0;
    int count = 0;
    for (int x = col; x < col + length; x ++) {
      if (data[row][x] == '_' || data[row][x] == word.charAt(index)) {
        count ++;
        index ++;
      }
    }
    index = 0;
    if (count == length) {
      for (int i = col; i < col + length; i ++) {
        data[row][i] = word.charAt(index);
        index++;
      }
    } else {
      return false;
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
    int length = word.length();
    if (row < 0 || col < 0 || row > data.length || col > data[row].length || row + length > data.length) {
      return false;
    }
    int index = 0;
    int count = 0;
    for (int x = row; x < row + length; x ++) {
      if (data[x][col] == '_' || data[x][col] == word.charAt(index)) {
        count ++;
        index ++;
      }
    }
    index = 0;
    if (count == length){
      for (int i = row; i < row + length; i ++) {
        data[i][col] = word.charAt(index);
        index++;
      }
    } else {
      return false;
    }
    return true;
  }

  public boolean addWordDiagonal(String word,int row, int col){
    int length = word.length();
    if (row < 0 || col < 0 || row > data.length || col > data[row].length || row + length > data.length || col + length > data[row].length) {
      return false;
    }
    int index = 0;
    int count = 0;
    int y = col;
    for (int x = row; x < row + length; x ++) {
      if (data[x][y] == '_' || data[x][y] == word.charAt(index)) {
        count ++;
        index ++;
        y++;
      }
    }
    index = 0;
    y = col;
    if (count == length){
      for (int i = row; i < row + length; i ++) {
        data[i][y] = word.charAt(index);
        index++;
        y++;
      }
    } else {
      return false;
    }
    return true;
  }

}
