package test;

import multiplayer.MultiplayerClient;
import multiplayer.MultiplayerServer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Testing {
	MultiplayerClient mc;
	MultiplayerServer ms;

	@Before
	public void setUp() throws Exception {
		new MultiplayerServer("A10").start();
		mc = MultiplayerClient.getClient();
	
	}

	@Test
	public void test() {		
	assertEquals("A10", mc.getMove());
	}
}
