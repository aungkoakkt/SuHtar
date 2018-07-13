package com.example.aungko.suhtar.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.aungko.suhtar.entity.Wallet;

@Dao
public interface WalletDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long addWallet(Wallet wallet);

    @Delete
    void clearWalletData(Wallet wallet);

    @Query("select * from Wallet")
    Wallet getWallet();
}
