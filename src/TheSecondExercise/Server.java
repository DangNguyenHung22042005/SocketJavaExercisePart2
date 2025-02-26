package TheSecondExercise;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	private ArrayList<Handle> clients = new ArrayList<>();
    public Server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("Server started");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                Handle clientHandler = new Handle(in, out, clients);
            }
            catch (Exception e) {
                socket.close();
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception {
        new Server();
    }
}
