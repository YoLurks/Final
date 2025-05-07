import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReadyScreen extends JComponent {

    public static final String SLICKS = "Slicks";
    public static final String WETS = "Wets";
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
    private final Rectangle exitArea = new Rectangle(53,51,65,65);

    public ReadyScreen() {
        blueberryWait = new ImageIcon("./assets/waitBlueberry.png").getImage();
        blueberryReady = new ImageIcon("./assets/readyBlueberry.png").getImage();
        blueberryExit = new ImageIcon("./assets/exitBlueberry.png").getImage();
        strawberryWait = new ImageIcon("./assets/waitStrawberry.png").getImage();
        strawberryReady = new ImageIcon("./assets/readyStrawberrypng").getImage();
        strawberryExit = new ImageIcon("./assets/exitStrawberry.png").getImage();
        blueberry_Ready = false;
        strawberry_Ready = false;
        backPicked = false;
        maps = new Maps();
        kingdom = new Kingdom();

        setBounds(0, 0, 1024, 768);

        if (kingdom.getType().equals("Blueberry")){
            currentImage = blueberryWait;
        }else if (kingdom.getType().equals("Strawberry")){
            currentImage = strawberryWait;
        }

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point p = e.getPoint();
                if (kingdom.getType().equals("Blueberry")){
                if (readyArea.contains(p)) {
                    currentImage = blueberryReady;
                } else if (exitArea.contains(p)) {
                    currentImage = blueberryExit;
                } else {
                    currentImage = blueberryWait;
                }
                repaint();
            }
                if (kingdom.getType().equals("Strawberry")){
                    if (readyArea.contains(p)) {
                        currentImage = strawberryReady;
                    } else if (exitArea.contains(p)) {
                        currentImage = strawberryExit;
                    } else {
                        currentImage = strawberryWait;
                    }
                    repaint();
                }
        }

        });

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                if (kingdom.getType().equals("Blueberry")){
                if (readyArea.contains(p) && blueberry_Ready == false) {
                    blueberry_Ready = true;
                    System.out.println("Driver: Ready");
                } else if (readyArea.contains(p) && blueberry_Ready == true) {
                    blueberry_Ready = false;
                    System.out.println("Driver: Not Ready");

                }else if (exitArea.contains(p) && blueberry_Ready == false) {
                    maps.nullify();
                    backPicked = true;
                    maps.changeMap(null);
                }
            }

            if (kingdom.getType().equals("Strawberry")){
                if (readyArea.contains(p) && strawberry_Ready == false) {
                    strawberry_Ready = true;
                    System.out.println("Driver: Ready");
                } else if (readyArea.contains(p) && strawberry_Ready == true) {
                    strawberry_Ready = false;
                    System.out.println("Driver: Not Ready");

                }else if (exitArea.contains(p) && strawberry_Ready == false) {
                    maps.nullify();
                    backPicked = true;
                    maps.changeMap(null);
                }
            }
                
            }
        });
    }



    public boolean isBlueBerryReady(){
        return blueberry_Ready;
    }

    public boolean isStrawberryReady(){
        return strawberry_Ready;
    }

    public boolean isBackPicked(){
        return backPicked;
    }


    public void nullify(){
        blueberry_Ready = false;
        strawberry_Ready = false;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
    }
}
