package com.runsystem.dungpt1.apptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnDataPass,OnChangeActivity {

    FrameLayout frameLayout;
    Intent intent;
    TextView tvActivity1;


    boolean isFragmentA = true;


    public void changeActivity(boolean isFragment) {
            intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("isC",isFragment);
            startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent2 = getIntent();
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.container1);
        tvActivity1 = (TextView) findViewById(R.id.tvActivity1);

        if (intent2.getExtras() != null){
            isFragmentA = intent2.getExtras().getBoolean("isA");
        }

        if (isFragmentA){
            this.getSupportFragmentManager().beginTransaction().add(R.id.container1,FragmentA.newInstance()).commit();
        } else {
            this.getSupportFragmentManager().beginTransaction().add(R.id.container1,FragmentB.newInstance()).commit();
        }



    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDataPass(String data) {
        tvActivity1.setText(data);
    }


    @Override
    public void onChangeActivity(boolean isFragment) {
            changeActivity(isFragment);
    }
}
