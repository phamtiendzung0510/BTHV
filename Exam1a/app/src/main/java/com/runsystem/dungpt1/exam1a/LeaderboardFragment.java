package com.runsystem.dungpt1.exam1a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by dungpt1 on 24-Jul-17.
 */

public class LeaderboardFragment extends Fragment {

    ImageButton btnBack;

    public LeaderboardFragment(){
    }

    public static LeaderboardFragment newInstance() {
        LeaderboardFragment leaderboardFragment = new LeaderboardFragment();
        return leaderboardFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.leaderboard_fragment,container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnBack = (ImageButton) getActivity().findViewById(R.id.btnBackMenuLe);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,MenuFragment.newInstance()).commit();
            }
        });
    }
}
