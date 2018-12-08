package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server started... Waiting clients");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread reader = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        System.out.println("from client: " + msg);
                        if (msg.equals("/end")) {
                            socket.close();
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            reader.setDaemon(true);
            reader.start();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
                while (true) {
                    String s = br.readLine();
                    out.writeUTF(s);
                    if (s.equals("/end")) {
                        socket.close();
                        break;
                    }
                }
            } catch (SocketException e) {
                System.out.println("Client has closed connection");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
