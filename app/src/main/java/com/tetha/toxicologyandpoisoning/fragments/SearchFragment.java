package com.tetha.toxicologyandpoisoning.fragments;


import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tetha.toxicologyandpoisoning.Adapter.ListsAdapter;
import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.activity.MainActivity;
import com.tetha.toxicologyandpoisoning.activity.SplashScreenActivity;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;
import com.tetha.toxicologyandpoisoning.model.ItemModel;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;

//TODO: when no result found set "imageView_noresltFound" visible.
    //TODO: when some result found set items for "fragment_search_results_recyclerView" recycleView.

public class SearchFragment extends Fragment {

    Context context;
    EditText editText;
    DatabaseReference databaseReference;
    RecyclerView recyclerView;


    public SearchFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView = view.findViewById(R.id.fragment_search_results_recyclerView);
        editText = view.findViewById(R.id.editText_search);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                search();
            }
        });
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    search();
                    return true;
                }
                return false;
            }
        });

    }

    private void search() {
        databaseReference.child("toxins").orderByChild("title").startAt(editText.getText().toString()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                ArrayList<CategoryModel> data = new ArrayList<>();
                data.add(new CategoryModel("-1", 0));

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    data.get(0).addItem(new ItemModel(String.valueOf(snapshot.child("title").getValue()), String.valueOf(snapshot.child("description").getValue())));
                }

                recyclerView.setAdapter(new ListsAdapter(0, data));
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_search, container, false);
    }

}
