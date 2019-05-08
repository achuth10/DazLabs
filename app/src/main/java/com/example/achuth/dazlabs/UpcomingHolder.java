package com.example.achuth.dazlabs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class UpcomingHolder extends RecyclerView.ViewHolder {
    private TextView name,number;
    public UpcomingHolder(@NonNull View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.UpcomingName);
    }
    public void setdetails(Obj obj)
    {
        name.setText(obj.getName());
    }
}
