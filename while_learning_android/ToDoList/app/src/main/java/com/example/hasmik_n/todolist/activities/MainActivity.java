package com.example.hasmik_n.todolist.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.hasmik_n.todolist.fragments.FragmentAllTasks;
import com.example.hasmik_n.todolist.fragments.FragmentLandingPage;
import com.example.hasmik_n.todolist.fragments.FragmentAddTask;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.handlers.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FragmentAddTask.OnTaskCreatedListener {

    //TODO Use TasksManager
    private ArrayList<Task> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar customToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(customToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
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
