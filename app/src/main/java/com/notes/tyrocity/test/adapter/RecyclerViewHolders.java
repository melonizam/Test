package com.notes.tyrocity.test.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.notes.tyrocity.test.interfaces.ItemClickListener;
import com.notes.tyrocity.test.model.ItemObject;
import com.notes.tyrocity.test.R;


public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{


    public TextView title;

    public ImageView homeImageView;
    public CardView cardView;
    public Context context;
    ItemClickListener itemClickListener;
    private ItemObject currentItem;



    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        title = (TextView) itemView.findViewById(R.id.title);

        homeImageView = (ImageView) itemView.findViewById(R.id.homeImageView);
        cardView = (CardView) itemView.findViewById(R.id.carsCardView);

    }


    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());

    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    public void bind(ItemObject item) {

//        carTitle.setText(item.getMake());
//        carYear.setText(item.getYear());
//        carPrice.setText(item.getPrice());


        currentItem= item;
    }


//    @Override
//    public void onClick(View view) {
//        Toast.makeText(view.getContext(), "Clicked Country Position = " + items.get(getPosition()-1).getMake().toString(), Toast.LENGTH_SHORT).show();
////        Intent i = new Intent(context, CarInfoActivity.class);
////
////        i.putExtra("vehicleID", items.get());
////        context.startActivity(i);
//    }
}