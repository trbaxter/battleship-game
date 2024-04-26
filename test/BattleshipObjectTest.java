
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import Object.Battleship;

import static org.junit.jupiter.api.Assertions.*;


public class BattleshipObjectTest {
    private final Battleship battleship = new Battleship();
    private final ArrayList<String> location = new ArrayList<>();

    @Test
    public void testShipHit() {
        location.add("a1");
        location.add("a2");
        location.add("a3");
        battleship.setLocationCells(location);
        battleship.setName("test ship");

        String userGuess = "a1";
        String result = battleship.checkYourself(userGuess);

        assertEquals(result, "Hit!");
    }

    @Test
    public void testShipMiss() {
        location.add("a1");
        location.add("a2");
        location.add("a3");
        battleship.setLocationCells(location);
        battleship.setName("test ship");

        String userGuess = "a5";
        String result = battleship.checkYourself(userGuess);

        assertEquals(result, "Miss!");
    }

    @Test
    public void testShipDestroy() {
        location.add("a1");
        battleship.setLocationCells(location);
        battleship.setName("test ship");

        String userGuess = "a1";
        String result = battleship.checkYourself(userGuess);

        assertEquals(result, "Battleship destroyed!");
    }
}