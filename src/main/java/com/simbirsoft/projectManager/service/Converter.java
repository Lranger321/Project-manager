package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.entity.ProjectEntity;
import com.simbirsoft.projectManager.entity.TaskEntity;
import com.simbirsoft.projectManager.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public ProjectResponse convertToProjectResponse(ProjectEntity project){
        return new ProjectResponse();
    }

    public ProjectEntity convertToProjectEntity(ProjectRequest request){
        return new ProjectEntity();
    }

    public ProjectEntity convertToProjectEntity(ProjectEntity project, ProjectRequest request){

        return project;
    }

    public UserEntity convertToUserEntity(UserRegisterRequest request){
        return new UserEntity();
    }

    public UserResponse convertToUserResponse(UserEntity entity){
        return new UserResponse();
    }

    public UserEntity convertToUserEntity(UserEntity user,UserRegisterRequest request){
        return new UserEntity();
    }

    public TaskResponse convertToTaskResponse(TaskEntity taskEntity) {
        return null;
    }

    public TaskEntity convertToTaskEntity(TaskEntity taskEntity, TaskRequest request) {
        return taskEntity;
    }

    public TaskEntity convertToTaskEntity(TaskRequest request) {
        return null;
    }
}
