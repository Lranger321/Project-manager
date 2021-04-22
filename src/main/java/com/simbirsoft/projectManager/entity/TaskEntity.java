package com.simbirsoft.projectManager.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private TaskStatus status;

    private String priority;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ReleaseEntity release;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private UserEntity user;

    public TaskEntity () {

    }

    public TaskEntity(String name, String description, TaskStatus status, String priority,
                      ProjectEntity project, ReleaseEntity release, UserEntity user) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.project = project;
        this.release = release;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public ReleaseEntity getRelease() {
        return release;
    }

    public void setRelease(ReleaseEntity release) {
        this.release = release;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
