import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.GridLayout;

public class GameFrame extends JFrame {
    Board GameBoard;

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

    public void drawTiles() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.add(new Tile(this.GameBoard.tilesValues[i][j]));
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
            drawTiles();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }

    }

}