package co.edu.udistrital.proxy;

public class User {
    private final String username;
    private final RoleType role;

    public User(String username, RoleType role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public RoleType getRole() {
        return role;
    }

    public boolean isAdmin() {
        return role == RoleType.ADMIN;
    }
}