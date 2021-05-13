package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.ChangeProjectStatusRequest;
import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.ProjectResponse;
import com.simbirsoft.projectManager.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Управление проектом")
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(summary = "Получить проект по id")
    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable("id") String id) {
        return ResponseEntity.ok(projectService.getById(id));
    }

    @Operation(summary = "Добавить проект")
    @PostMapping("/")
    public ResponseEntity<UUID> addProject(@RequestBody ProjectRequest request) {
        return ResponseEntity.ok(projectService.addProject(request));
    }

    @Operation(summary = "Обновить данные о проекте")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProject(@PathVariable String id,
                                                 @RequestBody ProjectRequest request) {
        return ResponseEntity.ok(projectService.updateProject(id, request));
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable("id") String id) {
        return ResponseEntity.ok(projectService.deleteById(id));
    }

    @Operation(summary = "Изменить статус проекта")
    @PostMapping("/changeStatus")
    public ResponseEntity<Boolean> changeStatus(@RequestBody ChangeProjectStatusRequest request) {
        return ResponseEntity.ok(projectService.changeStatus(request));
    }

}