package com.simbirsoft.projectManager.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProjectToUserID implements Serializable {
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="project_id", nullable=false)
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;

    public ProjectToUserID() {

    }

    public ProjectToUserID(ProjectEntity project, UserEntity user) {
        this.project = project;
        this.user = user;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ProjectToUserID && ((ProjectToUserID) obj).project.equals(this.project) &&
                ((ProjectToUserID) obj).user.equals(this.user);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
