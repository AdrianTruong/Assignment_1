import  java.util.List;
import  java.util.ArrayList;

public abstract class Customer {
    protected String id;
    protected String fullName;
    protected InsuranceCard insuranceCard;
    protected List<Claim> claims = new ArrayList<>();

    public Customer() {
        fullName = "Default";
        id = "Default";
        insuranceCard = "Default";
    }

}
