package com.hyperdev.androidme.data;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import com.hyperdev.androidme.R;
import android.widget.ImageView;
import android.view.ViewGroup;
import java.util.ArrayList;
import android.view.View;
import android.os.Bundle;
import java.util.List;


public class BodyFragment extends Fragment {

    private List<Integer> Arr;private int pos;
    private static final String PartA = "partA", PartB = "partB";


    public BodyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        if(savedInstanceState != null){
            Arr = savedInstanceState.getIntegerArrayList(PartA);
            pos = savedInstanceState.getInt(PartB);
        }

        View rootView = inflater.inflate(R.layout.fragment_body, container, false);

        final ImageView imageView = (ImageView) rootView.findViewById(R.id.imgfrag);

        if(Arr !=null){
            imageView.setImageResource(Arr.get(pos));
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if(pos < Arr.size()-1){ pos++; }else { pos = 0;}
                    imageView.setImageResource(Arr.get(pos));
                }
            });
        }
        return rootView;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PartA, (ArrayList<Integer>)Arr);
        outState.putInt(PartB,pos);
    }

    public void setPartList(List<Integer> partList) {
        this.Arr = partList;
    }

    public void setListPosition(int ListPos) {
        this.pos = ListPos;
    }


}