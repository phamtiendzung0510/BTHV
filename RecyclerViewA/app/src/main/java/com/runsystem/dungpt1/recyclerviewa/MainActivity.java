package com.runsystem.dungpt1.recyclerviewa;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClick, SwipeRefreshLayout.OnRefreshListener, OnItemClickIem {

    RecyclerView recyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        final List<MultiTypeBean> multiTypeBeanList = new ArrayList<>();
        multiTypeBeanList.add(new MultiTypeBean("Android header","http://www.avatarsdb.com/avatars/spongebob_happy.jpg","Title header", MultiTypeBean.HEADER));
        for (int i=0;i<100;i++){
            multiTypeBeanList.add(new MultiTypeBean("Android "+i,"http://www.avatarsdb.com/avatars/spongebob_happy.jpg","Title "+i, MultiTypeBean.ITEM));
        }

        final MultiTypeAdapter demoAdapter = new MultiTypeAdapter(multiTypeBeanList);
        demoAdapter.setOnItemClick(this);
        demoAdapter.setOnItemClickIem(this);
        recyclerView.setAdapter(demoAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,null));
//        recyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
//            @Override
//            public void onLoadMore(int currentPage) {
//                multiTypeBeanList.add(new MultiTypeBean("Android header","http://www.avatarsdb.com/avatars/spongebob_happy.jpg","Title header 1", MultiTypeBean.HEADER));
//                demoAdapter.notifyDataSetChanged();
//            }
//        });
    }


    @Override
    public void onItemClick(View v, int position) {
        Toast.makeText(this,"click" + position,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onItemClickItem(int viewID) {
        Toast.makeText(this,"View ID "+viewID,Toast.LENGTH_LONG).show();
    }
}
