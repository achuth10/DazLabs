package com.example.achuth.dazlabs;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class UpcomingAdapter extends RecyclerView.Adapter <UpcomingHolder> {
    private Context context;
    private ArrayList <Obj> objs;
    UpcomingAdapter(Context context,ArrayList <Obj> objs)
    {
        this.context=context;
        this.objs=objs;
    }
    @Override
    public UpcomingHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcominglayout,viewGroup,false);
        return new UpcomingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingHolder upcomingHolder, int i) {
        Obj obj= objs.get(i);
        upcomingHolder.setdetails(obj);
    }

    @Override
    public int getItemCount() {
        return objs.size();
    }
}
