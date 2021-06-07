package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.rest.dto.request.ChangeProjectStatusRequest;
import com.simbirsoft.projectManager.rest.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.rest.dto.response.ProjectResponse;


import java.util.List;
import java.util.UUID;

public interface ProjectService {

    ProjectResponse getById(String id);

    List<ProjectResponse> getByUsername(String username);

    UUID addProject(ProjectRequest request);

    boolean updateProject(String id, ProjectRequest request);

    boolean deleteById(String id);

    boolean changeStatus(ChangeProjectStatusRequest request);

}
