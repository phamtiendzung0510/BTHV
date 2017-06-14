package com.gmo.phamt.hocfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by phamt on 6/1/2017.
 */

public class ContentFragment extends Fragment {
    Button btnNext;

    public ContentFragment() {
    }

    public static ContentFragment newInstance() {
        ContentFragment fragment = new ContentFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        return inflater.inflate(R.layout.content_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = (Button) getActivity().findViewById(R.id.click);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,LogInFragment.newInstance()).commit();
            }
        });
    }


}
