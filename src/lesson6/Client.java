package lesson6;

import java.io.*;
import java.net.Socket;

import static lesson6.ClientServerUtils.createReceiveMessagesThread;
import static lesson6.ClientServerUtils.createSendMessagesThread;

public class Client {
    public static void main(String[] args) {
        try(Socket clientSocket = new Socket(Server.serverHost, Server.serverPort)){
            System.out.println("Connected to Server.....Client started");

            Thread sendMessagesThread = createSendMessagesThread(clientSocket, "client");
            Thread receiveMessagesThread = createReceiveMessagesThread(clientSocket);

            sendMessagesThread.start();
            receiveMessagesThread.start();

            sendMessagesThread.join();
            receiveMessagesThread.join();
        } catch (IOException | InterruptedException ex) {
            System.err.println(ex);
        }
    }
}
