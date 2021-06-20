package kodlamaio.hrms.business.validationRules;

import kodlamaio.hrms.business.constants.Messages;
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
                return new ErrorResult(Messages.fieldsCannotBeNull);
            }
        }
        return new SuccessResult();
    }

    public static Result IsPasswordSameAsConfirmPassword(String password, String confirmPassword){
        if (!password.equals(confirmPassword)){
            return new ErrorResult(Messages.passwordDoesntMatchPasswordConfirmation);
        }
        return new SuccessResult();
    }

    public static Result DoesEmailHaveSameDomainAsWebsite(String email, String website){
        String[] splittedEmail = email.split("@");
        String[] splittedWebsite = website.split("www.");

        if (splittedEmail.length >= 2 && splittedWebsite.length >= 2){
            if (!splittedEmail[1].equals(splittedWebsite[1])){
                return new ErrorResult(Messages.emailAndWebsiteCannotHaveDifferentDomain);
            }
            return new SuccessResult();
        }
        return new SuccessResult();
    }

    public static Result IsEmailInEmailFormat(String email){
        Pattern pattern = Pattern.compile("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.find()){
            return new ErrorResult(Messages.emailIsNotInEmailFormat);
        }
        return new SuccessResult();
    }

    public static Result IsPhoneNumberInPhoneNumberFormat(String phoneNumber){
        Pattern pattern = Pattern.compile("^(\\d{3}-){2}\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);

        if (!matcher.find()){
            return new ErrorResult(Messages.phoneNumberIsNotInPhoneNumberFormat);
        }
        return new SuccessResult();
    }

    public static Result IsBirthDateInBirthDateFormat(String birthDate){
        Pattern pattern = Pattern.compile("^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(String.valueOf(birthDate));

        if (!matcher.find()){
            return new ErrorResult(Messages.birthDateIsNotInDateFormat);
        }else if(LocalDate.now().toEpochDay() - LocalDate.parse(birthDate).toEpochDay() < 6574){
            return new ErrorResult(Messages.ageIsNotOldEnough);
        }
        return new SuccessResult();
    }

    public static Result IsApplicationDeadlineInApplicationDeadlineFormat(String applicationDeadline){
        Pattern pattern = Pattern.compile("^(19|20)\\d\\d[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(String.valueOf(applicationDeadline));

        if (!matcher.find()){
            return new ErrorResult(Messages.applicationDeadlineIsNotInDateFormat);
        }else if (LocalDate.now().toEpochDay() >= LocalDate.parse(applicationDeadline).toEpochDay()){
            return new ErrorResult(Messages.applicationDateIsNotFutureDate);
        }
        return new SuccessResult();
    }

    public static Result IsWebsiteInWebsiteFormat(String website){
        Pattern pattern = Pattern.compile("^(http://)(www.)([a-zA-Z0-9]+).[a-zA-Z0-9]*.([a-z]+)$");
        Matcher matcher = pattern.matcher(String.valueOf(website));

        if (!matcher.find()){
            return new ErrorResult(Messages.websiteIsNotInWebsiteFormat);
        }
        return new SuccessResult();
    }

    public static Result IsNationalIdentityNumberInNationalIdentityNumberFormat(String nationalIdentityNumber){
        Pattern pattern = Pattern.compile("^[1-9]{1}[0-9]{9}[02468]{1}$");
        Matcher matcher = pattern.matcher(String.valueOf(nationalIdentityNumber));

        if (!matcher.find()){
            return new ErrorResult(Messages.nationalIdentityNumberIsNotInNationalIdentityNumberFormat);
        }
        return new SuccessResult();
    }
}
