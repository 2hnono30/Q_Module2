package QL_Ung_Vien.util;

import java.util.regex.Pattern;

public class ValidateUtil {
    private static final String BIRTHDAY = "^(0[1-9]|1\\d|2\\d|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";
    private static final String PHONE_NUMBER = "^(09||03||07)+([0-9]{8})\\b";
    private static final String NAME ="^[A-Za-z ]{6,30}$";
    private static final String EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$";
    public boolean NameValidateUtil(String fullName) {
        return Pattern.matches(NAME, fullName);
    }
    public boolean BirthDayValidateUtil(String birthDay) {
        return Pattern.matches(BIRTHDAY, birthDay);
    }
    public boolean phoneNumberValidateUtil(String phoneNumber) {
        return Pattern.matches(PHONE_NUMBER, phoneNumber);
    }
    public boolean emailvalidateUtil(String email){
        return Pattern.matches(EMAIL,email);
    }
}
