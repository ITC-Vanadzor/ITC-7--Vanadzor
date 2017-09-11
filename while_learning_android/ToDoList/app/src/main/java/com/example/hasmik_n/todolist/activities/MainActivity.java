package com.example.hasmik_n.todolist.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import com.example.hasmik_n.todolist.fragments.*;

import com.example.hasmik_n.todolist.R;

public class MainActivity extends FragmentActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragmentOfLandingPage = new FragmentLandingPage();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentOfLandingPage);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FloatingActionButton fab = findViewById(R.id.add_task);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Fragment fragmentToAddTask = new FragmentAddTask();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentToAddTask); // give your fragment container id in first parameter
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
    }

}
