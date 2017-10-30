package com.notes.tyrocity.test.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.notes.tyrocity.test.MainActivity;
import com.notes.tyrocity.test.fragments.HomeSecondFragment;
import com.notes.tyrocity.test.interfaces.ItemClickListener;
import com.notes.tyrocity.test.model.ItemObject;

import com.notes.tyrocity.test.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<ItemObject> itemList;
    private Context context;
    FragmentActivity c;


    public RecyclerViewAdapter(FragmentActivity c, List<ItemObject> itemList) {
        this.itemList = itemList;
        this.c= c;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_view_list, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, final int position) {
        holder.title.setText(itemList.get(position).getName());


        holder.homeImageView.setImageResource(itemList.get(position).getImageUrl());

//        holder.cardView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                //Here goes your desired onClick behaviour. Like:
//                Toast.makeText(view.getContext(), "You have clicked " + view.getTransitionName(), Toast.LENGTH_SHORT).show(); //you can add data to the tag of your cardview in onBind... and retrieve it here with with.getTag().toString()..
//                //You can change the fragment, something like this, not tested, please correct for your desired output:
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                HomeSecondFragment homeSecondFragment = new HomeSecondFragment();
//                //Create a bundle to pass data, add data, set the bundle to your fragment and:
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeSecondFragment).addToBackStack(null).commit();
//            }
//        });


        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                Toast.makeText(v.getContext(), "You have clicked " + itemList.get(position).getName(), Toast.LENGTH_SHORT).show();

                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                HomeSecondFragment homeSecondFragment = new HomeSecondFragment();

                //Create a bundle to pass data, add data, set the bundle to your fragment and:
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeSecondFragment).addToBackStack(null).commit();


//                Intent i = new Intent(context, CarInfoActivity.class);
//                i.putExtra("vehicleID", itemList.get(position).getId());
//                context.startActivity(i);


//                HomeSecondFragment homeSecondFragment = new HomeSecondFragment();
//
//                FragmentManager fragmentManager = c.getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment_container, homeSecondFragment);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();

//                Toast.makeText(context, "name "+ itemList.get(pos).getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}