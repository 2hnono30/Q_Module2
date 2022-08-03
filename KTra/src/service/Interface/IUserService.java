package service.Interface;

import model.UserModel;

import java.util.ArrayList;

public interface IUserService {
    ArrayList<UserModel> getUser();

    UserModel getUserById(long userId);
    UserModel signIn(String userName, String userPassword);

    void addUser(UserModel user);
    void editUser(UserModel user);
    void removeUser(UserModel user);

    boolean existsUserId(long userId);
    boolean existsUserName(String userName);
    boolean existsUserEmail(String userEmail);
    boolean existsUserPhoneNumber(String userPhoneNumber);

}
