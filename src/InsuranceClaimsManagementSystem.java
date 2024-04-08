/**
 * @author <Truong Bien Hai Trong - S3872952>
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InsuranceClaimsManagementSystem {

    // Simulate storage for claims, policyholders, dependents
    private static List<Claim> claims = new ArrayList<>();

    // Instance of ClaimStatus to manage claim statuses
    private static ClaimStatus claimStatusManager = new ClaimStatus(claims);

    // List to store customers
    private static List<Claim> customers = new ArrayList<>();

    // Instance of CustomerMangerImp to manage customers
    private static CustomerMangerImp customerMangerImp = new CustomerMangerImp(customers);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    manageCustomersMenu(scanner);
                    break;
                case 2:
                    manageClaimsMenu(scanner);
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to display the main menu
    private static void displayMainMenu() {
        System.out.println("\nInsurance Claims Management System");
        System.out.println("----------------------------------");
        System.out.println("1. Manage Customers");
        System.out.println("2. Manage Claims");
        System.out.println("3. Exit System");
        System.out.print("Enter your choice: ");
    }

    // Method to manage customers
    private static void manageCustomersMenu(Scanner scanner) {
        boolean manageCustomers = true;
        while (manageCustomers) {
            System.out.println("\nManage Customers");
            System.out.println("-----------------");
            System.out.println("1. Add a New Customer");
            System.out.println("2. Back to Main Screen ");
            System.out.print("Enter your choice: ");

            int choice1 = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice1) {
                case 1:
                    // Implement add customer functionality
                    System.out.println("Adding a new customer:");

                    // Customer ID input and validation
                    boolean validCustomerId = false;
                    String customerId = null;
                    while (!validCustomerId) {
                        System.out.print("Enter customer ID (c- followed by 7 digits): ");
                        customerId = scanner.nextLine();

                        // Regular expression for the customer ID format
                        Pattern pattern = Pattern.compile("^c-\\d{7}$");
                        if (pattern.matcher(customerId).matches()) {
                            validCustomerId = true;
                        } else {
                            System.out.println("Customer ID format must follow c-numbers with 7 digits pattern");
                        }
                    }

                    // Input customer details
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Is this a Policy Holder (P) or Dependent (D)? ");
                    String input = scanner.nextLine().toUpperCase();

                    CustomerRole role = null;
                    while (role == null) {
                        try {
                            role = CustomerRole.valueOf(input);
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Invalid input. Please enter either 'POLICYHOLDER' or 'DEPENDENT'.");
                            input = scanner.nextLine().toUpperCase().trim().replace("'", "");
                        }
                    }

                    System.out.print("Enter insurance card number: ");
                    String cardNumber = scanner.nextLine();

                    System.out.print("Enter card holder name: ");
                    String cardHolder = scanner.nextLine();

                    System.out.print("Enter policy owner name: ");
                    String policyOwner = scanner.nextLine();

                    System.out.print("Enter expiration date (format MM/dd/yyyy): ");
                    String expirationDateStr = scanner.nextLine();
                    Date expirationDate = null;
                    try {
                        expirationDate = InsuranceCard.dateFormat.parse(expirationDateStr);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please use MM/dd/yyyy");
                    }

                    // Input banking information
                    System.out.print("Bank: ");
                    String bankName = scanner.nextLine();

                    System.out.print("Account's holder name: ");
                    String accountHolderName = scanner.nextLine();

                    System.out.print("Account Number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.println("Receiver Insurance Info " + cardNumber + "-" + cardHolder + "-" + policyOwner + "-" + expirationDate);
                    String receiverInsuranceInfo = scanner.nextLine();

                    // Create the new customer object
                    Customer newCustomer = new Customer(customerId, fullName, input, receiverInsuranceInfo);

                    // Add the customer to the customer manager
                    customerMangerImp.addCustomer(newCustomer);
                    System.out.println("Customer added successfully.");
                    break;
                case 2:
                    System.out.println("Returning to main menu...");
                    manageCustomers = false; // Exit the customers menu loop
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to manage claims
    private static void manageClaimsMenu(Scanner scanner) {
        boolean manageClaims = true;
        while (manageClaims) {
            System.out.println("\nManage Claims");
            System.out.println("-----------------");
            System.out.println("1. Add a New Claim");
            System.out.println("2. Update an Existing Claim");
            System.out.println("3. Delete a Claim");
            System.out.println("4. Search for Claims");
            System.out.println("5. Display all Claims");
            System.out.println("6. Back to Main Screen ");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Implement add claim functionality
                    System.out.println("Adding a new claim:");

                    // Claim ID input and validation
                    boolean validClaimId = false;
                    String claimId = null;

                    // Validate and input claim ID
                    while (!validClaimId) {
                        System.out.print("Enter claim ID (f- followed by 10 digits): ");
                        claimId = scanner.nextLine();

                        // Regular expression for the claim ID format
                        Pattern pattern = Pattern.compile("^f-\\d{10}$");

                        if (pattern.matcher(claimId).matches()) {
                            validClaimId = true;
                        } else {
                            System.out.println("Claim ID format must follow f-numbers with 10 digits pattern");
                        }
                    }

                    // Input claim date
                    System.out.print("Enter claim date (yyyy-MM-dd): ");
                    String claimDateString = scanner.nextLine();
                    Date claimDate = null;
                    try {
                        claimDate = Claim.dateFormat.parse(claimDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                        break;
                    }

                    // Input insured person
                    System.out.print("Enter insured person: ");
                    String insuredPerson = scanner.nextLine();

                    // Input card number
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();

                    // Input exam date
                    System.out.print("Enter exam date (yyyy-MM-dd): ");
                    String examDateString = scanner.nextLine();
                    Date examDate = null;
                    try {
                        examDate = Claim.dateFormat.parse(examDateString);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                        break;
                    }

                    // Input claim amount
                    System.out.print("Enter claim amount: ");
                    double claimAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    // Input claim status
                    System.out.print("Enter status (New/Processing/Done): ");
                    String claimStatus = scanner.nextLine();

                    // Input number of documents
                    System.out.print("Enter number of documents: ");
                    int numDocuments = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Enter the name of the documents
                    List<String> documentNames = new ArrayList<>();
                    for (int i = 0; i < numDocuments; i++) {
                        System.out.println("Name of document number " + (i + 1) + ": ");
                        String documentName = scanner.nextLine();
                        documentNames.add(documentName);
                    }

                    // Create the list of documents
                    List<String> documentFullNames = new ArrayList<>();
                    for (String documentName : documentNames) {
                        String documentFullName = claimId + "_" + cardNumber + "_" + documentName + ".pdf";
                        documentFullNames.add(documentFullName);
                    }

                    // Show list of document
                    System.out.println("List of documents:");
                    for (String documentFullName : documentFullNames) {
                        System.out.println(documentFullName);
                    }

                    // Insert banking information
                    System.out.print("Bank: ");
                    String bankName = scanner.nextLine();

                    System.out.print("Account's holder name: ");
                    String accountHolderName = scanner.nextLine();

                    System.out.print("Account Number: ");
                    String accountNumber = scanner.nextLine();

                    // Display the Banking Information
                    System.out.println("Receiver Banking Info " + bankName + "-" + accountHolderName + "-" + accountNumber);
                    String receiverBankingInfo = scanner.nextLine();

                    // Create the new claim object
                    Claim newClaim = new Claim(claimId, claimDate, insuredPerson, cardNumber,
                            examDate, documentFullNames, claimAmount, claimStatus, receiverBankingInfo);

                    // Add the claim to the claim process manager
                    claimStatusManager.addClaim(newClaim);
                    System.out.println("Claim added successfully.");
                    break;
                case 2:
                    // Implement update claim functionality
                    System.out.println("Updating a claim:");

                    // Claim ID input and validation
                    validClaimId = false;
                    String updateClaimId = null;

                    // Validate and input updated claim ID
                    while (!validClaimId) {
                        System.out.print("Enter claim ID (f- followed by 10 digits): ");
                        updateClaimId = scanner.nextLine();

                        // Regular expression for the claim ID format
                        Pattern pattern = Pattern.compile("^f-\\d{10}$");

                        if (pattern.matcher(updateClaimId).matches()) {
                            validClaimId = true;
                        } else {
                            System.out.println("Claim ID format must follow f-numbers with 10 digits pattern");
                        }
                    }

                    // Check if the claim ID exists
                    Claim claimToUpdate = claimStatusManager.getOneClaim(updateClaimId);
                    if (claimToUpdate != null) {
                        // Prompt user for updated details
                        System.out.print("Enter new claim date (yyyy-MM-dd): ");
                        String newClaimDateString = scanner.nextLine();
                        Date newClaimDate = null;
                        try {
                            newClaimDate = Claim.dateFormat.parse(newClaimDateString);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                            break;
                        }
                        System.out.print("Enter new insured person: ");
                        String newInsuredPerson = scanner.nextLine();
                        System.out.print("Enter new card number: ");
                        String newCardNumber = scanner.nextLine();
                        System.out.print("Enter new exam date (yyyy-MM-dd): ");
                        String newExamDateString = scanner.nextLine();
                        Date newExamDate = null;
                        try {
                            newExamDate = Claim.dateFormat.parse(newExamDateString);
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
                            break;
                        }
                        System.out.print("Enter new claim amount: ");
                        double newClaimAmount = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter new status (New/Processing/Done): ");
                        String newStatus = scanner.nextLine();
                        // Insert banking information
                        System.out.print("Bank: ");
                        String newBankName = scanner.nextLine();

                        System.out.print("Account's holder name: ");
                        String newAccountHolderName = scanner.nextLine();

                        System.out.print("Account Number: ");
                        String newAccountNumber = scanner.nextLine();
                        // Display the Banking Information
                        System.out.println("Receiver Banking Info " + newBankName + "-" + newAccountHolderName + "-" + newAccountNumber);
                        String newReceiverBankingInfo = scanner.nextLine();

                        System.out.print("Enter new number of documents: ");
                        int newNumDocuments = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        // Enter the name of the documents
                        List<String> newDocumentNames = new ArrayList<>();
                        for (int i = 0; i < newNumDocuments; i++) {
                            System.out.println("Name of document number " + (i + 1) + ": ");
                            String documentName = scanner.nextLine();
                            newDocumentNames.add(documentName);
                        }
                        // Create the list of documents
                        List<String> newDocumentFullNames = new ArrayList<>();
                        for (String documentName : newDocumentNames) {
                            String documentFullName = updateClaimId + "_" + newCardNumber + "_" + documentName + ".pdf";
                            newDocumentFullNames.add(documentFullName);
                        }
                        // Show list of document
                        System.out.println("List of documents:");
                        for (String documentFullName : newDocumentFullNames) {
                            System.out.println(documentFullName);
                                }

                        // Update the claim with new details
                        claimToUpdate = new Claim(claimToUpdate.getId(), newClaimDate, newInsuredPerson, newCardNumber,
                                newExamDate, newDocumentFullNames, newClaimAmount, newStatus, newReceiverBankingInfo);
                        claimStatusManager.updateClaim(claimToUpdate);
                        System.out.println("Claim updated successfully.");
                    } else {
                        System.out.println("Claim with ID " + updateClaimId + " does not exist.");
                            }
                    break;
                        case 3:
                            // Implement delete claim functionality
                            System.out.println("Deleting a claim:");

                            // Claim ID input and validation
                            validClaimId = false;
                            String deletedClaimId = null;

                            while (!validClaimId) {
                                System.out.print("Enter claim ID (f- followed by 10 digits): ");
                                deletedClaimId = scanner.nextLine();

                                // Regular expression for the claim ID format
                                Pattern pattern = Pattern.compile("^f-\\d{10}$");

                                if (pattern.matcher(deletedClaimId).matches()) {
                                    validClaimId = true;
                                } else {
                                    System.out.println("Claim ID format must follow f-numbers with 10 digits pattern");
                                }
                            }

                            // Check if the claim ID exists
                            Claim claimToDelete = claimStatusManager.getOneClaim(deletedClaimId);
                            if (claimToDelete != null) {
                                // Delete the claim
                                claimStatusManager.deleteClaim(deletedClaimId);
                                System.out.println("Claim with ID " + deletedClaimId + " deleted successfully.");
                            } else {
                                System.out.println("Claim with ID " + deletedClaimId + " does not exist.");
                            }
                            break;
                        case 4:

                            // Claim ID input and validation
                            validClaimId = false;
                            String searchClaimId = null;

                            while (!validClaimId) {
                                System.out.print("Enter claim ID (f- followed by 10 digits): ");
                                searchClaimId = scanner.nextLine();

                                // Regular expression for the claim ID format
                                Pattern pattern = Pattern.compile("^f-\\d{10}$");

                                if (pattern.matcher(searchClaimId).matches()) {
                                    validClaimId = true;
                                } else {
                                    System.out.println("Claim ID format must follow f-numbers with 10 digits pattern");
                                }
                            }

                            // Retrieve the claim by ID
                            Claim searchedClaim = claimStatusManager.getOneClaim(searchClaimId);
                            if (searchedClaim != null) {
                                // Display claim details
                                System.out.println("Claim ID: " + searchedClaim.getId());
                                System.out.println("Claim Date: " + Claim.dateFormat.format(searchedClaim.getClaimDate()));
                                System.out.println("Insured Person: " + searchedClaim.getInsuredPerson());
                                System.out.println("Card Number: " + searchedClaim.getCardNumber());
                                System.out.println("Exam Date: " + Claim.dateFormat.format(searchedClaim.getExamDate()));
                                System.out.println("Claim Amount: " + searchedClaim.getClaimAmount());
                                System.out.println("Status: " + searchedClaim.getStatus());
                                System.out.println("Receiver Banking Info: " + searchedClaim.getReceiverBankingInfo());
                                System.out.println("Documents:");
                                for (String document : searchedClaim.getDocuments()) {
                                    System.out.println("- " + document);
                                }
                            } else {
                                System.out.println("Claim with ID " + searchClaimId + " does not exist.");
                            }
                            break;
                        case 5:
                            System.out.println("Displaying all claims:");

                            // Retrieve all claims
                            List<Claim> allClaims = claimStatusManager.getAllClaims();

                            // Check if there are any claims
                            if (allClaims.isEmpty()) {
                                System.out.println("There are no claims at the moment...");
                            } else {
                                // Display details of all claims
                                for (Claim claim : allClaims) {
                                    System.out.println("Claim ID: " + claim.getId());
                                    System.out.println("Claim Date: " + Claim.dateFormat.format(claim.getClaimDate()));
                                    System.out.println("Insured Person: " + claim.getInsuredPerson());
                                    System.out.println("Card Number: " + claim.getCardNumber());
                                    System.out.println("Exam Date: " + Claim.dateFormat.format(claim.getExamDate()));
                                    System.out.println("Claim Amount: " + claim.getClaimAmount());
                                    System.out.println("Status: " + claim.getStatus());
                                    System.out.println("Receiver Banking Info: " + claim.getReceiverBankingInfo());
                                    System.out.println("Documents:");
                                    for (String document : claim.getDocuments()) {
                                        System.out.println("- " + document);
                                    }
                                    System.out.println();
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Returning to main menu...");
                            manageClaims = false; // Exit the claims menu loop
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }


