package com.tetha.toxicologyandpoisoning.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;

public class ItemDescriptionActivity extends AppCompatActivity {

    Intent intent;
    TextView textViewTitle;
    TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        intent = getIntent();
        textViewTitle = findViewById(R.id.textView_itemDescription_title);
        textViewDescription = findViewById(R.id.textView_itemDescription_description);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
