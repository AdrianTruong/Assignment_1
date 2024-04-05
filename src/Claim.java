import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Claim {

    private String id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents = new ArrayList<>();
    private double claimAmount;
    private ClaimStatus status;
    private String receiverBankingInfo;

    // Constructor
    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, double claimAmount, ClaimStatus status, String receiverBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverBankingInfo = receiverBankingInfo;
    }


}
