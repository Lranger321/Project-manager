package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.repository.ProjectRepository;
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
 * Контроллер для основной страницы приложения, что открывается пользователю после логина
 */
@Controller
public class IndexPageController {

    private static final Logger logger = LoggerFactory.getLogger(IndexPageController.class);

    private final ProjectService projectService;
    private final ProjectRepository projectRepository;

    @Autowired
    public IndexPageController(ProjectRepository projectRepository, ProjectService projectService) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());

        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("project", new Project());
        return "index";
    }

    @PostMapping
    public String newProject(Project project, Principal principal) {
        logger.info("User name: {}", principal.getName());
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