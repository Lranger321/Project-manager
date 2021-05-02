package com.simbirsoft.projectManager.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "release")
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String version;

    @Column(name="date_start")
    private LocalDateTime dateStart;

    @Column(name="date_end")
    private LocalDateTime dateEnd;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Project project;

    @OneToMany(mappedBy = "release", cascade = CascadeType.ALL)
    private List<Task> taskEntities = new ArrayList<>();

    public Release() {

    }

    public Release(String version, LocalDateTime dateStart, LocalDateTime dateEnd, Project project) {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<Task> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
