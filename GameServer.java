import java.io.*;
import java.net.*;
import java.util.Scanner;

public class GameServer {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(51000);
            System.out.println("Waiting for Driver 2...");

            Socket clientSocket = serverSocket.accept(); 
            System.out.println("Driver 2 has joined!");

            DataInputStream dataIn = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());

            System.out.print("Enter message for Driver 2: ");
            String firstMessage = in.nextLine();
            dataOut.writeUTF(firstMessage);

            String response1 = dataIn.readUTF();
            System.out.println("Driver 2: " + response1);
            System.out.println("Driver 2 is now picking the Kingdom");
            dataOut.writeUTF("What kingdom will you pick?");

            String response = dataIn.readUTF();
            System.out.println("Driver 2 picks: " + response);

            clientSocket.close();
            serverSocket.close();  

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
