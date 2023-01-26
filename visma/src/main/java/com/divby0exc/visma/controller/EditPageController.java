package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.service.VismaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/edit_page/*")
public class EditPageController {

    @Autowired
    VismaService vismaService;

    @GetMapping("receipt/{id}")
    public String editInvoice(@PathVariable("id") int id, Model model) {
        Receipt editReceipt = vismaService.findReceiptById(id);
        model.addAttribute("receipt", editReceipt);

        return "editPage";
    }

    @PostMapping
    public String saveReceipt(@ModelAttribute Receipt receipt) {
        vismaService.editReceipt(receipt);

        return "redirect:/visma/homepage";
    }
}
