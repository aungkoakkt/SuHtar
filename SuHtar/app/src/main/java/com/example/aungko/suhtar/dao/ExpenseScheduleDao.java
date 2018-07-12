package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.aungko.suhtar.entity.ExpenseSchedule;

import java.util.List;

@Dao
public interface ExpenseScheduleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] addExpenseSchedule(List<ExpenseSchedule> expenseSchedules);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addExpenseSchedule(ExpenseSchedule expenseSchedule);

    @Delete
    void clearExpenseScheduleData(ExpenseSchedule expenseSchedule);

    @Query("select * from ExpenseSchedule")
    List<ExpenseSchedule> getExpenseSchedule();
}
