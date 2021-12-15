package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class ThreadServer extends Thread {
    private static final int SERVER_PORT = 23456;
    private static final RequestToDbMap REQUEST_TO_DB_MAP = new RequestToDbMap();
    boolean flag;

    public ThreadServer() {
        this.flag = true;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println("Server started!");
            try (ServerSocket server = new ServerSocket(SERVER_PORT)) {
                Socket socket = server.accept();
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                String request = inputStream.readUTF();
                int sizeOfArgs = Integer.parseInt(inputStream.readUTF());
                outputStream.writeUTF(String.valueOf(REQUEST_TO_DB_MAP.start(request, sizeOfArgs)));
                if (Arrays.asList(request.split(" ")).contains("exit")) {
                    interrupt();
                    flag=false;
                }

            } catch (IOException e) {
                System.out.println("Enjoy stack trace! =)");
                e.printStackTrace();
            }
        }
    }

}
