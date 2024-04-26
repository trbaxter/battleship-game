import Object.Battleship;
import Object.GameTitleScreen;

import java.util.ArrayList;

public class Main {

    private final GameHelper helper = new GameHelper();
    private final ArrayList<Battleship> battleshipList = new ArrayList<>();
    private int numOfGuesses = 0;

    public static void main(String[] args) {
        Main game = new Main();
        game.setUpGame();
        game.startPlaying();
    }

    private void setUpGame() {

        GameTitleScreen gameStart = new GameTitleScreen();

        Battleship one = new Battleship();
        one.setName("cruiser");
        Battleship two = new Battleship();
        two.setName("submarine");
        Battleship three = new Battleship();
        three.setName("destroyer");

        battleshipList.add(one);
        battleshipList.add(two);
        battleshipList.add(three);

        gameStart.displayTitleScreen();

        for (Battleship battleshipToSet : battleshipList) {
            ArrayList<String> newLocation = helper.placeBattleship(3);
            battleshipToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!battleshipList.isEmpty()) {
            String userGuess = helper.getUserInput("\nEnter your guess:");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {

        if ((userGuess == null) || !userGuess.substring(0, 1).matches(".*[abcdefg].*") ||
                !userGuess.substring(1, 2).matches(".*[0123456].*") || !(userGuess.length() == 2)) {
            System.out.println("Invalid conditions for guess. Please specify a grid location using A-G and 0-6.");
        }

        if ((userGuess != null) &&
                userGuess.substring(0, 1).matches(".*[abcdefg].*") &&
                userGuess.substring(1, 2).matches(".*[0123456].*") &&
                userGuess.length() == 2) {
            numOfGuesses++;
            String result = "Miss!";

            for (Battleship battleship : battleshipList) {
                result = battleship.checkYourself(userGuess);
                if (result.equals("Hit!")) {
                    break;
                }
                if (result.equals("Battleship destroyed!")) {
                    battleshipList.remove(battleship);
                    break;
                }
            }
            System.out.println(result);
        }
    }

    private void finishGame() {
        System.out.println("\nAll enemy battleships have been eliminated - game over!\n");
        if (numOfGuesses <= 18) {
            System.out.println(STR."Your score is: \{numOfGuesses} guesses.");
            System.out.println("Nice work!");
        } else {
            System.out.println(STR."Your score is: \{numOfGuesses} guesses.");
            System.out.println("Try a little harder next time.");
        }
    }

}
