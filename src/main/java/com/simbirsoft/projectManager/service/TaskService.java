package com.simbirsoft.projectManager.service;

import com.simbirsoft.projectManager.dto.request.TaskRequest;
import com.simbirsoft.projectManager.dto.response.tasks.TaskAddResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskDeleteResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskResponse;
import com.simbirsoft.projectManager.dto.response.tasks.TaskUpdateResponse;

public interface TaskService {

    TaskResponse getTaskById(String id);

    TaskAddResponse addTask(TaskRequest request);

    TaskUpdateResponse updateTask(String id, TaskRequest request);

    TaskDeleteResponse deleteTask(String id);

}
