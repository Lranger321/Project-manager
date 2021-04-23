package com.simbirsoft.projectManager.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 12)
    private ProjectStatus status;

    @Column(name = "date_start")
    private LocalDateTime dateStart;

    @Column(name = "date_end")
    private LocalDateTime dateEnd;

    @OneToMany(mappedBy = "projectToUserID.project", cascade = CascadeType.ALL)
    private List<ProjectToUserEntity> projectToUserEntities = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ReleaseEntity> releaseEntities = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<TaskEntity> taskEntities = new ArrayList<>();

    public ProjectEntity() {
    }

    public ProjectEntity(String name, ProjectStatus status, LocalDateTime dateStart, LocalDateTime dateEnd) {
        this.name = name;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
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

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public List<ProjectToUserEntity> getProjectToUserEntities() {
        return projectToUserEntities;
    }

    public void setProjectToUserEntities(List<ProjectToUserEntity> projectToUserEntities) {
        this.projectToUserEntities = projectToUserEntities;
    }

    public List<ReleaseEntity> getReleaseEntities() {
        return releaseEntities;
    }

    public void setReleaseEntities(List<ReleaseEntity> releaseEntities) {
        this.releaseEntities = releaseEntities;
    }

    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
