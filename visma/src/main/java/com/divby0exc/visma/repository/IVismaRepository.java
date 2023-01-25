package com.divby0exc.visma.repository;

import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.model.ReceiptList;
import com.divby0exc.visma.model.Registrator;

import java.sql.SQLException;

public interface IVismaRepository {

    public void addReceipt(Receipt receipt, String username);

    public void editReceipt(Receipt receipt);

    public ReceiptList getAllReceipts(String username) throws SQLException;

    public void deleteReceipt(int id) throws SQLException;

    public boolean findUserIfExist(String username);

    public void addUserToDB(Registrator user);

    public Registrator retrieveCredentials(String username);
}
