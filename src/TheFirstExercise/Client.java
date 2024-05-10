package TheFirstExercise;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		final String SERVER_ADDRESS = "localhost";
		final int Port = 11111;

		try {
			Socket socket = new Socket(SERVER_ADDRESS, Port);
			System.out.println("Connected to server");
			DataInputStream in = new DataInputStream(socket.getInputStream());
			Handle clientHandler = new Handle(socket);
			clientHandler.start();
			int number;
			while ((number = in.readInt()) != -1) {
				System.out.println("Received from server: " + number);
			}
			in.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
