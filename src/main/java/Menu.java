import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    JFrame frame = new JFrame("Menu");

    JLabel naslov = new JLabel("Guess The Number");
    JLabel nameLabel = new JLabel("Type your name");
    JTextField name = new JTextField();
    JButton startGame = new JButton("Start");
    JButton scoreboardGame = new JButton("Scoreboard");

    public String player;

    Menu() {
        naslov.setBounds(100, 30, 200, 40);
        naslov.setFont(new Font("Serif", Font.PLAIN, 20));
        naslov.setForeground(Color.white);
        naslov.setHorizontalAlignment(JLabel.CENTER);
        naslov.setHorizontalTextPosition(JLabel.RIGHT);

        nameLabel.setBounds(100, 60, 200, 40);
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        nameLabel.setForeground(Color.white);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setHorizontalTextPosition(JLabel.RIGHT);

        name.setBounds(100, 100, 200, 40);
        name.setHorizontalAlignment(JLabel.CENTER);

        startGame.setBounds(100, 160, 200, 40);
        startGame.setFocusable(false);
        startGame.addActionListener(this);

        scoreboardGame.setBounds(100, 210, 200, 40);
        scoreboardGame.setFocusable(false);
        scoreboardGame.addActionListener(this);

        frame.add(naslov);
        frame.add(startGame);
        frame.add(name);
        frame.add(scoreboardGame);
        frame.add(nameLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,350);
        frame.getContentPane().setBackground(new Color(60,71,139));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public String getPlayer() {
        return player;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startGame) {
            if(name.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You have not entered a name in the provided field", "POGREŠKA", JOptionPane.ERROR_MESSAGE);
            } else {
                frame.dispose();
                player = name.getText();
                Game game = new Game();
            }
        }
    }
}
