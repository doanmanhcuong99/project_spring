package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public String showList(Model model) {
        model.addAttribute("list", studentService.getList(1, 10));
        return "list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String storeStudent(@Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        studentService.create(student);
        return "success";
    }

}
