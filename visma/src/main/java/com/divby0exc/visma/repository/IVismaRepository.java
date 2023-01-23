package com.divby0exc.visma.repository;

import com.divby0exc.visma.model.Invoice;

import java.util.List;

public interface IVismaRepository {

    public void addInvoice();

    public void editInvoice();

    public List<Invoice> getAllInvoices();

    public void deleteInvoice(int id);

    public boolean findIfExist(String username);

    public void addUserToDB(String username, String password);




}
