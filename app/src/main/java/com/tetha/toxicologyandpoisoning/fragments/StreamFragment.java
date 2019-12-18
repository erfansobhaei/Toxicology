package com.tetha.toxicologyandpoisoning.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetha.toxicologyandpoisoning.Adapter.StreamRecyclerViewAdapter;
import com.tetha.toxicologyandpoisoning.R;

 public class StreamFragment extends Fragment{

     Context context;
     RecyclerView videoRecyclerView;

     //TODO : cards toolbar

     public StreamFragment(Context context){
         this.context = context;
     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
         videoRecyclerView = view.findViewById(R.id.stream_recyclerView);
         videoRecyclerView.setLayoutManager(new LinearLayoutManager(context));
         videoRecyclerView.setAdapter(new StreamRecyclerViewAdapter());
     }

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

         return inflater.inflate(R.layout.fragment_stream, container, false);
     }

 }
