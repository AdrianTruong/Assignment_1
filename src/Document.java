/**
 * @author <Truong Bien Hai Trong - S3872952>
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Document extends Claim {

    private String documentName;

    // Constructor with validations
    public Document(String id, String cardNumber, String documentName, List<String> additionalDocuments,
                    double claimAmount, String status, String receiverBankingInfo) {
        super(id, new Date(), "John Doe", cardNumber, new Date(), additionalDocuments, claimAmount,
                status, receiverBankingInfo);
        this.documentName = documentName;
    }

    // Getter for the full document name
    public String getDocumentName() {
        return documentName;
    }

}
