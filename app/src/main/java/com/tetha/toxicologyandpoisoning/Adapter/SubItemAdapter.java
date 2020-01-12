package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Context;
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
import com.tetha.toxicologyandpoisoning.activity.ItemListActivity;
import com.tetha.toxicologyandpoisoning.activity.ListActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class SubItemAdapter extends RecyclerView.Adapter<SubItemAdapter.SubItemHolder> {
    ArrayList<CategoryModel> data;
    int parentId;
    private Context activityContext;

    public SubItemAdapter(int parentId, ArrayList<CategoryModel> data) {
        this.parentId = parentId;
        this.data = data;
    }

    @NonNull
    @Override
    public SubItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SubItemHolder viewHolder = new SubItemHolder(inflater.inflate(R.layout.items_simple, parent, false));
        activityContext = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubItemHolder holder, final int position) {

        holder.title.setText(data.get(position).getTitle());
        Log.d(TAG, "onBindViewHolder: title : " + data.get(position).getTitle());


        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), ItemDescriptionActivity.class);
//                intent.putExtra("title", data.get(position).getItems().get(position).getTitle());
//                intent.putExtra("description", data.get(position).getItems().get(position).getDescription());
//                v.getContext().startActivity(intent);
//
                Intent intent = new Intent(v.getContext(), ItemListActivity.class);
                intent.putExtra("id", data.get(position).getId());
                activityContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SubItemHolder extends RecyclerView.ViewHolder {
        CardView container;
        TextView title;

        public SubItemHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.items_simple_cardView);
            title = itemView.findViewById(R.id.item_textView);
        }
    }
}
