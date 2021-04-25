package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.ProjectRequest;
import com.simbirsoft.projectManager.dto.response.projects.ProjectResponse;
import com.simbirsoft.projectManager.exception.ProjectNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Tag(name = "Управление проектом")
@RestController
@RequestMapping("api/projects")
public class ProjectController {

    //временное хранилище
    //TODO: создать сервисы и убрать все лишнее из контроллера
    private final Map<Integer, ProjectResponse> repository;


    public ProjectController(Map<Integer, ProjectResponse> repository) {
        this.repository = repository;
    }

    public ProjectController() {
        repository = new HashMap<>();
    }

    @Operation(summary = "Получить список проектов")
    @GetMapping(value = "/")
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        // TODO: запрашивать все экземпляры проектов из БД
        if (repository == null) throw new ProjectNotFoundException();
        ArrayList<ProjectResponse> responses = new ArrayList<>(repository.values());
        return ResponseEntity.ok().body(responses);
    }

    @Operation(summary = "Получить проект по id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable("id") int id) {
        // TODO: запрашивать проект по id из БД
        //TODO: добавить выброс исключения, если запись не найдена
        if (repository == null) throw new ProjectNotFoundException();
        return ResponseEntity.ok(repository.get(id));
    }

    @Operation(summary = "Добавить проект")
    @PostMapping(value = "/")
    public ResponseEntity<ProjectResponse> addProject(@RequestBody ProjectRequest projectRequestDto) {
        //TODO: добавлять запись в БД
        ProjectResponse response = new ProjectResponse(
                projectRequestDto.getName(),
                projectRequestDto.getStatus(),
                projectRequestDto.getStartTime(),
                projectRequestDto.getReleaseTime());
        repository.put(projectRequestDto.getId(), response);
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Обновить данные о проекте")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@RequestBody ProjectRequest projectRequestDto) {
        //TODO: обновлять запись в БД
        //TODO: добавить выброс исключения, если запись не найдена
        ProjectResponse response = new ProjectResponse(
                projectRequestDto.getName(),
                projectRequestDto.getStatus(),
                projectRequestDto.getStartTime(),
                projectRequestDto.getReleaseTime());
        repository.put(projectRequestDto.getId(), response);
        return ResponseEntity.ok().body(new ProjectResponse());
    }

    @Operation(summary = "Удалить проект")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteProject(@PathVariable("id") int id) {
        //TODO: удалять запись из БД
        //TODO: добавить выброс исключения, если запись не найдена
        repository.remove(id);
        return ResponseEntity.ok().body(id);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ProjectResponse> handleException(IOException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}