import java.awt.*;
import javax.swing.*;

public class PlayButton extends JComponent {
    private Image backgroundImage;

    private final int buttonX = 150;
    private final int buttonY = 100;
    private final int buttonWidth = 700;
    private final int buttonHeight = 550;


    private final int clickX = 334 - buttonX;
    private final int clickY = 348 - buttonY;
    private final int clickW = 355;
    private final int clickH = 127;

    public PlayButton() {
        ImageIcon icon = new ImageIcon("./assets/play.png");
        backgroundImage = icon.getImage();

        setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
    }

    public boolean isClicked(Point p) {
        Rectangle clickArea = new Rectangle(clickX, clickY, clickW, clickH);
        return clickArea.contains(p);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }


        g.setColor(new Color(0, 0, 0, 0));
        g.drawRect(clickX, clickY, clickW, clickH);
    }
}
