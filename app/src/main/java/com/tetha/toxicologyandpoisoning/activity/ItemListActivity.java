package com.tetha.toxicologyandpoisoning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tetha.toxicologyandpoisoning.Adapter.ItemListAdapter;
import com.tetha.toxicologyandpoisoning.Adapter.ListsAdapter;
import com.tetha.toxicologyandpoisoning.R;

public class ItemListActivity extends AppCompatActivity {
    private static final String TAG = "ItemListActivity";

    RecyclerView recyclerView;
    Intent intent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: start");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView_list_items);
        intent = getIntent();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new ItemListAdapter(intent.getIntExtra("id",0)));
    }
}
