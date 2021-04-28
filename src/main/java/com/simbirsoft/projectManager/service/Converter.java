package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.users.UserResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.entity.User;
import org.springframework.stereotype.Service;

@Service
public class Converter {

    public ProjectResponse convertToProjectResponse(Project project){
        return new ProjectResponse();
    }

    public Project convertToProjectEntity(ProjectRequest request){
        return new Project();
    }

    public Project convertToProjectEntity(Project project, ProjectRequest request){

        return project;
    }

    public User convertToUserEntity(UserRegisterRequest request){
        return new User();
    }

    public UserResponse convertToUserResponse(User entity){
        return new UserResponse();
    }

    public User convertToUserEntity(User user, UserRegisterRequest request){
        return new User();
    }

    public TaskResponse convertToTaskResponse(Task task) {
        return null;
    }

    public Task convertToTaskEntity(Task task, TaskRequest request) {
        return task;
    }

    public Task convertToTaskEntity(TaskRequest request) {
        return null;
    }
}
