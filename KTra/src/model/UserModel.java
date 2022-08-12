package model;

import model.enumerate.RoleModel;

import java.time.Instant;

public class UserModel {
    private RoleModel userRole;
    private long userId;
    private String userName;
    private String userPassword;
    private String userFullName;
    private String userAddress;
    private String userEmail;
    private String userPhoneNumber;
    private Instant userCreateDate;
    private Instant userUpdateDate;


    public UserModel() {
    }

    public UserModel(
            String userName,
            String userPassword,
            String userFullName,
            String userAddress,
            String userEmail,
            String userPhoneNumber,
            RoleModel userRole
    ) {
        this.userRole = userRole;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userFullName = userFullName;
        this.userAddress = userAddress;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
    }

    public UserModel parseUser(String fileData) {
        UserModel userModel = new UserModel();
        String[] fileIndex = fileData.split(",");

        userModel.userRole = RoleModel.parseRole(fileIndex[0]);
        userModel.userId = Long.parseLong(fileIndex[1]);
        userModel.userName = fileIndex[2];
        userModel.userPassword = fileIndex[3];
        userModel.userFullName = fileIndex[4];
        userModel.userAddress = fileIndex[5];
        userModel.userEmail = fileIndex[6];
        userModel.userPhoneNumber = fileIndex[7];
        userModel.userCreateDate = Instant.parse(fileIndex[8]);
        String temp = fileIndex[9];
        if (temp != null && !temp.equals("null")) userModel.userUpdateDate = Instant.parse(temp);
        return userModel;
    }

    public RoleModel getUserRole() {
        return userRole;
    }

    public long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserFullName() {
        return userFullName;
    }


    public String getUserAddress() {
        return userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public Instant getUserCreateDate() {
        return userCreateDate;
    }

    public Instant getUserUpdateDate() {
        return userUpdateDate;
    }

    public void setUserRole(RoleModel userRole) {
        this.userRole = userRole;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }


    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public void setUserCreateDate(Instant userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public void setUserUpdateDate(Instant userUpdateDate) {
        this.userUpdateDate = userUpdateDate;
    }

    @Override
    public String toString() {
        return String.format(
                "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                userRole,
                userId,
                userName,
                userPassword,
                userFullName,
                userAddress,
                userEmail,
                userPhoneNumber,
                userCreateDate,
                userUpdateDate
        );
    }
}
