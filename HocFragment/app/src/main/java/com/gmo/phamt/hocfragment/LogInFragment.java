package com.gmo.phamt.hocfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by phamt on 6/1/2017.
 */

public class LogInFragment extends Fragment{
    EditText edtUserName;
    EditText edtPassword;
    Button btnLogin;
    String userNameLogin;
    String passwordLogin;



    public LogInFragment() {
    }

    public static LogInFragment newInstance() {
        LogInFragment fragment = new LogInFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.login_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtUserName = (EditText) getActivity().findViewById(R.id.edtUserName);
        edtPassword = (EditText) getActivity().findViewById(R.id.edtPassword);
        btnLogin = (Button) getActivity().findViewById(R.id.loginbutton);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
//                MainActivity mainActivity = (MainActivity) getActivity();
                Bundle bundle = new Bundle();
                bundle.putString("username",userName);
                bundle.putString("password",password);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,MenuFragment.newInstance(bundle)).commit();

            }
        });
    }
}
