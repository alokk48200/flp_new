package filesystem;

public interface FileSystemEntity {
    void move(String path);
    void delete();
    String getPath();
    String getName();
}
