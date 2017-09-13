package com.example.hasmik_n.todolist.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.example.hasmik_n.todolist.fragments.FragmentAllTasks;
import com.example.hasmik_n.todolist.fragments.FragmentLandingPage;
import com.example.hasmik_n.todolist.fragments.FragmentAddTask;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.handlers.Task;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements FragmentAddTask.OnHeadlineSelectedListener {

    //TODO Use TasksManager
    private ArrayList<Task> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasksList = new ArrayList<>();
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentToAddTask = new FragmentAddTask();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentToAddTask);
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
    }

    public void onTaskSubmitted(String desc, String deadline) {
        Task task = new Task(desc,deadline,false);
        tasksList.add(task);
        Fragment fragmentOfAllTasks = new FragmentAllTasks();
        Bundle args = new Bundle();
        args.putParcelableArrayList ("tasksList", tasksList );
        fragmentOfAllTasks.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentOfAllTasks);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
