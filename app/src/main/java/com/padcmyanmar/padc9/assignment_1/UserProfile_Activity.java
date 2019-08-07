package com.padcmyanmar.padc9.assignment_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UserProfile_Activity extends AppCompatActivity {

    private final static int REQUEST_CODE_1 = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);

        TextView userName_tv = findViewById(R.id.userName_tv);
        TextView userEmail_tv = findViewById(R.id.userEmail_tv);
        TextView userPhone_tv = findViewById(R.id.userPh_tv);

        Intent intent = getIntent();
        userName_tv.setText(intent.getStringExtra("name"));
        userEmail_tv.setText(intent.getStringExtra("email"));
        userPhone_tv.setText(intent.getStringExtra("phone"));

        ImageView profile_back_iv = findViewById(R.id.profile_back_iv);
        profile_back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ImageView flash_iv = findViewById(R.id.flash_iv);
        flash_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile_Activity.this, FlashDetail_Activity.class);
                startActivityForResult(intent, REQUEST_CODE_1);
            }
        });

        ImageView hotel_iv = findViewById(R.id.hotel_iv);
        hotel_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Coming soon", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent dataIntent) {
        super.onActivityResult(requestCode, resultCode, dataIntent);
        switch (requestCode)
        {
            case REQUEST_CODE_1:

                TextView rating_tv = findViewById(R.id.rating_tv);

                if(resultCode == RESULT_OK)
                {
                    String messageReturn = dataIntent.getStringExtra("rating");
                    rating_tv.setText(messageReturn);
                }
        }
    }
}
