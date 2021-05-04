package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.ProjectResponse;

import java.util.UUID;

public interface ProjectService {

    ProjectResponse getById(String id);

    UUID addProject(ProjectRequest request);

    boolean updateProject(String id, ProjectRequest request);

    boolean deleteById(String id);

}
