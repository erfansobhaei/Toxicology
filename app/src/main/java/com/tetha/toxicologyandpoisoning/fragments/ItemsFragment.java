package com.tetha.toxicologyandpoisoning.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tetha.toxicologyandpoisoning.Adapter.ItemsAdapter;
import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.SplashScreenActivity;

public class ItemsFragment extends Fragment {

    Context context;
    RecyclerView mRecyclerView;

    public ItemsFragment( Context context) {
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecyclerView = view.findViewById(R.id.recyclerView_main_items);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(new ItemsAdapter(SplashScreenActivity.categoryModels));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_items, container, false);
    }

}
