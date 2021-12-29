import javax.swing.JFrame;

import java.awt.GridLayout;

public class GameFrame extends JFrame {

    GameFrame() {

        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {

            this.add(new Tile(i));
        }
        this.pack();
        this.setResizable(false);

    }

}
