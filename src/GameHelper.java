import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {
    private static final String alphabet = "abcdefg";      // Column letters
    private final int gridSize = 49;                       // Total number of grid cells
    private final int[] grid = new int[gridSize];          // Array to contain the virtual board
    private int shipCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in)); // User input isn't primitive
            inputLine = is.readLine();                                                // So BuffReader inst. of Scanner
            if (inputLine.isEmpty()) return null;
        } catch (IOException e) {                        // Added in case of any input or output interruptions
            System.out.println("IOException: " + e);
        }
        assert inputLine != null;
        return inputLine.toLowerCase();                  // Lowercase avoids case sensitivity issues with guesses
    }

    public ArrayList<String> placeBattleship(int shipSize) {
        ArrayList<String> shipCells = new ArrayList<>();

        String temp;                         // String to grab the letter of the column for a shipCell later
        int[] coords = new int[shipSize];
        int attempts = 0;
        boolean success = false;             // Process flag
        int location;

        shipCount++;
        int incr = 1;                        // Horizontal increment
        int gridLength = 7;
        if ((shipCount % 2) == 1) {          // If shipCount odd, set the vertical alignment
            incr = gridLength;
        }

        while (!success & attempts++ < 200) {             // Loop limitation to prevent endless attempts
            location = (int) (Math.random() * gridSize);  // Grab a random integer from 0 to 6 to start
            int x = 0;                                    // Index variable for an adjacent spot to the ship
            success = true;
            while (success && x < shipSize) {             // Look for adjacent cells
                if (grid[location] == 0) {                // Ensure the cell isn't already being used
                    coords[x++] = location;               // Save the cell value
                    location += incr;                     // Try the next adjacent cell
                    if (location >= gridSize) {           // If out of bounds at the top, redo
                        success = false;
                    }
                    if (location % gridLength == 0) {    // If out of bounds at the right edge, redo
                        success = false;
                    }
                } else {                                  // Used location already found, redo
                    success = false;
                }
            }
        }

        int x = 0;                                                // Turn cell number into alpha coords
        int row;
        int column;
        while (x < shipSize) {
            grid[coords[x]] = 1;                                  // Mark grid point as used
            row = coords[x] / gridLength;                         // Get row value using integer division
            column = coords[x] % gridLength;                      // Get column value using modulus
            temp = String.valueOf(alphabet.charAt(column));       // Convert column value to letter from alphabet

            shipCells.add(temp.concat((Integer.toString(row))));  // Combine column letter and row number
            x++;
        }
        return shipCells;

    }
}

