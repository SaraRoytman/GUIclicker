import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JButton button;
    private int count = 0;

    public GUI() {
        // יצירת החלון הראשי
        frame = new JFrame("Character Clicker");

        String buttonText = "CLICK THE CAT!!🐱";

        String path = "src/character.jpg";
        ImageIcon charIcon = new ImageIcon(path);

        if (charIcon.getIconWidth() == -1) {
            button = new JButton(buttonText);
        } else {
            Image image = charIcon.getImage();
            Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            charIcon = new ImageIcon(newimg);

            button = new JButton(buttonText, charIcon);

            button.setVerticalTextPosition(SwingConstants.CENTER);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
        }

        button.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.white);

        button.addActionListener(e -> {
            count++;
            System.out.println("The cat was clicked! Total: " + count);

            if(count == 5 || count == 6){
                button.setText("WHY DID YOU DO THAT");
                button.setBackground(Color.RED);
                button.setForeground(Color.white);
            }
            else if(count == 7){
                button.setText("why did you stop");
                button.setBackground(Color.GREEN);
                button.setForeground(Color.BLACK);

            } else if (count > 7) {
                button.setText("why didnt you stop");
                button.setBackground(Color.RED);


            } else{
                button.setText("AGAIN!🐱");
                button.setBackground(new Color(144, 238, 144));

            }


        });

        button.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBorder(new LineBorder(Color.white, 3, true));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(6, 19, 8));
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}