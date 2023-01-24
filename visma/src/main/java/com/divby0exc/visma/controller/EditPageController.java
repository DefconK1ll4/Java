package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Invoice;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("edit")
public class EditPageController {

    @GetMapping
    public String editInvoice(HttpSession session, RedirectAttributes redirect, @ModelAttribute Invoice invoice) {

        return "editPage";
    }
}
