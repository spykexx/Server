import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Spykexx on 8/12/2017.
 */
public class Connection {
        ServerSocket connection = null;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
    public Connection() throws Exception {
        connection = new ServerSocket(919);
        while(true) {
            socket = connection.accept();
            if (socket.isConnected()) {
                System.out.print("Connected\r\n");
            }
            receive();

            receive();
            send("hello");

        }
        //socket.close();
    }
    public void receive() throws Exception{
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = in.readLine();
        System.out.println(line);

    }
    public void send(String s) throws Exception{
        out=new PrintWriter(socket.getOutputStream());
        out.println(s);
        out.flush();
    }
}

