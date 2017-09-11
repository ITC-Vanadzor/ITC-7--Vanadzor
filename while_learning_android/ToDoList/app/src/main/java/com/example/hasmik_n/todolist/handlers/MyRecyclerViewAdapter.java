package com.example.hasmik_n.todolist.handlers;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.fragments.FragmentAllTasks;

import java.util.Collections;
import java.util.List;
/**
 * A Simple Adapter for the RecyclerView
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<FragmentAllTasks.SimpleViewHolder> {
    private String[] dataSource;
    public MyRecyclerViewAdapter(String[] dataArgs){
        dataSource = dataArgs;
    }

    @Override
    public FragmentAllTasks.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new TextView(parent.getContext());
        FragmentAllTasks.SimpleViewHolder viewHolder = new FragmentAllTasks.SimpleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FragmentAllTasks.SimpleViewHolder holder, int position) {
        holder.textView.setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }
}