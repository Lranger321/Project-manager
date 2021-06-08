package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.entity.ProjectStatus;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.repository.ProjectToUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

/**
 * Контроллер для основной страницы приложения, что открывается пользователю после логина
 */
@Controller
public class IndexPageController {

    private static final Logger logger = LoggerFactory.getLogger(IndexPageController.class);

    private final ProjectRepository projectRepository;
    private final ProjectToUserRepository projectToUserRepository;

    @Autowired
    public IndexPageController(ProjectRepository projectRepository, ProjectToUserRepository projectToUserRepository) {
        this.projectRepository = projectRepository;
        this.projectToUserRepository = projectToUserRepository;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());
        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("project", new Project());
        return "index";
    }

    @GetMapping("/findOne")
    @ResponseBody
    public Project findOne(String id) {
        return projectRepository.findById(UUID.fromString(id)).get();
    }

    @PostMapping
    public String newProject(Project project, Principal principal) {
        logger.info("User name: {}", principal.getName());
        project.setStatus(ProjectStatus.NOT_STARTED);
        project.setDateStart(LocalDateTime.now());
        projectRepository.save(project);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable("id") UUID id) {
        logger.info("project id: {}", id);
        projectRepository.deleteById(id);
        return "redirect:/";
    }
}