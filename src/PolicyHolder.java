import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {

    // Attribute to store the list of dependents associated with the policy holder
    private List<Dependent> dependents = new ArrayList<>();

    // Constructor
    public PolicyHolder(String id, String fullName, String insuranceCard) {
        super(id, fullName, insuranceCard, String.valueOf(CustomerRole.POLICYHOLDER));
    }

    // Getter for the list of dependents
    public List<Dependent> getDependents() {
        return dependents;
    }

    // Method to add a dependent to the list
    public void addDependent(Dependent dependent) {
        dependents.add(dependent);
    }


    // Override toString method for better representation
    @Override
    public String toString() {
        return "PolicyHolder{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                ", dependents=" + dependents +
                '}';
    }


}
