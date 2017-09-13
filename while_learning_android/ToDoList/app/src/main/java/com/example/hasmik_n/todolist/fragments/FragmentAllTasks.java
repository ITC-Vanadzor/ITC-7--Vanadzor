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


/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentAllTasks extends Fragment {

    private ArrayList<Task> taskList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        taskList = getArguments().getParcelableArrayList("tasksList");
        ;
        return inflater.inflate(R.layout.fragment_all_tasks, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView reclist = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        reclist.setHasFixedSize(true);
        reclist.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView.Adapter mAdapter = new MyRecyclerViewAdapter(taskList);
        reclist.setAdapter(mAdapter);
    }
}