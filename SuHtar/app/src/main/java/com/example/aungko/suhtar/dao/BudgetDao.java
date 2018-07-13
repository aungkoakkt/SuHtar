package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.aungko.suhtar.entity.Budget;

import java.util.List;

@Dao
public interface BudgetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addBudget(Budget budget);

    @Delete
    void removeBudget(Budget budget);

    @Query("select * from Budget where budget_id=:budget_id")
    Budget getBudget(int budget_id);

    @Query("select * from Budget")
    List<Budget> getAllBudget();

}
