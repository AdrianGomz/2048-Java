import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.HashMap;

public class Tile extends JPanel {
    int num;
    JLabel numLabel;
    static HashMap<Integer, Color> colors = new HashMap<Integer, Color>() {
        {
            put(0, Color.DARK_GRAY);
            put(2, new Color(69, 181, 170));
            put(4, new Color(151, 94, 62));
            put(8, new Color(214, 0, 110));
            put(16, new Color(0, 166, 214));
            put(32, new Color(0, 132, 61));
            put(64, new Color(255, 105, 0));
            put(128, new Color(117, 168, 50));
            put(256, new Color(1, 33, 105));
            put(512, new Color(214, 37, 152));
            put(1024, new Color(220, 20, 60));
            put(2048, new Color(249, 215, 28));
        }
    };

    Tile(int i) {
        this.setPreferredSize(new Dimension(100, 100));
        this.num = i;
        numLabel = new JLabel(Integer.toString(num));
        numLabel.setPreferredSize(new Dimension(90, 90));
        numLabel.setHorizontalAlignment(JLabel.CENTER);
        numLabel.setForeground(Color.white);
        numLabel.setBackground(colors.get(num));
        numLabel.setFont(new Font("Arial", Font.BOLD, 16));
        numLabel.setOpaque(true);

        this.add(numLabel);
    }

    public void update(int num) {
        this.num = num;
        numLabel.setBackground(colors.get(num));
        numLabel.setText(Integer.toString(num));

    }

    // public void paint(Graphics g) {
    // g.fillRoundRect(5, 5, 90, 90, 10, 10);
    // g.setColor(Color.white);
    // g.drawString(Integer.toString(num), 50, 50);

    // }
}
