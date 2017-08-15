
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class ReadFile {
        List<Customer> customerL = new ArrayList<>(); //list to hold all objects created.
        List<Purchase> purchaseL = new ArrayList<>();
        Scanner readerC;
        Scanner readerP;
        boolean created = false;

        ReadFile(){
            customerL.clear();
            purchaseL.clear();
            try {
                readerC = new Scanner(new File("Customer.txt")); //open file
                readerP = new Scanner(new File("Purchase.txt"));
                String[] transInfo = new String[6]; //Array to hold string information

                while (readerC.hasNextLine() && readerP.hasNextLine()) { //While there is more to read
                    transInfo[0] = readerC.next();//salesID
                    transInfo[1] = readerC.next();//Fname
                    transInfo[2] = readerC.nextLine();//LName
                    transInfo[3] = readerP.next(); //trans ID
                    transInfo[4] = readerP.next();//Description
                    transInfo[5] = readerP.nextLine();

                    customerL.add(new Customer(Integer.parseInt(transInfo[0]), transInfo[1], transInfo[2]));
                    purchaseL.add(new Purchase(Integer.parseInt(transInfo[3]), transInfo[4], Double.parseDouble(transInfo[5])));

                }

                readerC.close();
            }catch(FileNotFoundException F){
                JOptionPane.showMessageDialog(null, "Please create files first utilzing the form.");
            }
        }
        public List<Customer> returnCust(){
            return customerL;
        }
        public List<Purchase> returnPur(){
            return purchaseL;
        }
    }



