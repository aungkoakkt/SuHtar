package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ExpenseSchedule {

    @PrimaryKey(autoGenerate = true)
    private int expense_schedule_id;
    private String expense_schedule_name;

    @Ignore
    public ExpenseSchedule(int expense_schedule_id) {
        this.expense_schedule_id = expense_schedule_id;
    }


    public ExpenseSchedule(String expense_schedule_name) {
        this.expense_schedule_name = expense_schedule_name;
    }

    public int getExpense_schedule_id() {
        return expense_schedule_id;
    }

    public void setExpense_schedule_id(int expense_schedule_id) {
        this.expense_schedule_id = expense_schedule_id;
    }

    public String getExpense_schedule_name() {
        return expense_schedule_name;
    }

    public void setExpense_schedule_name(String expense_schedule_name) {
        this.expense_schedule_name = expense_schedule_name;
    }
}
