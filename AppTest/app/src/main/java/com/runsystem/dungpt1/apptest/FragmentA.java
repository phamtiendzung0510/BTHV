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

public class FragmentA extends Fragment {

    public final static String FRAGA = "fragA";

    OnDataPass onDataPass;
    OnChangeActivity onChangeActivity;


    Button btnAtoB;
    Button btnAtoC;
    Button btnAtoD;

    public FragmentA(){
    }

    public static FragmentA newInstance() {
        FragmentA fragmentA = new FragmentA();
        return fragmentA;
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
        return inflater.inflate(R.layout.fragment_a,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDataPass.onDataPass("This is fragment A");
        btnAtoB = (Button) getActivity().findViewById(R.id.btnAtoB);
        btnAtoB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container1,FragmentB.newInstance()).commit();
            }
        });
        btnAtoC = (Button) getActivity().findViewById(R.id.btnAtoC);
        btnAtoC.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(true);
            }
        });
        btnAtoD = (Button) getActivity().findViewById(R.id.btnAtoD);
        btnAtoD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(false);
            }
        });

    }

}
