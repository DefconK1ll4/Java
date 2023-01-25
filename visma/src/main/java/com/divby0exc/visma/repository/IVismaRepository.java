package com.divby0exc.visma.repository;

import com.divby0exc.visma.model.Invoice;
import com.divby0exc.visma.model.InvoiceList;
import com.divby0exc.visma.model.Registrator;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface IVismaRepository {

    public void addInvoice(Invoice invoice, String username);

    public void editInvoice(Invoice invoice);

    public InvoiceList getAllInvoices(String username) throws SQLException;

    public void deleteInvoice(int id) throws SQLException;

    public boolean findUserIfExist(String username);

    public void addUserToDB(Registrator user);

    public Registrator retrieveCredentials(String username);
}
