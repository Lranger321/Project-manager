package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.ProjectUpdateResponse;

import java.util.UUID;

public interface ProjectService {

    ProjectResponse getById(String id);

    ProjectAddResponse addProject(ProjectRequest request);

    ProjectUpdateResponse updateProject(String id, ProjectRequest request);

    ProjectDeleteResponse deleteById(String id);


}
