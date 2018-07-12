package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.aungko.suhtar.entity.Expense;
import com.example.aungko.suhtar.model.ExpenseInformation;

import java.util.List;

@Dao
public interface ExpenseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addExpense(Expense expense);

    @Delete
    void clearExpenseData(Expense expense);

    @Query("select * from Expense")
    List<Expense> getAllExpense();

    @Query("select * from Expense as a,ExpenseCategory as b,ExpenseSchedule as c " +
            "where a.f_expense_category_id=b.expense_category_id and a.f_expense_schedule_id=c.expense_schedule_id")
    List<ExpenseInformation> getAllExpenseInformation();
}
