public class BankingInfo { // Main class representing banking information

    private String bankName;             // Private fields for security
    private String accountHolderName;
    private String accountNumber;

    // Constructor to initialize the banking information object
    public BankingInfo(String bankName,String accountHolderName, String accountNumber) {
        this.bankName = bankName;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    // Getters for accessing the private data
    public String getBankName() {
        return bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // toString() for better object representation when printed
    @Override
    public String toString() {
        return "BankingInfo{" +
                "bankName='" + bankName + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
