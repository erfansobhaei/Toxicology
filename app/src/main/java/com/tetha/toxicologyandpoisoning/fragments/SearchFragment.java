package com.tetha.toxicologyandpoisoning.fragments;


import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.MainActivity;

    //TODO: when no result found set "imageView_noresltFound" visible.
    //TODO: when some result found set items for "fragment_search_results_recyclerView" recycleView.

public class SearchFragment extends Fragment {

    Context context;


    public SearchFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}
