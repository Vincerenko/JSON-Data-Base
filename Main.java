package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    private static final int SERVER_PORT = 23456;
    private final static RequestToDB REQUEST_TO_DB = new RequestToDB();
    public static void main(String[] args) {
    ThreadServer threadServer = new ThreadServer();
    threadServer.start();


    }
}
