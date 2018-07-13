package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;


@Entity(foreignKeys = {
        @ForeignKey(entity = IncomeCategory.class,
        parentColumns = "income_category_id",
        childColumns = "f_income_category_id",onDelete = CASCADE,onUpdate = CASCADE),
        @ForeignKey(entity = IncomeSchedule.class,
        parentColumns = "income_schedule_id",
        childColumns =  "f_income_schedule_id",
        onDelete = CASCADE,onUpdate = CASCADE)})
public class Income {
    @PrimaryKey(autoGenerate = true)
    private long income_id;
    private int income_amount;
    private String income_note;
    private Date income_date;
    private long f_income_category_id;
    private long f_income_schedule_id;

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

    public long getF_income_category_id() {
        return f_income_category_id;
    }

    public void setF_income_category_id(long f_income_category_id) {
        this.f_income_category_id = f_income_category_id;
    }

    public long getF_income_schedule_id() {
        return f_income_schedule_id;
    }

    public void setF_income_schedule_id(long f_income_schedule_id) {
        this.f_income_schedule_id = f_income_schedule_id;
    }
}
