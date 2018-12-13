package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static lesson6.ClientServerUtils.createReceiveMessagesThread;
import static lesson6.ClientServerUtils.createSendMessagesThread;

public class Server {
    static String serverHost = "localhost";
    static int serverPort = 8189;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(serverPort)){
            System.out.println("Server started... Waiting clients");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            Thread sendMessagesThread = createSendMessagesThread(socket, "server");
            Thread receiveMessagesThread = createReceiveMessagesThread(socket);

            sendMessagesThread.start();
            receiveMessagesThread.start();

            sendMessagesThread.join();
            receiveMessagesThread.join();
        } catch (IOException | InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
