package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = BudgetSchedule.class,
        parentColumns = "budget_schedule_id",childColumns = "f_budget_schedule_id",onDelete = CASCADE,onUpdate = CASCADE))
public class Budget {

    @PrimaryKey(autoGenerate = true)
    private long budget_id;
    private int budget_amount;
    private int budget_noti;
    private Date budget_date;
    private int f_budget_schedule_id;

    public long getBudget_id() {
        return budget_id;
    }

    public void setBudget_id(long budget_id) {
        this.budget_id = budget_id;
    }

    public int getBudget_amount() {
        return budget_amount;
    }

    public void setBudget_amount(int budget_amount) {
        this.budget_amount = budget_amount;
    }

    public int getBudget_noti() {
        return budget_noti;
    }

    public void setBudget_noti(int budget_noti) {
        this.budget_noti = budget_noti;
    }

    public Date getBudget_date() {
        return budget_date;
    }

    public void setBudget_date(Date budget_date) {
        this.budget_date = budget_date;
    }

    public int getF_budget_schedule_id() {
        return f_budget_schedule_id;
    }

    public void setF_budget_schedule_id(int f_budget_schedule_id) {
        this.f_budget_schedule_id = f_budget_schedule_id;
    }
}
