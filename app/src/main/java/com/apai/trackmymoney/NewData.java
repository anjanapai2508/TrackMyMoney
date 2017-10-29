package com.apai.trackmymoney;

/**
 * Created by Anjana on 10/3/2017.
 */

public class NewData {

    String category; //Expense or Income
    String merchant; // where did you spend
    String amount;

    public NewData() {

    }

    public NewData(String category, String merchant, String amount) {
        this.category = category;
        this.merchant = merchant;
        this.amount = amount;

    }

    public String getCategory() {
        return category;
    }

    public String getMerchant() {
        return merchant;
    }

    public String getAmount() {
        return amount;
    }
}
