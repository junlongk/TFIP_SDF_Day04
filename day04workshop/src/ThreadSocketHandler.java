package src;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSocketHandler extends Thread{
    private Socket s;
    private DataInputStream dis;
    private DataOutputStream dos;

    public ThreadSocketHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        // Handle the socket communication here.

        while (true) {
            try {
                String fromClient = dis.readUTF();

                if (fromClient.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("LOG: msg from client: " + fromClient);
                if (fromClient.equalsIgnoreCase("get-cookie")) {
                    // Send a random cookie from the file
                    dos.writeUTF("Dummy cookie.. from => " + Thread.currentThread().getName());
                    dos.flush();
                } else {
                    // Send a msg, "Invalid command from server"
                    dos.writeUTF("From server: Invalid command");
                    dos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
