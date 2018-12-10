package lesson6;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Client {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8189)) {
      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

      Thread reader = new Thread(() -> {
        try {
          while (true) {
            String msg = in.readUTF();
            if (msg.equalsIgnoreCase("/kick client")) {
              System.out.println("Kicked from server");
              break;
            }
            System.out.println("from server: " + msg);
          }
          socket.close();
          System.exit(0);
        }
        catch (SocketException | EOFException e) {
          System.out.println("Server has closed connection");
          System.exit(0);
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      });
      reader.setDaemon(true);
      reader.start();

      try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
        while (true) {
          String s = br.readLine();
          if (!s.trim().isEmpty()){
            out.writeUTF(s);
          }
          if (s.equalsIgnoreCase("/end")){
            break;
          }
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }

    }
    catch (IOException e) {
      e.printStackTrace();
    }
  }
}
