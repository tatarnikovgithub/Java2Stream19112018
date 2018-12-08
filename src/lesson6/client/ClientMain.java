package lesson6.client;

import java.io.*;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class ClientMain {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8189)) {
            System.out.println("Client connected");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread reader = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        System.out.println("from server: " + msg);
                        if (msg.equals("/end")) break;
                    }
                } catch (SocketException e) {
                    System.out.println("Server has closed connection");
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
                    if (s.equals("/end")) break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
