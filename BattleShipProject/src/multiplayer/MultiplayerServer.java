package multiplayer;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MultiplayerServer extends Thread {

	private static String coordinate;
	
	public MultiplayerServer(String coordinate){
		MultiplayerServer.coordinate = coordinate;
		new MultiplayerServer().start();
	}
	
	private MultiplayerServer(){
		
	}

	public void run() {

			try {				
				DatagramSocket datagramSocket = new DatagramSocket();

				byte[] buffer = coordinate.getBytes();
				InetAddress receiverAddress = InetAddress.getByName("255.255.255.255");
				
				DatagramPacket packet = new DatagramPacket(buffer,
						buffer.length, receiverAddress, 1600);

				datagramSocket.send(packet);
				datagramSocket.close();

			} catch (Exception e) {
		}
	}
}
