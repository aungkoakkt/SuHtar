package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.aungko.suhtar.entity.Income;
import com.example.aungko.suhtar.model.IncomeInformation;

import java.util.List;

@Dao
public interface IncomeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addIncome(Income income);

    @Delete
    void clearIncomeData(Income Income);

    @Query("select * from income")
    List<Income> getAllIncome();

    @Query("select * from Income as a,IncomeCategory as b,IncomeSchedule as c " +
            "where a.f_income_category_id=b.income_category_id and a.f_income_schedule_id=c.income_schedule_id")
    List<IncomeInformation> getAllIncomeInformation();

}
