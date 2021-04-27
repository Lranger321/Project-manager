package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectUpdateResponse;
import com.simbirsoft.projectManager.service.impl.ProjectServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Управление проектом")
@RestController
@RequestMapping("api/projects")
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Получить список проектов")
    @GetMapping(value = "/")
    public List<ProjectResponse> getAllProjects() {
        return null;
    }

    @Operation(summary = "Получить проект по id")
    @GetMapping(value = "/{id}")
    public ProjectResponse getProjectById(@PathVariable("id") String id) {
        return projectService.getById(id);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/")
    public ProjectAddResponse addProject(@RequestBody ProjectRequest request) {
        return projectService.addProject(request);
    }

    @Operation(summary = "Обновить данные о проекте")
    @PutMapping(value = "/{id}")
    public ProjectUpdateResponse updateProject(@PathVariable String id, @RequestBody ProjectRequest request) {
        return projectService.updateProject(id, request);
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ProjectDeleteResponse deleteProject(@PathVariable("id") String id) {
        return projectService.deleteById(id);
    }

}