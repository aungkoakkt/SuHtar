package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
        @ForeignKey(entity = ExpenseCategory.class,
                parentColumns = "expense_category_id",
                childColumns = "f_expense_category_id",onDelete = CASCADE,onUpdate = CASCADE),
        @ForeignKey(entity = ExpenseSchedule.class,
                parentColumns = "expense_schedule_id",
                childColumns =  "f_expense_schedule_id",onDelete = CASCADE,onUpdate = CASCADE)})
public class Expense {

    @PrimaryKey(autoGenerate = true)
    private long expense_id;
    private int expense_amount;
    private String expense_note;
    private Date expense_date;
    private long f_expense_category_id;
    private long f_expense_schedule_id;

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

    public long getF_expense_category_id() {
        return f_expense_category_id;
    }

    public void setF_expense_category_id(long f_expense_category_id) {
        this.f_expense_category_id = f_expense_category_id;
    }

    public long getF_expense_schedule_id() {
        return f_expense_schedule_id;
    }

    public void setF_expense_schedule_id(long f_expense_schedule_id) {
        this.f_expense_schedule_id = f_expense_schedule_id;
    }
}
