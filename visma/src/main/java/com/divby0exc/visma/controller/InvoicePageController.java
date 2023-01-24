package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.InvoiceList;
import com.divby0exc.visma.repository.VismaRepository;
import com.divby0exc.visma.service.VismaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

@Controller
@RequestMapping("/visma/*")
public class InvoicePageController {
    @Autowired
    VismaRepository repo;
    @Autowired
    VismaService vismaService;

    @GetMapping("homepage")
    public String showAllInvoices(Model model, HttpSession session) throws SQLException {
        String username = (String) session.getAttribute("username");
        /***
        InvoiceList invoices = vismaService.showAllInvoices(username);

        model.addAttribute("invoices", "Logged in as: " + vismaService.showAllInvoices(username));
        model.addAttribute("loggedInAs", username);
        ***/

        return "invoicePage";
    }

}
