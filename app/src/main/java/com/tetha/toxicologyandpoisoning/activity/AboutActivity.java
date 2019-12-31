package com.tetha.toxicologyandpoisoning.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.tetha.toxicologyandpoisoning.R;

public class AboutActivity extends AppCompatActivity {



    TextView textView_telegram, textView_admin, textView_developers;
    String telegramId = "https://t.me/mls_97";
    String admin_gmail = "Labratory.mrgums@gmail.com";
    String developers_gmail = "Tetha.nine@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView_telegram = findViewById(R.id.textView_about_telegram);
        textView_telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(telegramId));
                startActivity(intent);
            }
        });


        textView_admin = findViewById(R.id.textView_about_admin);
        textView_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + admin_gmail));
                startActivity(Intent.createChooser(intent, ""));
            }
        });

        textView_developers = findViewById(R.id.textView_about_developer);
        textView_developers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + developers_gmail));
                startActivity(Intent.createChooser(intent, ""));
            }
        });


    }
}
