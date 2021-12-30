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

    private int[] mergeLineToLeft(int[] line) {

        int[] newArr = new int[line.length];

        int current = 0;
        // we loop through the entire array
        for (int i = 0; i < line.length; i++) {
            // Initializing all the values of the new array to 0
            newArr[i] = 0;
            // we only care if the i'th element is different from 0
            if (line[i] != 0) {
                // if the current space in the newArr is 0 we repalce it with line[i]
                if (newArr[current] == 0) {
                    newArr[current] = line[i];
                }
                // if the current space in newArr is diferent from 0 we have to ckeck if
                // it is equal or different to the current value, if it is we add them up
                // else we assign the next space in newArr to the current value in the line
                else {
                    if (newArr[current] == line[i]) {
                        newArr[current] += line[i];

                    } else {
                        newArr[current + 1] = line[i];
                    }
                    current++;
                }
            }

        }

        return newArr;
    }

    private int[] mergeLineToRight(int[] line) {
        int[] reversedMergedLine = mergeLineToLeft(reverseLine(line));

        return reverseLine(reversedMergedLine);

    }

    private int[][] getTranspose(int[][] tiles) {
        int[][] transpose = new int[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                transpose[col][row] = tiles[row][col];

            }
        }
        return transpose;

    }

    private int[] reverseLine(int[] line) {
        int[] newArr = new int[line.length];
        for (int i = 0; i < line.length / 2; i++) {
            newArr[i] = line[line.length - 1 - i];
            newArr[line.length - 1 - i] = line[i];
        }
        return newArr;
    }

    public void moveUp() {
        tilesValues = getTranspose(tilesValues);
        for (int i = 0; i < tilesValues.length; i++) {
            tilesValues[i] = mergeLineToLeft(tilesValues[i]);
        }
        tilesValues = getTranspose(tilesValues);
        newRandomTile();
    }

    public void moveDown() {
        tilesValues = getTranspose(tilesValues);
        for (int i = 0; i < tilesValues.length; i++) {
            tilesValues[i] = mergeLineToRight(tilesValues[i]);
        }
        tilesValues = getTranspose(tilesValues);
        newRandomTile();
    }

    public void moveLeft() {
        for (int i = 0; i < tilesValues.length; i++) {
            tilesValues[i] = mergeLineToLeft(tilesValues[i]);
        }
        newRandomTile();
    }

    public void moveRight() {
        for (int i = 0; i < tilesValues.length; i++) {
            tilesValues[i] = mergeLineToRight(tilesValues[i]);
        }
        newRandomTile();
    }

}
