package game;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) {

		ServerSocket s = null;

		// Register your service on port 5432
		try {
			s = new ServerSocket(5432);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Run the listen/accept loop forever
		while (true) {
			try {
				// Wait here and listen for a connection
				Socket s1 = s.accept();
				
				InputStreamReader ir = new InputStreamReader(s1.getInputStream());
				BufferedReader br = new BufferedReader(ir);
				
				String msg = br.readLine();
				System.out.println(msg);
				
				if(msg!=null){
					// Get output stream associated with the key
					OutputStream s1out = s1.getOutputStream();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s1out));

					// Send your string!
					bw.write("Message received!\n");
					
					 // Close the connection, but not the server socket
					bw.close();
					s1.close();
				}				

			} catch (IOException e) {
			 e.printStackTrace();
			} // END of try-catch
		 } // END of while(true)
	}

}
