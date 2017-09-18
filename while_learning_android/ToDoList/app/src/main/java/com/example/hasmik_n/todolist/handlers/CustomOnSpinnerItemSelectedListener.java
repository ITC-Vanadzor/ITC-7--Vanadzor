package com.example.hasmik_n.todolist.handlers;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.example.hasmik_n.todolist.R;
import com.example.hasmik_n.todolist.fragments.FragmentFinishedTasks;

public class CustomOnSpinnerItemSelectedListener extends AppCompatActivity implements OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {


        Fragment fragmentOfLandingPage = new FragmentFinishedTasks();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentOfLandingPage);
        transaction.addToBackStack(null);
        transaction.commit();


        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}