package com.example.achuth.dazlabs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class MissedHolder extends RecyclerView.ViewHolder{
    private TextView name,about;
    public MissedHolder(@NonNull View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.MissedName);
        about=(TextView)itemView.findViewById(R.id.MissedClass);
    }

    public void setDetails(Obj obj)
    {
        name.setText(obj.getName());
        about.setText(obj.getAbout());
    }
}
