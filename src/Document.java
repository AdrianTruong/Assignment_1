public class Document {
    private String claimID;
    private String cardNumber;
    private String documentName;

    //Constructor to enforce the naming convention
    public Document(String claimId, String cardNumber, String documentName) {
        // Check if the document name ends with ".pdf"
        if (!documentName.endsWith(".pdf")) {
            throw new IllegalArgumentException("Document name must be a pdf file");
        }

        this.claimID = claimId;
        this.cardNumber = cardNumber;
        this.documentName = documentName;
    }


    //Getter for the full document name
    public String getDocumentName() {
        // Concatenate claim ID, card number, and document name to form the full document name
        return claimID + "_" + cardNumber + "_" + documentName;
    }
}
