package letsCHAT.letsCHAT;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientService implements Runnable {
	public void run() {

		// get the localhost IP address, if server is running on some other IP,
		// you need to use that
		InetAddress host;
		try {
			host = InetAddress.getLocalHost();

			Socket socket = null;
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			for (int i = 0; i < 5; i++) {
				// establish socket connection to server
				socket = new Socket(host.getHostName(), 9875);
				// write to socket using ObjectOutputStream
				oos = new ObjectOutputStream(socket.getOutputStream());
				System.out.println("Sending request to Socket Server");
				if (i == 4)
					oos.writeObject("exit");
				else
					oos.writeObject(" " + i);
				// read the server response message
				ois = new ObjectInputStream(socket.getInputStream());
				String message = (String) ois.readObject();
				System.out.println("Message: " + message);
				// close resources
				ois.close();
				oos.close();
				Thread.sleep(100);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
