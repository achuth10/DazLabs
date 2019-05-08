package com.example.achuth.dazlabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MissedFollow missedFollow;
    private UpcomingFollow upcomingFollow;
    private RecyclerView missed,upcoming;
    private ArrayList<Obj> objs;
    private MissedAdapter missedAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        missedFollow=new MissedFollow();
        upcomingFollow=new UpcomingFollow();
        replaceFragment(missedFollow);
        replaceFragment1(upcomingFollow);
        init();


    }

    private void init() {




    }


    public void replaceFragment(Fragment destFragment)
    {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.MissedFrame, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }
    public void replaceFragment1(Fragment destFragment)
    {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.UpcomingFrame, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }
}
