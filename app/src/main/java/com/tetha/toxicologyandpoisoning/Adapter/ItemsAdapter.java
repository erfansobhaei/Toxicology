package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.ItemListActivity;
import com.tetha.toxicologyandpoisoning.activity.ListActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;
import com.tetha.toxicologyandpoisoning.model.LinkerModel;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ItemsAdapter extends RecyclerView.Adapter <ItemsAdapter.ItemHolder> {
    private static final String TAG = "ItemsAdapter";

    Context activityContext;
    ArrayList<CategoryModel> data;
    ArrayList<LinkerModel> linker;

    public ItemsAdapter (ArrayList<CategoryModel> data, ArrayList<LinkerModel> linker){
        this.data = data;
        this.linker = linker;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        activityContext = parent.getContext();
        return new ItemHolder(inflater.inflate(R.layout.items_expandable_categories, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {

        try {

            holder.title.setText( data.get(position).getTitle() );
            Log.d(TAG, "onBindViewHolder: "+ data.get(position).getTitle());
//            holder.cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(v.getContext(), ListActivity.class);
//                    intent.putExtra("id", position );
//                    v.getContext().startActivity(intent);
//                }
//            });

            holder.headContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(linker.get(position).getItems().size() != 0) {
                        CategoryModel cm = data.get(position);
                        cm.setExpanded(!cm.isExpanded());
                        notifyItemChanged(position);
                    } else {
                        Intent intent = new Intent(activityContext , ItemListActivity.class);
                        intent.putExtra("id", position);
                        activityContext.startActivity(intent);
                    }
                }
            });

            holder.recyclerView.setLayoutManager(new LinearLayoutManager(activityContext));
            holder.recyclerView.setAdapter(new SubItemAdapter(position ,linker.get(position).getItems()));

        } catch(NullPointerException err) {
            Log.e("items adapter", "data ArrayList is empty!");
        } finally {

            boolean isExpanded = data.get(position).isExpanded();
            if(linker.get(position).getItems().size() != 0) {
                holder.recyclerView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
            }
            // todo : else -->
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView recyclerView;
        LinearLayout headContainer;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            headContainer = itemView.findViewById(R.id.expandable_category_head_container);
            recyclerView = itemView.findViewById(R.id.searchResultItems_layout_subItems_recyclerView);
            title = itemView.findViewById(R.id.expandable_category_title);
        }
    }
}
