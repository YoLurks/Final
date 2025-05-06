import java.awt.*;
import javax.swing.*;

public class IntroBackground extends JComponent {
    private Image backgroundImage;

    public IntroBackground() {
        ImageIcon icon = new ImageIcon("./assets/Background.jpg");
        backgroundImage = icon.getImage();
        setBounds(0, 0, 1024, 768);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
