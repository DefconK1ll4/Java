package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Registrator;
import com.divby0exc.visma.service.Authentication;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/authentication/*")
public class AuthController {
    @Autowired
    Authentication auth;

    @GetMapping("login")
    public String showLoginPage() {return "newLoginPage";}
    @GetMapping("register")
    public String showRegisterPage() {return "newRegisterPage";}

    @PostMapping("login")
    public String login(HttpSession session, RedirectAttributes redirect, @ModelAttribute Registrator userDetails) {

        if(session.getAttribute("username") != null) {
            return "redirect:/visma/homepage";

        } else if(userDetails.getUsr() != null) {
            if(auth.authenticateUser(userDetails)) {

                session.setMaxInactiveInterval(60 * 30);
                session.setAttribute("username", userDetails.getUsr());

                return "redirect:/visma/homepage";
            } else {
                redirect.addAttribute("invalid", "Invalid username or password. Please try again");
            }
        }

        return "redirect:login";
    }
    @PostMapping("register")
    public String register(HttpSession session, RedirectAttributes redirect, @ModelAttribute Registrator userDetails) {

        String msg = auth.validateNewUser(userDetails);
        if(msg.equalsIgnoreCase("success")) {
            return "redirect:login";
        }
        redirect.addAttribute("invalid", msg);

        return "redirect:register";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/authentication/login";
    }
}
