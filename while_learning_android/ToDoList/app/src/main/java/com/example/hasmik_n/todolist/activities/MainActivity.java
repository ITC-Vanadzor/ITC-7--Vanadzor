package com.example.hasmik_n.todolist.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import com.example.hasmik_n.todolist.fragments.FragmentLandingPage;
import com.example.hasmik_n.todolist.fragments.FragmentAddTask;
import com.example.hasmik_n.todolist.fragments.FragmentAllTasks;

import com.example.hasmik_n.todolist.R;

public class MainActivity extends FragmentActivity implements FragmentAddTask.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment fragmentOfLandingPage = new FragmentLandingPage();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragmentOfLandingPage);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FloatingActionButton fab = findViewById(R.id.add_task);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentToAddTask = new FragmentAddTask();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentToAddTask);
                transaction.addToBackStack(null);  // if written, this transaction will be added to backstack
                transaction.commit();
            }
        });
    }

    public void onTaskSubmitted(String desc, String deadline) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article


//        Fragment allTasksFrag = (Fragment)
//                getSupportFragmentManager().findFragmentById(R.id.all_tasks_fragment);

//        if (allTasksFrag != null) {
//            // If article frag is available, we're in two-pane layout...
//
//            // Call a method in the ArticleFragment to update its content
//            allTasksFrag.updateArticleView(position);
//        } else {
//            // Otherwise, we're in the one-pane layout and must swap frags...
//
//            // Create fragment and give it an argument for the selected article
//            FragmentAllTasks newFragment = new FragmentAllTasks();
//            Bundle args = new Bundle();
//            args.putInt(FragmentAllTasks.ARG_POSITION, position);
//            newFragment.setArguments(args);
//
//            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//
//            // Replace whatever is in the fragment_container view with this fragment,
//            // and add the transaction to the back stack so the user can navigate back
//            transaction.replace(R.id.fragment_container, newFragment);
//            transaction.addToBackStack(null);
//
//            // Commit the transaction
//            transaction.commit();
    }
}
