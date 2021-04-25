package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectUpdateResponse;

public interface ProjectService {

    ProjectResponse getById(String id);

    ProjectAddResponse addProject(ProjectRequest request);

    ProjectUpdateResponse updateProject(String id, ProjectRequest request);

    ProjectDeleteResponse deleteById(String id);


}
