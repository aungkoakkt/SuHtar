package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.aungko.suhtar.entity.IncomeSchedule;

import java.util.List;

@Dao
public interface IncomeScheduleDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] addIncomeSchedule(List<IncomeSchedule> incomeSchedules);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addIncomeSchedule(IncomeSchedule incomeSchedule);

    @Delete
    void clearIncomeScheduleData(IncomeSchedule incomeSchedule);

    @Query("select * from IncomeSchedule")
    List<IncomeSchedule> getIncomeSchedule();
}
