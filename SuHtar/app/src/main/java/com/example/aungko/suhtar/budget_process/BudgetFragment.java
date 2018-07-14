package com.example.aungko.suhtar.budget_process;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aungko.suhtar.R;
import com.example.aungko.suhtar.database.SuHtarDB;
import com.example.aungko.suhtar.entity.Budget;
import com.example.aungko.suhtar.entity.BudgetSchedule;
import com.example.aungko.suhtar.helper.FontEmbedder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.myatminsoe.mdetect.MMToast;

public class BudgetFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    @BindView(R.id.tb_budget) Toolbar toolbar;
    @BindView(R.id.toolbar_title) TextView toolText;
    @BindView(R.id.tv_budget_title11) TextView tv_title1;
    @BindView(R.id.et_budget_bgamount)EditText et_bgamount;
    @BindView(R.id.tv_budget_title2) TextView tv_title2;
    @BindView(R.id.tv_budget_title3) TextView tv_title3;
    @BindView(R.id.tv_budget_title4) TextView tv_title4;
    @BindView(R.id.btn_budget_start_date) Button tv_start_date;
    @BindView(R.id.btn_budget_confirm) Button btn_confirm;
    @BindView(R.id.btn_budget_cancel) Button btn_cancel;
    @BindView(R.id.sp_budget_spinner) Spinner spinner;
    @BindView(R.id.sw_budget_noti) Switch aSwitch;

    private DatePickerDialog datePickerDialog;
    private Date date;

    private SuHtarDB db;
    private int year,month,day;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.budget,container,false);
        ButterKnife.bind(this,view);
        setCurrentDate();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FontEmbedder.forceTitle(toolText, getString(R.string.budget));
        FontEmbedder.forceTitle(tv_title1, getString(R.string.target_amount));
        FontEmbedder.EditTextforce(et_bgamount, getString(R.string.oneone));
        FontEmbedder.forceTitle(tv_title2, getString(R.string.begin_time));
        FontEmbedder.forceTitle(tv_title3, getString(R.string.usage_duration));
        FontEmbedder.forceTitle(tv_title4, getString(R.string.send_email));
        FontEmbedder.Btnforce(btn_confirm, getString(R.string.make_confirm));
        FontEmbedder.Btnforce(btn_cancel, getString(R.string.make_cancel));

        db=SuHtarDB.getDatabase(getContext());

        List<BudgetSchedule> dataList=db.getBudgetScheduleDao().getBudgetSchedule();

        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,dataList);
        spinner.setAdapter(arrayAdapter);

    }

    public void setCurrentDate(){

        final Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DAY_OF_MONTH);

        date=c.getTime();

        tv_start_date.setText(new StringBuilder().append(day).append("-").append(month+1).append("-").append(year).append(""));

        datePickerDialog = new DatePickerDialog(
                getContext(), BudgetFragment.this, year, month, day);
    }

    @OnClick({R.id.btn_budget_start_date,R.id.btn_budget_confirm,R.id.btn_budget_cancel})
    public void clickDateBtn(View view){
        switch (view.getId()){
            case R.id.btn_budget_start_date:
                datePickerDialog.show();
                break;
            case R.id.btn_budget_confirm:
                saveBudget();
                Log.e("Testing","Confirm");
                break;
            case R.id.btn_budget_cancel:
                cancelBudget();
                Log.e("Testing","Cancel");
                break;
        }
    }

    private void cancelBudget() {
        et_bgamount.setText("");
        setCurrentDate();
        aSwitch.setChecked(false);
    }

    private void saveBudget() {

        BudgetSchedule budgetSchedule=(BudgetSchedule) spinner.getSelectedItem();

        Budget budget=new Budget();
        String sAmount=et_bgamount.getText().toString();
        int amount = 0;
        if(!TextUtils.isEmpty(sAmount)){
            amount=Integer.parseInt(sAmount);
        }

        budget.setBudget_amount(amount);
        budget.setBudget_date(date);
        budget.setF_budget_schedule_id(budgetSchedule.getBudget_schedule_id());
        if(aSwitch.isChecked()){
            budget.setBudget_noti(1);
        }else {
            budget.setBudget_noti(0);
        }

        if(amount>0){
            long result=db.getBudgetDao().addBudget(budget);
            et_bgamount.setText("");
            Log.e("result",result+"");
        }else {
            MMToast.INSTANCE.showShortToast(getActivity(),"တန်ဖိုးထည့်ပေးပါ");
        }

        List<Budget> budgets=db.getBudgetDao().getAllBudget();
        for (int i=0;i<budgets.size();i++){
            Log.e(i+"",budgets.get(i).getBudget_id()+"");
            Log.e(i+"",budgets.get(i).getBudget_amount()+"");
            Log.e(i+"",budgets.get(i).getBudget_date()+"");
            Log.e(i+"",budgets.get(i).getF_budget_schedule_id()+"");
            Log.e(i+"",budgets.get(i).getBudget_noti()+"");
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Calendar calander2 = Calendar.getInstance();

        calander2.setTimeInMillis(0);

        calander2.set(year, month, dayOfMonth, 0, 0, 0);

        date= calander2.getTime();

        tv_start_date.setText(new StringBuilder().append(dayOfMonth).append("-").append(month+1).append("-").append(year).append(""));
    }
}
