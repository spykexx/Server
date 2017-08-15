import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class WriteFile {
    DecimalFormat df = new DecimalFormat("#0.00");
    BufferedWriter bw;
    Customer c;
    Purchase p;
    WriteFile(Object o){


        try{

            if(o.getClass().equals(Customer.class)) {
                bw = new BufferedWriter(new FileWriter("Customer.txt", true));
                c = (Customer) o;
                bw.write(c.getCustNumber() + " ");
                bw.write(cap(c.getFirstName()) + " ");
                bw.write(cap(c.getLastName()) + " ");
                bw.newLine();


            }else if (o.getClass().equals(Purchase.class)){
                bw = new BufferedWriter(new FileWriter("Purchase.txt", true));
                p = (Purchase) o;
                bw.write(p.getTransactionID() + " ");
                bw.write(p.getDescription() + " ");
                bw.write(df.format(p.getPrice()));
                bw.newLine();

            }

            bw.close();
        }catch (IOException e){
            e.printStackTrace(); //print error
        }

    }
    WriteFile(){


    }



    private String cap(String line){
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }
}