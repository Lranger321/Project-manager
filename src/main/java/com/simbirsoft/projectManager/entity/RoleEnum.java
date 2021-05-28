package com.simbirsoft.projectManager.entity;

public enum RoleEnum {
    ADMIN,
    USER;

//  ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE)),
//  USER(Set.of(Permission.DEVELOPERS_READ));
//
//  private final Set<Permission> permissions;
//
//  Role(Set<Permission> permissions) {
//    this.permissions = permissions;
//
//  }
//
//  public Set<SimpleGrantedAuthority> getAuthorities() {
//        return getPermissions().stream()
//            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
//            .collect(Collectors.toSet());
//  }

    @Override
    public String toString() {
        switch (this) {
            case ADMIN:
                return "admin";
            case USER:
                return "user";
            default:
                return "";

        }
    }
}
