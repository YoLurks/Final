import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Wheels extends JComponent {
    // Constants
    public static final String SLICKS = "Slicks";
    public static final String WETS = "Wets";
    public boolean slicksPicked;
    public boolean wetsPicked;
    public boolean backPicked;
    private Image defaultImage;
    private Image hoverImage1;
    private Image hoverImage2;
    private Image hoverImage3;
    private Image currentImage;
    private Engine engine;


    private String selectedWheelsType = null;

    private final Rectangle hoverArea1 = new Rectangle(249, 211, 230, 446); // Slicks
    private final Rectangle hoverArea2 = new Rectangle(546, 211, 230, 446); // Wets
    private final Rectangle hoverArea3 = new Rectangle(53,51,65,65);

    public Wheels() {
        defaultImage = new ImageIcon("./assets/Wheels.png").getImage();
        hoverImage1 = new ImageIcon("./assets/slicks.png").getImage();
        hoverImage2 = new ImageIcon("./assets/wets.png").getImage();
        hoverImage3 = new ImageIcon("./assets/exitWheels.png").getImage();
        currentImage = defaultImage;
        slicksPicked = false;
        wetsPicked = false;
        backPicked = false;

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
                    selectedWheelsType = SLICKS;
                    slicksPicked = true;
                    System.out.println(SLICKS + " selected!");
                } else if (hoverArea2.contains(p)) {
                    selectedWheelsType = WETS;
                    wetsPicked = true;
                    System.out.println(WETS + " selected!");
                } else if (hoverArea3.contains(p)) {
                    System.out.println("Pick Engine again. ");
                    selectedWheelsType = null;
                    engine.nullify();
                    backPicked = true;
                    engine.changeEngine(null);

                }
            }
        });
    }

    public String getType() {
        return selectedWheelsType;
    }

    public boolean isSlicksPicked(){
        return slicksPicked;
    }

    public boolean isWetsPicked(){
        return wetsPicked;
    }

    public boolean isBackPicked(){
        return backPicked;
    }

    public void changeWheelType(String x){
        selectedWheelsType = x;
    }

    public void nullify(){
        selectedWheelsType = null;
        slicksPicked = false;
        wetsPicked = false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
