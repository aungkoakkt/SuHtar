package com.example.aungko.suhtar.model;

import java.util.Date;

public class ExpenseInformation {

    private long expense_id;
    private int expense_amount;
    private String expense_note;
    private Date expense_date;
    private String expense_category_name;
    private String expense_category_icon;
    private String expense_schedule_name;

    public long getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(long expense_id) {
        this.expense_id = expense_id;
    }

    public int getExpense_amount() {
        return expense_amount;
    }

    public void setExpense_amount(int expense_amount) {
        this.expense_amount = expense_amount;
    }

    public String getExpense_note() {
        return expense_note;
    }

    public void setExpense_note(String expense_note) {
        this.expense_note = expense_note;
    }

    public Date getExpense_date() {
        return expense_date;
    }

    public void setExpense_date(Date expense_date) {
        this.expense_date = expense_date;
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

    public String getExpense_schedule_name() {
        return expense_schedule_name;
    }

    public void setExpense_schedule_name(String expense_schedule_name) {
        this.expense_schedule_name = expense_schedule_name;
    }
}
