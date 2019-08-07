package com.padcmyanmar.padc9.assignment_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name_et = findViewById(R.id.name_et);
        final EditText email_et = findViewById(R.id.email_et);
        final EditText ph_et = findViewById(R.id.ph_et);

        Button continue_btn = findViewById(R.id.continue_btn);
        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = name_et.getText().toString();
                String userEmail = email_et.getText().toString();
                String userPhone = ph_et.getText().toString();

                Intent intent = new Intent(MainActivity.this, UserProfile_Activity.class);
                intent.putExtra("name", userName);
                intent.putExtra("email", userEmail);
                intent.putExtra("phone", userPhone);
                startActivity(intent);
                finish();
            }
        });
    }
}
