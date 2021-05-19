package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.entity.Project;
import com.simbirsoft.projectManager.repository.ProjectRepository;
import com.simbirsoft.projectManager.repository.UserRepository;
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

@Controller
public class IndexPageController {

    private static final Logger logger = LoggerFactory.getLogger(IndexPageController.class);

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    @Autowired
    public IndexPageController(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public String indexPage(Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());

        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("project", new Project());
        //model.addAttribute("items", projectRepository.findByUserUsername(principal.getName()));
        //model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @GetMapping("/{id}")
    public String ProjectPage(Model model, Principal principal) {
        logger.info("User name: {}", principal.getName());

        model.addAttribute("projects", projectRepository.findAll());
        model.addAttribute("project", new Project());
        //model.addAttribute("items", projectRepository.findByUserUsername(principal.getName()));
        //model.addAttribute("item", new ShoppingItem());
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