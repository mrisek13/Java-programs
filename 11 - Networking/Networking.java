package networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;


public class Networking {

    // 1. TCP/IP Server
    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Received: " + message);
                output.println("Echo: " + message);
            }

            socket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // 2. TCP/IP Client
    public static void startClient() {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Hello, Server!");
            System.out.println("Server says: " + input.readLine());
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

    // 3. Demonstrate InetAddress usage
    public static void showInetAddressInfo() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local Host Address: " + localHost.getHostAddress());

            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("Google Host Name: " + google.getHostName());
            System.out.println("Google Host Address: " + google.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("InetAddress error: " + e.getMessage());
        }
    }

    // 4. Using URL to fetch content
    public static void fetchUrlContent() {
        try {
            URL url = new URL("http://facebook.com");
            BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            input.close();
            
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Port: " + url.getPort());
            System.out.println("Host: " + url.getHost());
            System.out.println("File: " + url.getFile());
            System.out.println("External form: " + url.toExternalForm());
        } catch (IOException e) {
            System.out.println("URL error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Choose an option:");
        System.out.println("1. Start TCP Server");
        System.out.println("2. Start TCP Client");
        System.out.println("3. Show InetAddress Info");
        System.out.println("4. Fetch URL Content");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1:
                    startServer();
                    break;
                case 2:
                    startClient();
                    break;
                case 3:
                    showInetAddressInfo();
                    break;
                case 4:
                    fetchUrlContent();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Input error: " + e.getMessage());
        }
    }    
}
