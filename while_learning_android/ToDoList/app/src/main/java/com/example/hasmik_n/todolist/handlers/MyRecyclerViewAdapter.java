package com.example.hasmik_n.todolist.handlers;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A Simple Adapter for the RecyclerView
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.SimpleViewHolder> {
    private String[] dataSource;
    public MyRecyclerViewAdapter(String[] dataArgs){
        dataSource = dataArgs;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = new TextView(parent.getContext());
        SimpleViewHolder viewHolder = new SimpleViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.textView.setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }

    /**
     * A Simple ViewHolder for the RecyclerView
     */
    public static class SimpleViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }
    }
}

