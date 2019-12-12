package com.tetha.toxicologyandpoisoning.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.fragments.ItemsFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, new ItemsFragment(this)).commit();
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);


    }

    private void setupViews() {
        mBottomNavigationView = findViewById(R.id.bottom_navigation_main);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.bottom_navigation_item_items:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, new ItemsFragment(this)).commit();
                break;
            case R.id.bottom_navigation_item_search:
                Toast.makeText(this, "search fragment", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bottom_navigation_item_stream:
                Toast.makeText(this, "video fragment", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
