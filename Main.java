package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int SERVER_PORT = 23456;

    public static void main(String[] args) {
        System.out.println("Server started!");
        try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
            Socket socket = server.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String output = "A record # 12 was sent!";
            System.out.println("Received: " + inputStream.readUTF());
            System.out.println("Sent: " + output);
            outputStream.writeUTF(output);
        } catch (IOException e) {

            System.out.println("Server was interrupted");
        }
    }
}
