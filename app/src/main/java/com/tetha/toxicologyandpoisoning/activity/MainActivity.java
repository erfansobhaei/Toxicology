package com.tetha.toxicologyandpoisoning.activity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tetha.toxicologyandpoisoning.R;
import com.tetha.toxicologyandpoisoning.model.CategoryModel;
import com.tetha.toxicologyandpoisoning.model.ItemModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> categories = new ArrayList<>();

    public static ArrayList<CategoryModel> categoryModels = new ArrayList<>();

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromDatabase();


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
                        categoryModels.add(new CategoryModel(categoryTitle));
                        CategoryModel category = categoryModels.get(categoryId);
                        category.addItem(new ItemModel(itemTitle, itemDescription));
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
