package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.dto.response.GetUserResponse;
import com.simbirsoft.projectManager.dto.response.ProjectResponse;
import com.simbirsoft.projectManager.entity.ProjectEntity;
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

    public GetUserResponse convertToUserResponse(UserEntity entity){
        return new GetUserResponse();
    }

    public UserEntity convertToUserEntity(UserEntity user,UserRegisterRequest request){
        return new UserEntity();
    }

}
