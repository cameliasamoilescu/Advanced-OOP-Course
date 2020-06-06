package client;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatClient {
    private final String serverAddress ;
    private final int serverPort;

    private Socket socket;


    public ChatClient(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }
    public ChatClient(){
        this.serverAddress = "localhost";
        this.serverPort = 8088;
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient("localhost", 8088);

        if(client.connect()){
            System.out.println("connected to chat server ");

        }
    }

    private boolean connect(){
        try {
            socket = new Socket(serverAddress, serverPort);
            return true;
        } catch (IOException e) {
            System.err.println("Connection failed");
            return false;
        }
    }
}
