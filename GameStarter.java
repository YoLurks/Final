import java.io.*;
import java.net.*;
import java.util.Scanner;
import javax.sound.sampled.*;

public class GameStarter {
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        GameFrame frame = null;
        frame = new GameFrame();
        frame.setUpGUI();

        try (Socket socket = new Socket("localhost", 51000);
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            Scanner in = new Scanner(System.in)) {
            System.out.println("You have joined the race!");

            String firstMessage = dataIn.readUTF();
            System.out.println("Driver 1: " + firstMessage);
            System.out.print("Respond to Driver 1: ");
            String response = in.nextLine();
            dataOut.writeUTF(response);

            String kingdomPrompt = dataIn.readUTF();
            System.out.println("Driver 1: " + kingdomPrompt);
            System.out.print("Enter Kingdom: ");
            String userInput = in.nextLine();
            dataOut.writeUTF(userInput);

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
