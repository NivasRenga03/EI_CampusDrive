package exercise1.structural.decorator;

import java.util.List;

public abstract class AccessDecorator implements Permission {
    protected Permission user;

    public AccessDecorator(Permission user) {
        this.user = user;
    }

    @Override
    public abstract List<String> getAccess();
}
