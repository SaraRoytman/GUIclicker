import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JButton button;
    private int count = 0;

    public GUI() {
        // יצירת החלון הראשי
        frame = new JFrame("Character Clicker");

        String buttonText = "CLICK THE CAT!! 🐱";

        String path = "src/character.jpg";
        ImageIcon charIcon = new ImageIcon(path);

        if (charIcon.getIconWidth() == -1) {
            button = new JButton(buttonText);
        } else {
            Image image = charIcon.getImage();
            Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            charIcon = new ImageIcon(newimg);

            button = new JButton(buttonText, charIcon);

            button.setVerticalTextPosition(SwingConstants.TOP);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
        }


        button.setFont(new Font("Segoe UI Emoji", Font.BOLD, 25));

        button.setForeground(Color.BLACK);
        button.setBackground(Color.LIGHT_GRAY);

        button.addActionListener(e -> {
            count++; // מעלה את הספירה ב-1
            System.out.println("The cat was clicked! Total: " + count);

            // שינוי הטקסט על הכפתור בזמן אמת
            button.setText("You clicked " + count + " times! 🐱");

            // בונוס: שינוי צבע לירוק בלחיצה (הצבע שאת אוהבת!) [cite: 2025-07-29]
            button.setBackground(new Color(144, 238, 144));
        });

        // הגדרות למראה מודרני
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // הוספה לחלון
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}