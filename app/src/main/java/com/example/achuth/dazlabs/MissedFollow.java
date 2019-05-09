package com.example.achuth.dazlabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MissedFollow extends Fragment {


    private RecyclerView missed;
    private ArrayList<Obj> objs;
    private MissedAdapter missedAdapter;

    public MissedFollow() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=  inflater.inflate(R.layout.fragment_missed_follow, container, false);

        objs=new ArrayList<>();
        missed=(RecyclerView)v.findViewById(R.id.missedrecyler);
        missed.setLayoutManager(new LinearLayoutManager(
                getContext()
        ));
        missedAdapter=new MissedAdapter(getContext(),objs);
        missed.setAdapter(missedAdapter);
        adddata();
        return  v;
    }

    private void adddata() {
        objs.add(new Obj("Aditya Kapoor","Class 11th-Topper","828175987"));
        objs.add(new Obj("Aditya Kapoor","Class 11th-Topper","828175987"));
        objs.add(new Obj("Aditya Kapoor","Class 11th-Topper","828175987"));
        objs.add(new Obj("Aditya Kapoor","Class 11th-Topper","828175987"));
        missedAdapter.notifyDataSetChanged();

    }

}
