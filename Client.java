package server;

import client.ThreadClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

    private static final String REQUEST = "record # 12";

    public void start() throws IOException {
        String address = "127.0.0.1";
        int port = 23456;
        Socket socket = new Socket(InetAddress.getByName(address), port);
        System.out.println("Client started!");
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        String send = "Give me a " + REQUEST;
        output.writeUTF(send);
        System.out.println("Sent: "+ send +" cl");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        String resultFromServer = input.readUTF();
        System.out.println("Received: " + resultFromServer+" cl");
    }
}
