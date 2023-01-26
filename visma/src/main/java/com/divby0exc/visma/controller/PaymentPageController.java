package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.repository.VismaRepository;
import com.divby0exc.visma.service.VismaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receipt_page/*")
public class PaymentPageController {
    @Autowired
    VismaService vismaService;
    @Autowired
    VismaRepository repo;

    @GetMapping("new")
    public String showReceiptForm(Model model) {
        Receipt newReceipt = new Receipt();
        model.addAttribute("receipt", newReceipt);

        return "paymentPage";
    }

    @PostMapping("new")
    public String registerReceipt(HttpSession session, @ModelAttribute("receipt") Receipt receipt) {
        String username = (String) session.getAttribute("username");
        vismaService.registerReceipt(receipt, username);

        return "redirect:/visma/homepage";
    }

}

