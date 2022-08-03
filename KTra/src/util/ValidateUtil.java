package util;

import java.util.regex.Pattern;

public class ValidateUtil {
    private static final String STUDENT_NAME_REGEX ="^[A-Za-z ]{6,30}$";
    private static final String SEX_REGEX = "^((Male)|(Female)|(Private))$";
    private static final String PHONE_NUMBER_REGEX = "^(09||03||07)+([0-9]{8})\\b";
    private static final String DATE_OF_BIRTH = "^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
    public boolean studentNameValidateUtil(String studentName) {
        return Pattern.matches(STUDENT_NAME_REGEX, studentName);
    }
    public boolean sexValidateUtil(String sex) {
        return Pattern.matches(SEX_REGEX, sex);
    }
    public boolean phoneNumberValidateUtil(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }
    public boolean dateOfBirthvalidateUtil(String dateOfBirth){
        return Pattern.matches(DATE_OF_BIRTH,dateOfBirth);
    }
}
