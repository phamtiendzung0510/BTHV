package com.journaldev.recyclerviewmultipleviewtype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ArrayList<Model> list= new ArrayList<>();
        list.add(new Model(Model.TEXT_TYPE,"Xin chào, đây là text :))",0));
        list.add(new Model(Model.IMAGE_TYPE,"Ảnh này nhìn đẹp không?",R.drawable.wtc));
        list.add(new Model(Model.TEXT_TYPE,"Xin chào, lại là text đây :))",0));
        list.add(new Model(Model.IMAGE_TYPE,"Ảnh này có vẻ đẹp hơn nhỉ",R.drawable.snow));
        list.add(new Model(Model.TEXT_TYPE,"Text trở lại rồi nè",0));
        list.add(new Model(Model.IMAGE_TYPE,"Tui lại thấy thích cái ảnh này hơn",R.drawable.wtc));

        MultiViewTypeAdapter adapter = new MultiViewTypeAdapter(list,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(adapter);

    }

}
