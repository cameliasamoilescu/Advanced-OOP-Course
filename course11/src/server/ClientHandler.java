package server;

import model.User;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

/**
 * [command] [user] <message>
 *     login jim password
 *     msg joe how are you
 *     logout
 */

public class ClientHandler implements Runnable {

    private final Socket client;
    private final ChatServer chatServer;
    private BufferedReader br;
    private PrintWriter pw;
    private User user;


    public ClientHandler(Socket client, ChatServer chatServer)  {
        this.client = client;
        this.chatServer = chatServer;
        try {
            InputStream is = client.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = client.getOutputStream();
            pw = new PrintWriter(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void run() {

        try {
            handleClient();
        } catch (IOException e) {
            System.out.println("Error in client handler: " + e.getMessage());
        }

    }

    private void handleClient() throws IOException {
        String line;
        while((line = br.readLine()) != null){
            String[] tokens = line.split(" ");
            if(tokens.length > 0){
                String command = tokens[0];
                if("logout".equalsIgnoreCase(command)){
                    handleLogout();
                }else if("login".equalsIgnoreCase(command)){
                    handleLogin(tokens);
                }else if("msg".equalsIgnoreCase(command)){
                    handleMessage(tokens);
                }else
                {
                    String message = "unknown command " + command + "\n";
                    System.err.println(message);
                    sendMessageToClient(message, this);
                }
            }

        }
    }

    private void handleMessage(String[] tokens) {
        if(user != null){
            String targetUsername = tokens[1];
            Optional<ClientHandler> targetHandler = chatServer.getClients().stream()
                                                                                .filter(clientHandler -> clientHandler.getUser().getUsername().equalsIgnoreCase(targetUsername))
                                                                                .findFirst();

            // check client is connected to chat
            if(targetHandler.isPresent()){
                // check client is logged in
                if(targetHandler.get().getUser() != null){
                    String message = this.getUser().getUsername() + " says: " +
                                Arrays.stream(tokens)
                                        .skip(2)
                                        .collect(Collectors.joining(" "));

                    sendMessageToClient(message, targetHandler.get());
                }else {
                    String message = "Target user " + targetUsername + " is not logged in";
                    System.err.println(message);
                    sendMessageToClient(message, this);
                }

            }else {
                String message  = "Target user " + targetUsername + " is not connected to server";
                System.err.println(message);
                sendMessageToClient(message, this);
            }


        }else{
            String message = "login before trying to send messages";
            System.err.println(message);
            sendMessageToClient(message, this);
        }
    }

    private void handleLogin(String[] tokens) {
        if(tokens.length == 3){
            String username = tokens[1];
            String password = tokens[2];
            if(user != null){
                String message = user.getUsername() + " already logged in";
                System.err.println(message);
                sendMessageToClient(message, this);
            }
            else{
                User user = new User(username, password);
                this.user = user;
                String message = username + " logged in";
                broadcast(message, Collections.singletonList(this));
                sendMessageToClient("You are now logged in ", this);
            }


        }else{
            String errorMessage = "incorrect command format";
            System.err.println(errorMessage);
            sendMessageToClient(errorMessage, this);
        }
    }

    private void handleLogout() {
        if(user != null){
            String message = user.getUsername() + " logged out";
            System.out.println(message);
            broadcast(message, new ArrayList<>());

            this.user = null;
            chatServer.getClients().remove(this);
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            String message = "login first before logging out";
            System.err.println(message);
            sendMessageToClient(message, this);
        }

    }

    private void sendMessageToClient(String message, ClientHandler clientHandler) {
        clientHandler.pw.println(message);
    }

    private void broadcast(String message, List<ClientHandler> excludedClients) {
        Set<ClientHandler> audience = chatServer.getClients()
                .stream()
                .filter(client -> client.getUser() != null)
                .collect(Collectors.toSet());

        audience.removeAll(excludedClients);
        audience.forEach(client -> client.sendMessageToClient(message, this));
    }

    public User getUser() {
        return user;
    }
}
