package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ExpenseCategory {

    @PrimaryKey(autoGenerate = true)
    private long expense_category_id;
    private String expense_category_name;
    private String expense_category_icon;

    public ExpenseCategory(String expense_category_name, String expense_category_icon) {
        this.expense_category_name = expense_category_name;
        this.expense_category_icon = expense_category_icon;
    }

    public long getExpense_category_id() {
        return expense_category_id;
    }

    public void setExpense_category_id(long expense_category_id) {
        this.expense_category_id = expense_category_id;
    }

    public String getExpense_category_name() {
        return expense_category_name;
    }

    public void setExpense_category_name(String expense_category_name) {
        this.expense_category_name = expense_category_name;
    }

    public String getExpense_category_icon() {
        return expense_category_icon;
    }

    public void setExpense_category_icon(String expense_category_icon) {
        this.expense_category_icon = expense_category_icon;
    }
}
