public class Driver {
  public static void main(String[] args) {

    /*System.out.println("Tiffany's Driver \n");
    System.out.println("testing Constructor");
    WordSearch testCase = new WordSearch(3, 5);
    System.out.println("should print out 3 by 5 array with underscores");
    System.out.println(testCase.toString());
    System.out.println("\n\n\n");
    System.out.println("Testing addWordHorizontal");
    testCase.addWordHorizontal("hey", 0, 0);
    System.out.println(testCase.addWordHorizontal("hey", 0, 0));
    System.out.println("top row should say hey");
    System.out.println(testCase.toString());
    System.out.println("\n\n\n");
    testCase.addWordHorizontal("whats", 0, 0);
    System.out.println("should not contain whats because of capacity");
    System.out.println(testCase.toString());
    System.out.println(testCase.toString());
    System.out.println("\n\n\n");
    System.out.println("testing addWordVertical");
    testCase.addWordVertical("hey", 0, 0);
    System.out.println("first column should say hey");
    System.out.println(testCase.toString());
    System.out.println("\n\n\n");
    testCase.addWordVertical("greetings", 0, 0);
    System.out.println("should not print greetings because of capacity");
    System.out.println(testCase.toString());
    System.out.println("\n\n\n");
    System.out.println("should have yeh on third column");
    testCase.addWordVertical("yeh", 0, 2);
    System.out.println(testCase.toString());

    //THEODORE Driver

    System.out.println("\n Theordore's Driver \n");
    WordSearch one = new WordSearch(10,10);
		System.out.println("Initializing a 11 by 11, WordSearch");
		System.out.println("Should print out a 10 X 10 array of underscores: ");
		System.out.println(one);
		System.out.println("*******************************");
		System.out.println("attempting to add 'hello' horizontally at (1,4)");
		System.out.println("should print True: ");
		System.out.println(one.addWordHorizontal("hello",1,4));
		System.out.println("should have the second row as: _ _ _ _ h e l l o _");
		System.out.println(one);
		System.out.println("*******************************");
		System.out.println("attempting to add overlapping word 'oS' horizonally at (1,7) where it should not be able to be placed");
		System.out.println("should print false: ");
		String old = one + "";
		System.out.println(one.addWordHorizontal("oS",1,7));
		if (old.equals(""+one)){
			System.out.println("Yay you did not modify the WordSearch as you were supposed to!");
		}else{
			System.out.println("uh Oh you modified the WordSearch: ");
			System.out.println(one);
		}

		System.out.println("*******************************");
		System.out.println("attempting to add overlapping word 'oS' at (1,8)");
		System.out.println("should print true: ");
		System.out.println(one.addWordHorizontal("oS",1,8));
		System.out.println("should have the second row as: _ _ _ _ h e l l o S");
		System.out.println(one);
		System.out.println("*******************************");
		System.out.println("attempting to add 'elloHay' vertically at (1,5)");
		System.out.println("should print true: ");
		System.out.println(one.addWordVertical("elloHay",1,5));
		System.out.println("should have the sixth column as: _ e l l o H a y _ _");
		System.out.println(one);
		System.out.println("*******************************");
		System.out.println("attempting to add 'LocCabos' vertically at (1,5)");
		System.out.println("should print false: ");
		old = one + "";
		System.out.println(one.addWordVertical("LosCabos", 0, 7));
		if (old.equals(""+one)){
			System.out.println("Yay you did not modify the WordSearch as you were supposed to!");
		}else{
			System.out.println("uh Oh you modified the WordSearch: ");
			System.out.println(one);
		}

    //VINCENT Driver

    System.out.println("\n1. CONSTRUCTOR INITIALIZATION + TOSTRING");
    // System.out.println("Creating a -1 x -1 WordSearch (should fail, print that it caught an exception )");
    System.out.println("Creating a 5 x 5 WordSearch and printing (hopefully y'all know what that is supposed to look like)");
    WordSearch WS = new WordSearch(5,5);
    System.out.println(WS);
    System.out.println("\n---------------\n");

    System.out.println("2. ADD WORD HORIZONTAL");
    System.out.println("Adding to a negative row index (should print false): " + WS.addWordHorizontal("abc",-1,2));
    System.out.println("Adding to a negative column index (should print false): " + WS.addWordHorizontal("abc",0,-1));
    System.out.println("Adding to an out of bounds row index (should print false): " + WS.addWordHorizontal("abc",10,0));
    System.out.println("Adding to an out of bounds column index (should print false): " + WS.addWordHorizontal("abc",0,10));
    System.out.println("Adding to last index of row, where a 3-letter word doesn't fit (should print false): " + WS.addWordHorizontal("abc",0,4));
    System.out.println("Adding a 6-letter word (doesn't fit, should print false): " + WS.addWordHorizontal("abcdef",0,4));
    System.out.println("Adding \"abc\" to last 3 slots of each row (should print true, once): " + (WS.addWordHorizontal("abc",0,2) && WS.addWordHorizontal("abc",1,2) && WS.addWordHorizontal("abc",2,2) && WS.addWordHorizontal("abc",3,2) && WS.addWordHorizontal("abc",4,2)));
    System.out.println("\nPrinting WS (see above description)\n" + WS);
    System.out.println("\n---------------\n");

    System.out.println("3. ADD WORD VERTICAL (with a new WordSearch! of the same dimensions!)");
    WordSearch SW = new WordSearch(5,5);
    System.out.println("Adding to a negative row index (should print false): " + SW.addWordVertical("abc",-1,2));
    System.out.println("Adding to a negative column index (should print false): " + SW.addWordVertical("abc",0,-1));
    System.out.println("Adding to an out of bounds row index (should print false): " + SW.addWordVertical("abc",10,0));
    System.out.println("Adding to an out of bounds column index (should print false): " + SW.addWordVertical("abc",0,10));
    System.out.println("Adding to last index of column, where a 3-letter word doesn't fit (should print false): " + SW.addWordVertical("abc",4,0));
    System.out.println("Adding a 6-letter word (doesn't fit, should print false): " + WS.addWordHorizontal("abcdef",0,0));
    System.out.println("Adding \"abc\" to last 3 slots of each column (should print true, once): " + (SW.addWordVertical("abc",2,0) && SW.addWordVertical("abc",2,1) && SW.addWordVertical("abc",2,2) && SW.addWordVertical("abc",2,3) && SW.addWordVertical("abc",2,4)));
    System.out.println("\nPrinting WS (see above description)\n" + SW);
    System.out.println("\n---------------\n");
*/
if(args.length >= 2) {
  WordSearch WSe2 = new WordSearch(Integer.parseInt(args[0]),Integer.parseInt(args[1]), args[2] ,Integer.parseInt(args[3]));

  System.out.println("WordSearch WSe2 = new WordSearch(args[0],args[1],\"words.txt\")");
  System.out.println(WSe2);
  /*
    example:
    java Driver_Test 10 12
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|
    |_ _ _ _ _ _ _ _ _ _ _ _|

    example:
    java Driver_Test 3 5
    |_ _ _ _ _|
    |_ _ _ _ _|
    |_ _ _ _ _|

    example:
    java Driver_Test 6 6
    |_ _ _ _ _ _|
    |_ _ _ _ _ _|
    |_ _ _ _ _ _|
    |_ _ _ _ _ _|
    |_ _ _ _ _ _|
    |_ _ _ _ _ _|
  */

  WSe2.addAllWords();
//System.out.println(WSe2);
  System.out.println(WSe2.getKey());
  // hopefully filled WordSearch

} else if(args.length == 1) {
  System.out.println("MISSING INPUT:\nDriver_Test class needs terminal line args:");
  System.out.println("- int rows [FOUND]\n- int cols [NOT FOUND]");

} else if(args.length == 0) {
  System.out.println("MISSING INPUT:\nDriver_Test class needs terminal line args:");
  System.out.println("- int rows [NOT FOUND]\n- int cols [NOT FOUND]");

}
  }
}
