package com.example.hasmik_n.todolist.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hasmik_n.todolist.R;

import java.util.Calendar;

/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentAddTask extends Fragment   {

    OnTaskCreatedListener mCallback;

    // Container Activity must implement this interface
    public interface OnTaskCreatedListener {
        void onTaskSubmitted(String description, String dueDate);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnTaskCreatedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnTaskCreatedListener");
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

        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();

        final EditText taskDescription, taskDueDate;
        taskDescription   = getView().findViewById(R.id.task_description_input);
        taskDueDate = getView().findViewById(R.id.task_due_date_input);
        super.onActivityCreated(savedInstanceState);
        Button submitTaskButton = getView().findViewById(R.id.submit_task);
        submitTaskButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                // Send the event to the host activity
                if (taskDescription.getText().toString()!=null && !taskDescription.getText().toString().isEmpty() ) {
                    mCallback.onTaskSubmitted( taskDescription.getText().toString(), taskDueDate.getText().toString());
                } else {
                    Toast toast = Toast.makeText(view.getContext(), "Enter task at first", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        FloatingActionButton datePickerButton = getView().findViewById(R.id.calendar);
        datePickerButton.setOnClickListener(new View.OnClickListener() {
             EditText tfDueDate = getView().findViewById(R.id.task_due_date_input);
            @Override
            public void onClick(View view) {

                // TODO Can be moved to separate Fragment

                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

//                        Works for SDK 24
//                        GregorianCalendar c = new GregorianCalendar(year, monthOfYear, dayOfMonth);
//                        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");//
//                        String date = sdf.format(c.getTime()).toString();

                        String date = String.valueOf(year) +", "+ view.getMonth()
                                +", "+String.valueOf(dayOfMonth);
                        tfDueDate.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();
            }
        });
    }
}