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

public class FragmentC extends Fragment {

    OnDataPass onDataPass;
    OnChangeActivity onChangeActivity;

    Button btnCtoA;
    Button btnCtoB;
    Button btnCtoD;

    public FragmentC() {
    }

    public static FragmentC newInstance() {
        FragmentC fragmentC = new FragmentC();
        return fragmentC;
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
        return inflater.inflate(R.layout.fragment_c,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDataPass.onDataPass("This is fragment C");
        btnCtoA = (Button) getActivity().findViewById(R.id.btnCtoA);
        btnCtoA.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(true);
            }
        });
        btnCtoB = (Button) getActivity().findViewById(R.id.btnCtoB);
        btnCtoB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(false);
            }
        });
        btnCtoD = (Button) getActivity().findViewById(R.id.btnCtoD);
        btnCtoD.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container2,FragmentD.newInstance()).commit();
            }
        });
    }
}
