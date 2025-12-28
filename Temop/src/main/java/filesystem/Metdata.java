package filesystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Metdata {
    private LocalDateTime creationDate;
    private LocalDateTime updationdate;
    private String Owner;
    private Set<String>permission;

    public Metdata(String owner, Set<String> permission) {
        Owner = owner;
        this.permission = permission;
        this.creationDate = LocalDateTime.now();
        this.updationdate = LocalDateTime.now();
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdationdate() {
        return updationdate;
    }

    public void setUpdationdate(LocalDateTime updationdate) {
        this.updationdate = updationdate;
    }

    public Set<String> getPermission() {
        return permission;
    }

    public void setPermission(Set<String> permission) {
        this.permission = permission;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }
}
