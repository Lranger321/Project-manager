package com.simbirsoft.projectManager.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String email;

    private String password;

    @Column(name="date_register")
    private LocalDateTime dateRegister;

    @Column(name="full_name")
    private String fullName;

    @OneToMany(mappedBy = "projectToUserID.user", cascade = CascadeType.ALL)
    private List<ProjectToUserEntity> projectToUserEntities = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TaskEntity> taskEntities = new ArrayList<>();

    public UserEntity () {

    }

    public UserEntity(String email, String password, LocalDateTime dateRegister, String fullName) {
        this.email = email;
        this.password = password;
        this.dateRegister = dateRegister;
        this.fullName = fullName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(LocalDateTime dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<ProjectToUserEntity> getProjectToUserEntities() {
        return projectToUserEntities;
    }

    public void setProjectToUserEntities(List<ProjectToUserEntity> projectToUserEntities) {
        this.projectToUserEntities = projectToUserEntities;
    }

    public List<TaskEntity> getTaskEntities() {
        return taskEntities;
    }

    public void setTaskEntities(List<TaskEntity> taskEntities) {
        this.taskEntities = taskEntities;
    }
}
