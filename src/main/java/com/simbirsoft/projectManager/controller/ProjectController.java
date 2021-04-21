package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.ProjectRequest;
import com.simbirsoft.projectManager.dto.ProjectResponse;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Tag(name = "Управление проектом")
@RestController
@RequestMapping("api/project")
public class ProjectController {

    private final Map<String, ProjectResponse> repository;

    public ProjectController(Map<String, ProjectResponse> repository) {
        this.repository = repository;
    }

    public ProjectController() {
        repository = null;
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/projects")
    public ResponseEntity<ProjectResponse> addProject(@RequestBody ProjectRequest projectRequestDto) {
        //TODO работа с БД

        return ResponseEntity.ok().body(new ProjectResponse());
    }

    @Operation(summary = "Обновить информацию о проекте")
    @PostMapping(value = "/projects/{id}")
    public ResponseEntity<ProjectResponse> setProject(@RequestBody ProjectRequest projectRequestDto) {
        //TODO работа с БД

        return ResponseEntity.ok().body(new ProjectResponse());
    }

    @GetMapping(value = "{key}")
    public ResponseEntity<ProjectResponse> getSimpleDto(@PathVariable("key") String key) {
        // TODO ?

        if (repository == null) throw new ProjectNotFoundException();

        return ResponseEntity.ok(repository != null ? repository.get(key) : null);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
