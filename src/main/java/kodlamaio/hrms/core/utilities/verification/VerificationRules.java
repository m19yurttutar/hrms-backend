package kodlamaio.hrms.core.utilities.verification;

import kodlamaio.hrms.core.utilities.results.Result;

public class VerificationRules {
    public static Result run(Result... logics){
        for (Result logic : logics) {
            if (!logic.isSuccess()) {
                return logic;
            }
        }
        return null;
    }
}
