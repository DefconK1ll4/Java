package com.divby0exc.visma.repository;

import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.model.ReceiptList;
import com.divby0exc.visma.model.Registrator;

import java.sql.SQLException;

public interface IVismaRepository {

    public void addReceipt(Receipt receipt, String username);

    public int updateReceipt(Receipt receipt);

    public ReceiptList getAllReceipts(String username) throws SQLException;

    public int deleteReceipt(int id) throws SQLException;

    public boolean findUserIfExist(String username);

    public void addUserToDB(Registrator user);

    public Registrator retrieveCredentials(String username);

    public Receipt getReceiptById(int id);

    public int findId(String username);
}
