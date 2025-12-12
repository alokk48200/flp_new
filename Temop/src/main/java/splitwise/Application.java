package splitwise;

import java.util.ArrayList;

public class Application {
    private static Application instance = null;
    private ArrayList<User>users;
    private ArrayList<Group>groups;

    private Application(){
        users = new ArrayList<>();
        groups = new ArrayList<>();

    }
    public static Application getInstance(){
        if(instance == null){
            synchronized (Application.class){
                if(instance ==null){
                    instance = new Application();
                }
            }
        }
        return instance;
    }

    public void addGroup(Group group){
        if(groups.contains(group)){
           throw new RuntimeException("this group is exist");
        }
        groups.add(group);
    }


}
