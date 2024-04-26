package Object;

public class GameTitleScreen {

    public void displayTitleScreen() {

        System.out.println("\n------------------------------------------------------------------------------------------\n");
        System.out.println("""
                 _______               __      __      __                      __        __          \s
                /       \\             /  |    /  |    /  |                    /  |      /  |         \s
                $$$$$$$  |  ______   _$$ |_  _$$ |_   $$ |  ______    _______ $$ |____  $$/   ______ \s
                $$ |__$$ | /      \\ / $$   |/ $$   |  $$ | /      \\  /       |$$      \\ /  | /      \\\s
                $$    $$<  $$$$$$  |$$$$$$/ $$$$$$/   $$ |/$$$$$$  |/$$$$$$$/ $$$$$$$  |$$ |/$$$$$$  |
                $$$$$$$  | /    $$ |  $$ | __ $$ | __ $$ |$$    $$ |$$      \\ $$ |  $$ |$$ |$$ |  $$ |
                $$ |__$$ |/$$$$$$$ |  $$ |/  |$$ |/  |$$ |$$$$$$$$/  $$$$$$  |$$ |  $$ |$$ |$$ |__$$ |
                $$    $$/ $$    $$ |  $$  $$/ $$  $$/ $$ |$$       |/     $$/ $$ |  $$ |$$ |$$    $$/\s
                $$$$$$$/   $$$$$$$/    $$$$/   $$$$/  $$/  $$$$$$$/ $$$$$$$/  $$/   $$/ $$/ $$$$$$$/ \s
                                                                                            $$ |     \s
                                                                                            $$ |     \s
                                                                                            $$/      \s
                """);
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("""
                                
                The goal of the game is is to sink three of the enemy's battleships.
                Each battleship is placed somewhere on a virtual 7x7 grid spanning three grid cells.

                A guess on the virtual grid may be placed using the letters A-G and numbers 0-6.""");
        System.out.println("Try to sink them all in the smallest number of guesses. Good luck!");
    }
}
