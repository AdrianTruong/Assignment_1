import  java.util.List;
import  java.util.ArrayList;

public abstract class Customer {
    // Attributes
    protected String id;
    protected String fullName;
    protected InsuranceCard insuranceCard;
    protected List<Claim> claims = new ArrayList<>();
    private CustomerRole role; //Represent whether the customer is a policyholder or dependent

    // Default constructor
    public Customer() {
        this.fullName = "Default";
        this.id = "Default";
        this.insuranceCard = null;
    }

    //Constructor with validations
    public Customer(String id, String fullName, InsuranceCard insuranceCard, CustomerRole role) {

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
        this.role = role;
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

    public CustomerRole getRole() {
        return role;
    }

    // Method to add claims to a customer
    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    // Setters with validations
    public void setId(String id) {
        if (!id.matches("^c\\d{7}$")) {
            throw new IllegalArgumentException("Customer ID format must follow c-numbers with 7 digits pattern");
        }
        this.id = id;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty");
        }
        this.fullName = fullName;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public void setRole(CustomerRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Customer role cannot be null");
        }
        this.role = role;
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
