package com.example.achuth.dazlabs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MissedAdapter extends RecyclerView.Adapter <MissedHolder>{
    private Context context;
    private ArrayList <Obj > objs;
    MissedAdapter(Context context, ArrayList<Obj> objs)
    {
        this.context=context;
        this.objs=objs;
    }
    @Override
    public MissedHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardlayout,viewGroup,false);
        return new MissedHolder(view);
    }

    @Override
    public void onBindViewHolder(MissedHolder missedHolder, int i) {
        Obj obj =objs.get(i);
        missedHolder.setDetails(obj);
    }

    @Override
    public int getItemCount() {
        return objs.size();
    }
}
