package com.example.achuth.dazlabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFollow extends Fragment {
private RecyclerView upcoming;
private ImageButton whatsaap,phone;
private ArrayList <Obj> objs;
private UpcomingAdapter upcomingAdapter;


    public UpcomingFollow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_upcoming_follow, container, false);
        upcoming= (RecyclerView)v.findViewById(R.id.upcomingrecyler);
        objs=new ArrayList<>();
        upcoming.setLayoutManager(new LinearLayoutManager(getContext()));
        upcomingAdapter=new UpcomingAdapter(getContext(),objs);
        upcoming.setAdapter(upcomingAdapter);
        adddata();


        return v;
    }




    private void adddata() {
        objs.add(new Obj("Aditya Kapoor", "Class 11th-Topper", "828175987"));
        objs.add(new Obj("Aditya Kapoor", "Class 11th-Topper", "828175987"));
        objs.add(new Obj("Aditya Kapoor","Class 11th-Topper","828175987"));
        objs.add(new Obj("Aditya Kapoor","Class 11th-Topper","828175987"));
        upcomingAdapter.notifyDataSetChanged();
    }

}
