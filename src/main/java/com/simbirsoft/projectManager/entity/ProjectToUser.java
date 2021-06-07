package com.simbirsoft.projectManager.entity;

import javax.persistence.*;

@IdClass(ProjectToUserId.class)
@Entity
@Table(name = "project_to_user")
public class ProjectToUser {

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    public ProjectToUser() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
