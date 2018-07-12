package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.aungko.suhtar.entity.BudgetSchedule;

import java.util.List;

@Dao
public interface BudgetScheduleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] addBudgetSchedule(List<BudgetSchedule> budgetSchedules);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addBudgetSchedule(BudgetSchedule budgetSchedule);

    @Delete
    void clearBudgetScheduleData(BudgetSchedule budgetSchedule);

    @Query("select * from BudgetSchedule")
    List<BudgetSchedule> getBudgetSchedule();
}
