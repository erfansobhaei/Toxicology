package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.ItemDescriptionActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


//fixme : this class is useless now
public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ItemHolder> {

    ArrayList<CategoryModel> data;
    int categoryId;

    public ListsAdapter(int categoryId, ArrayList<CategoryModel> categoryModels) {
        this.categoryId = categoryId;
        this.data = categoryModels;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ItemHolder(inflater.inflate(R.layout.subitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, final int position) {
        holder.textView.setText(data.get(categoryId).getItems().get(position).getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDescriptionActivity.class);
                intent.putExtra("title", data.get(categoryId).getItems().get(position).getTitle());
                intent.putExtra("description", data.get(categoryId).getItems().get(position).getDescription());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (data != null) {
            return data.get(categoryId).getItems().size();
        } else
            return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.search_result_item);
            textView = itemView.findViewById(R.id.item_textView);
        }
    }
}
