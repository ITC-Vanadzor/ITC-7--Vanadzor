package com.example.hasmik_n.todolist.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.handlers.TasksRecyclerViewAdapter;
import com.example.hasmik_n.todolist.handlers.Task;

import java.util.ArrayList;


/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentAllTasks extends Fragment {

    private ArrayList<Task> tasks;
    TasksRecyclerViewAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        tasks = getArguments().getParcelableArrayList("tasksList");
        return inflater.inflate(R.layout.fragment_all_tasks, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView tasksList = getView().findViewById(R.id.my_recycler_view);
        tasksList.setHasFixedSize(true);
        tasksList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new TasksRecyclerViewAdapter(tasks);
        tasksList.setAdapter(mAdapter);
        FloatingActionButton fab = getView().findViewById(R.id.add_task);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        search(searchView);
        super.onCreateOptionsMenu(menu,inflater);
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

}