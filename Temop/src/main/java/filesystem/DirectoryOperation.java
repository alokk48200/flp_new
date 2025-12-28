package filesystem;

import java.util.List;

public interface DirectoryOperation {
    List<FileSystemEntity> listContents();
    void addEntity(FileSystemEntity fileSystemEntity);
    void RemoveEntity(FileSystemEntity fileSystemEntity);
    FileSystemEntity getEntity(String name);
}
