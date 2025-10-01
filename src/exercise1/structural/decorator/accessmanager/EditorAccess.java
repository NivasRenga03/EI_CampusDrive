package exercise1.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class EditorAccess extends AccessDecorator {

    public EditorAccess(Permission user) {
        super(user);
    }

    @Override
    public List<String> getAccess() {
        List<String> access = new ArrayList<>(user.getAccess());
        access.add("edit");
        return access;
    }
}
