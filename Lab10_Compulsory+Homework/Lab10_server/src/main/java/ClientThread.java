import Database.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

class ClientThread extends Thread {
    private final Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Get the request from the input stream: client → server
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = input.readLine();
            // Send the response to the output stream: server → client
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            Connection connection = Database.getConnection();
            String message = "Empty message!";

            while (request != null) {
                switch (request) {
                    case "register" -> {
                        output.println("type an username: ");
                        output.flush();
                        String name = input.readLine();
                        try (PreparedStatement preparedStatement = connection.prepareStatement("insert into users (name) values (?)")) {
                            preparedStatement.setString(1, name);
                            preparedStatement.executeUpdate();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        output.println("successfully registered!");
                        output.flush();
                    }

                    case "login" -> {
                        output.println("type an username: ");
                        output.flush();
                        String name = input.readLine();
                        // check if the name already exists
                        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery("select name from users where name='" + name + "'")) {
                            String queryResponse = rs.next() ? rs.getString(1) : null;
                            if (queryResponse == null)
                                output.println("login failed");
                            else
                                output.println("login successfully");
                            output.flush();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    case "friend" -> {
                        // TODO first check if the client is logged in
                        String name;
                        while ((name = input.readLine()) != null) {
                            // TODO add the friend to the list if the friend exists
                            System.out.println(name + " was added to the friends list!");
                        }
                        output.println("friend added successfully!");
                        output.flush();
                    }

                    case "send" -> {
                        message = input.readLine();

                        output.println("The message was sent successfully!");
                        output.flush();
                    }

                    case "read" -> {
                        if (message.equals("Empty message!"))
                            output.println(message);
                        else
                            output.println("Your message is: '" + message + "'!");
                        output.flush();
                    }

                    case "exit" -> {
                        output.println("The client stopped!");
                        output.flush();
                        System.out.println("The connections has ended!");
                    }

                    case "stop" -> {
                        output.println("Server Stopped");
                        output.close();
                        output.flush();
                        System.out.println("The connections has ended!");
                        System.exit(0);
                    }
                    default -> output.println("Error: not a valid request!");
                }

                request = input.readLine();
            }

        } catch (IOException e) {

            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println();
            }
        }
    }
}