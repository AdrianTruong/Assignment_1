/**
 * @author <Truong Bien Hai Trong - S3872952>
 */
import java.util.ArrayList;
import java.util.List;

class ClaimStatus implements ClaimProcessManager {

    private static List<Claim> claims;

    // Constructor: Initializes the ClaimStatus object with a list of claims
    public ClaimStatus(List<Claim> claims) {
        ClaimStatus.claims = claims;
    }

    @Override
    // Adds a new claim to the list of claims
    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    @Override
    // Updates an existing claim in the list
    public void updateClaim(Claim claim) {
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claim.getId())) {
                claims.set(i, claim); // Replaces the old claim with the updated version
                break;
            }
        }
    }

    @Override
    // Deletes a claim from the list based on its claim ID
    public void deleteClaim(String claimId) {
        claims.removeIf(claim -> claim.getId().equals(claimId));
    }

    @Override
    // Retrieves a specific claim from the list based on its claim ID
    public Claim getOneClaim(String claimId) {
        for (Claim claim : claims) {
            if (claim.getId().equals(claimId)) {
                return claim;
            }
        }
        return null;
    }

    @Override
    // Returns a copy of the list of claims
    public List<Claim> getAllClaims() {
        return new ArrayList<>(claims);
    }
}
