import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private final Socket socket;
    private BufferedReader input;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run () {
        try {
            // Read the information coming into the socket from the client
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream());

            // Read the request and send the response until the client stops the connection
            do {
                String request = input.readLine();
                String response = request + " Hello world!";
                output.println(response);
                output.flush();
            } while ( !socket.isClosed() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendResponse() throws IOException {
        String request = input.readLine();
        System.out.println("Read request '" + request + "'");

        if (request == null) {
            return;
        }

        // Create a PrintWriter to write the information from the server to the client
        PrintWriter output = new PrintWriter(socket.getOutputStream());

        switch (request) {
            case "register" -> {
                String name = input.readLine();
                // TODO register
                output.println("successfully registered!");
            }

            case "login" -> {
                String name = input.readLine();
                // TODO check if the name already exists
                output.println("successfully logged in!");
            }

            case "friend" -> {
                // TODO first check if the client is logged in
                String name = null;
                while ( (name = input.readLine()) != null) {
                    // TODO add the friend to the list if the friend exists
                    System.out.println( name + " was added to the friends list!");
                }
                output.println("friend added successfully!");
            }

            case "send" -> {
                String name = null;
                while ( (name = input.readLine()) != null) {
                    // TODO check if the name represents a friend
                    System.out.println("Send a message to " + name);
                }
                output.println("message sent successfully!");
            }

            case "read" -> {
                String text = null;
                // TODO
                output.println("message read successfully!");
            }

            case "stop" -> {
                output.println("The server stopped!");
                output.close();
                output.flush();
                System.out.println("The connections has ended!");
                System.exit(0);
            }

            default -> {
                output.println("Error: bad request!");
            }
        }
        output.flush();
    }
}