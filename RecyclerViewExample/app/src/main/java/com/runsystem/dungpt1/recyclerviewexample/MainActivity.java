package com.runsystem.dungpt1.recyclerviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duyen", false));
        people.add(new Person("Long", true));
        people.add(new Person("My", false));
        people.add(new Person("Duong", true));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duyen", false));
        people.add(new Person("Duyen", false));


        rvItems = (RecyclerView) findViewById(R.id.rv_item);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvItems.setLayoutManager(layoutManager);
        rvItems.setHasFixedSize(true);
        rvItems.setAdapter(new RecyclerDataAdapter(this, people));
    }
}
