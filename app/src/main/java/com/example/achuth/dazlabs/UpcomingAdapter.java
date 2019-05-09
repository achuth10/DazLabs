package com.example.achuth.dazlabs;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class UpcomingAdapter extends RecyclerView.Adapter <UpcomingAdapter.UpcomingHolder> {
    private Context context;
    private ArrayList<Obj> objs;

    UpcomingAdapter(Context context, ArrayList<Obj> objs) {
        this.context = context;
        this.objs = objs;
    }

    @Override
    public UpcomingHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.upcominglayout, viewGroup, false);
        return new UpcomingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UpcomingHolder upcomingHolder, int i) {
        Obj obj = objs.get(i);
        upcomingHolder.setdetails(obj);
    }

    @Override
    public int getItemCount() {
        return objs.size();
    }


    public class UpcomingHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView name, about;
        private ImageButton whatsaap, phonebtn;
        private ImageView delete;
        private PackageManager pm;
        private final Context context;

        public UpcomingHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            pm = context.getPackageManager();
            name = (TextView) itemView.findViewById(R.id.UpcomingName);
            about = (TextView) itemView.findViewById(R.id.upcomingabout);
            delete = (ImageView) itemView.findViewById(R.id.Upcomingedit);
            whatsaap = (ImageButton) itemView.findViewById(R.id.whatsaapbtn);
            phonebtn = (ImageButton) itemView.findViewById(R.id.Phonebtn);
            whatsaap.setOnClickListener(this);
            phonebtn.setOnClickListener(this);
            delete.setOnClickListener(this);
        }

        public void setdetails(Obj obj) {
            name.setText(obj.getName());
            about.setText(obj.getAbout());
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == whatsaap.getId()) {
                try {
                    String message = "Hello";
                    String phone = "+919999999999";
                    String url = "https://api.whatsapp.com/send?phone=" + phone + "&text=" + URLEncoder.encode(message, "UTF-8");
                    PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
                    Intent sendIntent = new Intent();
                    sendIntent.setData(Uri.parse(url));
                    sendIntent.setPackage("com.whatsapp");
                    context.startActivity(sendIntent);
                } catch (PackageManager.NameNotFoundException e) {
                    Toast.makeText(context, "Whatsaap not installed", Toast.LENGTH_SHORT).show();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } else if (v.getId() == phonebtn.getId()) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + "9999999999"));
                context.startActivity(callIntent);
            }
//            else if(v.getId()==delete.getId())
//            {
//                AlertDialog.Builder builder=new AlertDialog.Builder(context);
//                builder.setTitle("Delete lead");
//                builder.setMessage("Are you sure you want to delete this lead?");
//                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        deleteItem(getAdapterPosition());
//                    }
//                });
//                builder.setNegativeButton("Cancel",null);
//                builder.setIcon(R.drawable.ic_warning_black_24dp);
//                AlertDialog alertDialog =builder.create();
//                alertDialog.show();
//            }
//        }
//    }
//    private void deleteItem(int adapterPosition) {
//        objs.remove(adapterPosition);
//        notifyItemRemoved(adapterPosition);
//    }

        }
    }
}
