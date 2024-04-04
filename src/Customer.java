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
    public Customer(String id, String fullName, InsuranceCard insuranceCard) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    // Method to add claims to a customer
    public void addClaim(Claim claim) {
        claims.add(claim);
    }


    // Override toString() method
    @Override
    public String toString() {
        return "Customer{" +
                "id=' " + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                '}';
    }

}
