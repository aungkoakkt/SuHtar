package com.example.aungko.suhtar.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.aungko.suhtar.converter.DateConverter;
import com.example.aungko.suhtar.dao.BudgetDao;
import com.example.aungko.suhtar.dao.BudgetScheduleDao;
import com.example.aungko.suhtar.dao.ExpenseCategoryDao;
import com.example.aungko.suhtar.dao.ExpenseDao;
import com.example.aungko.suhtar.dao.ExpenseScheduleDao;
import com.example.aungko.suhtar.dao.IncomeCategoryDao;
import com.example.aungko.suhtar.dao.IncomeDao;
import com.example.aungko.suhtar.dao.IncomeScheduleDao;
import com.example.aungko.suhtar.dao.WalletDao;
import com.example.aungko.suhtar.entity.Budget;
import com.example.aungko.suhtar.entity.BudgetSchedule;
import com.example.aungko.suhtar.entity.Expense;
import com.example.aungko.suhtar.entity.ExpenseCategory;
import com.example.aungko.suhtar.entity.ExpenseSchedule;
import com.example.aungko.suhtar.entity.Income;
import com.example.aungko.suhtar.entity.IncomeCategory;
import com.example.aungko.suhtar.entity.IncomeSchedule;
import com.example.aungko.suhtar.entity.Wallet;

@Database(entities = {Budget.class, BudgetSchedule.class, Expense.class, ExpenseCategory.class, ExpenseSchedule.class,
        Income.class, IncomeCategory.class, IncomeSchedule.class, Wallet.class},version = 1)
@TypeConverters({DateConverter.class})
public abstract class SuHtarDB extends RoomDatabase{

    public abstract ExpenseDao getExpenseDao();
    public abstract ExpenseCategoryDao getExpenseCategoryDao();
    public abstract ExpenseScheduleDao getExpenseScheduleDao();
    public abstract IncomeDao getIncomeDao();
    public abstract IncomeScheduleDao getIncomeScheduleDao();
    public abstract IncomeCategoryDao getIncomeCategoryDao();
    public abstract BudgetScheduleDao getBudgetScheduleDao();
    public abstract WalletDao getWalletDao();
    public abstract BudgetDao getBudgetDao();


    private static SuHtarDB instance;

    public static SuHtarDB getDatabase(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),SuHtarDB.class,"suhtardb")
                    .allowMainThreadQueries().build();
        }
        return instance;
    }

}