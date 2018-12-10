package lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Server {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8189)) {
      System.out.println("Server started... Waiting clients");

      Socket socket = serverSocket.accept();
      System.out.println("Client connected");

      DataInputStream inS = new DataInputStream(socket.getInputStream());
      DataOutputStream outS = new DataOutputStream(socket.getOutputStream());

      Thread reader = new Thread(() -> {
        try {
          while (true) {
            String msg = inS.readUTF();
            System.out.println("from client: " + msg);
            if (msg.equalsIgnoreCase("/end")) {
              System.out.println("Client disconnected");
              break;
            }
          }
          socket.close();
        }
        catch (SocketException | EOFException e){
          System.out.println("Client disconnected");
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      });
      reader.setDaemon(true);
      reader.start();

      Thread sender = new Thread(() -> {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
          while (true) {
            String s = br.readLine();
            if (s.equalsIgnoreCase("/kill server")){
              System.out.println("Server killed");
              socket.close();
              break;
            }
            if (!s.trim().isEmpty()){
              outS.writeUTF(s);
            }
          }
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      });
      sender.start();

    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }

}
