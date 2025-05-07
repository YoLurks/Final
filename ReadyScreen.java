import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReadyScreen extends JComponent {

    public boolean blueberry_Ready;
    public boolean strawberry_Ready;
    public boolean backPicked;
    private Image blueberryWait;
    private Image blueberryReady;
    private Image blueberryExit;
    private Image strawberryWait;
    private Image strawberryReady;
    private Image strawberryExit;
    private Image currentImage;
    private Maps maps;
    private Kingdom kingdom;

    private final Rectangle readyArea = new Rectangle(323, 487, 404, 114);
    private final Rectangle exitArea = new Rectangle(53, 51, 65, 65);

    public ReadyScreen(Kingdom kingdom) {
        this.kingdom = kingdom;
        blueberryWait = new ImageIcon("./assets/waitBlueberry.png").getImage();
        blueberryReady = new ImageIcon("./assets/readyBlueberry.png").getImage();
        blueberryExit = new ImageIcon("./assets/exitBlueberry.png").getImage();
        strawberryWait = new ImageIcon("./assets/waitStrawberry.png").getImage();
        strawberryReady = new ImageIcon("./assets/readyStrawberry.png").getImage();
        strawberryExit = new ImageIcon("./assets/exitStrawberry.png").getImage();

        blueberry_Ready = false;
        strawberry_Ready = false;
        backPicked = false;

        maps = new Maps();

        setBounds(0, 0, 1024, 768);

        String type = kingdom.getType();
        if ("Blueberry".equals(type)) {
            currentImage = blueberryWait;
        } else if ("Strawberry".equals(type)) {
            currentImage = strawberryWait;
        } else {
            System.err.println("Warning: Kingdom type is null or unknown. Defaulting to Blueberry wait screen.");
            currentImage = blueberryWait;
        }

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                String type = kingdom.getType();

                // Check hover effects only if not ready
                if ("Blueberry".equals(type) && !blueberry_Ready) {
                    if (exitArea.contains(p)) {
                        currentImage = blueberryExit;
                    } else {
                        currentImage = blueberryWait;
                    }
                }

                if ("Strawberry".equals(type) && !strawberry_Ready) {
                    if (exitArea.contains(p)) {
                        currentImage = strawberryExit;
                    } else {
                        currentImage = strawberryWait;
                    }
                }

                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                String type = kingdom.getType();

                // Handle click logic for Blueberry
                if ("Blueberry".equals(type)) {
                    if (readyArea.contains(p)) {
                        // Toggle ready state for Blueberry only if it's not backpicked
                        if (!blueberry_Ready && !backPicked) {
                            blueberry_Ready = true;
                            currentImage = blueberryReady;
                            repaint();
                            System.out.println("Driver: Ready (Blueberry)");
                        } else if (blueberry_Ready && !backPicked) {
                            blueberry_Ready = false;
                            currentImage = blueberryWait;
                            repaint();
                            System.out.println("Driver: Not Ready (Blueberry)");
                        }
                    } else if (exitArea.contains(p)) {
                        // If clicked on the exit area, set backPicked to true
                        if (!blueberry_Ready) {
                            maps.nullify();
                            backPicked = true;
                            maps.changeMap(null);
                            System.out.println("Exiting to Maps (Blueberry)");
                        }
                    }
                }

                // Handle click logic for Strawberry
                if ("Strawberry".equals(type)) {
                    if (readyArea.contains(p)) {
                        // Toggle ready state for Strawberry only if it's not backpicked
                        if (!strawberry_Ready && !backPicked) {
                            strawberry_Ready = true;
                            currentImage = strawberryReady;
                            repaint();
                            System.out.println("Driver: Ready (Strawberry)");
                        } else if (strawberry_Ready && !backPicked) {
                            strawberry_Ready = false;
                            currentImage = strawberryWait;
                            repaint();
                            System.out.println("Driver: Not Ready (Strawberry)");
                        }
                    } else if (exitArea.contains(p)) {
                        
                        if (!strawberry_Ready) {
                            maps.nullify();
                            backPicked = true;
                            maps.changeMap(null);
                            System.out.println("Exiting to Maps (Strawberry)");
                        }
                    }
                }
            }
        });
    }

    public boolean isBlueBerryReady() {
        return blueberry_Ready;
    }

    public boolean isStrawberryReady() {
        return strawberry_Ready;
    }

    public boolean isBackPicked() {
        return backPicked;
    }

    public void nullify() {
        blueberry_Ready = false;
        strawberry_Ready = false;
    }

    public void changebackPicked(boolean x){
        backPicked = x;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
