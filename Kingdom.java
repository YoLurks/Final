import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kingdom extends JComponent {
    public static final String STRAWBERRY = "Strawberry";
    public static final String BLUEBERRY = "Blueberry";

    private Image defaultImage;
    private Image hoverImage1;
    private Image hoverImage2;
    private Image currentImage;
    private boolean blueberryPicked;
    private boolean strawberryPicked;

    private String selectedKingdomType = null;

    private final Rectangle hoverArea1 = new Rectangle(528, 247, 418, 374);  // Strawberry
    private final Rectangle hoverArea2 = new Rectangle(76, 247, 418, 373);   // Blueberry

    public Kingdom() {
        defaultImage = new ImageIcon("./assets/chooseKingdom.png").getImage();
        hoverImage1 = new ImageIcon("./assets/strawberryhover.png").getImage();
        hoverImage2 = new ImageIcon("./assets/blueberryhover.png").getImage();
        currentImage = defaultImage;

        setBounds(0, 0, 1024, 768);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                if (hoverArea1.contains(p)) {
                    currentImage = hoverImage1;
                } else if (hoverArea2.contains(p)) {
                    currentImage = hoverImage2;
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
                    selectedKingdomType = STRAWBERRY;
                    strawberryPicked = true;
                    System.out.println(STRAWBERRY + " selected!");
                } else if (hoverArea2.contains(p)) {
                    selectedKingdomType = BLUEBERRY;
                    blueberryPicked = true;
                    System.out.println(BLUEBERRY + " selected!");
                }
            }
        });
    }

    public String getType() {
        return selectedKingdomType;
    }

    public void changeKingdomType(String x){
        selectedKingdomType = x;
    }
    public boolean isStrawberryPicked(){
        return strawberryPicked;
    }

    public boolean isBlueberryPicked(){
        return blueberryPicked;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
