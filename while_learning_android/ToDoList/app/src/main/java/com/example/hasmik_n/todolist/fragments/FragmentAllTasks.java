package com.example.hasmik_n.todolist.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hasmik_n.todolist.handlers.MyRecyclerViewAdapter;

/**
 * Created by hasmik_n on 9/8/17.
 */


public class FragmentAllTasks extends Fragment {
    String[] data = {"1", "2", "3", "4", "5", "6", "7"};

    public FragmentAllTasks() {
//        TODO
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView rv = new RecyclerView(getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new MyRecyclerViewAdapter(data));
        return rv;
    }

}