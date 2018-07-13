package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class IncomeSchedule {

    @PrimaryKey(autoGenerate = true)
    private int income_schedule_id;
    private String income_schedule_name;


    public IncomeSchedule(String income_schedule_name) {
        this.income_schedule_name = income_schedule_name;
    }

    @Ignore
    public IncomeSchedule(int income_schedule_id) {
        this.income_schedule_id = income_schedule_id;
    }

    public int getIncome_schedule_id() {
        return income_schedule_id;
    }

    public void setIncome_schedule_id(int income_schedule_id) {
        this.income_schedule_id = income_schedule_id;
    }

    public String getIncome_schedule_name() {
        return income_schedule_name;
    }

    public void setIncome_schedule_name(String income_schedule_name) {
        this.income_schedule_name = income_schedule_name;
    }
}
