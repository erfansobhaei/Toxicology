package com.tetha.toxicologyandpoisoning.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;

public class ItemDescriptionActivity extends AppCompatActivity {
    private final String TAG = ItemDescriptionActivity.class.getSimpleName();

    Intent intent;
    TextView textViewTitle;
    TextView textViewDescription;
    ImageView sharebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        intent = getIntent();
        textViewTitle = findViewById(R.id.textView_itemDescription_title);
        textViewDescription = findViewById(R.id.textView_itemDescription_description);
        sharebutton = findViewById(R.id.activity_item_description_share_imageView);

        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textViewDescription.getText() != null && textViewTitle != null) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_SUBJECT, textViewTitle.getText());
                    intent.putExtra(Intent.EXTRA_TEXT, textViewDescription.getText());
                    intent.setType("text/plain");
                    view.getContext().startActivity(Intent.createChooser(intent, "share description"));
                } else
                    Log.e(TAG, "cant share because title or description is null");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
