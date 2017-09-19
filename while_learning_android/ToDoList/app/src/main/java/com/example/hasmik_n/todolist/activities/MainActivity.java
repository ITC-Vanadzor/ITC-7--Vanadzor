package com.example.hasmik_n.todolist.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.hasmik_n.todolist.fragments.FragmentAllTasks;
import com.example.hasmik_n.todolist.fragments.FragmentFinishedTasks;
import com.example.hasmik_n.todolist.fragments.FragmentLandingPage;
import com.example.hasmik_n.todolist.fragments.FragmentAddTask;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.handlers.Task;
import com.example.hasmik_n.todolist.handlers.TasksHolder;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements FragmentAddTask.OnTaskCreatedListener {

    // TODO Get rid of static members
    public static TasksHolder tasksHolder;
    private ArrayList tasksList;
    private boolean isTaskCreated = false;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar customToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(customToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tasksHolder = new TasksHolder();
        Fragment fragmentOfLandingPage = new FragmentLandingPage();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentOfLandingPage);
        transaction.addToBackStack(null);
        transaction.commit();
        addListenerOnSpinnerItemSelection();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FloatingActionButton fab = findViewById(R.id.add_task);
        if (fab != null) {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);

        return true;
    }


    private void search(SearchView searchView) {

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                mAdapter.getFilter().filter(newText);
                return true;
            }
        });
    }

    public void onTaskSubmitted(String desc, String deadline) {
        isTaskCreated = true;
        getSupportActionBar().show();
        Task task = new Task(desc, deadline, false);
        tasksList = tasksHolder.getTasksList();
        tasksList.add(task);
        Fragment fragmentOfAllTasks = new FragmentAllTasks();
        Bundle args = new Bundle();
        args.putParcelableArrayList("tasksList", tasksList);
        fragmentOfAllTasks.setArguments(args);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentOfAllTasks);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        @Override
         public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

//            TODO Create base fragment class

            if (position == 1){
                Fragment fragmentOfFinishedTasks = new FragmentFinishedTasks();
                Bundle args = new Bundle();
                args.putParcelableArrayList("finishedTasksList", tasksHolder.getFinishedTasksList());
                fragmentOfFinishedTasks.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentOfFinishedTasks);
                transaction.addToBackStack(null);
                transaction.commit();
            } else {
                if (isTaskCreated) {
                Fragment fragmentOfAllTasks = new FragmentAllTasks();
                Bundle args = new Bundle();
                args.putParcelableArrayList("tasksList", tasksList);
                fragmentOfAllTasks.setArguments(args);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentOfAllTasks);
                transaction.addToBackStack(null);
                transaction.commit();
                }
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parentView) {
            //TODO Add the corresponding code base if required
            }
        }
        );
    }

}
