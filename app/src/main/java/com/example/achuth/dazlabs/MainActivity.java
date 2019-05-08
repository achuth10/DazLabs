package com.example.achuth.dazlabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
MissedFollow missedFollow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        missedFollow=new MissedFollow();
        //replaceFragment(missedFollow);
    }
//    public void replaceFragment(Fragment destFragment)
//    {
//        // First get FragmentManager object.
//        FragmentManager fragmentManager = this.getSupportFragmentManager();
//
//        // Begin Fragment transaction.
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//        // Replace the layout holder with the required Fragment object.
//        fragmentTransaction.replace(//id of framelayout, destFragment);
//
//        // Commit the Fragment replace action.
//        fragmentTransaction.commit();
//    }
}
