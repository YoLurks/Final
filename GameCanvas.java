import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.sound.sampled.*;
import javax.swing.*;

public class GameCanvas extends JComponent {
    private Clip clip1;
    private Clip clip2;
    private PlayButton playButton;
    private Kingdom chooseKingdom;
    private ArrayList<JComponent> elements;
    private IntroBackground introBackground;
    private Engine chooseEngine;
    private Wheels wheels;
    private Brakes brakes;
    private Addon addon;
    private Maps maps;
    private ReadyScreen readyScreen;

    public GameCanvas() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        setPreferredSize(new Dimension(1024, 768));
        setLayout(null);
        elements = new ArrayList<>();

        File music1 = new File("./assets/intro.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(music1);
        clip1 = AudioSystem.getClip();
        clip1.open(audioStream);


        try {
            File music2 = new File("./assets/roblox.wav");
            AudioInputStream audioStream2 = AudioSystem.getAudioInputStream(music2);
            clip2 = AudioSystem.getClip();
            clip2.open(audioStream2);
            // Uncomment this to play the second music if needed
            // clip2.start();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Failed to load or play roblox.wav");
        }
        


        introBackground = new IntroBackground();
        playButton = new PlayButton();
        chooseKingdom = new Kingdom();
        chooseEngine = new Engine();
        wheels = new Wheels();
        brakes = new Brakes();
        addon = new Addon();
        maps = new Maps();
        readyScreen = new ReadyScreen();

        elements.add(introBackground);
        add(playButton);

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (playButton.isClicked(e.getPoint())) {
                    System.out.println("\nTime to build your car!\n");
                    remove(playButton);
                    elements.remove(introBackground);
                    add(chooseKingdom);
                    repaint();
                }
            }
        });

        chooseKingdom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chooseKingdom.isBlueberryPicked() || chooseKingdom.isStrawberryPicked()) {
                    remove(chooseKingdom);
                    add(chooseEngine);
                    repaint();

                }
            }
        });

        chooseEngine.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (chooseEngine.isShortcakePicked() || chooseEngine.isChocoPicked() || chooseEngine.isMatchaPicked()) {
                    remove(chooseEngine);
                    chooseEngine.nullify();
                    add(wheels);
                    repaint();
                }
            }
        });

        wheels.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (wheels.isBackPicked()) {
                    wheels.nullify();  
                    wheels.backPicked = false;  
                    remove(wheels);
                    chooseEngine.nullify();
                    add(chooseEngine);
                    repaint();
                    System.out.println("\nWent back to Engine selection.\n");
                } else if (wheels.isSlicksPicked() || wheels.isWetsPicked()) {
                    remove(wheels);
                    wheels.nullify();  
                    add(brakes);
                    repaint();
                }
            }
        });

        brakes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (brakes.isBackPicked()) {
                    brakes.changebackPicked(false);
                    brakes.nullify();  // Optional cleanup
                    remove(brakes);
                    add(wheels);
                    repaint();
                    System.out.println("\nWent back to Wheels selection.\n");
                } else if (brakes.isCandyPicked() || brakes.isStripePicked() || brakes.isMagicPicked()) {
                    remove(brakes);
                    add(addon);
                    repaint();
                }
            }
        });

        addon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (addon.isBackPicked()) {
                    addon.changebackPicked(false);
                    addon.nullify();  
                    remove(addon);
                    brakes.nullify();
                    add(brakes);
                    repaint();
                    System.out.println("\nWent back to Brakes selection.\n");
                } else if (addon.isAddonPicked() || addon.isXPicked()) {
                    remove(addon);
                    add(maps);
                    repaint();
                }
            }
        });

        maps.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (maps.isBackPicked()) {
                    maps.changebackPicked(false);
                    maps.nullify(); 
                    remove(maps);
                    add(addon);
                    repaint();
                    System.out.println("\nWent back to Add-on selection.\n");
                } else if (maps.isStrawPicked() || maps.isBlueberryPicked() || maps.isChocoPicked()) {
                    remove(maps);
                    add(readyScreen);
                    repaint();

                }
            } 
        });

       




        
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (JComponent element : elements) {
            Graphics2D g2d = (Graphics2D) g.create();
            element.paint(g2d);
            g2d.dispose();
        }
    }
}
