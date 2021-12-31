import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridLayout;
import java.util.Arrays;

public class GameFrame extends JFrame {
    Board GameBoard;
    Tile[][] tilesPanels = new Tile[4][4];

    GameFrame(Board GameBoard) {
        this.GameBoard = GameBoard;
        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4, 4));
        drawTiles();
        this.pack();
        this.setResizable(false);
        this.addKeyListener(new KeyMoves(GameBoard));

    };

    public void updateTiles() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tilesPanels[i][j].update(this.GameBoard.tilesValues[i][j]);
            }

        }

    }

    public void drawTiles() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tilesPanels[i][j] = (new Tile(this.GameBoard.tilesValues[i][j]));
                this.add(tilesPanels[i][j]);
            }

        }
    }

    public GameFrame getGameFrameInstance() {
        return this;
    }

    class KeyMoves implements KeyListener {
        Board gameBoard;

        KeyMoves(Board GameBoard) {
            this.gameBoard = GameBoard;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (gameBoard.running) {

                int keyCode = e.getKeyCode();
                // Copy of the current tiles values before making the move
                int[][] prevTileValues = Arrays.copyOf(gameBoard.tilesValues, gameBoard.tilesValues.length);
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        gameBoard.moveUp();
                        break;

                    case KeyEvent.VK_DOWN:
                        gameBoard.moveDown();
                        break;

                    case KeyEvent.VK_RIGHT:
                        gameBoard.moveRight();
                        break;

                    case KeyEvent.VK_LEFT:
                        gameBoard.moveLeft();
                        break;
                }
                // If the previus value of the tiles is different from the actual value we
                // create a new random tile.
                if (!Arrays.deepEquals(gameBoard.tilesValues, prevTileValues)) {
                    gameBoard.newRandomTile();

                }

                updateTiles();
                if (gameBoard.checkForLoose()) {
                    new RestartWindow("loose", gameBoard, getGameFrameInstance());
                    gameBoard.running = false;
                } else if (gameBoard.checkForWin()) {
                    new RestartWindow("win", gameBoard, getGameFrameInstance());
                    gameBoard.running = false;
                }
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

}