package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Intent;
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

import java.util.ArrayList;

public class SearchResultAdatper extends RecyclerView.Adapter<SearchResultItemHolder> {
    int id;
    ArrayList<CategoryModel> data;

    public SearchResultAdatper(int id , ArrayList<CategoryModel> data) {
        this.id = id;
        this.data = data;
    }

//    private void init() {
//        data = SplashScreenActivity.categoryModels;
//    }

    @NonNull
    @Override
    public SearchResultItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SearchResultItemHolder(inflater.inflate(R.layout.items_simple, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultItemHolder holder, final int position) {
        holder.textView.setText(data.get(id).getItems().get(position).getTitle());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ItemDescriptionActivity.class);
                intent.putExtra("title", data.get(id).getItems().get(position).getTitle());
                intent.putExtra("description", data.get(id).getItems().get(position).getDescription());

                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

class SearchResultItemHolder extends RecyclerView.ViewHolder {
    CardView cardView;
    TextView textView;


    public SearchResultItemHolder(@NonNull View itemView) {
        super(itemView);
        cardView = itemView.findViewById(R.id.items_simple_cardView);
        textView = itemView.findViewById(R.id.item_textView);
    }
}
