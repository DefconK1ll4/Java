package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.ReceiptList;
import com.divby0exc.visma.repository.VismaRepository;
import com.divby0exc.visma.service.VismaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;

import static java.time.LocalTime.now;

@Controller
@RequestMapping("/visma")
public class InvoicePageController {
    @Autowired
    VismaService vismaService;

    @GetMapping("/homepage")
    public String showAllInvoices(Model model, HttpSession session) throws SQLException {
        String username = (String) session.getAttribute("username");
        System.out.println(username + " got from session");

        ReceiptList receiptList = vismaService.showAllRecipes(username);

//        if(receiptList.getInvoices().size()==0) {
//            model.addAttribute("receiptList", "NoData");
 //       } else {
            model.addAttribute("receipt", receiptList.getRecipes());
 ///       }
        model.addAttribute("loggedInAs", username);


        return "receiptPage";
    }

}
