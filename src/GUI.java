import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    private JButton button;
    private int count = 0;

    public GUI() {
        frame = new JFrame("Character Clicker");

        // 1. הגדרת הטקסט ההתחלתי
        String buttonText = "CLICK THE CAT!! 🐱";

        // 2. יצירת הכפתור (בלי שום ImageIcon)
        button = new JButton(buttonText);

        // 3. הגדרות עיצוב (פונט וצבעים)
        button.setFont(new Font("Segoe UI Emoji", Font.BOLD, 20));
        button.setForeground(Color.BLACK);
        button.setBackground(Color.WHITE);

        // הגדרות למראה כפתור נקי ומודרני
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // 4. לוגיקת הלחיצות והשינויים
        button.addActionListener(e -> {
            count++;
            System.out.println("The cat was clicked! Total: " + count);

            if (count > 7) {
                button.setText("why didnt you stop");
                button.setBackground(Color.BLUE);
                button.setForeground(Color.CYAN);
            }
            else if (count > 5) {
                button.setText("why did you stop");
                button.setBackground(Color.ORANGE);
                button.setForeground(Color.BLACK);
            }
            else if (count == 5) {
                button.setText("WHY DID YOU DO THAT");
                button.setBackground(Color.RED);
                button.setForeground(Color.WHITE);
            }
            else {
                button.setText("AGAIN! 🐱");
                button.setBackground(new Color(144, 238, 144)); // ירוק בהיר
                button.setForeground(Color.BLACK);
            }
        });

        // 5. הגדרות החלון (JFrame)
        frame.setLayout(new GridBagLayout()); // שומר על הכפתור במרכז
        frame.getContentPane().setBackground(new Color(21, 53, 8)); // הרקע הירוק הכהה

        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null); // מרכז את החלון על המסך
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // מריץ את ה-GUI בצורה בטוחה
        SwingUtilities.invokeLater(() -> new GUI());
    }
}