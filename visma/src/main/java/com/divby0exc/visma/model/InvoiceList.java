package com.divby0exc.visma.model;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class InvoiceList {
    private List<Invoice> invoices;
    private String owner;

    public InvoiceList(String owner) {
        this.owner = owner;
        this.invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public String getOwner() {
        return owner;
    }
}
