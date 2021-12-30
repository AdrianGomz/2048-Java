import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Tile extends JPanel {
    int num;

    Tile(int i) {
        this.setPreferredSize(new Dimension(100, 100));
        num = i;

    }

    public void paint(Graphics g) {
        g.fillRoundRect(5, 5, 90, 90, 10, 10);
        g.setColor(Color.white);
        g.drawString(Integer.toString(num), 50, 50);

    }
}
