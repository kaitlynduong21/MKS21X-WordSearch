public class WordSearch{
    private char[][]data;

    /**Initialize the grid to the size specified
     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
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
        for (int y = 0; y < data[x].length; y++) {
          if (y != data[x].length - 1) {
            s = s + data[x][y] + " ";
          } else {
            s = s + data[x][y] + " \n";
          }
        }
      }
      return s;
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
}
