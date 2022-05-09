import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private final String serverAddress;
    private final int PORT;

    BufferedReader input; // for the responses coming from the server

    public Client(String serverAddress, int PORT) {
        this.serverAddress = serverAddress;
        this.PORT = PORT;
    }

    public void connect() throws IOException {

        Socket socket = new Socket(serverAddress, PORT);

        PrintWriter output = new PrintWriter(socket.getOutputStream());
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request;
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

        welcomeMsg();

        do {
            System.out.println("Input: ");
            request = consoleInput.readLine();
             System.out.println("Read the request: '" + request + "'");

            // Send request to server
            output.println(request);
            output.flush();

            // Wait for response
            getResponse();
        } while ( !request.equals("stop"));
    }

    private void welcomeMsg() {
        System.out.println("Welcome to the server-client application!");
    }

    private void getResponse() throws IOException {
        String response = input.readLine();
        System.out.println("Server response '" + response + "' !");
    }
}


