import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) {
        List<InetAddress> IP = new ArrayList<>();

        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("Waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                    System.out.println("Client connected");

                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                    String echoString = input.readLine();

                /*try {
                    Thread.sleep(15000);
                } catch(InterruptedException e) {
                    System.out.println("Thread interrupted");
                }*/
                    if (echoString.equals("exit")) {
                        System.out.println("Closing Server");
                        break;
                    }
                    output.println("Echo from server: " + echoString);
                }

        } catch (IOException e){
                System.out.println("Server exception " + e.getMessage());
            }
        }
    }
