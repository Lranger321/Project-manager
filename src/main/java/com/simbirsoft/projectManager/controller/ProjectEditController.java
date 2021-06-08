package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.ProjectStatus;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.UUID;

/**
 * Контроллер для страницы редактирования проекта
 */
@Controller
public class ProjectEditController {

    private static final Logger logger = LoggerFactory.getLogger(ProjectEditController.class);

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectEditController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/project/edit/{id}")
    public String projectEditPage(@PathVariable("id") UUID id, Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());
        logger.info("Project id: {}", id);
        Project bufProject = new Project();
        if (projectRepository.findById(id).isPresent()) {
            bufProject = projectRepository.findById(id).get();
        }
        model.addAttribute("project", bufProject);
        model.addAttribute("projectStatuses", ProjectStatus.values());
        return "projectedit";
    }

    @PostMapping("/save/project")
    public String save(Project project) {
        projectRepository.save(project);
        return "redirect:/";
    }

}
