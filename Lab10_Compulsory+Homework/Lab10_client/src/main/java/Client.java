import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
        //BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        welcomeMsg();

        do {
            System.out.println("Input: ");
            request = scanner.next();
            System.out.println("Server received the request: '" + request + "'");

            // Send request to server
            output.println(request);

            if (request.equals("register") || request.equals("login")) {
                output.flush();
                String response = input.readLine();
                System.out.println(response);
                output.println(scanner.next());
                output.flush();
                response = input.readLine();
                System.out.println(response);
                output.flush();
            }

            if (request.equals("stop") || request.equals("exit")) {
                output.flush();
                String response = input.readLine();
                System.out.println(response);
            }

            if (request.equals("read")) {
                output.flush();
                String string = input.readLine();
                System.out.println(string);
            }

            if (request.equals("send")) {
                output.flush();
                output.println(scanner.next());
                output.flush();
                String string = input.readLine();
                System.out.println(string);
            }
        } while (!request.equals("exit") && !request.equals("stop"));
    }

    private void welcomeMsg() {
        System.out.println("Welcome to the server - client application!");
    }

    private void getResponse() throws IOException {
        String response = input.readLine();
        System.out.println("Server response '" + response + "' !");
    }
}


