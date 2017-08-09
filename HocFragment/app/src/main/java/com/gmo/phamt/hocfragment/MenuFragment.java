package com.gmo.phamt.hocfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by phamt on 6/1/2017.
 */

public class MenuFragment extends android.support.v4.app.Fragment{
    TextView tvUserName;
    TextView tvPassword;
    Button btnBack;
    public MenuFragment() {
    }

    public static MenuFragment newInstance(Bundle bundle) {
        MenuFragment fragment = new MenuFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack = (Button) getActivity().findViewById(R.id.backBtn);
        tvUserName = (TextView) getActivity().findViewById(R.id.tvUserName);
        tvPassword = (TextView) getActivity().findViewById(R.id.tvPassword);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, ContentFragment.newInstance()).commit();
            }

        });

    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        if (bundle != null) {
            tvUserName.setText(bundle.getString("username"));
            tvPassword.setText(bundle.getString("password"));
        }
    }
}


