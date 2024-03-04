package Clients;

import java.net.DatagramSocket;
import java.net.SocketException;

public class P1 {

    public static void main(String[] args) {
        int id = 0;
        String name = "P1";
        int configPort = 5000;
        int connectionPort = 5001; //P2
        DatagramSocket server;

        try {
            server = new DatagramSocket(configPort);

            Sender sender = new Sender(name, server, connectionPort);
            Thread s = new Thread(sender);
            s.start();

            Receiver receiver = new Receiver(name, server, connectionPort);
            Thread r = new Thread(receiver);
            r.start();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}