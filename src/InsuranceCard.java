import java.util.Date;

public class InsuranceCard {
    // Attributes
    private String cardNumber;
    private String cardHolder;
    private String policyOwner;
    private Date expirationDate;

    // Default constructor
    public InsuranceCard() {
        this.cardNumber = "Default";
        this.cardHolder = "Default";
        this.policyOwner = "Default";
        this.expirationDate = null;
    }

    // Parameterized Constrictor
    public InsuranceCard(String cardNumber, String cardHolder, String policyOwner, Date expirationDate) {
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
        return "InsuranceCard{" +
                "cardHolder='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", policyOwner='" + policyOwner + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }


}
