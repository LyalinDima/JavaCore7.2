import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(Server.SERVER_HOST, Server.SERVER_PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            while (true) {
                String resp = in.readLine();
                System.out.println(resp);
                if (resp.equalsIgnoreCase("Write your name")) {
                    out.println("Dmitriy");
                } else if (resp.equalsIgnoreCase("Are you child? (yes/no)")) {
                    out.println("No");
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
