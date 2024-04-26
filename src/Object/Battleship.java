package Object;

import java.util.ArrayList;

public class Battleship {
    private ArrayList<String> locationCells;
    private String name;

    public void setLocationCells(ArrayList<String> location) {
        locationCells = location;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "Miss!";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove(index);

            if (locationCells.isEmpty()) {
                result = "Battleship destroyed!";
                System.out.println(STR."Hit! You sunk an enemy \{name}.");
            } else {
                result = "Hit!";
            }
        }
        return result;
    }
}
