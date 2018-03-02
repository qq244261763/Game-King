package com.example.person.gameking;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.person.gameking.view.FightingFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        loadFightingView();
    }


    /**战斗界面*/
    private void loadFightingView() {
        replaceFragment(new FightingFragment());

    }


    private void replaceFragment(Fragment fragment) {
        transaction.replace(R.id.layout_root,fragment);
        transaction.commitAllowingStateLoss();
    }


}
