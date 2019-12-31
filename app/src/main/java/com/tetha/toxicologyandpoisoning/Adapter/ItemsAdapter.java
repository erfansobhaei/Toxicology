package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.ListActivity;
import com.tetha.toxicologyandpoisoning.activity.SplashScreenActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//FIXME : when first time we come in this fragment its empty
//FIXME : when data is empty it import two empty cardView to recyclerView

public class ItemsAdapter extends RecyclerView.Adapter <ItemsAdapter.ItemHolder> {
    private static final String TAG = "ItemsAdapter";
    Context activityContext;

    ArrayList<CategoryModel> data;

    public ItemsAdapter (ArrayList<CategoryModel> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        activityContext = parent.getContext();
        return new ItemHolder(inflater.inflate(R.layout.search_result_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemHolder holder, final int position) {
        
        try {

            holder.textView.setText( data.get(position).getTitle() );
            Log.d(TAG, "onBindViewHolder: "+ data.get(position).getTitle());
//            holder.cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), ListActivity.class);
//                    intent.putExtra("id", position );
//                    v.getContext().startActivity(intent);
//                }
//            });
            holder.subitems.setLayoutManager(new LinearLayoutManager(activityContext));
            holder.subitems.setAdapter(new ListsAdapter(position, SplashScreenActivity.categoryModels));

        } catch(NullPointerException err) {
            Log.e("items adapter", "data ArrayList is empty!");
        } finally {

            boolean isExpanded = data.get(position).isExpanded();
            if(SplashScreenActivity.categoryModels.get(position).getSize() != 0)
                holder.subitems.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView subitems;
        LinearLayout title;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_item);
            textView = itemView.findViewById(R.id.item_textView);
            subitems = itemView.findViewById(R.id.searchResultItems_layout_subItems_recyclerView);

            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    CategoryModel cm = data.get(getAdapterPosition());
                    cm.setExpanded(!cm.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
