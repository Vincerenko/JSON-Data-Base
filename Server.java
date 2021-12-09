package server;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void start() throws IOException {
        String address = "127.0.0.1";
        int port = 23456;
        ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
        System.out.println("Server started!");
        Socket socket = server.accept();
        DataInputStream input = new DataInputStream(socket.getInputStream());
        String requestFromClient = input.readUTF();
        System.out.println("Received: " + requestFromClient+" serv");
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        System.out.println("Sent: A record # 12 was sent!"+" serv");
        output.writeUTF("Sent: A record # 12 was sent!"+" serv");


    }


}