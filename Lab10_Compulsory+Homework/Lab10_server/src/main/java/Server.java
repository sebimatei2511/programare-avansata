import Database.Database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // Define the port on which the server is listening
    public static final int PORT = 8100;

    public Server() throws IOException {
        Database.createConnection();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);

            // TODO timeout
            // TODO serverSocket.setSoTimeout(30*1000);

            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Oops... " + e);
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }
}
