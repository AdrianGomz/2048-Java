import javax.swing.JFrame;

import java.awt.GridLayout;

public class GameFrame extends JFrame {

    GameFrame(Board GameBoard) {

        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.add(new Tile(GameBoard.tilesValues[i][j]));
            }

        }
        this.pack();
        this.setResizable(false);

    }

}
