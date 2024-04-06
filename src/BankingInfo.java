public class BankingInfo {

    private String bankName;
    private String accountHolderName;
    private String accountNumber;

    public BankingInfo(String bankName, String accountNumber) {
        this.bankName = bankName;
        this.accountHolderName = accountNumber;
        this.accountNumber = accountNumber;
    }

    //Getters
    public String getBankName() {
        return bankName;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // toString() to make it more easy to read and understand
    @Override
    public String toString() {
        return "BankingInfo{" +
                "bankName='" + bankName + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }


}
