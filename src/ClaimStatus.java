public enum ClaimStatus {
    NEW("New"),
    PROCESSING("In Progress"),
    DONE("Completed");

    private final String displayName;
    ClaimStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
