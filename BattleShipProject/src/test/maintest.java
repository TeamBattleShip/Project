package test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class maintest {
	public static void main(String args[]) {
	

		// Split command line paramater at the @ character
		String username = "Kalle-Dator";
		String hostname = "Kalle-Dator";

		try {
			System.out.println("Connecting to " + hostname);

			// Create a connection to server
			Socket s = new Socket(hostname, 79);

			// Create input and output streams to socket
			PrintStream out = new PrintStream(s.getOutputStream());
			DataInputStream in = new DataInputStream(s.getInputStream());

			// Write username to socket output
			out.println(username);

			// Read response from socket
			String line = in.readLine();

			while (line != null) {
				System.out.println(line);

				// Read next line
				line = in.readLine();
			}

			// Terminate connection
			s.close();

		} catch (SocketException e) {
			System.err.println("Socket error : " + e);
		} catch (UnknownHostException e) {
			System.err.println("Invalid host!");
		} catch (IOException e) {
			System.err.println("I/O error : " + e);
		}
	}

}
