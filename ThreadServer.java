package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer extends Thread {
    private static final int SERVER_PORT = 23456;
    //private final static RequestToDB REQUEST_TO_DB = new RequestToDB();
    private static final RequestToDbMap REQUEST_TO_DB_MAP = new RequestToDbMap();
    private boolean isActive;

    void disable(){
        isActive=false;
    }

    ThreadServer(){
        isActive = true;
    }
    @Override
    public void run() {
        while (isActive) {
            System.out.println("Server started!");
            try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
                Socket socket = server.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                String request = inputStream.readUTF();
                int sizeOfArgs = Integer.parseInt(inputStream.readUTF());

                outputStream.writeUTF(String.valueOf(REQUEST_TO_DB_MAP.start(request, sizeOfArgs)));
                if ((String.valueOf(REQUEST_TO_DB_MAP.start(request, sizeOfArgs)).equals("exit"))) {
                    disable();
                }

            } catch (IOException e) {
                System.out.println("Server was interrupted");
            }
        }
    }

}
