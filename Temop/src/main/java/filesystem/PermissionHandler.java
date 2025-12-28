package filesystem;

public interface PermissionHandler {
    boolean checkPermission(String permission);
    void setPermission(String Permission, Boolean value);
}
