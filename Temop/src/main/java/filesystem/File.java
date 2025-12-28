package filesystem;

import java.io.IOException;
import java.nio.CharBuffer;

public class File implements FileSystemEntity, Readable, Writeable {
    private String name;
    private String path;
    private Metdata metdata;

    public File(String name, String path, Metdata metdata) {
        this.name = name;
        this.path = path;
        this.metdata = metdata;
    }

    @Override
    public void move(String path) {

    }

    @Override
    public void delete() {

    }

    @Override
    public String getPath() {
        return "";
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void write(String data) {

    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        return 0;
    }
}
