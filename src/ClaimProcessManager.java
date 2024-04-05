import java.util.List;

public interface ClaimProcessManager {


    // Add a new claim
    void addClaim(Claim claim);

    //Update an existing claim
    void updateClaim(String claimId);

    //Delete a claim
    void deleteClaim(String claimId);

    //Retrieve a single claim by ID
    Claim getClaimById(String claimId);

    //Retrieve claims based on search criteria
    List<Claim> findClaims(Claim filter);
}
