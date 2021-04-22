package com.simbirsoft.projectManager.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="project_to_user")
public class ProjectToUserEntity {
    @EmbeddedId
    private ProjectToUserID projectToUserID;

    private String role;

    public ProjectToUserEntity () {

    }

    public ProjectToUserEntity(ProjectToUserID projectToUserID, String role) {
        this.projectToUserID = projectToUserID;
        this.role = role;
    }

    public ProjectToUserID getProjectToUserID() {
        return projectToUserID;
    }

    public void setProjectToUserID(ProjectToUserID projectToUserID) {
        this.projectToUserID = projectToUserID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
