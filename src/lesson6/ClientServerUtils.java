package lesson6;

import java.io.*;
import java.net.Socket;

final class ClientServerUtils {
    static Thread createSendMessagesThread(Socket socket, String senderName) {
        return new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    String destMsg = reader.readLine();
                    out.writeUTF(senderName + ": " + destMsg);
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        });
    }

    static Thread createReceiveMessagesThread(Socket socket) {
        return new Thread(() -> {
            try {
                DataInputStream in = new DataInputStream(socket.getInputStream());
                while (true) {
                    String srcMsg = in.readUTF();
                    System.out.println("from " + srcMsg);
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        });
    }
}
