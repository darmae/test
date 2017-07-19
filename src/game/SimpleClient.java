package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {

	public static void main(String args[]) {
		
		Boolean gameOver = false;

		try {
			// Open your connection to a server, at port 5432
			// localhost used here
			Socket s1 = new Socket("127.0.0.1", 5432);	
			BufferedReader br = null;
			
//			Scanner input = new Scanner(System.in);

			while(!gameOver){
				PrintStream PS = new PrintStream(s1.getOutputStream());
				PS.println("Hello to Server from Client");

				// Get an input stream from the socket
				InputStream is = s1.getInputStream();
				// Decorate it with a "data" input stream
				
				// Read the input and print it to the screen
				InputStreamReader ir =new InputStreamReader(is);
				br = new BufferedReader(ir);
				System.out.println(br.readLine());
			}
			// When done, just close the steam and connection
			br.close();
			s1.close();

		} catch (ConnectException connExc) {
			System.err.println("Could not connect. "+connExc.getMessage());
		} catch (IOException e) {
			// ignore
		} // END of try-catch

	} // END of main method
}
