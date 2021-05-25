package kodlamaio.hrms.core.utilities.validation;

import kodlamaio.hrms.core.utilities.results.Result;

public class ValidationRules {
    public static Result run(Result... logics){
        for (Result logic : logics) {
            if (!logic.isSuccess()) {
                return logic;
            }
        }
        return null;
    }
}
