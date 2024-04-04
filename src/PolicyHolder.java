import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {

    private List<Dependent> dependents = new ArrayList<>();

    public PolicyHolder(String id, String fullName, InsuranceCard insuranceCard) {
        super(id, fullName, insuranceCard);
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

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
