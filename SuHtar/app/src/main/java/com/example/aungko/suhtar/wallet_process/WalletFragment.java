package com.example.aungko.suhtar.wallet_process;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aungko.suhtar.R;
import com.example.aungko.suhtar.database.SuHtarDB;
import com.example.aungko.suhtar.entity.Wallet;
import com.example.aungko.suhtar.helper.FontEmbedder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalletFragment extends Fragment {


    public Toolbar toolbar;
    public TextView toolText,InitVal,OwnBudget;
    public TabLayout tabLayout;

    @BindView(R.id.et_one_hundred_thousand)EditText EnterVal;
    @BindView(R.id.btn_wallet_save)Button btn_wallet_save;
    @BindView(R.id.floating_amount)TextView FloatingVal;

    private String st_value;
    private int value=0;

    private SuHtarDB db;
    private Wallet wallet;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wallet,container,false);
        toolbar = view.findViewById(R.id.tb_budget);
        toolText = view.findViewById(R.id.toolbar_title);
        InitVal = view.findViewById(R.id.initial_value);
        OwnBudget = view.findViewById(R.id.own_budget);
        tabLayout = view.findViewById(R.id.tabLayout);

        ButterKnife.bind(this,view);

        db=SuHtarDB.getDatabase(getContext());
        wallet=db.getWalletDao().getWallet();

/*      tabItemIncome = view.findViewById(R.id.income_category);
        tabItemExpend = view.findViewById(R.id.expend_category);*/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FontEmbedder.forceTitle(toolText, getString(R.string.wallet));
        FontEmbedder.EditTextforce(EnterVal, getString(R.string.one_hundred_thousand));
        FontEmbedder.forceTitle(OwnBudget, getString(R.string.own_budget));

        tabLayout.addTab(tabLayout.newTab().setText(R.string.income_category));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.expend_category));

        FloatingVal.setText(wallet.getWallet_amount()+" MMK");
        if(wallet.getWallet_initial_amount()>0){
            EnterVal.setText(wallet.getWallet_initial_amount()+"");
        }


        EnterVal.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    btn_wallet_save.setVisibility(View.VISIBLE);
                }else {
                    btn_wallet_save.setVisibility(View.GONE);
                }
            }
        });

        EnterVal.addTextChangedListener(new TextWatcher(){
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (EnterVal.getText().toString().matches("^0") )
                {
                    // Not allowed
                    EnterVal.setText("");
                }
            }
            @Override
            public void afterTextChanged(Editable arg0) { }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        });

    }

    @OnClick(R.id.btn_wallet_save)
    public void onCLickSaveBtn(){

        st_value=EnterVal.getText().toString();

        if(!TextUtils.isEmpty(st_value)){
            value=Integer.parseInt(st_value);
        }else {
            value=0;
        }

        Wallet wallet=db.getWalletDao().getWallet();
        int current_wallet=wallet.getWallet_amount()+value-wallet.getWallet_initial_amount();
            wallet.setWallet_amount(current_wallet);
            wallet.setWallet_initial_amount(value);
            db.getWalletDao().updateWallet(wallet);

        Wallet result=db.getWalletDao().getWallet();
        FloatingVal.setText(result.getWallet_amount()+" MMK");
        Log.e("wallet",result.getWallet_id()+"  "+result.getWallet_amount()+"   "+result.getWallet_initial_amount());

    }
}
