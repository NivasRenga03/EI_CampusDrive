package exercise1.structural.decorator;

import java.util.ArrayList;
import java.util.List;

public class BasicUser implements Permission {

    @Override
    public List<String> getAccess() {
        List<String> access = new ArrayList<>();
        access.add("read");
        return access;
    }
}
