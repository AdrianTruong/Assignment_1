import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class Claim { //Made the class final

    private String id; // Fields are now final
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents = new ArrayList<>(); //Defensive copy below
    private double claimAmount;
    private ClaimStatus status;
    private BankingInfo receiverBankingInfo;


    // Constructor with all validations
    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, double claimAmount, ClaimStatus status, BankingInfo receiverBankingInfo) {

        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Claim ID cannot be empty");
        }
        if (claimDate == null) {
            throw new IllegalArgumentException("Claim date is required");
        }
        if (claimDate.after(new Date())) {
            throw new IllegalArgumentException("Claim date cannot be in the future");
        }
        if (insuredPerson == null || insuredPerson.isEmpty()) {
            throw new IllegalArgumentException("Insured person name is required");
        }
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number is required");
        }
        if (claimAmount <= 0) {
            throw new IllegalArgumentException("Claim amount must be positive");
        }
        if (status == null) {
            throw new IllegalArgumentException("Claim status is required");
        }

        if (!id.matches("^f\\d{10}$")) {
            throw new IllegalArgumentException("Claim ID format must follow f-numbers with 10 digits pattern");
        }


        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;

        //Defensive copy for document list
        this.documents = documents != null ? new ArrayList<>(documents) : new ArrayList<>();
    }



}
