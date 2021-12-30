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

    class KeyMoves implements KeyListener {
        Board GameBoard;

        KeyMoves(Board GameBoard) {
            this.GameBoard = GameBoard;
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            // Copy of the current tiles values before making the move
            int[][] prevTileValues = Arrays.copyOf(GameBoard.tilesValues, GameBoard.tilesValues.length);
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    GameBoard.moveUp();
                    break;

                case KeyEvent.VK_DOWN:
                    GameBoard.moveDown();
                    break;

                case KeyEvent.VK_RIGHT:
                    GameBoard.moveRight();
                    break;

                case KeyEvent.VK_LEFT:
                    GameBoard.moveLeft();
                    break;
            }
            // If the previus value of the tiles is different from the actual value we
            // create a new random tile.
            if (!Arrays.deepEquals(GameBoard.tilesValues, prevTileValues)) {
                GameBoard.newRandomTile();

            }

            updateTiles();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

}