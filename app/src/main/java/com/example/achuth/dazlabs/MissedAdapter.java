package com.example.achuth.dazlabs;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MissedAdapter extends RecyclerView.Adapter <MissedAdapter.MissedHolder> {
    private Context context;
    private ArrayList<Obj> objs;

    MissedAdapter(Context context, ArrayList<Obj> objs) {
        this.context = context;
        this.objs = objs;
    }

    @Override
    public MissedHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardlayout, viewGroup, false);
        return new MissedHolder(view);
    }

    @Override
    public void onBindViewHolder(MissedHolder missedHolder, int i) {
        Obj obj = objs.get(i);
        missedHolder.setDetails(obj);
    }

    @Override
    public int getItemCount() {
        return objs.size();
    }


    public class MissedHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name, about;
        private ImageView delete;

        public MissedHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.MissedName);
            about = (TextView) itemView.findViewById(R.id.MissedClass);
            delete = (ImageView) itemView.findViewById(R.id.MissedDelete);
            delete.setOnClickListener(this);
        }

        public void setDetails(Obj obj) {
            name.setText(obj.getName());
            about.setText(obj.getAbout());
        }

        @Override
        public void onClick(View v) {
            deleteItem(getAdapterPosition());
        }
    }

    private void deleteItem(int adapterPosition) {
        objs.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

}