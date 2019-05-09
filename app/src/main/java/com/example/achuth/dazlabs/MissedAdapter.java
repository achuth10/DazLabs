package com.example.achuth.dazlabs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("Delete lead");
            builder.setMessage("Are you sure you want to delete this lead?");
            builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    deleteItem(getAdapterPosition());
                    Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel",null);
            builder.setIcon(R.drawable.ic_warning_black_24dp);
            AlertDialog alertDialog =builder.create();
            alertDialog.show();
        }
    }

    private void deleteItem(int adapterPosition) {
        objs.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

}