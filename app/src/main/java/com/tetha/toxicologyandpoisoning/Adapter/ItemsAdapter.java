package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.ListActivity;
import com.tetha.toxicologyandpoisoning.activity.SplashScreenActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ItemsAdapter extends RecyclerView.Adapter <ItemsAdapter.ItemHolder> {

    ArrayList<CategoryModel> data = SplashScreenActivity.categoryModels;

    @NonNull
    @Override
    public ItemsAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ItemHolder(inflater.inflate(R.layout.description_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemHolder holder, final int position) {
        
        holder.textView.setText( data.get(position).getTitle() );
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                intent.putExtra("id", position );
                v.getContext().startActivity(intent);
            }
        });
        
        
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;
        public ItemHolder(@NonNull View itemView) {

            super(itemView);
            cardView = itemView.findViewById(R.id.item_cardView);
            textView = itemView.findViewById(R.id.item_textView);

        }
    }
}
