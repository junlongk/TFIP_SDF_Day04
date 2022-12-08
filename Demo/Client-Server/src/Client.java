package src;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    
    public static void main(String[] args) {
        int PORT = 12345;
        try {
            Socket cs = new Socket("localhost", PORT);

            // Get the I/O stream
            OutputStream os = cs.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);

            // dos.writeUTF("Hello world from Client");
            // dos.flush();
            // System.out.println("Message sent to Server!");
            // cs.close();

            Scanner inputSc = new Scanner(System.in);
            String line;
            while ((line  = inputSc.nextLine()) != null) {
                if (line.equalsIgnoreCase("close")) {
                    System.out.println("Exit from shell");
                    dos.writeUTF("close");
                    dos.flush();
                    break;
                }

                dos.writeUTF(line);
                dos.flush();
                System.out.println("Message sent to Server: " + line);
            }
            cs.close(); // closing the socket from client.
            inputSc.close();

        } catch (UnknownHostException e) {
            System.out.println("Unable to reach the HOST");
        } catch (IOException e) {
            System.out.println("IO Error");
        }
    }

}
