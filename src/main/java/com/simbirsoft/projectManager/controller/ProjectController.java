package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectAddResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectDeleteResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.dto.response.projects.ProjectUpdateResponse;
import com.simbirsoft.projectManager.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление проектом")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Получить проект по id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable("id") String id) {
        return new ResponseEntity<>(projectService.getById(id), HttpStatus.OK);
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/")
    public ResponseEntity<ProjectAddResponse> addProject(ProjectRequest request) {
        return new ResponseEntity<>(projectService.addProject(request), HttpStatus.OK);
    }

    @Operation(summary = "Обновить данные о проекте")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectUpdateResponse> updateProject(@PathVariable String id,
                                                               ProjectRequest request) {
        return new ResponseEntity<>(projectService.updateProject(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ProjectDeleteResponse> deleteProject(@PathVariable("id") String id) {
        return new ResponseEntity<>(projectService.deleteById(id), HttpStatus.OK);
    }

}