package com.tetha.toxicologyandpoisoning.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.fragments.ItemsFragment;
import com.tetha.toxicologyandpoisoning.fragments.SearchFragment;
import com.tetha.toxicologyandpoisoning.fragments.StreamFragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_main, new ItemsFragment(this)).commitNow();

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
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, new SearchFragment(this)).commit();
                break;
            case R.id.bottom_navigation_item_stream:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main, new StreamFragment(this)).commit();
                break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.about_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
