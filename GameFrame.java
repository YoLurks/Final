import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.*;
import javax.swing.*;

public class GameFrame {
    private JFrame frame;
    private GameCanvas gc;

    public GameFrame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        frame = new JFrame();
        gc = new GameCanvas();
    }

    public void setUpGUI()  {
        frame.setTitle("Final - Camacho245288 - Pardo246268");
        frame.setLayout(new BorderLayout());
        frame.add(gc, BorderLayout.CENTER); 
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
