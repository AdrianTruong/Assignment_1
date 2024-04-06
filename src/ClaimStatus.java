public enum ClaimStatus {
    // Enum constants with associated display names
    NEW("New"),
    PROCESSING("In Progress"),
    DONE("Completed");

    // Instance variable to store the display name of each claim status
    private final String displayName;

    // Constructor to initialize display name for each claim status
    ClaimStatus(String displayName) {
        this.displayName = displayName;
    }

    // Method to retrieve the display name of a claim status
    public String getDisplayName() {
        return displayName;
    }

}
