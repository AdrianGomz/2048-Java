import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartWindow implements ActionListener {
    JFrame frame = new JFrame();
    JLabel label;
    JButton button = new JButton("Restart");
    Board gameBoard;
    GameFrame gameFrame;

    RestartWindow(String result, Board gameBoard, GameFrame gameFrame) {
        this.gameBoard = gameBoard;
        this.gameFrame = gameFrame;
        label = new JLabel("You " + result);
        label.setBounds(0, 10, 200, 25);
        label.setHorizontalAlignment(JLabel.CENTER);
        button.setBounds(60, 40, 80, 30);
        button.addActionListener(this);
        frame.add(label);
        frame.add(button);
        frame.setSize(200, 150);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == button) {
            frame.dispose();
            gameBoard.restart();
            gameFrame.updateTiles();
            gameBoard.running = true;

        }

    }

}
