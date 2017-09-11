package com.example.hasmik_n.todolist.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hasmik_n.todolist.R;

/**
 * Created by hasmik_n on 9/8/17.
 */

public class FragmentLandingPage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_landing_page, container, false);
    }

}
