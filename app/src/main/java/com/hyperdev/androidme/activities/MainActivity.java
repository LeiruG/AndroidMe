package com.hyperdev.androidme.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.hyperdev.androidme.R;
import com.hyperdev.androidme.data.BodyFragment;
import com.hyperdev.androidme.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {

            BodyFragment HFrag = new BodyFragment();
            HFrag.setPartList(AndroidImageAssets.getHeads());
            int HPos = getIntent().getIntExtra("hPos", 0);
            HFrag.setListPosition(HPos);
            getSupportFragmentManager().beginTransaction().add(R.id.FH, HFrag).commit();


            BodyFragment BFrag = new BodyFragment();
            BFrag.setPartList(AndroidImageAssets.getBodies());
            int BPos = getIntent().getIntExtra("bPos", 0);
            BFrag.setListPosition(BPos);
            getSupportFragmentManager().beginTransaction().add(R.id.FB, BFrag).commit();


            BodyFragment LFrag = new BodyFragment();
            LFrag.setPartList(AndroidImageAssets.getLegs());
            int LPos = getIntent().getIntExtra("lPos", 0);
            LFrag.setListPosition(LPos);
            getSupportFragmentManager().beginTransaction().add(R.id.FL, LFrag).commit();

        }

    }



}