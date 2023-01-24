package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Registrator;
import com.divby0exc.visma.service.Authentication;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/authentication/*")
public class AuthController {
    @Autowired
    Authentication auth;
    @Autowired
    DataSource dataSource;

    @GetMapping("login")
    public String whyMustIDoThis() {return "loginPage";}
    @GetMapping("register")
    public String whyMustIDoThis2() {return "registerPage";}

    @PostMapping("login")
    public String login(HttpSession session, RedirectAttributes redirect, @ModelAttribute Registrator userDetails) {

        if(session.getAttribute("username") != null) {
            return "redirect:/visma/homepage";

        } else if(userDetails.getUsr() != null) {
            session.setMaxInactiveInterval(60 * 30);
            session.setAttribute("username", userDetails.getUsr());

            return "redirect:/visma/homepage";
        }

        redirect.addAttribute("invalid", "Invalid username or password. Please try again");

        return "redirect:login";
    }

    @PostMapping("register")
    public String register(HttpSession session, @ModelAttribute Registrator userDetails) {

        auth.validateUser(userDetails);


        return "redirect:login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/authentication/login";
    }
}
