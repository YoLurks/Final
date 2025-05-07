import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Engine extends JComponent {
    // Constants for types
    public static final String SHORTCAKE = "Shortcake Core";
    public static final String CHOCO = "Overload Core";
    public static final String MATCHA = "Matcha Core";

    private Image defaultImage;
    private Image hoverImage1;
    private Image hoverImage2;
    private Image hoverImage3;
    private Image currentImage;
    private boolean shortcakePicked;
    private boolean chocoPicked;
    private boolean matchaPicked;

    private String pickedEngineType;

    private final Rectangle hoverArea1 = new Rectangle(77, 211, 230, 448);   // Shortcake
    private final Rectangle hoverArea2 = new Rectangle(397, 211, 230, 446);  // Choco
    private final Rectangle hoverArea3 = new Rectangle(717, 211, 230, 446);  // Matcha

    public Engine() {
        defaultImage = new ImageIcon("./assets/Engine.png").getImage();
        hoverImage1 = new ImageIcon("./assets/shortcake.png").getImage();
        hoverImage2 = new ImageIcon("./assets/choco.png").getImage();
        hoverImage3 = new ImageIcon("./assets/matcha.png").getImage();
        currentImage = defaultImage;

        pickedEngineType = null;

        setBounds(0, 0, 1024, 768);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                if (hoverArea1.contains(p)) {
                    if (currentImage != hoverImage1) {
                        currentImage = hoverImage1;
                        repaint();
                    }
                } else if (hoverArea2.contains(p)) {
                    if (currentImage != hoverImage2) {
                        currentImage = hoverImage2;
                        repaint();
                    }
                } else if (hoverArea3.contains(p)) {
                    if (currentImage != hoverImage3) {
                        currentImage = hoverImage3;
                        repaint();
                    }
                } else {
                    if (currentImage != defaultImage) {
                        currentImage = defaultImage;
                        repaint();
                    }
                }
            }
        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (hoverArea1.contains(p)) {
                    pickedEngineType = SHORTCAKE;
                    shortcakePicked = true;
                    System.out.println("Engine: " + SHORTCAKE);
                } else if (hoverArea2.contains(p)) {
                    pickedEngineType = CHOCO;
                    chocoPicked = true;
                    System.out.println("Engine: " + CHOCO );
                } else if (hoverArea3.contains(p)) {
                    pickedEngineType = MATCHA;
                    matchaPicked = true;
                    System.out.println("Engine: " + MATCHA);
                }
            }
        });
    }

    public boolean isShortcakePicked(){
        return shortcakePicked;
    }

    public boolean isChocoPicked(){
        return chocoPicked;
    }

    public boolean isMatchaPicked(){
        return matchaPicked;
    }
    public String getEngineType() {
        return pickedEngineType;
    }

    public void changeEngine(String x){
        pickedEngineType = x;
    }

    public void nullify(){
        pickedEngineType = null;
        shortcakePicked = false;
        chocoPicked = false;
        matchaPicked = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
