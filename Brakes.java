import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Brakes extends JComponent {
    // Constants
    public static final String CANDY = "Candy Brakes";
    public static final String STRIPE = "Stripe Brakes";
    public static final String MAGIC = "Magic Brakes";

    private Image defaultImage;
    private Image hoverImage1, hoverImage2, hoverImage3, hoverImage4;
    private Image currentImage;
    private boolean candyPicked;
    private boolean stripePicked;
    private boolean magicPicked;
    private boolean backPicked;
    private Wheels wheels;

    private String selectedBrakeType = null;

    private final Rectangle hoverArea1 = new Rectangle(77, 211, 230, 448);   // Candy
    private final Rectangle hoverArea2 = new Rectangle(397, 211, 230, 446);  // Stripe
    private final Rectangle hoverArea3 = new Rectangle(717, 211, 230, 446);  // Magic
    private final Rectangle hoverArea4 = new Rectangle(53, 51, 65, 65);      // Exit

    public Brakes() {
        defaultImage = new ImageIcon("./assets/brakes.png").getImage();
        hoverImage1 = new ImageIcon("./assets/candy.png").getImage();
        hoverImage2 = new ImageIcon("./assets/stripe.png").getImage();
        hoverImage3 = new ImageIcon("./assets/magic.png").getImage();
        hoverImage4 = new ImageIcon("./assets/exitBreaks.png").getImage();
        currentImage = defaultImage;
        wheels = new Wheels();
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
                } else if (hoverArea4.contains(p)) {
                    currentImage = hoverImage4;
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
                    selectedBrakeType = CANDY;
                    System.out.println(CANDY + " selected!");
                    candyPicked = true;
                } else if (hoverArea2.contains(p)) {
                    selectedBrakeType = STRIPE;
                    System.out.println(STRIPE + " selected!");
                    stripePicked = true;
                } else if (hoverArea3.contains(p)) {
                    selectedBrakeType = MAGIC;
                    System.out.println(MAGIC + " selected!");
                    magicPicked = true;
                } else if (hoverArea4.contains(p)) {
                    selectedBrakeType = null;
                    wheels.changeWheelType(null);
                    backPicked = true;
                    wheels.nullify();
                    System.out.println("Returning to Engine selection...");
                }
            }
        });
    }

    public boolean isCandyPicked(){
        return candyPicked;
    }

    public boolean isStripePicked(){
        return stripePicked;
    }

    public boolean isMagicPicked(){
        return magicPicked;
    }

    public boolean isBackPicked(){
        return backPicked;
    }

    public String getType() {
        return selectedBrakeType;
    }

    public void changebackPicked(boolean x){
        backPicked = x;
    }

    public void nullify(){
        candyPicked = false;
        stripePicked = false;
        magicPicked = false;
    }

    public void changeBrake(String x){
        selectedBrakeType = x;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
