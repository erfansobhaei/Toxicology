package com.tetha.toxicologyandpoisoning.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Spinner;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;
import com.tetha.toxicologyandpoisoning.model.ItemModel;

import java.util.ArrayList;
import java.util.Arrays;


public class SplashScreenActivity extends AppCompatActivity {

    AlertDialog dialog;
    SpinKitView progress_bar;

    public static ArrayList<String> categories = new ArrayList<>();
    public static ArrayList<String> links = new ArrayList<>();
    public static ArrayList<String> titles = new ArrayList<>();

    public static ArrayList<CategoryModel> categoryModels = new ArrayList<>();

    DatabaseReference databaseReference;
    ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        progress_bar = findViewById(R.id.spinKitView);

        checkConnection();
    }

    private void checkConnection() {
        if(connectivityManager.getActiveNetworkInfo()!= null
                && connectivityManager.getActiveNetworkInfo().isAvailable()
                && connectivityManager.getActiveNetworkInfo().isConnected()) {

                    getDataFromDatabase();
        } else {
            progress_bar.setVisibility(View.INVISIBLE);
            dialog = new AlertDialog.Builder(this).create();
            dialog.setTitle("Connection error");
            dialog.setMessage("Please check your internet connection and try again.");
            dialog.setButton(AlertDialog.BUTTON_NEUTRAL, "TRY AGAIN", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.dismiss();
                    progress_bar.setVisibility(View.VISIBLE);
                    checkConnection();
                }
            });
            dialog.show();
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    private void getDataFromDatabase() {

        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int numberOfToxins = Integer.parseInt((String.valueOf((dataSnapshot.child("connectors").getChildrenCount()))));


                for (int i = 0; i < numberOfToxins; i++) {


                    // Read Category Data
                    int categoryId = Integer.parseInt(String.valueOf(dataSnapshot.child("connectors").child(String.valueOf(i)).child("categoryId").getValue()));
                    String categoryTitle = (String) dataSnapshot.child("categories").child(String.valueOf(categoryId)).child("title").getValue();
                    int categoryType = Integer.parseInt(String.valueOf(dataSnapshot.child("categories").child(String.valueOf(categoryId)).child("type").getValue()));

                    // Read Item data
                    String itemId = String.valueOf(dataSnapshot.child("connectors").child(String.valueOf(i)).child("toxinId").getValue());
                    String itemTitle = String.valueOf(dataSnapshot.child("toxins").child(String.valueOf(itemId)).child("title").getValue());
                    String itemDescription = String.valueOf(dataSnapshot.child("toxins").child(String.valueOf(itemId)).child("description").getValue());

                    try {
                        // Add item if category exists
                        CategoryModel category = categoryModels.get(categoryId);
                        category.addItem(new ItemModel(itemTitle, itemDescription));
                    } catch (Exception e) {
                        // Add new category and item
                        categoryModels.add(new CategoryModel(categoryTitle, categoryType));
                        CategoryModel category = categoryModels.get(categoryId);
                        category.addItem(new ItemModel(itemTitle, itemDescription));
                    }

                }

                for (DataSnapshot snapshot: dataSnapshot.child("videos").getChildren()){

                    links.add(String.valueOf(snapshot.child("url").getValue()));
                    titles.add(String.valueOf(snapshot.child("title").getValue()));

                }

                startActivity( new Intent(SplashScreenActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
