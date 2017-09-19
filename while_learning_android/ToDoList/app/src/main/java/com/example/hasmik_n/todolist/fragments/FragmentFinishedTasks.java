package com.example.hasmik_n.todolist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.handlers.Task;
import com.example.hasmik_n.todolist.handlers.TasksRecyclerViewAdapter;

import java.util.ArrayList;


/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentFinishedTasks extends Fragment {

    private ArrayList<Task> tasks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tasks = getArguments().getParcelableArrayList("finishedTasksList");
        return inflater.inflate(R.layout.fragment_finished_tasks, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView tasksList = getView().findViewById(R.id.finished_tasks_recycler_view);
        tasksList.setHasFixedSize(true);
        tasksList.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.Adapter mAdapter = new TasksRecyclerViewAdapter(tasks);
        tasksList.setAdapter(mAdapter);
    }
}