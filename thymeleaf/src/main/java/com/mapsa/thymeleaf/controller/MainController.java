package com.mapsa.thymeleaf.controller;

import com.mapsa.thymeleaf.model.User;
import com.mapsa.thymeleaf.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    private final UserServiceImpl userService;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(User user) {
        return "new-user";
    }

    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-user";
        }
        userService.saveUser(user);
        return "redirect:/";
//        return "forward:/";
    }

    @GetMapping({"/", "/index", "/index.html"})
    public String index(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("userList", /*userList.isEmpty() ? null :*/ userList);
        return "index";
    }


    // TODO: 11/20/2020 Delete Mapping
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }
}
