import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class WordSearch{
  private char[][]data;

  private char[][]key;

  private int seed;

  private Random randgen;

  private ArrayList<String>wordsToAdd;

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
    key = new char [rows][cols];
    clear();
    randgen = new Random ();
    wordsToAdd = new ArrayList<> ();
    wordsAdded = new ArrayList<> ();
    try {
      File f  = new File(fileName);
      Scanner in = new Scanner(f);
      while( in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word.toUpperCase());
      }
    } catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
  }

  public WordSearch( int rows, int cols, String fileName, int randSeed) {
    data = new char[rows][cols];
    key = new char [rows][cols];
    clear();
    randgen = new Random(randSeed);
    seed = randSeed;
    wordsToAdd = new ArrayList<> ();
    wordsAdded = new ArrayList<> ();
    try {
      File f  = new File(fileName);
      Scanner in = new Scanner(f);
      while(in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word.toUpperCase());
      }
    } catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      System.exit(1);
    }
  }

  private void clear(){
    for (int x = 0; x < data.length; x ++) {
      for (int y = 0; y < data[x].length; y++) {
        data[x][y] = '_' ;
      }
    }
  }

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
    s = s + "\n Words: ";
    for (int i = 0; i < wordsAdded.size(); i++) {
      s = s + wordsAdded.get(i);
      if (i != wordsAdded.size() - 1) {
        s += ", ";
      }
    }
    return s;
  }

  public String getKey(){
    String s = "";
    for (int x = 0; x < data.length; x++) {
      s += "|";
      for (int y = 0; y < data[x].length; y++) {
        if (y != data[x].length - 1) {
          if (data[x][y] == '_') {
            s += "  ";
          } else {
            s = s + data[x][y] + " ";
          }
        } else {
          if (data[x][y] == '_') {
            s += " | \n";
          } else {
            s = s + data[x][y] + "|\n";
          }
        }
      }
    }
    s = s + "\n Words: ";
    for (int i = 0; i < wordsAdded.size(); i++) {
      s = s + wordsAdded.get(i);
      if (i != wordsAdded.size() - 1) {
        s += ", ";
      }
    }
    s = s + " (seed: " + seed + ")";
    return s;
  }

  public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
    int x = row;
    int y = col;
    for (int i = 0; i < word.length(); i++) {
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
    for (int i = 0; i < word.length(); i ++) {
      data[x][y] = word.charAt(i);
      x += rowIncrement;
      y += colIncrement;
    }
    wordsAdded.add(word);
    wordsToAdd.remove(word);
    return true;
  }

  public void addAllWords() {
    for (int i = 0; i < wordsToAdd.size(); i ++) {
      int index =  Math.abs(randgen.nextInt() % wordsToAdd.size());
      String word = wordsToAdd.get(index);
      int r = Math.abs(randgen.nextInt() % data.length);
      int c = Math.abs(randgen.nextInt() % data[0].length) ;
      int ri = randgen.nextInt() % 2;
      int ci = randgen.nextInt() % 2;
      if (addWord(word, r, c, ri, ci)) {
        addWord(word, r, c, ri, ci);
        wordsAdded.remove(word);
        for (int x = 0; x < word.length(); x ++) {
          key[r][c] = word.charAt(x);
          r += ri;
          c += ci;
        }
      }
      i--;
    }
    /*for (int x = 0; x < data.length; x ++) {
      for (int y = 0;  y < data[x].length; y ++) {
        if (data[x][y] == '_') {
          data[x][y] = ('A'  Math.abs(randgen.nextInt() % 26));
        }
      }
    }*/
  }

  /*public boolean addWordHorizontal(String word,int row, int col){
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
  }*/

  public nonstatic void main (String[]args) {
    data = new char[args[0]][args[1]];
    key = new char [args[0]][args[1]];
    clear();
    wordsToAdd = new ArrayList<> ();
    wordsAdded = new ArrayList<> ();
    try {
      File f  = new File(args[2]);
      Scanner in = new Scanner(f);
      while( in.hasNext()){
        String word = in.next();
        wordsToAdd.add(word.toUpperCase());
      }
    } catch(FileNotFoundException e){
      System.out.println("File not found: " + args[2]);
      System.exit(1);
    }
    randgen = new Random ();
    if (args == 4) {
      randgen = new Random(randSeed);
      seed = randSeed;
    }
    if (args == 5 && args[4].equals("key")) {
      getKey();
    }
  }

}
