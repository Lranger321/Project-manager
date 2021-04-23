package com.simbirsoft.projectManager.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Управление задачами")
@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Operation(summary = "Добавить задачу")
    @PostMapping(value = "/")
    public ResponseEntity addProject() {

        return null;
    }

    @Operation(summary = "Обновить информацию о задаче")
    @PutMapping(value = "/")
    public ResponseEntity setProject() {

        return null;
    }


}
