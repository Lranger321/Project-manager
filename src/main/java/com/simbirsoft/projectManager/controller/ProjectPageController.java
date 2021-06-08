package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.Task;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.repository.TaskRepository;
import com.simbirsoft.projectManager.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.UUID;

/**
 * Контроллер для страницы с информацией о проекте
 */
@Controller
public class ProjectPageController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectPageController.class);

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final ProjectService projectService;

    @Autowired
    public ProjectPageController(ProjectRepository projectRepository, TaskRepository taskRepository, ProjectService projectService) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.projectService = projectService;
    }

    @GetMapping("/project/{id}")
    public String projectPage(@PathVariable("id") UUID id, Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());
        logger.info("Project id: {}", id);
        Project bufProject = new Project();
        if (projectRepository.findById(id).isPresent()) {
            bufProject = projectRepository.findById(id).get();
        }
        model.addAttribute("project", bufProject);
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("task", new Task());
        return "project";
    }

    @PostMapping("/createTask/{id}")
    public String newTask(@PathVariable("id") UUID id, Task task, Principal principal) {
        logger.info("User name: {}", principal.getName());
        logger.info("Project id: {}", id);
        task.setProject(projectRepository.findById(id).get());
        taskRepository.save(task);
        return "redirect:/project/" + id;
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable("id") UUID id) {
        logger.info("task id: {}", id);
        taskRepository.deleteById(id);
        return "redirect:/";
    }
}
