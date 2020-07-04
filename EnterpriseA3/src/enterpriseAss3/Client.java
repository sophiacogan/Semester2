package enterpriseAss3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Client implements Runnable {

	public static void main(String[] args) throws IOException {

		// connect to localhost port num 8000
		Socket s = new Socket("localhost", 8000);
		// creating input and output streams
		InputStream instream = s.getInputStream();
		OutputStream outstream = s.getOutputStream();
		// creating buffer readers
		BufferedReader in = new BufferedReader(new InputStreamReader(instream));
		PrintWriter out = new PrintWriter(outstream);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Client Connected to Server");
		String token = input.readLine();
		String response = " ";
		// while loop that continues to iterate until client enters 'QUIT'
		while (token != "QUIT") {

			out.println(token);
			out.flush();

			response = in.readLine();
			// printing out tokens and responses
			System.out.println("Client sent '" + token + "' to server ");
			System.out.println("Client Recieved message from Server: '" + response + "'");
			token = input.readLine();

		}

	}

	@Override
	public void run() {

	}
}
