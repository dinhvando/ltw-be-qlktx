package dodv.dormitorymanagement.demo.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student:read"),
    FOOD_LAUNDRY_REGISTER("student: FOOD_LAUNDRY_REGISTER"),
    OTHER("Other");
    private final String permission;
    ApplicationUserPermission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
