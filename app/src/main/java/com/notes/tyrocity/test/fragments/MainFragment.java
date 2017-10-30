package com.notes.tyrocity.test.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.notes.tyrocity.test.R;
import com.notes.tyrocity.test.adapter.RecyclerViewAdapter;
import com.notes.tyrocity.test.interfaces.ItemClickListener;
import com.notes.tyrocity.test.model.ItemObject;
import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment{
    private static final String TAG = "MainFragment";

    FragmentActivity c;

    public MainFragment() {
        // Required empty public constructor
        Log.d(TAG, "MainFragment: ");
    }

    private LinearLayoutManager lLayout;
    List<ItemObject> rowListItem;
  


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.main_fragment, container, false);

        rowListItem = new ArrayList<>();
        lLayout = new LinearLayoutManager(getContext());

        c = new FragmentActivity();

        RecyclerView rView = (RecyclerView) v.findViewById(R.id.featuredCarsRecycleView);


        String[] title = new String[]{"Sceince-11", "Management-11", "Humanities-11", "Scince-12", "Management-12", "Humanities-12", "BBA",
                "Civil Engineering", "Law", "IT", "Old is Gold"};

        int[] imageUrl = new int[]{
                R.drawable.ic_science, R.drawable.ic_management, R.drawable.ic_humanities,
                R.drawable.ic_science, R.drawable.ic_management, R.drawable.ic_humanities,
                R.drawable.ic_science, R.drawable.ic_management, R.drawable.ic_humanities,
                R.drawable.ic_science, R.drawable.ic_management};

        for (int i = 0; i < title.length; i++) {
            String title1 = title[i];
            int imageUrl1 = imageUrl[i];

            ItemObject item = new ItemObject(title1.toString(), imageUrl1);


            rowListItem.add(item);
        }

        rView.setLayoutManager(lLayout);

        final RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(c, rowListItem);
        rView.setAdapter(rcAdapter);


        return v;
    }


}