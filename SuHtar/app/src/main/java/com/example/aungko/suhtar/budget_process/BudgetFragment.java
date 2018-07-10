package com.example.aungko.suhtar.budget_process;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aungko.suhtar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BudgetFragment extends Fragment {

//    @BindView(R.id.et_budget_bgamount)EditText et_bgamount;
//    @BindView(R.id.tv_budget_currency)TextView tv_currency;
//    @BindView(R.id.tv_budget_period)TextView tv_period;
//    @BindView(R.id.tv_budget_start_date)TextView tv_start_date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.budget,container,false);
      //  ButterKnife.bind(this,view);
        return view;
    }
}
