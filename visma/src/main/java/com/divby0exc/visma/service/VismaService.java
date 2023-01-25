package com.divby0exc.visma.service;

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


}
