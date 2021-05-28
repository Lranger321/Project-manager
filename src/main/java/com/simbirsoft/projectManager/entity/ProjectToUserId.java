package com.simbirsoft.projectManager.entity;

import java.io.Serializable;

public class ProjectToUserId implements Serializable {


    private User user;

    private Project project;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
