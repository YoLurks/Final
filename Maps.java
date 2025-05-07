import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Maps extends JComponent {
    // Constants
    public static final String STRAWBERRY = "Strawberry Grand Prix";
    public static final String BLUEBERRY = "Blueberry Grand Prix";
    public static final String CHOCOLATE = "Chocolate Grand Prix";

    private Image defaultImage;
    private Image hoverImage1, hoverImage2, hoverImage3, hoverImage4;
    private Image currentImage;
    private boolean strawPicked;
    private boolean bluePicked;
    private boolean chocoPicked;
    private boolean backPicked;
    private Addon addon;

    private String selectedMap = null;

    private final Rectangle hoverArea1 = new Rectangle(38,209,307,353);   
    private final Rectangle hoverArea2 = new Rectangle(358,209,307,353);  
    private final Rectangle hoverArea3 = new Rectangle(679,208,307,353);  
    private final Rectangle hoverArea4 = new Rectangle(53, 51, 65, 65);      

    public Maps() {
        defaultImage = new ImageIcon("./assets/maps.png").getImage();
        hoverImage1 = new ImageIcon("./assets/firstmaphover.png").getImage();
        hoverImage2 = new ImageIcon("./assets/secondmaphover.png").getImage();
        hoverImage3 = new ImageIcon("./assets/thirdmaphover.png").getImage();
        hoverImage4 = new ImageIcon("./assets/exitmaps.png").getImage();
        currentImage = defaultImage;
        addon = new Addon();
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
                    selectedMap = STRAWBERRY;
                    System.out.println("Map: " + selectedMap);
                    strawPicked = true;
                } else if (hoverArea2.contains(p)) {
                    selectedMap = BLUEBERRY;
                    System.out.println("Map: " + selectedMap);
                    bluePicked = true;
                } else if (hoverArea3.contains(p)) {
                    selectedMap = CHOCOLATE;
                    System.out.println("Map: " + selectedMap);
                    chocoPicked = true;
                } else if (hoverArea4.contains(p)) {
                    selectedMap = null;
                    addon.changeAddonType(null);
                    backPicked = true;
                    addon.nullify();
                }
            }
        });
    }

    public boolean isStrawPicked(){
        return strawPicked;
    }

    public boolean isBlueberryPicked(){
        return bluePicked;
    }

    public boolean isChocoPicked(){
        return chocoPicked;
    }

    public boolean isBackPicked(){
        return backPicked;
    }

    public String getType() {
        return selectedMap;
    }

    public void changebackPicked(boolean x){
        backPicked = x;
    }

    public void nullify(){
        strawPicked = false;
        bluePicked = false;
        chocoPicked = false;
    }

    public void changeMap(String x){
        selectedMap = x;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
