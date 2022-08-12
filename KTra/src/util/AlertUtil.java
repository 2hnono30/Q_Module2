package util;

public class AlertUtil {
    public void alertUtil(String option){
        String output = "";
        String confirm = " \033[0;1m[\033[1;92mY\033[0;1m] \033[0;32mYes \033[0m- \033[0;1m[\033[1;92mN\033[0;1m] \033[0;32mNo\033[0m\n";
        if (option.equals("Student-Name-Require")) output = "\033[0;91m■ Student name must be between 6-30 character and not empty!\033[0m\n";
        if (option.equals("Student-Remove-Cancel")) output = "\033[0;92m■ Canceled remove successfully!\033[0m\n";
        if (option.equals("Student-Remove-Success")) output = "\033[0;92m■ Product removed successfully!\033[0m\n";
        if (option.equals("Student-Name")) output = "■ Type a student name: ";
        if (option.equals("Student-Remove-Confirm")) output = "■ Are your sure want to remove this student?" + confirm;

        if (option.equals("Student-Edit-Name-Success")) output = "\033[0;92m■ Student name edited successfully!\033[0m\n";
        if (option.equals("FullName-Edit-Success")) output = "\033[0;92m■ FullName edited successfully!\033[0m\n";
        if (option.equals("Address-Edit-Success")) output = "\033[0;92m■ Address edited successfully!\033[0m\n";
        if (option.equals("Email-Edit-Success")) output = "\033[0;92m■ Email edited successfully!\033[0m\n";

        if (option.equals("Add-Success")) output = "\033[0;92m■ Add successfully!\033[0m\n";

        if (option.equals("Users-Name-Require")) output = "\033[0;91m■ UsersName must be between 8-20 character and not empty!\033[0m\n";
        if (option.equals("User-Name")) output = "■ Type a UserName: ";
        if (option.equals("PassWord-Require")) output = "\033[0;91m■ PassWord must be from 8 character and not empty!\033[0m\n";
        if (option.equals("PassWord")) output = "■ Type a PassWord: ";
        if (option.equals("FullName-Require")) output = "\033[0;91m■ FullName nhập không phù hợp, Vui lòng nhập lại (Tên phải viết hoa chữ cái đầu và không dấu) !\033[0m\n";
        if (option.equals("FullName")) output = "■ Type a FullName(vd: Nguyen Van A): ";

        if (option.equals("Address")) output = "■ Type a Address(vd: Huế): ";
        if (option.equals("Email")) output = "■ Type a Email(vd: A@gmail.com): ";
        if (option.equals("Email-Require")) output = "\033[0;91m■ Email Login does not match, please re-enter\033[0m\n";
        if (option.equals("Email-Already-Exist")) output = "\033[0;91m■ Email already exists! Please re-enter \033[0m\n";
        if (option.equals("UsersName-Require")) output = "\033[0;91m■ Email Login does not match, please re-enter\033[0m\n";
        if (option.equals("UserName-Already-Exist")) output = "\033[0;91m■ UserName already exists! Please re-enter \033[0m\n";

        if (option.equals("Select")) output = "\033[0;92m■ Select : \n\033[0m";
        if (option.equals("Invalid-Select")) output = "\033[0;91m■ Invalid selected option, please try again!\n\033[0m";
        if (option.equals("Invalid-Input")) output = "\033[0;91m■ Invalid inputed, please try again!\n\033[0m";

        if (option.equals("Phone-Number-Require")) output = "\033[0;91m■ Phone number must 10 character and start with 09 || 03 or 07~! \033[0m\n";
        if (option.equals("Phone-Number-Edit-Success")) output = "\033[0;92m■ Phone Number edited successfully!\033[0m\n";
        if (option.equals("Phone-Number")) output = "■ Phone number(vd: 0345129876): ";
        if (option.equals("Phone-Number-Already-Exist")) output = "\033[0;91m■ Phone number already exists! Please re-enter \033[0m\n";

        if (option.equals("Sex-Require")) output = "\033[0;91m■ Sex must be between Male, Female and Private \033[0m\n";
        if (option.equals("Sex-Edit-Success")) output = "\033[0;92m■ Student of sex edited successfully!\033[0m\n";
        if (option.equals("Sex")) output = "■ Sex (Male, Female or Private): ";

        if (option.equals("DateOfBirth-Require")) output = "\033[0;91m■ Date Of Birth must be formatted as dd/MM/yyyy \033[0m\n";
        if (option.equals("Date Of Birth")) output = "■ Date Of Birth(vd:01/01/2000): ";
        if (option.equals("DateOfBirth-Edit-Success")) output = "\033[0;92m■ Date Of Birth edited successfully!\033[0m\n";

        if (option.equals("Account-Id-Not-Exist")) output = "\033[0;91m■ Account id is not exists, please try again!\033[0m\n";
        if (option.equals("Account-Id")) output = "■ Account Id : ";
        if (option.equals("Account-Remove-Confirm")) output = "■ Are your sure want to remove this Account?" + confirm;
        if (option.equals("Account-Remove-Success")) output = "\033[0;92m■ Account removed successfully!\033[0m\n";


        if (option.equals("Student-Id-Not-Exist")) output = "\033[0;91m■ Student id is not exists, please try again!\033[0m\n";
        if (option.equals("Student-Id-Render")) output = "\033[0;91m■ Id does not exist \033[0m\n";
        if (option.equals("Student-Id")) output = "■ Id : ";

        if (option.equals("Continue")) output = "■ Continue Edit ? \n";
        if (option.equals("Continue-rep")) output = "1. yes \n" + "2. no \n" + "Enter the number : \n";

        if (option.equals("Sign-In-Success")) output = "\033[0;92m■ You are signed in the account successfully!\033[0m\n";
        if (option.equals("Sign-In-Wrong")) output = "\033[0;91m■ You are typed wrong username or password, please try again!\033[0m\n";
        if (option.equals("Sign-In-Username")) output ="■ Type a username: ";
        if (option.equals("Sign-In-Password")) output = "■ Type a password: ";
        if (option.equals("Sign-In-Confirm")) output = "■ Are you sure want to sign in?" + confirm;
        if (option.equals("Sign-Out-Confirm")) output = "■ Are you sure want to sign out the account?"+confirm;
        if (option.equals("Sign-Out-Confirm-Success")) output = "\033[0;92m■ You are signed out the account successfully!\033[0m\n";
        if (option.equals("Sign-Out-Confirm-Cancel")) output = "\033[0;92m■ You are canceled sign out successfully!\033[0m\n";
        if (option.equals("Return-Success")) output = "\033[0;92m■ You are returned the previous menu successfully!\033[0m\n";

        if (option.equals("Exit-Confirm")) output = "■ Are you sure want to exit the application?" + confirm;;
        if (option.equals("Exit-Confirm-Success")) output = "\033[0;92m■ You are exited the application successfully!\033[0m\n";
        if (option.equals("Exit-Confirm-Cancel")) output = "\033[0;92m■ You are canceled exit successfully!\033[0m\n";

        if (option.equals("Admin")) output = "■ Contact us via email \033[0;96m2hnono30@gmail.com \033[0mto recover the account.\n";
        System.out.print(output);
    }
}
