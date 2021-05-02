package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;
import com.simbirsoft.projectManager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление задачами")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить задачу по id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> getProjectById(@PathVariable String id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/")
    public ResponseEntity<TaskAddResponse> addTask(TaskRequest request) {
        return new ResponseEntity<>(taskService.addTask(request), HttpStatus.OK);
    }

    @Operation(summary = "Обновить информацию о задаче")
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskUpdateResponse> updateProject(@PathVariable String id,
                                                            TaskRequest request) {
        return new ResponseEntity<>(taskService.updateTask(id, request), HttpStatus.OK);
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TaskDeleteResponse> deleteTask(@PathVariable String id) {
        return new ResponseEntity<>(taskService.deleteTask(id), HttpStatus.OK);
    }
}
