package com.example.hasmik_n.todolist.handlers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.hasmik_n.todolist.R;

import java.util.List;

public class FinishedTasksRecyclerViewAdapter extends RecyclerView.Adapter<FinishedTasksRecyclerViewAdapter.ViewHolder> {
    private List<Task> taskList;
    private List<Task> finishedTaskList;

    public FinishedTasksRecyclerViewAdapter(List<Task> tasks) {
        this.taskList = tasks;
    }

    @Override
    public FinishedTasksRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, null);
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        final int pos = position;
        final Task task = taskList.get(position);
        viewHolder.tvDescription.setText(task.getDescription());
        viewHolder.tvDueDate.setText(task.getDueDate());
        viewHolder.chkSelected.setChecked(task.isSelected());
        viewHolder.chkSelected.setTag(taskList.get(position));
        viewHolder.chkSelected.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                TODO
                finishedTaskList.add(task);
                taskList.remove(viewHolder.getAdapterPosition());
                notifyItemRemoved(position);
                notifyItemRangeChanged(viewHolder.getAdapterPosition(),taskList.size());
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvDescription;
        public TextView tvDueDate;
        public CheckBox chkSelected;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            tvDescription = (TextView) itemLayoutView.findViewById(R.id.task_details);
            tvDueDate = (TextView) itemLayoutView.findViewById(R.id.task_deadline);
            chkSelected = (CheckBox) itemLayoutView.findViewById(R.id.checkBox);
        }
    }
}