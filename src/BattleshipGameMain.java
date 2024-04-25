import java.util.ArrayList;

public class BattleshipGameMain {

    private final GameHelper helper = new GameHelper();
    private final ArrayList<Battleship> battleshipList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame() {
        Battleship one = new Battleship();
        one.setName("cruiser");
        Battleship two = new Battleship();
        two.setName("submarine");
        Battleship three = new Battleship();
        three.setName("destroyer");

        battleshipList.add(one);
        battleshipList.add(two);
        battleshipList.add(three);

        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println(" _______               __      __      __                      __        __           \n" +
                "/       \\             /  |    /  |    /  |                    /  |      /  |          \n" +
                "$$$$$$$  |  ______   _$$ |_  _$$ |_   $$ |  ______    _______ $$ |____  $$/   ______  \n" +
                "$$ |__$$ | /      \\ / $$   |/ $$   |  $$ | /      \\  /       |$$      \\ /  | /      \\ \n" +
                "$$    $$<  $$$$$$  |$$$$$$/ $$$$$$/   $$ |/$$$$$$  |/$$$$$$$/ $$$$$$$  |$$ |/$$$$$$  |\n" +
                "$$$$$$$  | /    $$ |  $$ | __ $$ | __ $$ |$$    $$ |$$      \\ $$ |  $$ |$$ |$$ |  $$ |\n" +
                "$$ |__$$ |/$$$$$$$ |  $$ |/  |$$ |/  |$$ |$$$$$$$$/  $$$$$$  |$$ |  $$ |$$ |$$ |__$$ |\n" +
                "$$    $$/ $$    $$ |  $$  $$/ $$  $$/ $$ |$$       |/     $$/ $$ |  $$ |$$ |$$    $$/ \n" +
                "$$$$$$$/   $$$$$$$/    $$$$/   $$$$/  $$/  $$$$$$$/ $$$$$$$/  $$/   $$/ $$/ $$$$$$$/  \n" +
                "                                                                            $$ |      \n" +
                "                                                                            $$ |      \n" +
                "                                                                            $$/       \n");
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("\n\nThe goal of the game is is to sink three of the enemy's battleships." +
                "\nEach battleship is placed somewhere on a virtual 7x7 grid spanning three grid cells." +
                ("\n\nA guess on the virtual grid may be placed using the letters A-G and numbers 0-6."));
        System.out.println("Try to sink them all in the smallest number of guesses. Good luck!\n");

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

        if (userGuess == null || !userGuess.substring(0,1).matches(".*[abcdefg].*") ||
                !userGuess.substring(1,2).matches(".*[0123456].*")) {
            System.out.println("Invalid conditions for guess. Please specify a grid location using A-G and 0-6.");
        }

        if (userGuess != null &&
                userGuess.substring(0,1).matches(".*[abcdefg].*") &&
                userGuess.substring(1,2).matches(".*[0123456].*")) {
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
            System.out.println("Your score is: " + numOfGuesses + " guesses.");
            System.out.println("Nice work!");
        } else {
            System.out.println("It took you " + numOfGuesses + " guesses.");
            System.out.println("Try a little harder next time.");
        }
    }

    public static void main(String[] args) {
        BattleshipGameMain game = new BattleshipGameMain();
        game.setUpGame();
        game.startPlaying();
    }

}
