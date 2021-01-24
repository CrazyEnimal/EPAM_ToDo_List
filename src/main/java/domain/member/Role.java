package domain.member;

public enum Role {
    SUPERUSER, USER, GUEST;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
