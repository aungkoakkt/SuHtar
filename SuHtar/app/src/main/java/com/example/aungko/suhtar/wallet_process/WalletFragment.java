package com.example.aungko.suhtar.wallet_process;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aungko.suhtar.R;
import com.example.aungko.suhtar.helper.FontEmbedder;

public class WalletFragment extends Fragment {


    public Toolbar toolbar;
    public TextView toolText,InitVal,OwnBudget,FloatingVal;
    public EditText EnterVal;
    public TabLayout tabLayout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wallet,container,false);
        toolbar = view.findViewById(R.id.tb_budget);
        toolText = view.findViewById(R.id.toolbar_title);
        InitVal = view.findViewById(R.id.initial_value);
        EnterVal = view.findViewById(R.id.one_hundred_thousand);
        OwnBudget = view.findViewById(R.id.own_budget);
        FloatingVal = view.findViewById(R.id.floating_amount);
        tabLayout = view.findViewById(R.id.tabLayout);

/*        tabItemIncome = view.findViewById(R.id.income_category);
        tabItemExpend = view.findViewById(R.id.expend_category);*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FontEmbedder.forceTitle(toolText, getString(R.string.wallet));
        FontEmbedder.forceTitle(InitVal, getString(R.string.initial_value));
        FontEmbedder.EditTextforce(EnterVal, getString(R.string.one_hundred_thousand), getString(R.string.one_hundred_thousand));
        FontEmbedder.forceTitle(OwnBudget, getString(R.string.own_budget));
        FontEmbedder.forceTitle(FloatingVal, getString(R.string.floating_amount));

        tabLayout.addTab(tabLayout.newTab().setText(R.string.income_category));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.expend_category));

    }
}
