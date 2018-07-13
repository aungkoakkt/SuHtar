package com.example.aungko.suhtar.budget_process;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aungko.suhtar.R;
import com.example.aungko.suhtar.helper.FontEmbedder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BudgetFragment extends Fragment {

    public Toolbar toolbar;
    public TextView toolText,txt1,txt3,txt4,txt5,txt6;
    public EditText txt2;
    public Button btn1, btn2;

//    @BindView(R.id.et_budget_bgamount)EditText et_bgamount;
//    @BindView(R.id.tv_budget_currency)TextView tv_currency;
//    @BindView(R.id.tv_budget_period)TextView tv_period;
//    @BindView(R.id.tv_budget_start_date)TextView tv_start_date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.budget,container,false);
        toolbar = view.findViewById(R.id.tb_budget);
        toolText = view.findViewById(R.id.toolbar_title);
        txt1 = view.findViewById(R.id.tv_budget_title11);
        txt2 = view.findViewById(R.id.et_budget_bgamount);
        txt3 = view.findViewById(R.id.tv_budget_title2);
        txt4 = view.findViewById(R.id.tv_budget_start_date);
        txt5 = view.findViewById(R.id.tv_budget_title3);
        txt6 = view.findViewById(R.id.tv_budget_title4);
        btn1 = view.findViewById(R.id.btn_budget_confirm);
        btn2 = view.findViewById(R.id.btn_budget_cancel);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FontEmbedder.forceTitle(toolText, getString(R.string.budget));
        FontEmbedder.forceTitle(txt1, getString(R.string.target_amount));
        FontEmbedder.EditTextforce(txt2, getString(R.string.oneone), getString(R.string.oneone));
        FontEmbedder.forceTitle(txt3, getString(R.string.begin_time));
        FontEmbedder.forceTitle(txt4, getString(R.string.date));
        FontEmbedder.forceTitle(txt5, getString(R.string.usage_duration));
        FontEmbedder.forceTitle(txt6, getString(R.string.send_email));
        FontEmbedder.Btnforce(btn1, getString(R.string.make_confirm));
        FontEmbedder.Btnforce(btn2, getString(R.string.make_cancel));
    }
}
