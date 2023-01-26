package com.divby0exc.visma.service;

import com.divby0exc.visma.model.Receipt;
import com.divby0exc.visma.model.ReceiptList;
import com.divby0exc.visma.repository.VismaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class VismaService {
    @Autowired
    VismaRepository repo;


    public ReceiptList showAllRecipes(String username) throws SQLException {
        ReceiptList recipt = repo.getAllReceipts(username);

        if(recipt == null) {
            recipt = new ReceiptList(username);
        }

        return recipt;
    }

    public void registerReceipt(Receipt receipt, String username) {
        repo.addReceipt(receipt,username);
    }

    public Receipt findReceiptById(int id) {
        return repo.getReceiptById(id);
    }

    public void editReceipt(Receipt receipt) {
        repo.updateReceipt(receipt);
    }

    public void deleteReceipt(int id) {
        repo.deleteReceipt(id);
    }


}
