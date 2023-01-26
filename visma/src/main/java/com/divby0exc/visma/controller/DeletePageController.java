package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.service.VismaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/delete_page/*")
public class DeletePageController {

    @Autowired
    VismaService vismaService;

    @GetMapping("receipt/{id}")
    public String deleteReceipt(@PathVariable("id") int id) {
        vismaService.deleteReceipt(id);

        return "redirect:/visma/homepage";
    }
}
