package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class AuthValidator {
    public static Result AreFieldsFull(String... fields){
        for (String field : fields){
            if (field.isEmpty() || field == null){
                return new ErrorResult("İstenilen alanlar boş bırakılamaz.");
            }
        }
        return new SuccessResult();
    }

    public static Result IsPasswordSameAsConfirmPassword(String password, String confirmPassword){
        if (!password.equals(confirmPassword)){
            return new ErrorResult("Doğrulama parolası parola ile uyuşmuyor.");
        }
        return new SuccessResult();
    }

    public static Result DoesEmailHaveSameDomainAsWebsite(String email, String website){
        String[] splitedEmail = email.split("@");
        String[] splitedWebsite = website.split("www.");

        if (splitedEmail.length >= 2 && splitedWebsite.length >= 2){
            if (!splitedEmail[1].equals(splitedWebsite[1])){
                return new ErrorResult("Email adresi ile websitesi farklı domainlere sahip.");
            }
            return new SuccessResult();
        }
        return new SuccessResult();
    }
}
