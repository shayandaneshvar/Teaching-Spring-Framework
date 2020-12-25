package com.mapsa.controller;


import com.mapsa.dto.EmailDto;
import com.mapsa.model.User;
import com.mapsa.security.SecurityUtil;
import com.mapsa.services.UserServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
//@CrossOrigin({"localhost:4200","192.172.23.12"})
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

    @ResponseBody
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/current")
    public Object showCurrentUser() {
        return SecurityUtil.getCurrentUser();
    }

    @ResponseBody
    @GetMapping("/hello")
    @PreAuthorize("isAnonymous()")
//    @Secured()
//    @PostAuthorize("isAnonymous()")
    public String sayHello() {
        return "Hello, Please login/register";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(EmailDto emailDto) {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String sendOtp(EmailDto emailDto, BindingResult bindingResult) {
        userService.sendOtp(emailDto.getEmail());
        return "redirect:/login";
    }
}
