package exercise1.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class AdminAccess extends AccessDecorator {

    public AdminAccess(Permission user) {
        super(user);
    }

    @Override
    public List<String> getAccess() {
        List<String> access = new ArrayList<>(user.getAccess());
        access.add("create");
        access.add("delete");
        return access;
    }
}
