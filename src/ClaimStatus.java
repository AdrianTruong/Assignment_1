import java.util.ArrayList;
import java.util.List;

class ClaimStatus implements ClaimProcessManager {

        private static List<Claim> claims;

        public ClaimStatus(List<Claim> claims) {
            ClaimStatus.claims = claims;
        }

        @Override
        public void addClaim(Claim claim) {
            claims.add(claim);
        }

        @Override
        public void updateClaim(Claim claim) {
            for (int i = 0; i < claims.size(); i++) {
                if (claims.get(i).getId().equals(claim.getId())) {
                    claims.set(i, claim);
                    break;
                }
            }
        }

        @Override
        public void deleteClaim(String claimId) {
            claims.removeIf(claim -> claim.getId().equals(claimId));
        }

        @Override
        public Claim getOneClaim(String claimId) { // Corrected version
            for (Claim claim : claims) {
                if (claim.getId().equals(claimId)) {
                    return claim;
                }
            }
            return null;
        }

        @Override
        public List<Claim> getAllClaims() {
            return new ArrayList<>(claims);
        }
    }

