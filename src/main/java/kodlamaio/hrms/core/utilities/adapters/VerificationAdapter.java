package kodlamaio.hrms.core.utilities.adapters;

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
}
