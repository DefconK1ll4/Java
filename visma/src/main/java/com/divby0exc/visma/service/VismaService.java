package com.divby0exc.visma.service;

import com.divby0exc.visma.model.Invoice;
import com.divby0exc.visma.model.InvoiceList;
import com.divby0exc.visma.repository.VismaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class VismaService {
    @Autowired
    VismaRepository repo;


    public InvoiceList showAllInvoices(String username) throws SQLException {
        InvoiceList invoices = repo.getAllInvoices(username);

        if(invoices == null) {
            invoices = new InvoiceList(username);
        }

        return invoices;
    }


}
