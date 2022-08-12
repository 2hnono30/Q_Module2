package util;

import java.util.regex.Pattern;

public class ValidateUtil {
    private static final String STUDENT_NAME_REGEX ="^[A-Za-z ]{6,30}$";
    private static final String SEX_REGEX = "^((Male)|(Female)|(Private))$";
    private static final String PHONE_NUMBER_REGEX = "^(09||03||07)+([0-9]{8})\\b";
    private static final String DATE_OF_BIRTH = "^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
    public static final String USERNAME_PATTERN = "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
    public static final String PASSWORD_PATTERN = "^([a-zA-Z0-9]{8,})";
    public static final String NAME_REGEX = "^([A-Z]+[a-z]*[ ]?)+$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";

    public static boolean isPasswordValid(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }

    public static boolean isUsernameValid(String password) {
        return Pattern.compile(USERNAME_PATTERN).matcher(password).matches();
    }

    public static boolean isNameValid(String name) {
        return Pattern.compile(NAME_REGEX).matcher(name).matches();
    }

    public static boolean isPhoneValid(String number) {
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }

    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

    public static boolean studentNameValidateUtil(String studentName) {
        return Pattern.matches(STUDENT_NAME_REGEX, studentName);
    }
    public static boolean sexValidateUtil(String sex) {
        return Pattern.matches(SEX_REGEX, sex);
    }
    public static boolean phoneNumberValidateUtil(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER_REGEX, phoneNumber);
    }
    public static boolean dateOfBirthvalidateUtil(String dateOfBirth){
        return Pattern.matches(DATE_OF_BIRTH,dateOfBirth);
    }
}
