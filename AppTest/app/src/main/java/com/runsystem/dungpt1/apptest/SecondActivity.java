package com.runsystem.dungpt1.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by dungpt1 on 14-Jun-17.
 */

public class SecondActivity extends AppCompatActivity implements OnDataPass, OnChangeActivity {

    FrameLayout frameLayout;
    TextView tvActivity2;
    boolean isFragmentC = true;

    Intent intent;

    public void changeActivity(boolean isFragment) {
            intent = new Intent(SecondActivity.this, MainActivity.class);
            intent.putExtra("isA",isFragment);
            startActivity(intent);
        //
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent2 = getIntent();
        setContentView(R.layout.activity_second);
        frameLayout = (FrameLayout) findViewById(R.id.container2);
        tvActivity2 = (TextView) findViewById(R.id.tvActivity2);

        if (intent2.getExtras() != null){
            isFragmentC = intent2.getExtras().getBoolean("isC");
        }

        if (isFragmentC){
            this.getSupportFragmentManager().beginTransaction().add(R.id.container2,FragmentC.newInstance()).commit();
        } else {
            this.getSupportFragmentManager().beginTransaction().add(R.id.container2,FragmentD.newInstance()).commit();
        }

    }

    @Override
    public void onDataPass(String data) {
        tvActivity2.setText(data);
    }


    @Override
    public void onChangeActivity(boolean isFragment) {
            changeActivity(isFragment);

    }
}
