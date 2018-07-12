package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class IncomeCategory {

    @PrimaryKey(autoGenerate = true)
    private long income_category_id;
    private String income_category_name;
    private String income_category_icon;

    public IncomeCategory(String income_category_name, String income_category_icon) {
        this.income_category_name = income_category_name;
        this.income_category_icon = income_category_icon;
    }

    public long getIncome_category_id() {
        return income_category_id;
    }

    public void setIncome_category_id(long income_category_id) {
        this.income_category_id = income_category_id;
    }

    public String getIncome_category_name() {
        return income_category_name;
    }

    public void setIncome_category_name(String income_category_name) {
        this.income_category_name = income_category_name;
    }

    public String getIncome_category_icon() {
        return income_category_icon;
    }

    public void setIncome_category_icon(String income_category_icon) {
        this.income_category_icon = income_category_icon;
    }
}
