/**
 * @author <Truong Bien Hai Trong - S3872952>
 */
public class Dependent extends Customer {

    // Additional attribute for relationship to policyholder
    private String relationshipToPolicyHolder;

    // Constructor
    public Dependent(String id, String fullName, String relationshipToPolicyHolder ) {
        super(id, fullName, null, String.valueOf(CustomerRole.DEPENDENT));
        this.relationshipToPolicyHolder = relationshipToPolicyHolder;
    }

    // Getter for relationship to policyholder
    public String getRelationshipToPolicyHolder() {
        return relationshipToPolicyHolder;
    }

    // Setter for relationship to policyholder
    public void setRelationshipToPolicyHolder(String relationshipToPolicyHolder) {
        this.relationshipToPolicyHolder = relationshipToPolicyHolder;
    }

    // Override toString() method to provide string representation of Dependent object
    @Override
    public String toString() {
        return "Dependent{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                ", relationshipToPolicyHolder='" + relationshipToPolicyHolder + '\'' +
                '}';
    }

}
