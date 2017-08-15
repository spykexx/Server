import java.io.Serializable;

/**
 * Created by Spykexx on 8/12/2017.
 */
public class Customer implements Serializable{
    private String firstName;
    private String lastName;
    private int custNumber;
    static final long serialVersionUID = 133L;
    Customer(){

    }



    Customer(int ID, String fName, String lName){
        setCustNumber(ID);
        setFirstName(fName);
        setLastName(lName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        //lastName = lastName.replaceAll("\\s", "");
        this.lastName = lastName;
    }

    public int getCustNumber() {
        return custNumber;
    }

    public void setCustNumber(int empNumber) {
        this.custNumber = empNumber;
    }
    @Override
    public String toString() {
        return "Customer: " + getCustNumber() + " " + getFirstName() + " " + getLastName() + " ";
    }

}
