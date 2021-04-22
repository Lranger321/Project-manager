package com.simbirsoft.projectManager.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "release")
public class ReleaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String version;

    @Column(name="date_start")
    private LocalDateTime dateStart;

    @Column(name="date_end")
    private LocalDateTime dateEnd;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProjectEntity project;

    @OneToMany(mappedBy = "release", cascade = CascadeType.ALL)
    private List<TaskEntity> taskEntities = new ArrayList<>();

    public ReleaseEntity () {

    }

    public ReleaseEntity(String version, LocalDateTime dateStart, LocalDateTime dateEnd, ProjectEntity project) {
        this.version = version;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.project = project;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
