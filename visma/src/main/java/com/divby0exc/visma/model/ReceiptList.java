package com.divby0exc.visma.model;

import java.util.ArrayList;
import java.util.List;

public class ReceiptList {
    private List<Receipt> receipts;
    private String owner;

    public ReceiptList(String owner) {
        this.owner = owner;
        this.receipts = new ArrayList<>();
    }

    public List<Receipt> getRecipes() {
        return receipts;
    }

    public String getOwner() {
        return owner;
    }
}
