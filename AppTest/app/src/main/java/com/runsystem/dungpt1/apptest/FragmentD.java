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

public class FragmentD extends Fragment {

    Button btnDtoA;
    Button btnDtoB;
    Button btnDtoC;

    OnDataPass onDataPass;
    OnChangeActivity onChangeActivity;

    public FragmentD(){
    }

    public static FragmentD newInstance() {
        FragmentD fragmentD = new FragmentD();
        return fragmentD;
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
        return inflater.inflate(R.layout.fragment_d,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDataPass.onDataPass("This is fragment D");
        btnDtoA = (Button) getActivity().findViewById(R.id.btnDtoA);
        btnDtoA.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(true);
            }
        });
        btnDtoB = (Button) getActivity().findViewById(R.id.btnDtoB);
        btnDtoB.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onChangeActivity.onChangeActivity(false);
            }
        });
        btnDtoC = (Button) getActivity().findViewById(R.id.btnDtoC);
        btnDtoC.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container2,FragmentC.newInstance()).commit();
            }
        });

    }
}
