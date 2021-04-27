package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;
import com.simbirsoft.projectManager.service.impl.TaskServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление задачами")
@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Получить проект по id")
    @GetMapping(value = "/{id}")
    public TaskResponse getProjectById(@PathVariable("id") String id) {
        return taskService.getTaskById(id);
    }

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/")
    public TaskAddResponse addTask(TaskRequest request) {
        return taskService.addTask(request);
    }

    @Operation(summary = "Обновить информацию о задаче")
    @PutMapping(value = "/{id}")
    public TaskUpdateResponse updateProject(@PathVariable String id, TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @Operation(summary = "Удалить задачу")
    @DeleteMapping(value = "/{id}")
    public TaskDeleteResponse deleteTask(@PathVariable("id") String id) {
        return taskService.deleteTask(id);
    }


}
