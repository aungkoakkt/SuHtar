package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class BudgetSchedule {

    @PrimaryKey(autoGenerate = true)
    private int budget_schedule_id;
    private String budget_schedule_name;

    @Ignore
    public BudgetSchedule(int budget_schedule_id) {
        this.budget_schedule_id = budget_schedule_id;
    }

    public BudgetSchedule(String budget_schedule_name) {
        this.budget_schedule_name = budget_schedule_name;
    }

    public int getBudget_schedule_id() {
        return budget_schedule_id;
    }

    public void setBudget_schedule_id(int budget_schedule_id) {
        this.budget_schedule_id = budget_schedule_id;
    }

    public String getBudget_schedule_name() {
        return budget_schedule_name;
    }

    public void setBudget_schedule_name(String budget_schedule_name) {
        this.budget_schedule_name = budget_schedule_name;
    }
}
