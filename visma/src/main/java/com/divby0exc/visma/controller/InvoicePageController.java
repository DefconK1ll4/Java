package com.divby0exc.visma.controller;

import com.divby0exc.visma.model.Invoice;
import com.divby0exc.visma.model.InvoiceList;
import com.divby0exc.visma.repository.VismaRepository;
import com.divby0exc.visma.service.VismaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.sql.SQLException;

import static java.time.LocalTime.now;

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
        System.out.println(username + " got from session");

        Invoice invoice = new Invoice();
        invoice.setTitle("Blood in Blood out");
        invoice.setCategory("Criminal");
        invoice.setDescription("Brothers divided by fate");
        invoice.setPrice(98946.43);

        repo.addInvoice(invoice, username);

        InvoiceList invoices = vismaService.showAllInvoices(username);

//        if(invoices.getInvoices().size()==0) {
//            model.addAttribute("invoices", "NoData");
 //       } else {
            model.addAttribute("invoices", invoices.getInvoices());
 ///       }
        model.addAttribute("loggedInAs", username);


        return "invoicePage";
    }

}
