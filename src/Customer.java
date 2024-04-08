/**
 * @author <Truong Bien Hai Trong - S3872952>
 */
import  java.util.List;
import  java.util.ArrayList;

public class Customer {
    // Attributes
    protected String id;
    protected String fullName;
    protected String insuranceCard;
    protected List<Claim> claims = new ArrayList<>();
    private String role; //Represent whether the customer is a policyholder or dependent

    // Default constructor
    public Customer(List<Claim> customers) {
        this.fullName = "Default";
        this.id = "Default";
        this.insuranceCard = null;
    }

    //Constructor with validations
    public Customer(String id, String fullName, String insuranceCard, String role) {

        // Validations
        if (!id.matches("^c\\d{7}$")) {
            throw new IllegalArgumentException("Customer ID format must follow c-numbers with 7 digits pattern");
        }

        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }

        if (role == null) {
            throw new IllegalArgumentException("Customer role cannot be empty");
        }

        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = new ArrayList<>();
        this.role = role;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInsuranceCard() {
        return insuranceCard;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public String getRole() {
        return role;
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
                ", role='" + role + '\'' +
                ", insuranceCard=" + insuranceCard +
                '}';
    }

}
