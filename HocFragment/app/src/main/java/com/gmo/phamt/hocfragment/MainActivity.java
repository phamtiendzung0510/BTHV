package com.gmo.phamt.hocfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    private LogInFragment logInFragment = new LogInFragment();
    private MenuFragment menuFragment = new MenuFragment();
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = (FrameLayout) findViewById(R.id.container);
        this.getSupportFragmentManager().beginTransaction().add(R.id.container,ContentFragment.newInstance()).commit();
    }

    public LogInFragment getLogInFragment() {return logInFragment;}
    public MenuFragment getMenuFragment() {return menuFragment;}
}
