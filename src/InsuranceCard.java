import java.text.SimpleDateFormat;
import java.util.Date;

public class InsuranceCard {
    // Attributes
    private String cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    // Default constructor
    public InsuranceCard() {
        // Set default values for card attributes
        this.cardNumber = "Default";
        this.cardHolder = "Default";
        this.policyOwner = "Default";
        this.expirationDate = null;
    }

    // Parameterized Constrictor
    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
        // Initialize card attributes with provided values
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    // Getter
    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    // toString() method
    public String toString() {
        // Return a string representation of the InsuranceCard object
        return "InsuranceCard{" +
                "cardHolder='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", policyOwner='" + policyOwner + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }


}
