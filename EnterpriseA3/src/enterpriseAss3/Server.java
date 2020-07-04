
package enterpriseAss3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {

	private Socket s;
	// Create Tree Set
	TreeSet<String> arr = new TreeSet<String>();

	// create new client number
	private static AtomicInteger cn = new AtomicInteger(1);

	public static void main(String[] args) throws IOException {

		// create socket and connect to same port as client
		ServerSocket server = new ServerSocket(8000);
		Server serverInstance = new Server();
		System.out.println("Server running. Waiting for a client to connect...");

		while (true) {
			serverInstance.s = server.accept();
			// increment client id
			int clientID = cn.getAndIncrement();
			ClientHandler handler = new ClientHandler(serverInstance.s, clientID);
			// starting thread
			Thread t = new Thread(handler);
			t.start();
		}
	}

}