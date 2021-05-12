package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.ChangeTaskStatusRequest;
import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.TaskResponse;

import java.util.UUID;

public interface TaskService {

    TaskResponse getTaskById(String id);

    UUID addTask(TaskRequest request);

    boolean updateTask(String id, TaskRequest request);

    boolean deleteTask(String id);

    boolean changeStatus(ChangeTaskStatusRequest request);

}
