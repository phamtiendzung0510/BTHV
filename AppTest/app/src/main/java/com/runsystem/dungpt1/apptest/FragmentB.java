package com.runsystem.dungpt1.apptest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by dungpt1 on 14-Jun-17.
 */

public class FragmentB extends Fragment{


    Button btnBtoA;
    Button btnBtoC;
    Button btnBtoD;

    OnDataPass onDataPass;
    OnChangeActivity onChangeActivity;

    public FragmentB() {
    }

    public static FragmentB newInstance() {
        FragmentB fragmentB = new FragmentB();
        return fragmentB;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onDataPass = (OnDataPass) context;
        onChangeActivity = (OnChangeActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_b,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDataPass.onDataPass("This is fragment B");
        btnBtoA = (Button) getActivity().findViewById(R.id.btnBtoA);
        btnBtoA.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container1,FragmentA.newInstance()).commit();
            }
        });

        btnBtoC = (Button) getActivity().findViewById(R.id.btnBtoC);
        btnBtoC.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(true);
            }
        });

        btnBtoD = (Button) getActivity().findViewById(R.id.btnBtoD);
        btnBtoD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(false);
            }
        });
    }
}
