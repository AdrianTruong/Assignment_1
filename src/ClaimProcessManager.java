/**
 * @author <Truong Bien Hai Trong - S3872952>
 */
import java.util.List;

public interface ClaimProcessManager {


    // Add a new claim
    void addClaim(Claim claim);


    //Update an existing claim
    void updateClaim(Claim claim);

    //Delete a claim
    void deleteClaim(String claimId);

    //Retrieve a single claim by ID
    Claim getOneClaim(String claimId);

    //Retrieve all claims
    List<Claim> getAllClaims();
}
