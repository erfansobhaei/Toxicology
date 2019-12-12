package com.tetha.toxicologyandpoisoning.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tetha.toxicologyandpoisoning.R;

 public class StreamFragment extends Fragment{

     Context context;


     public StreamFragment(Context context){
         this.context = context;
     }

     @Override
     public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

     }

     @Override
     public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {

         return inflater.inflate(R.layout.fragment_stream, container, false);
     }

 }
