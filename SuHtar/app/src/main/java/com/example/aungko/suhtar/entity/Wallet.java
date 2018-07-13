package com.example.aungko.suhtar.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Wallet {

    @PrimaryKey(autoGenerate = true)
    private long wallet_id;
    private int wallet_amount;
    private int wallet_initial_amount;

    public long getWallet_id() {
        return wallet_id;
    }

    public void setWallet_id(long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public int getWallet_amount() {
        return wallet_amount;
    }

    public void setWallet_amount(int wallet_amount) {
        this.wallet_amount = wallet_amount;
    }

    public int getWallet_initial_amount() {
        return wallet_initial_amount;
    }

    public void setWallet_initial_amount(int wallet_initial_amount) {
        this.wallet_initial_amount = wallet_initial_amount;
    }
}
