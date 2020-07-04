package enterpriseAss3;
//imports

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.TreeSet;

public class ClientHandler implements Runnable {

	private BufferedReader in;
	private PrintWriter out;
	// define tree set
	public static TreeSet<String> arr = new TreeSet<String>();
	Socket s;
	int id;

	public ClientHandler(Socket s, int id) {
		// setting client id to id
		this.id = id;
		this.s = s;

	}

	@Override
	// run method
	public void run() {
		System.out.println("Client " + id + " connected");
		while (true) {

			String request = " ";
			try {
				// accept requests from client
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));
				out = new PrintWriter(s.getOutputStream());
				request = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Recieved message from client " + id + ": " + request);

			String token = request;

			// Submit request
			if (request.contains("SUBMIT")) {
				// checking the list to see if it already contains token
				if (arr.contains(token)) {
					System.out.println("Server sent response 'OK' to client");
					out.println("Server sent response 'OK' to client");
					out.flush();
					// if the array is full
				} else if (arr.size() == 10) {
					System.out.println("Error Maximum number of tokens recieved");
					out.println("Error");
					out.flush();
				} else {
					// ADDING THE TOKEN ONLY TO LIST
					String tokens = token.split(" ", 2)[1];
					arr.add(tokens);
					// server response
					out.println("OK");
					out.flush();

					System.out.println("Server sent response 'OK' to client");

				}
			}
			// retrieve request
			else if (request.equals("RETRIEVE")) {
				// if the array is empty print error
				if (arr.isEmpty()) {
					System.out.println("ERROR");
					out.println("ERROR: list is empty");
				} else {
					// printing out the contents of the list without [,] symbols
					// ensuring tokens are separated by whitespace
					out.println(arr.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", " ")); // server
																													// response
					System.out.println("Server sent response '"
							+ arr.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\,", " ")
							+ "' to client" + id);

				}
			} else if (request.equals("QUIT")) {
				// no server response to client

				System.out.println("Client " + id + " disconnected.");
				// if the request isn't recognised
			} else {
				System.err.println("Unknown request!");

			}

			out.flush();
		}

	}

}
