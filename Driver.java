public class Driver {
  public static void main(String[] args) {

    System.out.println("Tiffany's Driver \n");
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

    //TIMOTHY Driver

    WordSearch WSe = new WordSearch(6,10);

    System.out.println("WordSearch WSe = new WordSearch(6,10)");
    System.out.println(WSe);
    /*
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println();

    System.out.println("WSe.addWordHorizontal(\"CLOUD\",0,7)");
    if(WSe.addWordHorizontal("CLOUD",0,7)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, CLOUD is outside of bounds

    System.out.println(WSe);
    /*
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println();

    System.out.println("WSe.addWordHorizontal(\"TIFA\",0,5)");
    if(WSe.addWordHorizontal("TIFA",0,5)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, TIFA is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      _ _ _ _ _ T I F A _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordHorizontal(\"REDXIII\",0,2)");
    if(WSe.addWordHorizontal("REDXIII",0,2)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, REDXIII is within bounds, yes destructive interference

    System.out.println(WSe);
    /*
      _ _ _ _ _ T I F A _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordHorizontal(\"REDXIII\",1,0)");
    if(WSe.addWordHorizontal("REDXIII",1,0)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, REDXIII is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      _ _ _ _ _ T I F A _
      R E D X I I I _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordHorizontal(\"BARRET\",0,0)");
    if(WSe.addWordHorizontal("BARRET",0,0)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, BARRET is within bounds, only constructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
      _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordVertical(\"YUFFIE\",2,9)");
    if(WSe.addWordVertical("YUFFIE",2,9)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, YUFFIE is out of bounds

    System.out.println(WSe);
    /*
    B A R R E T I F A _
    R E D X I I I _ _ _
    _ _ _ _ _ _ _ _ _ _
    _ _ _ _ _ _ _ _ _ _
    _ _ _ _ _ _ _ _ _ _
    _ _ _ _ _ _ _ _ _ _
    */

    System.out.println("WSe.addWordVertical(\"CLOUD\",1,9)");
    if(WSe.addWordVertical("CLOUD",1,9)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, CLOUD is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ _ _ _ _ _ _ _ _ L
      _ _ _ _ _ _ _ _ _ O
      _ _ _ _ _ _ _ _ _ U
      _ _ _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordVertical(\"YUFFIE\",0,9)");
    if(WSe.addWordVertical("YUFFIE",0,9)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, YUFFIE is within bounds, yes destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ _ _ _ _ _ _ _ _ L
      _ _ _ _ _ _ _ _ _ O
      _ _ _ _ _ _ _ _ _ U
      _ _ _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordVertical(\"AERITH\",0,1)");
    if(WSe.addWordVertical("AERITH",0,1)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success.
    // should succeed, AERITH is within bounds, only constructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R _ _ _ _ _ _ _ L
      _ I _ _ _ _ _ _ _ O
      _ T _ _ _ _ _ _ _ U
      _ H _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"CAIT\",3,2)");
    if(WSe.addWordDiagonal("CAIT",3,2)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure.
    // should fail, CAIT is out of bounds

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R _ _ _ _ _ _ _ L
      _ I _ _ _ _ _ _ _ O
      _ T _ _ _ _ _ _ _ U
      _ H _ _ _ _ _ _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"CAIT\",2,2)");
    if(WSe.addWordDiagonal("CAIT",2,2)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success
    // should succeed, CAIT is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C _ _ _ _ _ _ L
      _ I _ A _ _ _ _ _ O
      _ T _ _ I _ _ _ _ U
      _ H _ _ _ T _ _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"SITH\",2,3)");
    if(WSe.addWordDiagonal("SITH",2,3)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success
    // should succeed, SITH is within bounds, no destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C S _ _ _ _ _ L
      _ I _ A I _ _ _ _ O
      _ T _ _ I T _ _ _ U
      _ H _ _ _ T H _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"CAIT\",2,0)");
    if(WSe.addWordDiagonal("CAIT",2,0)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - FAIL");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - PASS");
    }
    // > addition failure
    // should fail, CAIT is within bounds, yes destructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C S _ _ _ _ _ L
      _ I _ A I _ _ _ _ O
      _ T _ _ I T _ _ _ U
      _ H _ _ _ T H _ _ D
    */

    System.out.println("WSe.addWordDiagonal(\"TIFA\",0,5)");
    if(WSe.addWordDiagonal("TIFA",0,5)) {
      System.out.println("> addition success.");
      System.out.println("> TEST CASE - PASS");
    } else {
      System.out.println("> addition failure.");
      System.out.println("> TEST CASE - FAIL");
    }
    // > addition success
    // should succeed, TIFA is within bounds, only constructive interference

    System.out.println(WSe);
    /*
      B A R R E T I F A _
      R E D X I I I _ _ C
      _ R C S _ _ _ F _ L
      _ I _ A I _ _ _ A O
      _ T _ _ I T _ _ _ U
      _ H _ _ _ T H _ _ D
    */

    // System.out.println("WSe.clear()");
    // WSe.clear();
    //
    // System.out.println(WSe);
    // /*
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    //   _ _ _ _ _ _ _ _ _ _
    // */


    // MIHAD DRIVER


    System.out.println("\n Mihad's Driver \n");

    WordSearch p1 = new WordSearch(15,15);
    // Should be 15 by 15 with only underscores
    System.out.println(p1);
    // Should return true and add fortnite to the puzzle
    System.out.println(p1.addWordHorizontal("FORTNITE",1,1));
    System.out.println(p1);
    // Should return false and not change the puzzle
    System.out.println(p1.addWordHorizontal("YEET",1,13));
    System.out.println(p1);
    // Should return true and add victory to the puzzle
    System.out.println(p1.addWordVertical("VICTORY",0,6));
    System.out.println(p1);
    // Should return false and not change the puzzle
    System.out.println(p1.addWordVertical("ROYALE",13,13));
    System.out.println(p1);
    // Doing some cool things
    String[] words = {"YEET", "DAB", "YURR", "TIMBS"};
    for (int i=0;i<words.length;i++) {
      System.out.println(p1.addWordHorizontal(words[i],(int)(Math.random()*14),(int)(Math.random()*14)));
    }
    System.out.println(p1);
    String[] words1 = {"CAR", "NICE", "COOL", "THANOS"};
    for (int i=0;i<words1.length;i++) {
      System.out.println(p1.addWordVertical(words1[i],(int)(Math.random()*14),(int)(Math.random()*14)));
    }
    System.out.println(p1);
  }
}
