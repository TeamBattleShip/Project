package multiplayer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MultiplayerClient {

	
	private String coordinate; 
	private static volatile MultiplayerClient client = null;
	
	private MultiplayerClient(){		
	}

	public String getMove() {
		client.getCoordinate();
		return coordinate;
	}

	private void getCoordinate() {
		try {
			DatagramSocket datagramSocket = new DatagramSocket(1600);

			byte[] buffer = new byte[3];
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			datagramSocket.receive(packet);
			coordinate = new String(packet.getData());
			datagramSocket.close();
			
		} catch (IOException e) {
		}
	}
	
	public static MultiplayerClient getClient()
	{
		if(client == null)
		synchronized (MultiplayerClient.class){
			if(client == null)
				client = new MultiplayerClient();
		}
		
		return client;
		
	}

}