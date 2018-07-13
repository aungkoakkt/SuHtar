package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.aungko.suhtar.entity.ExpenseCategory;

import java.util.List;

@Dao
public interface ExpenseCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] addExpenseCategories(List<ExpenseCategory> list);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addExpenseCategory(ExpenseCategory expense_category);

    @Delete
    void clearExpenseCategoryData(ExpenseCategory expense_category);

    @Query("select * from ExpenseCategory")
    List<ExpenseCategory> getExpenseCategory();
}
