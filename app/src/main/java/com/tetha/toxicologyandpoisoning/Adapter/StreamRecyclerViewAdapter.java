package com.tetha.toxicologyandpoisoning.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.tetha.toxicologyandpoisoning.R;

//TODO : update onBindViewHolder(...) , getItemCount()

public class StreamRecyclerViewAdapter extends RecyclerView.Adapter<StreamRecyclerViewViewHolder>{
    private static final String TAG = "StreamRecyclerViewAdapt";


    @NonNull
    @Override
    public StreamRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_item, parent, false);
        StreamRecyclerViewViewHolder viewHolder = new StreamRecyclerViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StreamRecyclerViewViewHolder holder, int position) {
        Log.d(TAG ,"onBindViewHolder called .");


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class StreamRecyclerViewViewHolder extends RecyclerView.ViewHolder {

    WebView webView;
    TextView title;
    CardView parent;
    public StreamRecyclerViewViewHolder(@NonNull View itemView) {

        super(itemView);
        title = itemView.findViewById(R.id.streamfragment_item_title);
        webView = itemView.findViewById(R.id.streamFragment_item_webView);
        parent = itemView.findViewById(R.id.streamFragemnt_parent);

    }
}
