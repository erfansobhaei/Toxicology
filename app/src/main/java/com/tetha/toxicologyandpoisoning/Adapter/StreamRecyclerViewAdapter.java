package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
import com.tetha.toxicologyandpoisoning.R;

//FIXME : fix titles in onBindViewHolder(...)
//FIXME : fix getItemCount()

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
        holder.webView.loadUrl("https://www.google.com");
        holder.webView.getSettings().setJavaScriptEnabled(true);

        holder.title.setText("this is holder title");

        final String VIDEO_URL = holder.webView.getUrl();
        holder.share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, VIDEO_URL);
                intent.setType("text/plain");
                view.getContext().startActivity(Intent.createChooser(intent, "share"));
            }
        });
    }

    @Override
    public int getItemCount() {

        //FIXME : fix here
        return 2;
    }
}

class StreamRecyclerViewViewHolder extends RecyclerView.ViewHolder {

    WebView webView;
    TextView title;
    CardView parent;
    ImageView share_btn;
    public StreamRecyclerViewViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.streamfragment_item_title);
        webView = itemView.findViewById(R.id.streamFragment_item_webView);
        parent = itemView.findViewById(R.id.streamFragemnt_parent);
        share_btn = itemView.findViewById(R.id.streamFragment_item_share_imageView);
    }
}
