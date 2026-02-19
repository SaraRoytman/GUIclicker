import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    private JButton button;

    public GUI() {
        frame = new JFrame("Character Clicker");


        String path = "C:\\Users\\sara2\\Downloads\\character.jpg";
        ImageIcon charIcon = new ImageIcon(path);

        if (charIcon.getIconWidth() == -1) {
            button = new JButton("Click here!");
        }
        else {
            Image image = charIcon.getImage();
            Image newimg = image.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            charIcon = new ImageIcon(newimg);

            button = new JButton("click me!", charIcon);

            button.setVerticalTextPosition(SwingConstants.TOP);
            button.setHorizontalTextPosition(SwingConstants.CENTER);
            button.setFont(new Font("Arial", Font.BOLD, 14));
            button.setForeground(Color.WHITE);

            button.setBackground(new Color(0x147064));

            button.setUI(new javax.swing.plaf.basic.BasicButtonUI());

            button.setContentAreaFilled(true);
            button.setOpaque(true);
            button.setBorderPainted(false);
            button.setFocusPainted(false);

            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        button.addActionListener(this);

        // --- הגדרות הלייבל (הטקסט) ---
        label = new JLabel("Number of clicks: 0");

        // 1. קובע את סגנון וגודל הכתב
        label.setFont(new Font("Arial", Font.BOLD, 22));

        // 2. מרכוז הטקסט בתוך התיבה של הלייבל
        label.setHorizontalAlignment(JLabel.CENTER);

        button.setAlignmentX(Component.CENTER_ALIGNMENT); // <--- מרכוז הכפתור
        label.setAlignmentX(Component.CENTER_ALIGNMENT);  // <--- מרכוז הלייבל

        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // --- הוספה לפאנל לפי הסדר ---
        panel.add(button); // יופיע ראשון (למעלה)
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // רווח של 20 פיקסלים
        panel.add(label);  // יופיע מתחת לכפתור

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}