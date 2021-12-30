import java.util.ArrayList;

public class Board {
    public int[][] tilesValues = new int[4][4];

    Board() {
        createNewBoard();
    }

    private void createNewBoard() {
        // new 4x4 matrix full of 0's
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tilesValues[i][j] = 0;
            }
        }
        // add two random tiles
        newRandomTile();
        newRandomTile();
    }

    private void newRandomTile() {

        // ArrayList to list all the coordinates of the empty spaces
        ArrayList<Integer[]> emptySpaces = new ArrayList<Integer[]>();
        // Searching for all the empty spaces and adding them to the arrayList
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (tilesValues[row][col] == 0) {
                    emptySpaces.add(new Integer[] { row, col });
                }
            }
        }

        // Select random empty space
        int emptySpaceIndex = (int) (Math.random() * emptySpaces.size());
        // Getting the values for the row and col
        int rowVal = emptySpaces.get(emptySpaceIndex)[0];
        int colVal = emptySpaces.get(emptySpaceIndex)[1];

        // Setting the value of the new Tile (10% chance of getting a 4)
        int newTileVal;
        if ((int) (Math.random() * 10) == 0) {
            newTileVal = 4;
        } else {
            newTileVal = 2;
        }
        tilesValues[rowVal][colVal] = newTileVal;
        return;

    }

}
