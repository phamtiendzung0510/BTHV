package com.runsystem.dungpt1.exam1a;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by dungpt1 on 08-Aug-17.
 */

public class MenuFragment extends Fragment {

    Button btnDisconnect;
    Button btnProfile;
    Button btnAdvantages;
    Button btnDiary;
    Button btnLeaderboard;
    Button btnMembers;
    Button btnNews;

    public MenuFragment(){}

    public static MenuFragment newInstance() {
        MenuFragment menuFragment = new MenuFragment();
        return menuFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.menu_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnDisconnect = (Button) getActivity().findViewById(R.id.btnDisconnect);
        btnProfile = (Button) getActivity().findViewById(R.id.btnProfile);
        btnAdvantages = (Button) getActivity().findViewById(R.id.btnAdvantages);
        btnDiary = (Button) getActivity().findViewById(R.id.btnDiary);
        btnLeaderboard = (Button) getActivity().findViewById(R.id.btnLeaderBoard);
        btnMembers = (Button) getActivity().findViewById(R.id.btnMembers);
        btnNews = (Button) getActivity().findViewById(R.id.btnNews);

        btnDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,LoginFragment.newInstance()).commit();
            }
        });
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,ProfileFragment.newInstance()).commit();
            }
        });
        btnAdvantages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,AdvantagesFragment.newInstance()).commit();
            }
        });
        btnDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,DiaryFragment.newInstance()).commit();
            }
        });
        btnLeaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,LeaderboardFragment.newInstance()).commit();
            }
        });
        btnMembers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,MembersFragment.newInstance()).commit();
            }
        });
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container,NewsFragment.newInstance()).commit();
            }
        });
    }

}
