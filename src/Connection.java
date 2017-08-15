import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spykexx on 8/12/2017.
 */
public class Connection {
        ServerSocket connection = null;
        Socket socket = null;
        ObjectInputStream in = null;
        ObjectOutputStream out = null;

    List<Customer> customerL = new ArrayList<>();
    List<Purchase> purchaseL = new ArrayList<>();
    ReadFile rf = new ReadFile();


    public Connection() throws Exception {
        connection = new ServerSocket(919);
        customerL = rf.returnCust();
        purchaseL = rf.returnPur();

        while(true) {
            socket = connection.accept();
            if (socket.isConnected()) {
                System.out.print("Connected\r\n");
            }
            send(customerL, purchaseL);
            receive();
            receive();
            send(customerL, purchaseL);
            for(int i = 0; i < customerL.size(); i++) {
                System.out.print(customerL.get(i).toString());
                System.out.println(purchaseL.get(i).toString());
            }

        }
        //socket.close();
    }
    public void receive() throws Exception{
        in = new ObjectInputStream(socket.getInputStream());
        //System.out.println(in.readObject().getClass());
        Object obj;
        obj = in.readObject();
        WriteFile wf = new WriteFile(obj);
        if(obj.getClass().equals(Customer.class)) {
            customerL.add((Customer) obj);
            //System.out.print("Hello");
        }else if (obj.getClass().equals(Purchase.class)){
            purchaseL.add((Purchase) obj);
        }
    }
    public void send(List<Customer> c, List<Purchase> p) throws Exception{
        out=new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(c);
        out.writeObject(p);
        out.flush();
    }
}

