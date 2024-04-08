# Insurance Claims Management System

## Overview:
The Insurance Claims Management System is a comprehensive Java application designed to streamline the process of managing insurance claims and customer information. It offers a range of features to facilitate the efficient handling of claims, from their creation to their management and monitoring.

## Features:
1. **Manage Customers:**
    - Add new customers with ease, distinguishing between policyholders and dependents.
    - Capture essential customer details, including their full name, role, insurance card information, and banking details for streamlined payment processing.

2. **Manage Claims:**
    - Add new claims effortlessly, providing detailed information such as claim date, insured person, card number, exam date, claim amount, status, and associated documents.
    - Seamlessly update existing claims with any necessary modifications, ensuring accurate and up-to-date records.
    - Efficiently delete claims based on their unique claim ID, simplifying data management tasks.
    - Search for specific claims by their unique ID, enabling quick retrieval of relevant information.
    - Display all existing claims in a structured format, allowing for easy review and analysis of claim details.

## Components:
- **InsuranceCard:** Represents an insurance card, encapsulating attributes such as the card number, cardholder name, policy owner, and expiration date.
- **Claim:** Represents an insurance claim, containing details such as the claim ID, claim date, insured person, card number, exam date, claim amount, status, associated documents, and banking information.
- **ClaimStatus:** Manages the status of insurance claims, providing functionalities for adding, updating, deleting, and searching claims.
- **Customer:** Represents a customer within the system, storing essential information such as the customer ID, full name, role (policyholder or dependent), and relevant receiver information (insurance or banking).
- **CustomerMangerImp:** Facilitates the management of customers, including the addition of new customers to the system.

## Usage:
1. Run the `InsuranceClaimsManagementSystem` class to initiate the application.
2. From the main menu, select one of the following options:
   - **Manage Customers:** Add new customers, providing necessary details, or return to the main menu.
   - **Manage Claims:** Perform various operations on claims, including adding, updating, deleting, searching, or displaying them, before returning to the main menu.
   - **Exit System:** Safely exit the application.

## Conclusion:
The Insurance Claims Management System offers a robust solution for effectively managing insurance claims and customer information. With its user-friendly interface and comprehensive feature set, it empowers users to efficiently handle all aspects of the claims process, enhancing productivity and ensuring accurate record-keeping.
