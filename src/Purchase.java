import java.io.Serializable;

/**
 * Created by Spykexx on 8/13/2017.
 */
public class Purchase implements Serializable {
    private int transactionID;
    private String description;
    private double price;
    static final long serialVersionUID = 134L;
    Purchase(){

    }
    Purchase(int ID, String desc, double price){
        setTransactionID(ID);
        setDescription(desc);
        setPrice(price);
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getDescription() + " " + getPrice() ;
    }
}
