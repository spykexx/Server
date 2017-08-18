import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spykexx on 8/12/2017.
 */
public class Connection extends Thread {
        ServerSocket connection = null;
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

        List<Customer> customerL = new ArrayList<>();
        List<Purchase> purchaseL = new ArrayList<>();
        ReadFile rf = new ReadFile();
        WriteFile wf;
        private enum reqTypes {initial, customer, purchase, complete}


    public Connection() throws Exception {
        connection = new ServerSocket(919);
        customerL = rf.returnCust();
        purchaseL = rf.returnPur();
        reqTypes req;

        while(true) {
            socket = connection.accept();
            if (socket.isConnected()) {
                System.out.print("Connected\r\n");
            }
            receive();
            receive();
            for(int i = 0; i < customerL.size(); i++) {
                System.out.print(customerL.get(i).toString());
                System.out.println(purchaseL.get(i).toString());
            }
        }
    }
    public void receive() throws Exception{
        reqTypes req;
        in = new ObjectInputStream(socket.getInputStream());
        Object obj[] = new Object[3];
        req = (reqTypes) in.readObject();
        switch (req){
            case initial:
                send(customerL, purchaseL);
                break;
            case customer:
                obj[1] = (Customer) in.readObject();
                customerL.add((Customer) obj[1]);
                break;
            case purchase:
                obj[2] = (Purchase) in.readObject();
                purchaseL.add((Purchase) obj[2]);
                break;
            case complete:
                obj[1] = (Customer) in.readObject();
                customerL.add((Customer) obj[1]);
                obj[2] = (Purchase) in.readObject();
                purchaseL.add((Purchase) obj[2]);
                wf = new WriteFile(obj[1]);
                wf = new WriteFile(obj[2]);
                send(customerL, purchaseL);
                break;

        }
    }
    public void send(List<Customer> c, List<Purchase> p) throws Exception{
        out=new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(c);
        out.writeObject(p);
        out.flush();
    }
}

