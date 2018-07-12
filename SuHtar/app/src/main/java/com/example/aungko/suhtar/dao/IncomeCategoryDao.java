package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;


import com.example.aungko.suhtar.entity.IncomeCategory;

import java.util.List;

@Dao
public interface IncomeCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] addIncomeCategories(List<IncomeCategory> list);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addIncomeCategory(IncomeCategory income_category);

    @Delete
    void clearIncomeCategoryData(IncomeCategory income_category);

    @Query("select * from IncomeCategory")
    List<IncomeCategory> getIncomeCategory();

}
