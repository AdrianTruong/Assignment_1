public class Dependent extends Customer {

    private String relationshipToPolicyHolder;

    public Dependent(String id, String fullName, InsuranceCard insuranceCard, String relationshipToPolicyHolder ) {
        super(id, fullName, insuranceCard);
        this.relationshipToPolicyHolder = relationshipToPolicyHolder;
    }

    public String getRelationshipToPolicyHolder() {
        return relationshipToPolicyHolder;
    }

    public void setRelationshipToPolicyHolder(String relationshipToPolicyHolder) {
        this.relationshipToPolicyHolder = relationshipToPolicyHolder;
    }

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
