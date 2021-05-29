package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Result AreFieldsFull(Object... fields){
        for (Object field : fields){
            if (field == null){
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
        String[] splittedEmail = email.split("@");
        String[] splittedWebsite = website.split("www.");

        if (splittedEmail.length >= 2 && splittedWebsite.length >= 2){
            if (!splittedEmail[1].equals(splittedWebsite[1])){
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

    public static Result IsPhoneNumberInPhoneNumberFormat(String phoneNumber){
        Pattern pattern = Pattern.compile("^(\\d{3}-){2}\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (!matcher.find()){
            return new ErrorResult("Girmiş olduğunuz telefon numarası, telefon numarası formatında değil.(Gerekli format: '000-000-0000')");
        }
        return new SuccessResult();
    }

    public static Result IsBirthDateInBirthDateFormat(String birthDate){
        Pattern pattern = Pattern.compile("^(0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])[-](19|20)\\d\\d$");
        Matcher matcher = pattern.matcher(birthDate);

        if (!matcher.find()){
            return new ErrorResult("Girmiş olduğunuz doğum tarihi, doğum tarihi formatında değil.(Gerekli format: 'YYYY-AA-GG')");
        }
        return new SuccessResult();
    }
}
