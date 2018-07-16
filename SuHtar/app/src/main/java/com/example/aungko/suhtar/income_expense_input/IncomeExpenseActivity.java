package com.example.aungko.suhtar.income_expense_input;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aungko.suhtar.MainActivity;
import com.example.aungko.suhtar.R;
import com.example.aungko.suhtar.budget_process.BudgetFragment;
import com.example.aungko.suhtar.database.SuHtarDB;
import com.example.aungko.suhtar.entity.Expense;
import com.example.aungko.suhtar.entity.Income;
import com.example.aungko.suhtar.model.ExpenseInformation;
import com.example.aungko.suhtar.model.IncomeInformation;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IncomeExpenseActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    @BindView(R.id.tb_income_expense)Toolbar toolbar;
    @BindView(R.id.tv_income_expense_title)TextView tv_title;
    @BindView(R.id.et_income_expense_amount)EditText et_amount;
    @BindView(R.id.et_income_expense_note)EditText et_note;
    @BindView(R.id.tv_income_expense_date)TextView tv_date;
    @BindView(R.id.sp_income_expense_schedule)Spinner sp_schedule;

    private int id=0;
    private int year,month,day;
    private SuHtarDB db;
    private Date date;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.income_or_expense);
        ButterKnife.bind(this);

        db=SuHtarDB.getDatabase(this);

        Intent intent=getIntent();
        id=intent.getIntExtra("card_id",0);

        setCurrentDate();

        if(id==1){
            List income_schedles=db.getIncomeScheduleDao().getIncomeSchedule();
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,income_schedles);
            sp_schedule.setAdapter(arrayAdapter);
            tv_title.setText("Income");
        }else {
            List expense_schedule=db.getExpenseScheduleDao().getExpenseSchedule();
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,expense_schedule);
            sp_schedule.setAdapter(arrayAdapter);
            tv_title.setText("Expense");
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    @OnClick({R.id.btn_income_expense_confirm,R.id.btn_income_expense_cancel,R.id.tv_income_expense_date})
    public void onClickButton(View view){
        switch (view.getId()){
            case R.id.btn_income_expense_confirm:
                boolean flag=checkInput(et_amount.getText().toString());
                int amount=0;
                if(flag){
                    amount=Integer.parseInt(et_amount.getText().toString());
                    if(1==id){
                        Income income=new Income();
                        income.setIncome_amount(amount);
                        income.setIncome_note(et_note.getText().toString());
                        income.setIncome_date(date);
                        income.setF_income_category_id(1);
                        income.setF_income_schedule_id(1);
                        db.getIncomeDao().addIncome(income);
                        Log.e("Tag","Click on Income");
                    }else {
                        Expense expense=new Expense();
                        expense.setExpense_amount(amount);
                        expense.setExpense_note(et_note.getText().toString());
                        expense.setExpense_date(date);
                        expense.setF_expense_category_id(1);
                        expense.setF_expense_schedule_id(1);
                        db.getExpenseDao().addExpense(expense);
                        Log.e("Tag","Click on expense");
                    }
                }else {
                    Toast.makeText(this, "Select Amount", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_income_expense_cancel:
                startActivity(new Intent(IncomeExpenseActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.tv_income_expense_date:
                datePickerDialog.show();
                break;
        }

        List<ExpenseInformation> data1=db.getExpenseDao().getAllExpenseInformation();
        Log.e("data1",data1.size()+"");
        List<IncomeInformation> data2=db.getIncomeDao().getAllIncomeInformation();
        Log.e("data2",data2.size()+"");
    }

    private boolean checkInput(String st){
        if(TextUtils.isEmpty(st)){
            return false;
        }
        return true;
    }

    public void setCurrentDate(){

        final Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);

        date=c.getTime();

        tv_date.setText(new StringBuilder().append(day).append("-").append(month+1).append("-").append(year).append(""));

        datePickerDialog = new DatePickerDialog(
                this, this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calander2 = Calendar.getInstance();

        calander2.setTimeInMillis(0);

        calander2.set(year, month, dayOfMonth, 0, 0, 0);

        date= calander2.getTime();

        tv_date.setText(new StringBuilder().append(dayOfMonth).append("-").append(month+1).append("-").append(year).append(""));

    }
}
