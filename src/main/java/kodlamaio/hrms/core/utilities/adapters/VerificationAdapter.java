package kodlamaio.hrms.core.utilities.adapters;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class VerificationAdapter {
    public static Result EmailVerification(){
        System.out.println("Doğrulama maili gönderilmiştir.");
        return new SuccessResult();
    }

    public static Result SystemEmployeesVerification(){
        System.out.println("Sistem çalışanlarına doğrulama gönderilmiştir.");
        return new SuccessResult();
    }

    public static Result MernisVerification(String nationalIdentity){
        if (nationalIdentity.length() != 11){
            return new ErrorResult("Mernis doğrulaması başarısız oldu.");
        }
        return new SuccessResult();
    }
}
