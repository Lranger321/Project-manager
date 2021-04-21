package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import com.simbirsoft.projectManager.rest.dto.ProjectRequestDto;
import com.simbirsoft.projectManager.rest.dto.ProjectResponseDto;
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

    private final Map<String, ProjectResponseDto> repository;

    public ProjectController(Map<String, ProjectResponseDto> repository) {
        this.repository = repository;
    }

    public ProjectController() {
        repository = null;
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/projects")
    public ResponseEntity<ProjectResponseDto> addProject(@RequestBody ProjectRequestDto projectRequestDto) {
        //TODO работа с БД

        return ResponseEntity.ok().body(new ProjectResponseDto());
    }

    @Operation(summary = "Обновить информацию о проекте")
    @PostMapping(value = "/projects/{id}")
    public ResponseEntity<ProjectResponseDto> setProject(@RequestBody ProjectRequestDto projectRequestDto) {
        //TODO работа с БД

        return ResponseEntity.ok().body(new ProjectResponseDto());
    }

    @GetMapping(value = "{key}")
    public ResponseEntity<ProjectResponseDto> getSimpleDto(@PathVariable("key") String key) {
        // TODO ?

        if (repository == null ) throw new ProjectNotFoundException();

        return ResponseEntity.ok(repository != null ? repository.get(key) : null);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleException(IOException e) {
        //
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

}
