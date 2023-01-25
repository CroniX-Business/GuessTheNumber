import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    JFrame frame = new JFrame("Menu");

    JLabel naslov = new JLabel("Guess The Number");
    JButton startGame = new JButton("Start");

    Menu() {
        naslov.setBounds(100, 60, 200, 40);
        naslov.setFont(new Font("Serif", Font.PLAIN, 20));
        naslov.setForeground(Color.white);
        naslov.setHorizontalAlignment(JLabel.CENTER);
        naslov.setHorizontalTextPosition(JLabel.RIGHT);

        startGame.setBounds(100, 160, 200, 40);
        startGame.setFocusable(false);
        startGame.addActionListener(this);

        frame.add(naslov);
        frame.add(startGame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,300);
        frame.getContentPane().setBackground(new Color(60,71,139));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGame) {
            frame.dispose();
            Game game = new Game();
        }
    }
}
