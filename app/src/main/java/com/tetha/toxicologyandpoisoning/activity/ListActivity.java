package com.tetha.toxicologyandpoisoning.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.tetha.toxicologyandpoisoning.Adapter.ListsAdapter;
import com.tetha.toxicologyandpoisoning.R;

public class ListActivity extends AppCompatActivity {

    Intent intent;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = findViewById(R.id.recyclerView_list_items);
        intent = getIntent();

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new ListsAdapter(intent.getIntExtra("id", 0)));


    }
}
