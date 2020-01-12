package com.tetha.toxicologyandpoisoning.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


public class StreamRecyclerViewAdapter extends RecyclerView.Adapter<StreamRecyclerViewViewHolder> {
    private static final String TAG = "StreamRecyclerViewAdapt";
    private ArrayList<String> links, titles;

    public StreamRecyclerViewAdapter(ArrayList<String> links, ArrayList<String> titles) {
        this.links = links;
        this.titles = titles;
    }

    @NonNull
    @Override
    public StreamRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_stream, parent, false);
        StreamRecyclerViewViewHolder viewHolder = new StreamRecyclerViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StreamRecyclerViewViewHolder holder, int position) {



            holder.webView.loadUrl(links.get(position));
            holder.webView.getSettings().setJavaScriptEnabled(true);

            holder.title.setText(titles.get(position));

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

       return links.size();
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
