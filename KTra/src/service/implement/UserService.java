package service.implement;

import model.UserModel;
import model.enumerate.RoleModel;
import service.interfaces.IUserService;
import util.FileUtil;

import java.time.Instant;
import java.util.ArrayList;

import static util.PathUtil.PATH_USER_DATA;

public class UserService implements IUserService {
    FileUtil fileUtil = new FileUtil();

    @Override
    public ArrayList<UserModel> getUser() {
        UserModel userModel = new UserModel();
        ArrayList<UserModel> userList = new ArrayList<>();
        ArrayList<String> fileRecord = fileUtil.fileRead(PATH_USER_DATA);
        for (String temp : fileRecord) {
            userList.add(userModel.parseUser(temp));
        }
        return userList;
    }

    @Override
    public UserModel getUserById(long userId) {
        ArrayList<UserModel> userList = getUser();
        for (UserModel temp : userList) {
            if (temp.getUserId() == userId) {
                return temp;
            }
        }
        return null;
    }

    @Override
    public UserModel signIn(String userName, String userPassword) {
        ArrayList<UserModel> userList = getUser();

        for (UserModel temp : userList) {
            if (temp.getUserRole().equals(RoleModel.ADMIN) && temp.getUserName().equals(userName) && temp.getUserPassword().equals(userPassword)) {
                return temp;
            }
        }
        return null;
    }
    public UserModel signInUser(String userName,String userPassword){
        ArrayList<UserModel> userList = getUser();
        for (UserModel temp : userList) {
            if (temp.getUserRole().equals(RoleModel.STAFF) && temp.getUserName().equals(userName) && temp.getUserPassword().equals(userPassword)) {
                return temp;
            }
        }
        return null;
    }

    @Override
    public void addUser(UserModel user) {
        user.setUserId(System.currentTimeMillis() / 100000);
        user.setUserCreateDate(Instant.now());
        ArrayList<UserModel> userList = getUser();
        userList.add(user);
        fileUtil.fileWrite(PATH_USER_DATA, userList);
    }

    @Override
    public void editUser(UserModel user) {
        ArrayList<UserModel> userList = getUser();

        for (UserModel temp : userList) {
            if (temp.getUserId() == user.getUserId()) {

                String userName = user.getUserName();
                if (userName != null && !userName.isEmpty())
                    temp.setUserName(userName);

                String userPassword = user.getUserPassword();
                if (userPassword != null && !userPassword.isEmpty())
                    temp.setUserPassword(userPassword);

                String userFullName = user.getUserFullName();
                if (userFullName != null && !userFullName.isEmpty())
                    temp.setUserFullName(userFullName);

//                String userBirthDay = user.getUserBirthDay();
//                if (userBirthDay != null && !userBirthDay.isEmpty()) temp.setUserBirthDay(user.getUserBirthDay());

                String userAddress = user.getUserAddress();
                if (userAddress != null && !userAddress.isEmpty())
                    temp.setUserAddress(userAddress);

                String userEmail = user.getUserEmail();
                if (userEmail != null && !userEmail.isEmpty())
                    temp.setUserEmail(userEmail);

                String userPhoneNumber = user.getUserPhoneNumber();
                if (userPhoneNumber != null && !userPhoneNumber.isEmpty())
                    temp.setUserPhoneNumber(userPhoneNumber);

//                temp.setUserUpdateDate(Instant.now());
                fileUtil.fileWrite(PATH_USER_DATA, userList);
            }
        }
    }

    @Override
    public void removeUser(UserModel user) {
        ArrayList<UserModel> userList = getUser();

        userList.removeIf(temp -> temp.getUserId() == user.getUserId());
        fileUtil.fileWrite(PATH_USER_DATA, userList);
    }

    @Override
    public boolean existsUserId(long userId) {
        return getUserById(userId) != null;
    }

    @Override
    public boolean existsUserName(String userName) {
        ArrayList<UserModel> userList = getUser();

        for (UserModel temp : userList) if (temp.getUserName().equals(userName)) return true;
        return false;
    }

    @Override
    public boolean existsUserEmail(String userEmail) {
        ArrayList<UserModel> userList = getUser();

        for (UserModel temp : userList) if (temp.getUserEmail().equals(userEmail)) return true;
        return false;
    }

    @Override
    public boolean existsUserPhoneNumber(String userPhoneNumber) {
        ArrayList<UserModel> userList = getUser();

        for (UserModel temp : userList) {
            if (temp.getUserPhoneNumber().equals(userPhoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
