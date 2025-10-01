package exercise1.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Permission basicUser = new BasicUser();
        System.out.println("Basic User Access: " + basicUser.getAccess());

        Permission adminUser = new AdminAccess(basicUser);
        System.out.println("Admin User Access: " + adminUser.getAccess());

        Permission editorUser = new EditorAccess(basicUser);
        System.out.println("Editor User Access: " + editorUser.getAccess());

        Permission adminEditorUser = new EditorAccess(adminUser);
        System.out.println("Admin + Editor User Access: " + adminEditorUser.getAccess());
    }
}
