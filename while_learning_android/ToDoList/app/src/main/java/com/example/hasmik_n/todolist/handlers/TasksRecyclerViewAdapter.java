package com.example.hasmik_n.todolist.handlers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.hasmik_n.todolist.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.hasmik_n.todolist.activities.MainActivity.tasksHolder;

public class TasksRecyclerViewAdapter extends RecyclerView.Adapter<TasksRecyclerViewAdapter.ViewHolder> implements Filterable {
    private List<Task> taskList;
    private List<Task> mArrayList;
    private List<Task> mFilteredList;



    public TasksRecyclerViewAdapter(List<Task> tasks) {
        this.taskList = tasks;
    }

    @Override
    public TasksRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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
                tasksHolder.addToFinishedTasksList(task);
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mFilteredList = taskList;
                } else {
                    ArrayList<Task> filteredList = new ArrayList<>();
                    for (Task task : taskList) {
                        if (task.getDescription().toLowerCase().contains(charString)) {
                            filteredList.add(task);
                        }
                    }
                    mFilteredList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<Task>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}