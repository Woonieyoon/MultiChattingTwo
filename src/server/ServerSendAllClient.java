package server;

import java.net.Socket;

public class ServerSendAllClient implements SplitedTokenProcessor {

	private ServerClient serverClient;

	public ServerSendAllClient(ServerClient serverClient) {
		this.serverClient = serverClient;
	}

	@Override
	public void Process(Socket socket, String data) {
		for (ServerClient client : serverClient.getConnections()) {
			if (client.getSocket() != socket)
				client.send(serverClient.getUserName() + ">>" + data);
		}
	}

}