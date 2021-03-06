package com.example.aungko.suhtar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.aungko.suhtar.budget_process.BudgetFragment;
import com.example.aungko.suhtar.database.SuHtarDB;
import com.example.aungko.suhtar.entity.BudgetSchedule;
import com.example.aungko.suhtar.entity.ExpenseCategory;
import com.example.aungko.suhtar.entity.ExpenseSchedule;
import com.example.aungko.suhtar.entity.IncomeCategory;
import com.example.aungko.suhtar.entity.IncomeSchedule;
import com.example.aungko.suhtar.entity.Wallet;
import com.example.aungko.suhtar.home_process.HomeFragment;
import com.example.aungko.suhtar.wallet_process.WalletFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.fr_main)FrameLayout fr_main;
    @BindView(R.id.bnv_main)BottomNavigationView bnv_main;
    private SuHtarDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ButterKnife.bind(this);
        changeFragment(new HomeFragment());
        bnv_main.setOnNavigationItemSelectedListener(this);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("SuHtar", MODE_PRIVATE);
        boolean flag= sharedPreferences.getBoolean("SuHtar", true);

        if(flag){
            db=SuHtarDB.getDatabase(this);
            db.getBudgetScheduleDao().addBudgetSchedule(new BudgetSchedule("၁ ပတ်"));
            db.getBudgetScheduleDao().addBudgetSchedule(new BudgetSchedule("၂ ပတ်"));
            db.getBudgetScheduleDao().addBudgetSchedule(new BudgetSchedule("၃ ပတ်"));
            db.getBudgetScheduleDao().addBudgetSchedule(new BudgetSchedule("၁ လ"));
            db.getWalletDao().addWallet(new Wallet());

            db.getIncomeCategoryDao().addIncomeCategory(new IncomeCategory("Salary","salary icon"));
            db.getIncomeCategoryDao().addIncomeCategory(new IncomeCategory("Pocket","pocket icon"));
            db.getIncomeCategoryDao().addIncomeCategory(new IncomeCategory("Other","other icon"));

            db.getExpenseCategoryDao().addExpenseCategory(new ExpenseCategory("Food","food icon"));
            db.getExpenseCategoryDao().addExpenseCategory(new ExpenseCategory("Transport","transport icon"));
            db.getExpenseCategoryDao().addExpenseCategory(new ExpenseCategory("Entertainment","entertainment icon"));

            db.getExpenseScheduleDao().addExpenseSchedule(new ExpenseSchedule("TRUE"));
            db.getExpenseScheduleDao().addExpenseSchedule(new ExpenseSchedule("FALSE"));

            db.getIncomeScheduleDao().addIncomeSchedule(new IncomeSchedule("Done"));
            db.getIncomeScheduleDao().addIncomeSchedule(new IncomeSchedule("UnDone"));

            startActivity(new Intent(this,IntroSliderActivity.class));
            finish();

        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.isChecked())
            item.setChecked(false);

        switch (item.getItemId()) {
            case R.id.menu_home:
                //Check the Item
                item.setChecked(true);
                changeFragment(new HomeFragment());
                break;
            case R.id.menu_wallet:
                //Check the Item
                item.setChecked(true);
                changeFragment(new WalletFragment());
                break;
            case R.id.menu_budget:
                //Check the Item
                item.setChecked(true);
                changeFragment(new BudgetFragment());
                break;
            case R.id.menu_profile:
                //Check the Item
                item.setChecked(true);
                changeFragment(new WalletFragment());
                break;

        }
        return true;
    }

    private void changeFragment(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fr_main,fragment);
        ft.commit();

    }
}
