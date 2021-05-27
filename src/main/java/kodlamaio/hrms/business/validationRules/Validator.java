package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Result AreFieldsFull(String... fields){
        for (String field : fields){
            if (field == null){
                return new ErrorResult("İstenilen alanlar boş bırakılamaz.");
            }else if (field.isEmpty()){

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

    public static Result IsEmailInEmailFormat(String email){
        Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()){
            return new ErrorResult("Girmiş olduğunuz email adresi, email formatında değil.");
        }
        return new SuccessResult();
    }
}
