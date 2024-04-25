import java.util.ArrayList;

public class BattleshipObjectTest {

    public static void main(String[] args) {
        Battleship battleship = new Battleship();
        ArrayList<String> loc = new ArrayList<>();

        loc.add("a1");
        loc.add("a2");
        loc.add("a3");
        battleship.setLocationCells(loc);
        battleship.setName("testCom");

        String userGuess = "a1";
        System.out.println("\nTesting battleship behavior with a user guess of " + userGuess + ".");
        System.out.println("\nBattleship object located in cells a1, a2, and a3.");
        String result = battleship.checkYourself(userGuess);
        String testResult = "failed";

        if (result.equals("Hit!")) {
            testResult = "passed";
        }

        System.out.println(testResult);
    }
}