package model.enumerate;
public enum RoleModel {
    ADMIN("ADMIN"),
    STAFF("STAFF");

    private final String ROLE_VALUE;

    RoleModel(String ROLE_VALUE) {
        this.ROLE_VALUE = ROLE_VALUE;
    }

    public static RoleModel parseRole(String roleValue) {
        RoleModel[] roleList = values();

        for (RoleModel temp : roleList) if (temp.ROLE_VALUE.equals(roleValue)) return temp;
        return null;
    }
}
