import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int SERVER_PORT = 12345;
    public static final String SERVER_HOST = "netology.homework";

    public static void main(String[] args) {
        try (
                ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            System.out.println("New connection accepted");
            out.println("Write your name");
            String name = in.readLine();
            System.out.println(name);
            out.println("Are you child? (yes/no)");
            String childAnswer = in.readLine();
            System.out.println(childAnswer);
            if (childAnswer.equalsIgnoreCase("yes")) {
                out.println("Welcome to the kids area, " + name + "! Let's play!");
            } else {
                out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
