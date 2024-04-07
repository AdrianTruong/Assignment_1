public final class  Document {
    private String claimID;
    private String cardNumber;
    private String documentName;

    //Constructor with validations
    public Document(String claimId, String cardNumber, String documentName) {

        // Validations
        if (claimId == null || claimId.isEmpty()) {
            throw new IllegalArgumentException("Claim ID cannot be empty");
        }
        if (cardNumber == null || cardNumber.isEmpty()) {
            throw new IllegalArgumentException("Card number cannot be empty");
        }
        if (documentName == null || documentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Document name cannot be empty");
        }
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
