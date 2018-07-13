package com.example.aungko.suhtar.model;

import java.util.Date;

public class IncomeInformation {

    private long income_id;
    private int income_amount;
    private String income_note;
    private Date income_date;
    private String income_category_name;
    private String income_category_icon;
    private String income_schedule_name;

    public long getIncome_id() {
        return income_id;
    }

    public void setIncome_id(long income_id) {
        this.income_id = income_id;
    }

    public int getIncome_amount() {
        return income_amount;
    }

    public void setIncome_amount(int income_amount) {
        this.income_amount = income_amount;
    }

    public String getIncome_note() {
        return income_note;
    }

    public void setIncome_note(String income_note) {
        this.income_note = income_note;
    }

    public Date getIncome_date() {
        return income_date;
    }

    public void setIncome_date(Date income_date) {
        this.income_date = income_date;
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

    public String getIncome_schedule_name() {
        return income_schedule_name;
    }

    public void setIncome_schedule_name(String income_schedule_name) {
        this.income_schedule_name = income_schedule_name;
    }
}
