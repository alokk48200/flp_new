package filesystem;

import java.util.List;

public class Directory implements DirectoryOperation{
    @Override
    public List<FileSystemEntity> listContents() {
        return List.of();
    }

    @Override
    public void addEntity(FileSystemEntity fileSystemEntity) {

    }

    @Override
    public void RemoveEntity(FileSystemEntity fileSystemEntity) {

    }

    @Override
    public FileSystemEntity getEntity(String name) {
        return null;
    }
}
