package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

public class MernisAdapter {
    public static Result CheckIfRealPerson(String nationalIdentity){
        if (nationalIdentity.length() != 11){
            return new ErrorResult("Mernis doğrulaması başarısız oldu.");
        }
        return null;
    }
}
