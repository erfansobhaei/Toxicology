package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.ItemDescriptionActivity;
import com.tetha.toxicologyandpoisoning.activity.SplashScreenActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;
import com.tetha.toxicologyandpoisoning.model.ItemModel;

import java.util.ArrayList;

public class ItemListAdapter extends RecyclerView.Adapter<ItemHolder> {
    private static final String TAG = "ItemListAdapter";

    ArrayList<ItemModel> data;
    int id;

    public ItemListAdapter(int id) {
        this.id = id;
        init();
    }

    private void init() {
        data = SplashScreenActivity.categoryModels.get(id).getItems();
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: start");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemHolder viewHolder = new ItemHolder(inflater.inflate(R.layout.items_simple, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        holder.title.setText(data.get(position).getTitle());


        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ItemDescriptionActivity.class);
                intent.putExtra("title", data.get(position).getTitle());
                intent.putExtra("description", data.get(position).getDescription());
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}


class ItemHolder extends RecyclerView.ViewHolder {
    CardView container;
    TextView title;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        container = itemView.findViewById(R.id.items_simple_cardView);
        title = itemView.findViewById(R.id.item_textView);
    }
}
