package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;

public class JobSeekerAuthValidator {
    public static Result AreFieldsFull(int birthYear, String... fields){
        for (String field : fields){
            if (field == null){
                return new ErrorResult("İstenilen alanlar boş bırakılamaz.");
            }
        }
        return new SuccessResult();
    }
}
