import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Game extends JFrame implements ActionListener{
    Random rand = new Random();
    JFrame frame = new JFrame( "Guess the Number");
    JLabel topLeft = new JLabel("Type the number 0-100:");
    JLabel topRight = new JLabel("Tries:");
    JLabel bottom = new JLabel();
    JLabel tries = new JLabel("0");

    JLabel lastNumberText = new JLabel("Last number:");
    JLabel lastNumber = new JLabel("");
    JTextField brojField = new JTextField();

    JButton upis = new JButton("Send");

    private String str;
    private int broj;
    private int checkBroj;
    private int random_broj;
    private int counter = 0;
    Game() {
        random_broj = rand.nextInt(100);

        topLeft.setBounds(10,10,150,30);
        topLeft.setForeground(Color.white);
        topLeft.setHorizontalAlignment(JLabel.CENTER);
        topLeft.setHorizontalTextPosition(JLabel.RIGHT);

        brojField.setBounds(160, 10, 50,30);

        topRight.setBounds(250,10,100,30);
        topRight.setForeground(Color.white);
        topRight.setHorizontalAlignment(JLabel.CENTER);
        topRight.setHorizontalTextPosition(JLabel.RIGHT);

        tries.setBounds(320,10,50,30);
        tries.setForeground(Color.white);
        tries.setHorizontalAlignment(JLabel.CENTER);
        tries.setHorizontalTextPosition(JLabel.RIGHT);

        lastNumberText.setBounds(250,30,80,30);
        lastNumberText.setForeground(Color.white);
        lastNumberText.setHorizontalAlignment(JLabel.CENTER);
        lastNumberText.setHorizontalTextPosition(JLabel.RIGHT);

        lastNumber.setBounds(320,30,50,30);
        lastNumber.setForeground(Color.white);
        lastNumber.setHorizontalAlignment(JLabel.CENTER);
        lastNumber.setHorizontalTextPosition(JLabel.RIGHT);

        upis.setBounds(135, 55, 100, 40);
        upis.setBackground(new Color(94,110,216));
        upis.setForeground(Color.white);
        upis.setBorder(null);
        upis.setFocusable(false);
        upis.addActionListener(this);

        bottom.setBounds(60, 100, 250, 40);
        bottom.setForeground(Color.white);
        bottom.setHorizontalAlignment(JLabel.CENTER);
        bottom.setHorizontalTextPosition(JLabel.RIGHT);


        frame.add(topLeft);
        frame.add(brojField);
        frame.add(topRight);
        frame.add(tries);
        frame.add(upis);
        frame.add(bottom);
        frame.add(lastNumber);
        frame.add(lastNumberText);

        frame.setSize(400, 170);
        frame.getContentPane().setBackground(new Color(60,71,139));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setDefaultButton(upis);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == upis) {
            if (brojField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You have not entered a number in the provided field", "POGREŠKA", JOptionPane.ERROR_MESSAGE);
            } else{
                try {
                    broj = Integer.parseInt(brojField.getText());
                    provjeraBroja(broj);
                }
                catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(null, "You have entered a word not a number", "POGREŠKA", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void provjeraBroja(int a) {
        if (a == random_broj) {
            tries.setText(String.valueOf(counter+1));
            JOptionPane.showMessageDialog(null, "Congratulations\nYou guessed it from " + (counter+1) + " tries");
            tries.setText("0");
            lastNumber.setText("");
            brojField.setText("");
            counter = 0;
            random_broj = rand.nextInt(100);
        } else {
            if(a < random_broj) {
                counter++;
                tries.setText(String.valueOf(counter));
                bottom.setText("Too low");
                lastNumber.setText(brojField.getText());
                brojField.setText("");
            } else {
                counter++;
                tries.setText(String.valueOf(counter));
                bottom.setText("Too high");
                lastNumber.setText(brojField.getText());
                brojField.setText("");
            }
        }
    }
}
