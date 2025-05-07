import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Addon extends JComponent {
    // Constants
    public static final String ADDON = "Cinnamon Turbo";
    public static final String NONE = "None";
    public boolean addonPicked;
    public boolean xPicked;
    public boolean backPicked;
    private Image defaultImage;
    private Image hoverImage1;
    private Image hoverImage2;
    private Image hoverImage3;
    private Image currentImage;
    private Brakes brakes;


    private String AddonType = null;

    private final Rectangle hoverArea1 = new Rectangle(249, 211, 230, 446); // Slicks
    private final Rectangle hoverArea2 = new Rectangle(546, 211, 230, 446); // Wets
    private final Rectangle hoverArea3 = new Rectangle(53,51,65,65);

    public Addon() {
        defaultImage = new ImageIcon("./assets/addon.png").getImage();
        hoverImage1 = new ImageIcon("./assets/addonhover.png").getImage();
        hoverImage2 = new ImageIcon("./assets/xhover.png").getImage();
        hoverImage3 = new ImageIcon("./assets/exitaddon.png").getImage();
        currentImage = defaultImage;
        addonPicked = false;
        xPicked = false;
        backPicked = false;
        brakes = new Brakes();

        setBounds(0, 0, 1024, 768);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                if (hoverArea1.contains(p)) {
                    currentImage = hoverImage1;
                } else if (hoverArea2.contains(p)) {
                    currentImage = hoverImage2;
                } else if (hoverArea3.contains(p)) {
                    currentImage = hoverImage3;
                } else {
                    currentImage = defaultImage;
                }
                repaint();
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (hoverArea1.contains(p)) {
                    AddonType = ADDON;
                    addonPicked = true;
                    System.out.println("+ " + AddonType + " add-on");
                } else if (hoverArea2.contains(p)) {
                    AddonType = NONE;
                    xPicked = true;
                    System.out.println("No add-on added");
                } else if (hoverArea3.contains(p)) {
                    AddonType = null;
                    brakes.nullify();
                    backPicked = true;
                    brakes.changeBrake(null);

                }
            }
        });
    }

    public String getType() {
        return AddonType;
    }

    public boolean isAddonPicked(){
        return addonPicked;
    }

    public boolean isXPicked(){
        return xPicked;
    }

    public boolean isBackPicked(){
        return backPicked;
    }

    public void changeAddonType(String x){
        AddonType = x;
    }

    public void nullify(){
        AddonType = null;
        addonPicked = false;
        xPicked = false;
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
