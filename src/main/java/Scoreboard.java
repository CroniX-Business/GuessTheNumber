import javax.swing.*;
import java.awt.*;

public class Scoreboard extends JFrame {
    JFrame frame = new JFrame("Scoreboard");

    Scoreboard() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,350);
        frame.getContentPane().setBackground(new Color(60,71,139));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
