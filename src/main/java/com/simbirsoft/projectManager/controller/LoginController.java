package com.simbirsoft.projectManager.controller;

import com.simbirsoft.projectManager.rest.dto.request.UserRegisterRequest;
import com.simbirsoft.projectManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(@Valid @ModelAttribute("user") UserRegisterRequest userRegisterRequest,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (!userRegisterRequest.getPassword().equals(userRegisterRequest.getRepeatPassword())) {
            bindingResult.rejectValue("password", "", "Пароли не совпадают");
            return "register";
        }

        userService.registerUser(userRegisterRequest);
        return "redirect:/login";
    }
}
