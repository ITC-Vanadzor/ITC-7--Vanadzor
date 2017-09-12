package com.example.hasmik_n.todolist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.handlers.MyRecyclerViewAdapter;
import com.example.hasmik_n.todolist.handlers.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentAllTasks extends Fragment {

    private List<Task> taskList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_tasks, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        taskList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Task st = new Task("Task Description - " + i, "Task Due Date - " + i, false);
            taskList.add(st);
        }
        RecyclerView reclist = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        reclist.setHasFixedSize(true);
        reclist.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.Adapter mAdapter = new MyRecyclerViewAdapter(taskList);
        reclist.setAdapter(mAdapter);
    }
}