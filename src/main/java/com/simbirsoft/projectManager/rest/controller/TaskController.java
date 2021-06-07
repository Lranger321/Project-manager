package com.simbirsoft.projectManager.rest.controller;

import com.simbirsoft.projectManager.rest.dto.request.ChangeTaskStatusRequest;
import com.simbirsoft.projectManager.rest.dto.request.TaskRequest;
import com.simbirsoft.projectManager.rest.dto.response.TaskResponse;
import com.simbirsoft.projectManager.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Управление задачами")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить задачу по id")
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getProjectById(@PathVariable String id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping("/")
    public ResponseEntity<UUID> addTask(@RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.addTask(request));
    }

    @Operation(summary = "Обновить информацию о задаче")
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateProject(@PathVariable String id,
                                                 @RequestBody TaskRequest request) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable String id) {
        return ResponseEntity.ok(taskService.deleteTask(id));
    }

    @Operation(summary = "Изменить статус задачи")
    @PostMapping("/changeStatus")
    public ResponseEntity<Boolean> changeStatus(@RequestBody ChangeTaskStatusRequest request){
        return ResponseEntity.ok(taskService.changeStatus(request));
    }

}
