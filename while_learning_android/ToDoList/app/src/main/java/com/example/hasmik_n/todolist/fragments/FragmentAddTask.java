package com.example.hasmik_n.todolist.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hasmik_n.todolist.R;

/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentAddTask extends Fragment {

    OnHeadlineSelectedListener mCallback;

    // Container Activity must implement this interface
    public interface OnHeadlineSelectedListener {
        public void onTaskSubmitted(String description, String duedate);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnHeadlineSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button submitTaskButton = getView().findViewById(R.id.submit_task);
        submitTaskButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                // Send the event to the host activity
                mCallback.onTaskSubmitted("text","text");

                Fragment fragmentOfAllTasks = new FragmentAllTasks();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentOfAllTasks);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
